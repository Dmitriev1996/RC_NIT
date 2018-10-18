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
import logic.entity.Examinee;

/**
 *
 * @author Admin
 */
public class ExamineeDAO {
    private ArrayList<Examinee> allStudentList=new ArrayList<Examinee>();
    private ArrayList<Examinee> atParamsList=new ArrayList<Examinee>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private ArrayList<Examinee> getAllStudent() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examinee.Examinee_ID, examinee.Examine_ID, examinee.Student_ID, physfaces.FIO, \n" +
"examinee.Mark_ID, marks.Mark FROM examinee \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM students \n" +
"WHERE Student_ID=examinee.Student_ID) \n" +
"INNER JOIN marks ON marks.Mark_ID=examinee.Mark_ID");
            while(rs.next()){
                Examinee student=new Examinee();
                student.setExaminee_ID(rs.getInt("Examinee_ID"));
                student.setExamine_ID(rs.getInt("Examine_ID"));
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setFIO(rs.getString("FIO"));
                student.setMark_ID(rs.getInt("Mark_ID"));
                student.setMark(rs.getString("Mark"));
                allStudentList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ExamineeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allStudentList;
    }
    public ArrayList<Examinee> getAllStudentList() throws NamingException, SQLException{
        if(!allStudentList.isEmpty()){
            return allStudentList;
        } else {
            return getAllStudent();
        }
    }
    
    public ArrayList<Examinee> getStudentListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examinee.Examinee_ID, examinee.Examine_ID, examinee.Student_ID, physfaces.FIO, \n" +
"examinee.Mark_ID, marks.Mark FROM examinee \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM students \n" +
"WHERE Student_ID=examinee.Student_ID) \n" +
"INNER JOIN marks ON marks.Mark_ID=examinee.Mark_ID WHERE "+params);
            while(rs.next()){
                Examinee student=new Examinee();
                student.setExaminee_ID(rs.getInt("Examinee_ID"));
                student.setExamine_ID(rs.getInt("Examine_ID"));
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setFIO(rs.getString("FIO"));
                student.setMark_ID(rs.getInt("Mark_ID"));
                student.setMark(rs.getString("Mark"));
                atParamsList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ExamineeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ArrayList<Examinee> getStudentListByExamine(int examineId) throws NamingException, SQLException{
        ArrayList<Examinee> studentList=new ArrayList<Examinee>();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examinee.Examinee_ID, examinee.Examine_ID, examinee.Student_ID, physfaces.FIO, \n" +
"examinee.Mark_ID, marks.Mark FROM examinee \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM students \n" +
"WHERE Student_ID=examinee.Student_ID) \n" +
"INNER JOIN marks ON marks.Mark_ID=examinee.Mark_ID WHERE Examine_ID"+examineId);
            while(rs.next()){
                Examinee student=new Examinee();
                student.setExaminee_ID(rs.getInt("Examinee_ID"));
                student.setExamine_ID(rs.getInt("Examine_ID"));
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setFIO(rs.getString("FIO"));
                student.setMark_ID(rs.getInt("Mark_ID"));
                student.setMark(rs.getString("Mark"));
                studentList.add(student);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ExamineeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return studentList;
    }
    
    
    
    public Examinee getStudentById(int id) throws SQLException, NamingException{
        Examinee student=new Examinee();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examinee.Examinee_ID, examinee.Examine_ID, examinee.Student_ID, physfaces.FIO, \n" +
"examinee.Mark_ID, marks.Mark FROM examinee \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM students \n" +
"WHERE Student_ID=examinee.Student_ID) \n" +
"INNER JOIN marks ON marks.Mark_ID=examinee.Mark_ID WHERE Examinee_ID="+id);
            while(rs.next()){
                student.setExaminee_ID(rs.getInt("Examinee_ID"));
                student.setExamine_ID(rs.getInt("Examine_ID"));
                student.setStudent_ID(rs.getInt("Student_ID"));
                student.setFIO(rs.getString("FIO"));
                student.setMark_ID(rs.getInt("Mark_ID"));
                student.setMark(rs.getString("Mark"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(ExamineeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExamineeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    
    public void insertStudent(Examinee student) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO examinee (Examine_ID, Student_ID, Mark_ID, "
                + "VALUES (?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, student.getExamine_ID());
        prepstmt.setInt(2, student.getStudent_ID());
        prepstmt.setInt(3, student.getMark_ID());
        prepstmt.executeUpdate();
    }
    
    public void updateStudent(Examinee student) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE examinee SET Examine_ID=?, Student_ID=?, Mark_ID=?, "
                + "WHERE Examinee_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, student.getExamine_ID());
        prepstmt.setInt(2, student.getStudent_ID());
        prepstmt.setInt(3, student.getMark_ID());
        prepstmt.setInt(4, student.getExaminee_ID());
        prepstmt.executeUpdate();
    }
    
    
    
    public void deleteStudent(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM examinee WHERE Examinee_ID="+id);
    }
    
}
