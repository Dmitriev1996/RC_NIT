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
import logic.entity.IndividualClass;

/**
 *
 * @author Admin
 */
public class IndividualClassDAO {
    private ArrayList<IndividualClass> allClassList=new ArrayList<IndividualClass>();
    private ArrayList<IndividualClass> atParamsList=new ArrayList<IndividualClass>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private IndividualStudentDAO studentdao=new IndividualStudentDAO();
    private ArrayList<IndividualClass> getAllClass() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT individual_classes.IndividualClass_ID, individual_classes.IndividualStudent_ID, " + 
"physfaces.FIO, cources.Cource, individual_classes.DateClass, teachers.Teacher, " +
"individual_classes.NumberAudience FROM individual_classes " +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) " +
 "INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) " +
 "INNER JOIN teachers ON teachers.Teacher_ID=(SELECT Teacher_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID)");
            while(rs.next()){
                IndividualClass classes=new IndividualClass();
                classes.setIndividualClass_ID(rs.getInt("IndividualClass_ID"));
                classes.setIndividualStudent_ID(rs.getInt("IndividualStudent_ID"));
                classes.setIndividualStudent(studentdao.getStudentById(classes.getIndividualStudent_ID()));
                classes.setDateClass(rs.getDate("DateClass"));
                classes.setNumberAudience(rs.getInt("NumberAudience"));
                allClassList.add(classes);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(IndividualClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allClassList;
    }
    public ArrayList<IndividualClass> getAllClassList() throws NamingException, SQLException{
        if(!allClassList.isEmpty()){
            return allClassList;
        } else {
            return getAllClass();
        }
    }
    
    public ArrayList<IndividualClass> getClassListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT individual_classes.IndividualClass_ID, individual_classes.IndividualStudent_ID, " +
"physfaces.FIO, cources.Cource, individual_classes.DateClass, teachers.Teacher, " +
"individual_classes.NumberAudience FROM individual_classes " +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) " +
 "INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) " +
 "INNER JOIN teachers ON teachers.Teacher_ID=(SELECT Teacher_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) WHERE "+params);
            while(rs.next()){
                IndividualClass classes=new IndividualClass();
                classes.setIndividualClass_ID(rs.getInt("IndividualClass_ID"));
                classes.setIndividualStudent_ID(rs.getInt("IndividualStudent_ID"));
                classes.setIndividualStudent(studentdao.getStudentById(classes.getIndividualStudent_ID()));
                classes.setDateClass(rs.getDate("DateClass"));
                classes.setNumberAudience(rs.getInt("NumberAudience"));
                atParamsList.add(classes);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(IndividualClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public IndividualClass getClassById(int id) throws SQLException, NamingException{
        IndividualClass classes=new IndividualClass();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT individual_classes.IndividualClass_ID, individual_classes.IndividualStudent_ID, " +
"physfaces.FIO, cources.Cource, individual_classes.DateClass, teachers.Teacher, " +
"individual_classes.NumberAudience FROM individual_classes " +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) " +
 "INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) " +
 "INNER JOIN teachers ON teachers.Teacher_ID=(SELECT Teacher_ID FROM individual_students " +
 "WHERE IndividualStudent_ID=individual_classes.IndividualStudent_ID) WHERE IndividualClass_ID="+id);
            while(rs.next()){
                classes.setIndividualClass_ID(rs.getInt("IndividualClass_ID"));
                classes.setIndividualStudent_ID(rs.getInt("IndividualStudent_ID"));
                classes.setIndividualStudent(studentdao.getStudentById(classes.getIndividualStudent_ID()));
                classes.setDateClass(rs.getDate("DateClass"));
                classes.setNumberAudience(rs.getInt("NumberAudience"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(IndividualClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IndividualClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }
    
    public void insertClass(IndividualClass classes) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO individual_classes (IndividualStudent_ID, DateClass, NumberAudience) "
                + "VALUES (?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, classes.getIndividualStudent_ID());
        prepstmt.setDate(2, classes.getDateClass());
        prepstmt.setInt(3, classes.getNumberAudience());
        prepstmt.executeUpdate();
    }
    
    public void updateClass(IndividualClass classes) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE individual_class SET IndividualStudent_ID=?, DateClass=?, NumberAudience=?"
                + " WHERE IndividualClass_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, classes.getIndividualStudent_ID());
        prepstmt.setDate(2, classes.getDateClass());
        prepstmt.setInt(3, classes.getNumberAudience());
        prepstmt.setInt(4, classes.getIndividualClass_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteClass(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM individual_classes WHERE IndividualClass_ID="+id);
    }
}
