/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.Teacher;

/**
 *
 * @author Admin
 */
public class TeacherDAO {
    private ArrayList<Teacher> allteacherList=new ArrayList<Teacher>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<Teacher> getAllTeachers() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM teachers");
            while(rs.next()){
                Teacher teacher=new Teacher();
                teacher.setTeacher_ID(rs.getInt("Teacher_ID"));
                teacher.setTeacher(rs.getString("Teacher"));
                teacher.setStatus(rs.getString("Status"));
                allteacherList.add(teacher);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return allteacherList;
    }
    public ArrayList<Teacher> getAllTeacherList() throws NamingException, SQLException{
        if(!allteacherList.isEmpty()){
            return allteacherList;
        } else {
            return getAllTeachers();
        }
    }
    
    public Teacher getTeacherById(int id) throws NamingException, SQLException{
        Teacher teacher=new Teacher();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM teachers WHERE Teacher_ID="+id);
        while(rs.next()){
                teacher.setTeacher_ID(rs.getInt("Teacher_ID"));
                teacher.setTeacher(rs.getString("Teacher"));
                teacher.setStatus(rs.getString("Status"));
            }
        return teacher;
    }
    
}
