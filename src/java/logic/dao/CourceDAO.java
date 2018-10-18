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
import logic.entity.Cource;

/**
 *
 * @author Admin
 */
public class CourceDAO {
    private ArrayList<Cource> allcourceList=new ArrayList<Cource>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<Cource> getAllCources() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM cources");
            while(rs.next()){
                Cource cource=new Cource();
                cource.setCource_ID(rs.getInt("Cource_ID"));
                cource.setCource(rs.getString("Cource"));
                cource.setNumberHours(rs.getInt("NumberHours"));
                cource.setPrice(rs.getDouble("Price"));
                allcourceList.add(cource);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(CourceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return allcourceList;
    }
    public ArrayList<Cource> getAllCourceList() throws NamingException, SQLException{
        if(!allcourceList.isEmpty()){
            return allcourceList;
        } else {
            return getAllCources();
        }
    }
    
    public Cource getCourceById(int id) throws NamingException, SQLException{
        Cource cource=new Cource();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM cources WHERE Cource_ID="+id);
        while(rs.next()){
                cource.setCource_ID(rs.getInt("Cource_ID"));
                cource.setCource(rs.getString("Cource"));
                cource.setNumberHours(rs.getInt("NumberHours"));
                cource.setPrice(rs.getDouble("Price"));
            }
        return cource;
    }
    
    public int getIdByCource(String cource) throws SQLException, NamingException{
        int Cource_ID=0;
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT Cource_ID FROM cources WHERE Cource='"+cource+"'");
        while(rs.next()){
            Cource_ID=rs.getInt("Cource_ID");
        }
        return Cource_ID;
    }
}
