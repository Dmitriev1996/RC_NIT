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
import logic.entity.StatusOrder;

/**
 *
 * @author Admin
 */
public class StatusOrderDAO {
    private ArrayList<StatusOrder> allStatusList=new ArrayList<StatusOrder>();
    private ArrayList<StatusOrder> atParamsList=new ArrayList<StatusOrder>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private IndividualStudentDAO studentdao=new IndividualStudentDAO();
    private ArrayList<StatusOrder> getAllStatus() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM status_orders");
            while(rs.next()){
                StatusOrder status=new StatusOrder();
                status.setStatusOrder_ID(rs.getInt("StatusOrder_ID"));
                status.setStatusOrder(rs.getString("StatusOrder"));
                allStatusList.add(status);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StatusOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allStatusList;
    }
    public ArrayList<StatusOrder> getAllStatusList() throws NamingException, SQLException{
        if(!allStatusList.isEmpty()){
            return allStatusList;
        } else {
            return getAllStatus();
        }
    }
    
    public ArrayList<StatusOrder> getStatusListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM status_orders WHERE "+params);
            while(rs.next()){
                StatusOrder status=new StatusOrder();
                status.setStatusOrder_ID(rs.getInt("StatusOrder_ID"));
                status.setStatusOrder(rs.getString("StatusOrder"));
                atParamsList.add(status);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(StatusOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public StatusOrder getStatusById(int id) throws SQLException, NamingException{
        StatusOrder status=new StatusOrder();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM status_orders WHERE StatusOrder_ID="+id);
            while(rs.next()){
                status.setStatusOrder_ID(rs.getInt("StatusOrder_ID"));
                status.setStatusOrder(rs.getString("StatusOrder"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(StatusOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StatusOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public void insertStatus(StatusOrder status) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO status_orders (StatusOrder) "
                + "VALUES (?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setString(1, status.getStatusOrder());
        prepstmt.executeUpdate();
    }
    
    public void updateStatus(StatusOrder status) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE status_orders SET StatusOrder=?"
                + " WHERE IndividualClass_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setString(1, status.getStatusOrder());
        prepstmt.setInt(2, status.getStatusOrder_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteStatus(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM status_orders WHERE StatusOrder_ID="+id);
    }
}
