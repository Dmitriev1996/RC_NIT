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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.ActOrderYurface;
import logic.valid.ActOrderYurfaceValidate;
/**
 *
 * @author Admin
 */
public class ActOrderYurfaceDAO {
    private ArrayList<ActOrderYurface> allActList=new ArrayList<ActOrderYurface>();
    private ArrayList<ActOrderYurface> atParamsList=new ArrayList<ActOrderYurface>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private ActOrderYurfaceValidate actvalid=new ActOrderYurfaceValidate();
        private ArrayList<ActOrderYurface> getAllActYurface() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT acts_orders_yurfaces.ActsOrdersYurfaces_ID, "
                    + "acts_orders_yurfaces.ContractsOrdersYurfaces_ID, "
                    + "acts_orders_yurfaces.DateAct, \n" +
"yurfaces.NameOrganization, cources.Cource, contracts_orders_yurfaces.Price, \n" +
"acts_orders_yurfaces.DatePay, acts_orders_yurfaces.Comment, \n" +
"acts_orders_yurfaces.ReturnAct FROM acts_orders_yurfaces \n" +
"INNER JOIN yurfaces ON yurfaces.Yur_ID=(SELECT Yur_ID FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN contracts_orders_yurfaces ON \n" +
"contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID");
            while(rs.next()){
                ActOrderYurface actyurface=new ActOrderYurface();
                actyurface.setActsOrdersYurface_ID(rs.getInt("ActsOrdersYurfaces_ID"));
                actyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                actyurface.setDateAct(rs.getDate("DateAct"));
                actyurface.setNameOrganization(rs.getString("NameOrganization"));
                actyurface.setCource(rs.getString("Cource"));
                actyurface.setPrice(rs.getDouble("Price"));
                actyurface.setDatePay(rs.getDate("DatePay"));
                actyurface.setComment(rs.getString("Comment"));
                actyurface.setReturnAct(rs.getByte("ReturnAct"));
                allActList.add(actyurface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ActOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allActList;
    }
    public ArrayList<ActOrderYurface> getAllActList() throws NamingException, SQLException{
        if(!allActList.isEmpty()){
            return allActList;
        } else {
            return getAllActYurface();
        }
    }
    
    public ArrayList<ActOrderYurface> getAllActYurfaceAtParams(String params) throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT acts_orders_yurfaces.ActsOrdersYurfaces_ID, "
                    + "acts_orders_yurfaces.ContractsOrdersYurfaces_ID, "
                    + "acts_orders_yurfaces.DateAct, \n" +
"yurfaces.NameOrganization, cources.Cource, contracts_orders_yurfaces.Price, \n" +
"acts_orders_yurfaces.DatePay, acts_orders_yurfaces.Comment, \n" +
"acts_orders_yurfaces.ReturnAct FROM acts_orders_yurfaces \n" +
"INNER JOIN yurfaces ON yurfaces.Yur_ID=(SELECT Yur_ID FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN contracts_orders_yurfaces ON \n" +
"contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID WHERE "+params);
            while(rs.next()){
                ActOrderYurface actyurface=new ActOrderYurface();
                actyurface.setActsOrdersYurface_ID(rs.getInt("ActsOrdersYurfaces_ID"));
                actyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                actyurface.setDateAct(rs.getDate("DateAct"));
                actyurface.setNameOrganization(rs.getString("NameOrganization"));
                actyurface.setCource(rs.getString("Cource"));
                actyurface.setPrice(rs.getDouble("Price"));
                actyurface.setDatePay(rs.getDate("DatePay"));
                actyurface.setComment(rs.getString("Comment"));
                actyurface.setReturnAct(rs.getByte("ReturnAct"));
                atParamsList.add(actyurface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ActOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ActOrderYurface getActOrderYurfaceById(int id) throws NamingException, SQLException{
        ActOrderYurface actyurface=new ActOrderYurface();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT acts_orders_yurfaces.ActsOrdersYurfaces_ID, "
                    + "acts_orders_yurfaces.ContractsOrdersYurfaces_ID, "
                    + "acts_orders_yurfaces.DateAct, \n" +
"yurfaces.NameOrganization, cources.Cource, contracts_orders_yurfaces.Price, \n" +
"acts_orders_yurfaces.DatePay, acts_orders_yurfaces.Comment, \n" +
"acts_orders_yurfaces.ReturnAct FROM acts_orders_yurfaces \n" +
"INNER JOIN yurfaces ON yurfaces.Yur_ID=(SELECT Yur_ID FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN contracts_orders_yurfaces ON \n" +
"contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID WHERE acts_orders_yurfaces.ActsOrdersYurfaces_ID="+id);
            while(rs.next()){
                actyurface.setActsOrdersYurface_ID(rs.getInt("ActsOrdersYurfaces_ID"));
                actyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                actyurface.setDateAct(rs.getDate("DateAct"));
                actyurface.setNameOrganization(rs.getString("NameOrganization"));
                actyurface.setCource(rs.getString("Cource"));
                actyurface.setPrice(rs.getDouble("Price"));
                actyurface.setDatePay(rs.getDate("DatePay"));
                actyurface.setComment(rs.getString("Comment"));
                actyurface.setReturnAct(rs.getByte("ReturnAct"));
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ActOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return actyurface;
    }
    
    public void insertActOrderYurface(ActOrderYurface actyurface) throws SQLException, NamingException{
        conn=Database.getConnection();
        String values=actvalid.getInsertColumnList(actyurface);
        String sql="";
        sql="INSERT INTO acts_orders_yurfaces "+values;
        System.out.println(sql);
        prepstmt=conn.prepareStatement(sql);
        actvalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    public void updateActOrderYurface(ActOrderYurface actyurface) throws NamingException, SQLException{
            conn=Database.getConnection();
            String values=actvalid.getUpdateColumnList(actyurface);
            String sql="";
            sql="UPDATE acts_orders_yurfaces "+values+" WHERE ActsOrdersYurfaces_ID=?";
            prepstmt=conn.prepareStatement(sql);
            actvalid.fillUpdateData(prepstmt).executeUpdate();
    }
    
}
