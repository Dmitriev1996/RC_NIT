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
import logic.entity.StatusScience;

/**
 *
 * @author Admin
 */
public class StatusScienceDAO {
    private ArrayList<StatusScience> allstatusList=new ArrayList<StatusScience>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<StatusScience> getAllStatusScience() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM status_science");
            while(rs.next()){
                StatusScience status=new StatusScience();
                status.setStatusScience_ID(rs.getInt("StatusScience_ID"));
                status.setStatusScience(rs.getString("StatusScience"));
                allstatusList.add(status);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StatusScienceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return allstatusList;
    }
    public ArrayList<StatusScience> getAllStatusList() throws NamingException, SQLException{
        if(!allstatusList.isEmpty()){
            return allstatusList;
        } else {
            return getAllStatusScience();
        }
    }
    
    public StatusScience getSttausScienceById(int id) throws NamingException, SQLException{
        StatusScience status=new StatusScience();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM status_science WHERE StatusScience_ID="+id);
        while(rs.next()){
               status.setStatusScience_ID(rs.getInt("StatusScience_ID"));
               status.setStatusScience(rs.getString("StatusScience")); 
            }
        return status;
    }
    
}
