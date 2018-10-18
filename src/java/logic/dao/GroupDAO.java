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
import logic.entity.Cource;
import logic.entity.Group;
import logic.entity.Student;
import logic.entity.Teacher;

/**
 *
 * @author Admin
 */
public class GroupDAO {
    private ArrayList<Group> allGroupList=new ArrayList<Group>();
    private ArrayList<Group> atParamsList=new ArrayList<Group>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private ResultSet rs1=null;
    private StudentDAO studentdao=new StudentDAO();
    
        private ArrayList<Group> getAllGroup() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT groups.Group_ID, groups.Cource_ID, cources.Cource,  \n" +
"cources.Price, cources.NumberHours, groups.Certification, groups.Teacher_ID, \n" +
"teachers.Teacher, teachers.Status, groups.StatusScience_ID, status_science.StatusScience FROM groups \n" +
"INNER JOIN cources ON cources.Cource_ID=groups.Cource_ID \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=groups.Teacher_ID \n"+
"INNER JOIN status_science ON status_science.StatusScience_ID=groups.StatusScience_ID");
            while(rs.next()){
                Group group=new Group();
                group.setGroup_ID(rs.getInt("Group_ID"));
                /*System.out.println(group.getGroup_ID());
                group.setStudentList(studentdao.getStudentListByGroupID(group.getGroup_ID()));*/
                group.setCource_ID(rs.getInt("Cource_ID"));
                Cource cource=new Cource();
                cource.setCource_ID(group.getCource_ID());
                cource.setCource(rs.getString("Cource"));
                cource.setPrice(rs.getDouble("Price"));
                cource.setNumberHours(rs.getInt("NumberHours"));
                group.setCource(cource);
                group.setCertification(rs.getByte("Certification"));
                group.setTeacher_ID(rs.getInt("Teacher_ID"));
                Teacher teacher=new Teacher();
                teacher.setTeacher_ID(group.getTeacher_ID());
                teacher.setTeacher(rs.getString("Teacher"));
                teacher.setStatus(rs.getString("Status"));
                group.setTeacher(teacher);
                group.setStatusScience_ID(rs.getInt("StatusScience_ID"));
                group.setStatusScience(rs.getString("StatusScience"));
                allGroupList.add(group);
            }
            
            /*for(Group group : allGroupList){
                group.setStudentList(studentdao.getStudentListByGroupID(group.getGroup_ID()));
            }*/
            
        } catch(SQLException ex){
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allGroupList;
    }
    public ArrayList<Group> getAllGroupList() throws NamingException, SQLException{
        if(!allGroupList.isEmpty()){
            return allGroupList;
        } else {
            return getAllGroup();
        }
    }
    
    public ArrayList<Group> getGroupListAtParams(String params) throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT groups.Group_ID, groups.Cource_ID, cources.Cource,  \n" +
