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
public class PhysfaceList {
    private Map<Integer, ArrayList<Physface>> allphysfaceList=new HashMap<Integer, ArrayList<Physface>>();
    private ArrayList <Physface> data;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private Set<Map.Entry<Integer, ArrayList<Physface>>> getAllPhysfaces() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM physface");
            while(rs.next()){
                Physface physface=new Physface();
                data=new ArrayList<Physface>();
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
                data.add(physface);
                allphysfaceList.put(physface.getPhys_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allphysfaceList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<Physface>>> getAllPhysfaceList() throws NamingException, SQLException{
        if(!allphysfaceList.isEmpty()){
            return allphysfaceList.entrySet();
        } else {
            return getAllPhysfaces();
        }
    }
    
}
