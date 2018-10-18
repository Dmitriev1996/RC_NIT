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
import javax.naming.NamingException;
import logic.entity.GroupApp;
import logic.entity.Physface;
import logic.valid.GroupAppValidate;

/**
 *
 * @author Admin
 */
public class GroupAppDAO {
    private ArrayList<GroupApp> groupapplist=new ArrayList<GroupApp>();
    private Connection conn=null;
    private Statement stmt=null; 
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private GroupAppValidate groupvalid=new GroupAppValidate();
    private ArrayList<GroupApp> getAllGroupApp() throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM group_app");
        while(rs.next()){
            GroupApp groupapp=new GroupApp();
            groupapp.setGroupApp_ID(rs.getInt("GroupApp_ID"));
            groupapp.setAppTeach_ID(rs.getInt("AppTeach_ID"));
            groupapp.setYur_ID(rs.getInt("Yur_ID"));
            groupapp.setPhys_ID(rs.getInt("Phys_ID"));
            groupapplist.add(groupapp);
        }
        return groupapplist;
    }
    
    public ArrayList<GroupApp> getAllGroupAppList() throws NamingException, SQLException{
        if(!groupapplist.isEmpty()){
            return groupapplist;
        } else {
            return getAllGroupApp();
        }
    }
    
    public void insertGroupApp(GroupApp groupapp) throws NamingException, SQLException{
        String values=groupvalid.getInsertColumnList(groupapp);
        String sql="INSERT INTO group_app "+values;
        conn=Database.getConnection();
        prepstmt=conn.prepareStatement(sql);
        groupvalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    public void insertPhysfaceInGroupApp(GroupApp groupapp) throws NamingException, SQLException{
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        for(Physface physface : groupapp.getPhysfaceList()){
            physfacedao.insertPhysface(physface);
            rs=stmt.executeQuery("SELECT Phys_ID FROM physfaces ORDER BY Phys_ID DESC LIMIT 1");
            int ID=0;
            while(rs.next()){
              ID=rs.getInt("Phys_ID");
            }
            groupapp.setPhys_ID(ID);
            String sql="INSERT INTO group_app (AppTeach_ID, Yur_ID, Phys_ID) VALUES ("
                + "?, ?, ?)";
            prepstmt=conn.prepareStatement(sql);
            prepstmt.setInt(1, groupapp.getAppTeach_ID());
            prepstmt.setInt(2, groupapp.getYur_ID());
            prepstmt.setInt(3, groupapp.getPhys_ID());
            prepstmt.executeUpdate();
        }
        
    }
    
    public GroupApp getGroupAppByAppTeach(int id) throws NamingException, SQLException{
        GroupApp groupapp=new GroupApp();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM group_app WHERE AppTeach_ID="+id);
        while(rs.next()){
            groupapp.setGroupApp_ID(rs.getInt("GroupApp_ID"));
            groupapp.setAppTeach_ID(rs.getInt("AppTeach_ID"));
            groupapp.setYur_ID(rs.getInt("Yur_ID"));
            groupapp.setPhys_ID(rs.getInt("Phys_ID"));
        }
        return groupapp;
    }
    
    public void updateGroupApp(GroupApp groupapp) throws NamingException, SQLException{
        String sql="UPDATE group_app SET AppTeach_ID=?, Yur_ID=?, Phys_ID=? WHERE "
                + "GroupApp_ID=?";
        conn=Database.getConnection();
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, groupapp.getAppTeach_ID());
        prepstmt.setInt(2, groupapp.getYur_ID());
        prepstmt.setInt(3, groupapp.getPhys_ID());
        prepstmt.setInt(4, groupapp.getGroupApp_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteGroupApp(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM group_app WHERE GroupApp_ID="+id);
    }
    
    public void deleteGroupApp(GroupApp groupapp, ArrayList<Physface> physfacelist){
        
    }
    
}
