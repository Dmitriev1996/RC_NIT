/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
/**
 *
 * @author Admin
 */
public class YurfaceList {
    private Map<Integer, ArrayList<Yurface>> yurfaceList=new HashMap<Integer, ArrayList<Yurface>>();
    private ArrayList<Yurface> data;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private Set<Map.Entry<Integer, ArrayList<Yurface>>> getYurfaces() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM yurface");
            while(rs.next()){
                Yurface yurface=new Yurface();
                data=new ArrayList<Yurface>();
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
                
                yurfaceList.put(yurface.getYur_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return yurfaceList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<Yurface>>> getYurfaceList() throws NamingException, SQLException{
        if(!yurfaceList.isEmpty()){
            return yurfaceList.entrySet();
        } else {
            return getYurfaces();
        }
    }
}
