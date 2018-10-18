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
import logic.entity.StatusApp;

/**
 *
 * @author Admin
 */
public class StatusAppDAO {
    private ArrayList<StatusApp> statusapplist=new ArrayList<StatusApp>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    
    private ArrayList<StatusApp> getAllStatusApp() throws NamingException{
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM status_app");
            while(rs.next()){
                StatusApp statusapp=new StatusApp();
                statusapp.setStatusApp_ID(rs.getInt("StatusApp_ID"));
                statusapp.setStatusApp(rs.getString("StatusApp"));
                statusapplist.add(statusapp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statusapplist;
    }
    
    public ArrayList<StatusApp> getStausAppList() throws NamingException{
        if(!statusapplist.isEmpty()){
            return statusapplist;
        } else {
            return getAllStatusApp();
        }
    }
    
    public int getIdByStatusApp(String statusapp) throws NamingException{
        int StatusApp_ID=0;
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT StatusApp_ID FROM status_app "
                    + "WHERE StatusApp='"+statusapp+"'");
            while(rs.next()){
                StatusApp_ID=rs.getInt("StatusApp_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StatusApp_ID;
    }
    
}
