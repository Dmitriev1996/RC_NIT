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
import logic.entity.Examine;

/**
 *
 * @author Admin
 */
public class ExamineDAO {
    private ArrayList<Examine> allExamineList=new ArrayList<Examine>();
    private ArrayList<Examine> atParamsList=new ArrayList<Examine>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private ExamineeDAO studentdao=new ExamineeDAO();
    private ArrayList<Examine> getAllExamine() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examines.Examine_ID, examines.Cource_ID, cources.Cource, \n" +
"cources.NumberHours, examines.DateExamine, examines.Teacher_ID, teachers.Teacher FROM examines \n" +
"INNER JOIN cources ON cources.Cource_ID=examines.Cource_ID " + 
"INNER JOIN teachers ON teachers.Teacher_ID=examines.Teacher_ID");
            while(rs.next()){
                Examine examine=new Examine();
                examine.setExamine_ID(rs.getInt("Examine_ID"));
                examine.setCource_ID(rs.getInt("Cource_ID"));
                examine.setCource(rs.getString("Cource"));
                examine.setNumberHours(rs.getInt("NumberHours"));
                examine.setDateExamine(rs.getDate("DateExamine"));
                examine.setTeacher_ID(rs.getInt("Teacher_ID"));
                examine.setTeacher(rs.getString("Teacher"));
                examine.setStudentList(studentdao.
                        getStudentListByExamine(examine.getExamine_ID()));
                allExamineList.add(examine);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ExamineDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allExamineList;
    }
    public ArrayList<Examine> getAllExamineList() throws NamingException, SQLException{
        if(!allExamineList.isEmpty()){
            return allExamineList;
        } else {
            return getAllExamine();
        }
    }
    
    public ArrayList<Examine> getExamineListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examines.Examine_ID, examines.Cource_ID, cources.Cource, \n" +
"cources.NumberHours, examines.DateExamine, examines.Teacher_ID, teachers.Teacher FROM examines \n" +
"INNER JOIN cources ON cources.Cource_ID=examines.Cource_ID " +
"INNER JOIN teachers ON teachers.Teacher_ID=examines.Teacher_ID WHERE "+params);
            while(rs.next()){
                Examine examine=new Examine();
                examine.setExamine_ID(rs.getInt("Examine_ID"));
                examine.setCource_ID(rs.getInt("Cource_ID"));
                examine.setCource(rs.getString("Cource"));
                examine.setNumberHours(rs.getInt("NumberHours"));
                examine.setDateExamine(rs.getDate("DateExamine"));
                examine.setTeacher_ID(rs.getInt("Teacher_ID"));
                examine.setTeacher(rs.getString("Teacher"));
                examine.setStudentList(studentdao.
                        getStudentListByExamine(examine.getExamine_ID()));
                atParamsList.add(examine);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ExamineDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public Examine getExamineById(int id) throws SQLException, NamingException{
        Examine examine=new Examine();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT examines.Examine_ID, examines.Cource_ID, cources.Cource, \n" +
"cources.NumberHours, examines.DateExamine, examines.Teacher_ID, teachers.Teacher FROM examines \n" +
"INNER JOIN cources ON cources.Cource_ID=examines.Cource_ID" +
"INNER JOIN teachers ON teachers.Teacher_ID=examines.Teacher_ID WHERE Examine_ID="+id);
            while(rs.next()){
                examine.setExamine_ID(rs.getInt("Examine_ID"));
                examine.setCource_ID(rs.getInt("Cource_ID"));
                examine.setCource(rs.getString("Cource"));
                examine.setNumberHours(rs.getInt("NumberHours"));
                examine.setDateExamine(rs.getDate("DateExamine"));
                examine.setTeacher_ID(rs.getInt("Teacher_ID"));
                examine.setTeacher(rs.getString("Teacher"));
                examine.setStudentList(studentdao.
                        getStudentListByExamine(examine.getExamine_ID()));
            }
        } catch (NamingException ex) {
            Logger.getLogger(ExamineDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExamineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return examine;
    }
    
    public void insertExamine(Examine examine) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO examines (Cource_ID, DateExamine, Teacher_ID"
                + "VALUES (?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, examine.getCource_ID());
        prepstmt.setDate(2, examine.getDateExamine());
        prepstmt.setInt(3, examine.getTeacher_ID());
        prepstmt.executeUpdate();
    }
    
    public void updateExamine(Examine examine) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE examines SET Cource_ID=?, DateExamine=?, Teacher_ID=? "
                + "WHERE Examine_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, examine.getCource_ID());
        prepstmt.setDate(2, examine.getDateExamine());
        prepstmt.setInt(3, examine.getTeacher_ID());
        prepstmt.setInt(4, examine.getExamine_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteExamine(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM examines WHERE Examine_ID="+id);
    }
}
