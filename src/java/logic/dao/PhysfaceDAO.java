/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import java.util.ArrayList;
import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.Physface;
import logic.valid.PhysfaceValidate;

/**
 *
 * @author Admin
 */
public class PhysfaceDAO {
    private ArrayList<Physface> allphysfaceList=new ArrayList<Physface>();
    private ArrayList <Physface> data;
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private PhysfaceValidate physfacevalid=new PhysfaceValidate();
    public ArrayList<Physface> getAllPhysfaces() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM physfaces");
            while(rs.next()){
                Physface physface=new Physface();
                physface.setPhys_ID(rs.getInt("Phys_ID"));
                physface.setFIO(rs.getString("FIO"));
                physface.setPost(rs.getString("Post"));
                physface.setDocumentScience(rs.getString("DocumentScience"));
                physface.setSerialNumberDocument(rs.getString("SerialNumberDocument"));
                physface.setPhoneFax(rs.getString("PhoneFax"));
                physface.setWebsite(rs.getString("Website"));
                physface.setINN(rs.getLong("INN"));
                physface.setKPP(rs.getLong("KPP"));
                physface.setBIK(rs.getLong("BIK"));
                physface.setRS(rs.getLong("RS"));
                allphysfaceList.add(physface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allphysfaceList;
    }
    public ArrayList<Physface> getAllPhysfaceList() throws NamingException, SQLException{
        if(!allphysfaceList.isEmpty()){
            return allphysfaceList;
        } else {
            return getAllPhysfaces();
        }
    }
    
    public ArrayList<Physface> getUniqueColumnValue(String colname) throws SQLException, NamingException{
        ArrayList<Physface> uniquecolumnList=new ArrayList<Physface>();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT DISTINCT "+colname+" FROM physfaces");
            while(rs.next()){
                Physface physface=new Physface();
                switch(colname){
                    case "Phys_ID":
                      physface.setPhys_ID(rs.getInt("Phys_ID"));
                    break;
                    case "FIO":
                      physface.setFIO(rs.getString("FIO"));
                    break;
                    case "Post":
                      physface.setPost(rs.getString("Post"));
                    break;
                    case "DocumentScience":
                      physface.setDocumentScience(rs.getString("DocumentScience"));
                    break;
                    case "SerialNumberDocument":
                      physface.setSerialNumberDocument(rs.getString("SerialNumberDocument"));
                    break;
                    case "PhoneFax":
                      physface.setPhoneFax(rs.getString("PhoneFax"));
                    break;
                    case "Website":
                      physface.setWebsite(rs.getString("Website"));
                    break;
                    case "INN":
                      physface.setINN(rs.getLong("INN"));
                    break;
                    case "KPP":
                      physface.setKPP(rs.getLong("KPP"));
                    break;
                    case "BIK":  
                      physface.setBIK(rs.getLong("BIK"));
                    break;
                    case "RS":
                      physface.setRS(rs.getLong("RS"));
                    break;
                }
                uniquecolumnList.add(physface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return uniquecolumnList;
    }
    
    public Physface getPhysfaceById(int id) throws NamingException, SQLException{
        Physface physface=new Physface(); 
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM physfaces WHERE Phys_ID="+id);
            while(rs.next()){
                physface.setPhys_ID(rs.getInt("Phys_ID"));
                physface.setFIO(rs.getString("FIO"));
                physface.setPost(rs.getString("Post"));
                physface.setDocumentScience(rs.getString("DocumentScience"));
                physface.setSerialNumberDocument(rs.getString("SerialNumberDocument"));
                physface.setPhoneFax(rs.getString("PhoneFax"));
                physface.setWebsite(rs.getString("Website"));
                physface.setINN(rs.getLong("INN"));
                physface.setKPP(rs.getLong("KPP"));
                physface.setBIK(rs.getLong("BIK"));
                physface.setRS(rs.getLong("RS"));
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return physface;
    }
    
    public void insertPhysface(Physface physface) throws NamingException, SQLException{
        String values=physfacevalid.getInsertColumnList(physface);
        String sql="INSERT INTO physfaces "+values;
          conn=Database.getConnection();
          prepstmt=conn.prepareStatement(sql);
          physfacevalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    
    public void updatePhysface(Physface physface) throws NamingException, SQLException{
        String values=physfacevalid.getupdateColumnList(physface);
        String sql="UPDATE physfaces SET "+values+" WHERE Phys_ID=?";
        conn=Database.getConnection();
        prepstmt=conn.prepareStatement(sql);
        physfacevalid.fillUpdateData(prepstmt).executeUpdate();
    }
    
    public void updatePhysfaceList(ArrayList<Physface> physfacelist) throws NamingException, SQLException{
        for(Physface physface : physfacelist){
            updatePhysface(physface);
        }
    }
    
    public void deletePhysface(Physface physface) throws NamingException, SQLException{
        String sql="DELETE FROM physfaces WHERE Phys_ID="+physface.getPhys_ID();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.executeUpdate(sql);
    }
    
    public void deletePhysfaceList(ArrayList<Physface> physfacelist) throws NamingException, SQLException{
        for(Physface physface : physfacelist){
            deletePhysface(physface);
        }
    }
    
}
