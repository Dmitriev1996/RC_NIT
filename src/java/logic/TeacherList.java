/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class TeacherList {
    private Map<Integer, ArrayList<Teacher>> teacherList=new HashMap<Integer, ArrayList<Teacher>>();
    private ArrayList<Teacher> data;
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    private Set<Map.Entry<Integer, ArrayList<Teacher>>> getTeachers() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM teachers");
            while(rs.next()){
                Teacher teacher=new Teacher();
                data=new ArrayList<Teacher>();
                teacher.setTeacher_ID(rs.getInt("Teacher_ID"));
                teacher.setTeacher(rs.getString("Teacher"));
                teacher.setStatus(rs.getString("Status"));
                teacherList.put(teacher.getTeacher_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(TeacherList.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(stmt!=null) stmt.close();
            if(rs!=null) rs.close();
            if(conn!=null) conn.close();
            
        }
        return teacherList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<Teacher>>> getTeacherList() throws NamingException, SQLException{
        if(!teacherList.isEmpty()){
            return teacherList.entrySet();
        } else {
            return getTeachers();
        }
    }
}
