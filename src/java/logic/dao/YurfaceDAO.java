/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import logic.dao.PhysfaceDAO;
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
import logic.entity.Yurface;
import logic.valid.YurfaceValidate;
/**
 *
 * @author Admin
 */
public class YurfaceDAO {
    private ArrayList<Yurface> yurfaceList=new ArrayList<Yurface>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private YurfaceValidate yurfacevalid=new YurfaceValidate();
    private ArrayList<Yurface> getYurfaces() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM yurfaces");
            while(rs.next()){
                Yurface yurface=new Yurface();
                yurface.setYur_ID(rs.getInt("Yur_ID"));
                yurface.setNameOrganization(rs.getString("NameOrganization"));
                yurface.setDirector(rs.getString("Director"));
                yurface.setYurAdress(rs.getString("YurAdress"));
                yurface.setFactAdress(rs.getString("FactAdress"));
                yurface.setPhoneFax(rs.getString("PhoneFax"));
                yurface.setEmail(rs.getString("Email"));
                yurface.setRS(rs.getLong("RS"));
                yurface.setKS(rs.getLong("KS"));
                yurface.setBIK(rs.getLong("BIK"));
                yurface.setINN(rs.getLong("INN"));
                yurface.setKPP(rs.getLong("KPP"));
                yurfaceList.add(yurface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return yurfaceList;
    }
    public ArrayList<Yurface> getYurfaceList() throws NamingException, SQLException{
        if(!yurfaceList.isEmpty()){
            return yurfaceList;
        } else {
            return getYurfaces();
        }
    }
    
    public void insertYurface(Yurface yurface) throws NamingException, SQLException{
        String values=yurfacevalid.getInsertColumnList(yurface);
        String sql="INSERT INTO yurfaces "+values;
        conn=Database.getConnection();
        prepstmt=conn.prepareStatement(sql);
        yurfacevalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    public void updateYurface(Yurface yurface) throws NamingException, SQLException{
        String values=yurfacevalid.getUpdateColumnList(yurface);
        String sql="UPDATE yurfaces SET "+values+" WHERE Yur_ID=?";
        System.out.println(sql);
        conn=Database.getConnection();
        prepstmt=conn.prepareStatement(sql);
        PreparedStatement result=yurfacevalid.fillUpdateData(prepstmt);
        String status=result+"";
        if(!status.equals("null")){
            result.executeUpdate();
        }
    }
    
    public Yurface getYurfaceById(int id) throws NamingException, SQLException{
        Yurface yurface=new Yurface();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT * FROM yurfaces WHERE Yur_ID="+id);
        while(rs.next()){
            yurface.setYur_ID(rs.getInt("Yur_ID"));
                yurface.setNameOrganization(rs.getString("NameOrganization"));
                yurface.setDirector(rs.getString("Director"));
                yurface.setYurAdress(rs.getString("YurAdress"));
                yurface.setFactAdress(rs.getString("FactAdress"));
                yurface.setPhoneFax(rs.getString("PhoneFax"));
                yurface.setEmail(rs.getString("Email"));
                yurface.setRS(rs.getLong("RS"));
                yurface.setKS(rs.getLong("KS"));
                yurface.setBIK(rs.getLong("BIK"));
                yurface.setINN(rs.getLong("INN"));
                yurface.setKPP(rs.getLong("KPP"));
        }
        return yurface;
    }
    
    public void deleteYurface(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM yurfaces WHERE Yur_ID="+id);
    }
}
