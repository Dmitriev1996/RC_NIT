/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import java.util.ArrayList;
import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.Pay;

/**
 *
 * @author Admin
 */
public class PayDAO {
    private ArrayList<Pay> allpayList=new ArrayList<Pay>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<Pay> getAllPay() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM pay");
            while(rs.next()){
                Pay pay=new Pay();
                pay.setPay_ID(rs.getInt("Pay_ID"));
                pay.setPay(rs.getString("Pay"));
                allpayList.add(pay);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allpayList;
    }
    public ArrayList<Pay> getAllPayList() throws NamingException, SQLException{
        if(!allpayList.isEmpty()){
            return allpayList;
        } else {
            return getAllPay();
        }
    }
    
    public int getIdByPay(String pay){
        int Pay_ID=0;
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT Pay_ID FROM pay WHERE Pay='"+pay+"'");
            while(rs.next()){
                Pay_ID=rs.getInt("Pay_ID");
            }
        } catch (NamingException ex) {
            Logger.getLogger(PayDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Pay_ID;
    }
}
