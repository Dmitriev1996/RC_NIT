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
import logic.entity.IndividualStudent;

/**
 *
 * @author Admin
 */
public class IndividualStudentDAO {
    private ArrayList<IndividualStudent> allStudentList=new ArrayList<IndividualStudent>();
    private ArrayList<IndividualStudent> atParamsList=new ArrayList<IndividualStudent>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private PhysfaceDAO physfacedao=new PhysfaceDAO();
    private CourceDAO courcedao=new CourceDAO();
    private ArrayList<IndividualStudent> getAllStudent() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT individual_students.IndividualStudent_ID, individual_students.Phys_ID, \n"+
"individual_students.Cource_ID, individual_students.Certification, individual_students.DateCertification, \n"+ 
"individual_students.Teacher_ID, teachers.Teacher FROM individual_students \n"+ 
"INNER JOIN teachers ON teachers.Teacher_ID=individual_students.Teacher_ID");
            while(rs.next()){
                IndividualStudent student=new IndividualStudent();
                student.setIndividualStudent_ID(rs.getInt("IndividualStudent_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setCource_ID(rs.getInt("Cource_ID"));
                student.setCource(courcedao.getCourceById(student.getCource_ID()));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID()));
                student.setCertificaton(rs.getByte("Certification"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setTeacher_ID(rs.getInt("Teacher_ID"));
                student.setTeacher(rs.getString("Teacher"));
                allStudentList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(IndividualStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allStudentList;
    }
    public ArrayList<IndividualStudent> getAllStudentList() throws NamingException, SQLException{
        if(!allStudentList.isEmpty()){
            return allStudentList;
        } else {
            return getAllStudent();
        }
    }
    
    public ArrayList<IndividualStudent> getStudentListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT individual_students.IndividualStudent_ID, individual_students.Phys_ID, \n"+
"individual_students.Cource_ID, individual_students.Certification, individual_students.DateCertification, \n"+
"individual_students.Teacher_ID, teachers.Teacher FROM individual_students \n"+
"INNER JOIN teachers ON teachers.Teacher_ID=individual_students.Teacher_ID WHERE "+params);
            while(rs.next()){
                IndividualStudent student=new IndividualStudent();
                student.setIndividualStudent_ID(rs.getInt("IndividualStudent_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setCource_ID(rs.getInt("Cource_ID"));
                student.setCource(courcedao.getCourceById(student.getCource_ID()));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID()));
                student.setCertificaton(rs.getByte("Certification"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setTeacher_ID(rs.getInt("Teacher_ID"));
                student.setTeacher(rs.getString("Teacher"));
                atParamsList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(IndividualStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public IndividualStudent getStudentById(int id) throws SQLException, NamingException{
        IndividualStudent student=new IndividualStudent();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT individual_students.IndividualStudent_ID, individual_students.Phys_ID, \n"+
"individual_students.Cource_ID, individual_students.Certification, individual_students.DateCertification, \n"+
"individual_students.Teacher_ID, teachers.Teacher FROM individual_students \n"+
"INNER JOIN teachers ON teachers.Teacher_ID=individual_students.Teacher_ID WHERE IndividualStudent_ID="+id);
            while(rs.next()){
                student.setIndividualStudent_ID(rs.getInt("IndividualStudent_ID"));
                student.setPhys_ID(rs.getInt("Phys_ID"));
                student.setCource_ID(rs.getInt("Cource_ID"));
                student.setCource(courcedao.getCourceById(student.getCource_ID()));
                student.setPhysface(physfacedao.getPhysfaceById(student.getPhys_ID()));
                student.setCertificaton(rs.getByte("Certification"));
                student.setDateCertification(rs.getDate("DateCertification"));
                student.setTeacher_ID(rs.getInt("Teacher_ID"));
                student.setTeacher(rs.getString("Teacher"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(ContractOrderPhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContractOrderPhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    
    public void insertStudent(IndividualStudent student) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO individual_students (Phys_ID, Cource_ID, DateCertification, "
                + "Certification, Teacher_ID) "
                + "VALUES (?, ?, ?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, student.getPhys_ID());
        prepstmt.setInt(2, student.getCource_ID());
        prepstmt.setDate(3, student.getDateCertification());
        prepstmt.setByte(4, student.getCertificaton());
        prepstmt.setInt(5, student.getTeacher_ID());
        prepstmt.executeUpdate();
    }
    
    public void updateStudent(IndividualStudent student) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE individual_student SET Phys_ID=?, Cource_ID=?, DateCertification=?, "
                + "Certification=?, Teacher_ID=? WHERE IndividualStudent_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, student.getPhys_ID());
        prepstmt.setInt(2, student.getCource_ID());
        prepstmt.setDate(3, student.getDateCertification());
        prepstmt.setByte(4, student.getCertificaton());
        prepstmt.setInt(5, student.getTeacher_ID());
        prepstmt.setInt(6, student.getIndividualStudent_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteStudent(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM individual_students WHERE IndividualStudent_ID="+id);
    }
}
