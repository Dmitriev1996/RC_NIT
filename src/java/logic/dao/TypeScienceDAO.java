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
import logic.entity.TypeScience;
/**
 *
 * @author Admin
 */
public class TypeScienceDAO {
    private ArrayList<TypeScience> alltypescienceList=new ArrayList<TypeScience>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<TypeScience> getAllTypeScience() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM type_science");
            while(rs.next()){
                TypeScience typescience=new TypeScience();
                typescience.setTypeScience_ID(rs.getInt("TypeScience_ID"));
                typescience.setTypeScience(rs.getString("TypeScience"));
                alltypescienceList.add(typescience);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return alltypescienceList;
    }
    public ArrayList<TypeScience> getAllTypeScienceList() throws NamingException, SQLException{
        if(!alltypescienceList.isEmpty()){
            return alltypescienceList;
        } else {
            return getAllTypeScience();
        }
    }
    
    public int getIdByTypeScience(String typescience){
        int TypeScience_ID=0;
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT TypeScience_ID FROM type_science"
                    + " WHERE TypeScience='"+typescience+"'");
            while(rs.next()){
                TypeScience_ID=rs.getInt("TypeScience_ID");
            }
        } catch (NamingException ex) {
            Logger.getLogger(TypeScienceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TypeScienceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TypeScience_ID;
    }
}
