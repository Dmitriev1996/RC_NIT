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
import logic.entity.PayPeriod;

/**
 *
 * @author Admin
 */
public class PayPeriodDAO {
    private ArrayList<PayPeriod> allpayperiodList=new ArrayList<PayPeriod>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<PayPeriod> getAllPayPeriod() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM pay_period");
            while(rs.next()){
                PayPeriod payperiod=new PayPeriod();
                payperiod.setPayPeriod_ID(rs.getInt("PayPeriod_ID"));
                payperiod.setPayPeriod(rs.getString("PayPeriod"));
                allpayperiodList.add(payperiod);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PayPeriodDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allpayperiodList;
    }
    public ArrayList<PayPeriod> getAllPayPeriodList() throws NamingException, SQLException{
        if(!allpayperiodList.isEmpty()){
            return allpayperiodList;
        } else {
            return getAllPayPeriod();
        }
    }
    
    public int getIdByPayPeriod(String PayPeriod) throws NamingException{
        int PayPeriod_ID=0;
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT PayPeriod_ID FROM pay_period "
                    + "WHERE PayPeriod='"+PayPeriod+"'");
            while(rs.next()){
                PayPeriod_ID=rs.getInt("PayPeriod_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayPeriodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PayPeriod_ID;
    }
}
