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
import logic.entity.PayType;

/**
 *
 * @author Admin
 */
public class PayTypeDAO {
    private ArrayList<PayType> allpaytypeList=new ArrayList<PayType>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<PayType> getAllPayType() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM pay_type");
            while(rs.next()){
                PayType paytype=new PayType();
                paytype.setPayType_ID(rs.getInt("PayType_ID"));
                paytype.setPayType(rs.getString("PayType"));
                allpaytypeList.add(paytype);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PayTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allpaytypeList;
    }
    public ArrayList<PayType> getAllPayTypeList() throws NamingException, SQLException{
        if(!allpaytypeList.isEmpty()){
            return allpaytypeList;
        } else {
            return getAllPayType();
        }
    }
    
    public int getIdByPayType(String PayType) throws NamingException{
        int PayType_ID=0;
        try {
            
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT PayType_ID FROM pay_type WHERE PayType='"+PayType+"'");
            while(rs.next()){
                PayType_ID=rs.getInt("PayType_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PayType_ID;
    }
}