"cources.Price, cources.NumberHours, groups.Certification, groups.Teacher_ID, \n" +
"teachers.Teacher, teachers.Status, groups.StatusScience_ID, status_science.StatusScience FROM groups \n" +
"INNER JOIN cources ON cources.Cource_ID=groups.Cource_ID \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=groups.Teacher_ID \n" +
"INNER JOIN status_science ON status_science.StatusScience_ID=groups.StatusScience_ID WHERE "+params);
            while(rs.next()){
                Group group=new Group();
                group.setGroup_ID(rs.getInt("Group_ID"));
                group.setStudentList(studentdao.getStudentListByGroupID(group.getGroup_ID()));
                group.setCource_ID(rs.getInt("Cource_ID"));
                Cource cource=new Cource();
                cource.setCource_ID(group.getCource_ID());
                cource.setCource(rs.getString("Cource"));
                cource.setPrice(rs.getDouble("Price"));
                cource.setNumberHours(rs.getInt("NumberHours"));
                group.setCource(cource);
                group.setCertification(rs.getByte("Certification"));
                group.setTeacher_ID(rs.getInt("Teacher_ID"));
                Teacher teacher=new Teacher();
                teacher.setTeacher_ID(group.getTeacher_ID());
                teacher.setTeacher(rs.getString("Teacher"));
                teacher.setStatus(rs.getString("Status"));
                group.setTeacher(teacher);
                group.setStatusScience_ID(rs.getInt("StatusScience_ID"));
                group.setStatusScience(rs.getString("StatusScience"));
                atParamsList.add(group);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public Group getGroupById(int id) throws NamingException, SQLException{
        Group group=new Group();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT groups.Group_ID, groups.Cource_ID, cources.Cource,  \n" +
"cources.Price, cources.NumberHours, groups.Certification, groups.Teacher_ID, \n" +
"teachers.Teacher, teachers.Status, groups.StatusScience_ID, status_science.StatusScience FROM groups \n" +
"INNER JOIN cources ON cources.Cource_ID=groups.Cource_ID \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=groups.Teacher_ID \n" +
"INNER JOIN status_science ON status_science.StatusScience_ID=groups.StatusScience_ID WHERE groups.Group_ID="+id);
            while(rs.next()){
                group.setGroup_ID(rs.getInt("Group_ID"));
                group.setStudentList(studentdao.getStudentListByGroupID(group.getGroup_ID()));
                group.setCource_ID(rs.getInt("Cource_ID"));
                Cource cource=new Cource();
                cource.setCource_ID(group.getCource_ID());
                cource.setCource(rs.getString("Cource"));
                cource.setPrice(rs.getDouble("Price"));
                cource.setNumberHours(rs.getInt("NumberHours"));
                group.setCource(cource);
                group.setCertification(rs.getByte("Certification"));
                group.setTeacher_ID(rs.getInt("Teacher_ID"));
                Teacher teacher=new Teacher();
                teacher.setTeacher_ID(group.getTeacher_ID());
                teacher.setTeacher(rs.getString("Teacher"));
                teacher.setStatus(rs.getString("Status"));
                group.setTeacher(teacher);
                group.setStatusScience_ID(rs.getInt("StatusScience_ID"));
                group.setStatusScience(rs.getString("StatusScience"));
            }
            
        } catch(SQLException ex){
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return group;
    }
    
    public void insertGroup(Group group) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="SELECT Cource_ID, Teacher_ID "
                + "FROM cources, teachers "
                + "WHERE Cource=? AND Teacher=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setString(1, group.getCource().getCource());
        prepstmt.setString(2, group.getTeacher().getTeacher());
        rs=prepstmt.executeQuery();
        while(rs.next()){
            group.setCource_ID(rs.getInt("Cource_ID"));
            group.setTeacher_ID(rs.getInt("Teacher_ID"));
        }
        sql="INSERT INTO groups (Cource_ID, Certification, Teacher_ID, StatusScience_ID) "
                + " VALUES (?, ?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, group.getCource_ID());
        prepstmt.setByte(2, group.getCertification());
        prepstmt.setInt(3, group.getTeacher_ID());
        prepstmt.setInt(4, group.getStatusScience_ID());
        prepstmt.executeUpdate();
        int Group_ID=0;
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT Group_ID FROM groups ORDER BY Group_ID DESC LIMIT 1");
        while(rs.next()){
            Group_ID=rs.getInt("Group_ID");
        }
        if(!group.getStudentList().isEmpty()){
            for(Student student : group.getStudentList()){
            if(Group_ID!=0){
                student.setGroup_ID(Group_ID);
            }
            studentdao.insertStudent(student);
        }
        }
    }
    
    public void updateGroup(Group group) throws NamingException, SQLException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE groups SET Cource_ID=?, Certification=?, Teacher_ID=? "
                + "WHERE Group_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, group.getCource_ID());
        prepstmt.setByte(2, group.getCertification());
        prepstmt.setInt(3, group.getTeacher_ID());
        prepstmt.setInt(4, group.getGroup_ID());
        prepstmt.executeUpdate();
    }
    
}
