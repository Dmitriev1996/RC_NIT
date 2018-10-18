/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.Student;

/**
 *
 * @author Admin
 */
public class StudentDAO {
    private ArrayList<Student> allStudentList=new ArrayList<Student>();
    private ArrayList<Student> atParamsList=new ArrayList<Student>();
    private ArrayList<Student> atGroupStudentList=new ArrayList<Student>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
        private ArrayList<Student> getAllStudent() throws NamingException, SQLException{
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM students");
            while(rs.next()){
                Student student=new Student();
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setGroup_ID(rs.getInt("Group_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID()));
                allStudentList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allStudentList;
    }
    public ArrayList<Student> getAllStudentList() throws NamingException, SQLException{
        if(!allStudentList.isEmpty()){
            return allStudentList;
        } else {
            return getAllStudent();
        }
    }
    
    public ArrayList<Student> getStudentListAtParams(String params) throws NamingException, SQLException{
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM students WHERE "+params);
            while(rs.next()){
                Student student=new Student();
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setGroup_ID(rs.getInt("Group_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID()));
                atParamsList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ArrayList<Student> getStudentListByGroupID(int id) throws NamingException, SQLException{
        atGroupStudentList.clear();
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            String sql="";
            sql="SELECT * FROM students WHERE Group_ID="+id;
            System.out.println(sql);
            rs=stmt.executeQuery(sql);
            System.out.println();
            while(rs.next()){
                Student student=new Student();
                System.out.println(rs.getInt("Student_ID"));
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setGroup_ID(rs.getInt("Group_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID()));
                atGroupStudentList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atGroupStudentList;
    }
    
    public Student getStudentById(int id) throws NamingException, SQLException{
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        Student student=new Student();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM students WHERE Student_ID="+id);
            while(rs.next()){
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setGroup_ID(rs.getInt("Group_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID())); 
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return student;
    }
    
    public void insertStudent(Student student) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        /*sql="SELECT Group_ID FROM groups "
                + "WHERE Group=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setString(1, student.getGroup());
        rs=prepstmt.executeQuery();
        while(rs.next()){
            student.setGroup_ID(rs.getInt("Group_ID"));
        }*/
        sql="INSERT INTO students (DateCertification, Group_ID, Phys_ID) "
                + " VALUES (?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setDate(1, student.getDateCertification());
        prepstmt.setInt(2, student.getGroup_ID());
        prepstmt.setInt(3, student.getPhys_ID());
        prepstmt.executeUpdate();
    }
    
    public void updateStudent(Student student) throws NamingException, SQLException{
        conn=Database.getConnection();
        String sql="";
        sql="SELECT Group_ID FROM groups "
                + "WHERE Group=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setString(1, student.getGroup());
        rs=prepstmt.executeQuery();
        while(rs.next()){
            student.setGroup_ID(rs.getInt("Group_ID"));
        }
        sql="UPDATE students SET DateCertification=?, Group_ID=?, Phys_ID=? "
                + "WHERE Student_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setDate(1, student.getDateCertification());
        prepstmt.setInt(2, student.getGroup_ID());
        prepstmt.setInt(3, student.getPhys_ID());
        prepstmt.setInt(4, student.getStudent_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteStudent(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM students WHERE Student_ID="+id);
    }
    
}
