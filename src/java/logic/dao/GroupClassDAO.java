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
import logic.entity.GroupClass;

/**
 *
 * @author Admin
 */
public class GroupClassDAO {
    private ArrayList<GroupClass> allClassList=new ArrayList<GroupClass>();
    private ArrayList<GroupClass> atParamsList=new ArrayList<GroupClass>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private GroupDAO groupdao=new GroupDAO();
    private ArrayList<GroupClass> getAllClass() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT group_classes.GroupClasses_ID, group_classes.Group_ID, cources.Cource, \n" +
"group_classes.DateClass, teachers.Teacher, group_classes.NumberAudience FROM group_classes \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM groups \n" +
"WHERE Group_ID=groups.Group_ID) \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=(SELECT Teacher_ID FROM groups \n" +
"WHERE Group_ID=groups.Group_ID)");
            while(rs.next()){
                GroupClass classes=new GroupClass();
                classes.setGroupClasses_ID(rs.getInt("GroupClasses_ID"));
                classes.setGroup_ID(rs.getInt("Group_ID"));
                classes.setGroup(groupdao.getGroupById(classes.getGroup_ID()));
                classes.setCource(rs.getString("Cource"));
                classes.setDateClass(rs.getDate("DateClass"));
                classes.setTeacher(rs.getString("Teacher"));
                classes.setNumberAudience(rs.getInt("NumberAudience"));
                allClassList.add(classes);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(GroupClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allClassList;
    }
    public ArrayList<GroupClass> getAllClassList() throws NamingException, SQLException{
        if(!allClassList.isEmpty()){
            return allClassList;
        } else {
            return getAllClass();
        }
    }
    
    public ArrayList<GroupClass> getClassListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT group_classes.GroupClasses_ID, group_classes.Group_ID, cources.Cource, \n" +
"group_classes.DateClass, teachers.Teacher, group_classes.NumberAudience FROM group_classes \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM groups \n" +
"WHERE Group_ID=groups.Group_ID) \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=(SELECT Teacher_ID FROM groups \n" +
"WHERE Group_ID=groups.Group_ID) WHERE "+params);
            while(rs.next()){
                GroupClass classes=new GroupClass();
                classes.setGroupClasses_ID(rs.getInt("GroupClasses_ID"));
                classes.setGroup_ID(rs.getInt("Group_ID"));
                classes.setGroup(groupdao.getGroupById(classes.getGroup_ID()));
                classes.setCource(rs.getString("Cource"));
                classes.setDateClass(rs.getDate("DateClass"));
                classes.setTeacher(rs.getString("Teacher"));
                classes.setNumberAudience(rs.getInt("NumberAudience"));
                atParamsList.add(classes);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(GroupClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public GroupClass getClassById(int id) throws SQLException, NamingException{
        GroupClass classes=new GroupClass();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT group_classes.GroupClasses_ID, group_classes.Group_ID, cources.Cource, \n" +
"group_classes.DateClass, teachers.Teacher, group_classes.NumberAudience FROM group_classes \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM groups \n" +
"WHERE Group_ID=groups.Group_ID) \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=(SELECT Teacher_ID FROM groups \n" +
"WHERE Group_ID=groups.Group_ID) WHERE GroupClass_ID="+id);
            while(rs.next()){
                classes.setGroupClasses_ID(rs.getInt("GroupClasses_ID"));
                classes.setGroup_ID(rs.getInt("Group_ID"));
                classes.setGroup(groupdao.getGroupById(classes.getGroup_ID()));
                classes.setCource(rs.getString("Cource"));
                classes.setDateClass(rs.getDate("DateClass"));
                classes.setTeacher(rs.getString("Teacher"));
                classes.setNumberAudience(rs.getInt("NumberAudience"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(GroupClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GroupClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }
    
    public void insertClass(GroupClass classes) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO group_classes (Group_ID, DateClass, NumberAudience) "
                + "VALUES (?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, classes.getGroup_ID());
        prepstmt.setDate(2, classes.getDateClass());
        prepstmt.setInt(3, classes.getNumberAudience());
        prepstmt.executeUpdate();
    }
    
    public void updateClass(GroupClass classes) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE group_class SET Group_ID=?, DateClass=?, NumberAudience=?"
                + " WHERE GroupClass_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, classes.getGroup_ID());
        prepstmt.setDate(2, classes.getDateClass());
        prepstmt.setInt(3, classes.getNumberAudience());
        prepstmt.setInt(4, classes.getGroupClasses_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteClass(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM group_classes WHERE GroupClass_ID="+id);
    }
}
