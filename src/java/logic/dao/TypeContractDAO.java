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
import logic.entity.TypeContract;

/**
 *
 * @author Admin
 */
public class TypeContractDAO {
    private ArrayList<TypeContract> alltypecontractList=new ArrayList<TypeContract>();
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private ArrayList<TypeContract> getAllTypeContract() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM type_contract");
            while(rs.next()){
                TypeContract typecontract=new TypeContract();
                typecontract.setTypeContract_ID(rs.getInt("TypeContract_ID"));
                typecontract.setTypeContract(rs.getString("TypeContract"));
                alltypecontractList.add(typecontract);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(TypeContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return alltypecontractList;
    }
  
    public ArrayList<TypeContract> getAllTypeContractList() throws NamingException, SQLException{
        if(!alltypecontractList.isEmpty()){
            return alltypecontractList;
        } else {
            return getAllTypeContract();
        }
    }
    
    public int getIdByTypeContract(String TypeContract) throws NamingException{
        int TypeContract_ID=0;
        try {   
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT TypeContract_ID FROM type_contract "
                    + "WHERE TypeContract='"+TypeContract+"'");
            while(rs.next()){
                TypeContract_ID=rs.getInt("TypeContract_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TypeContract_ID;
    }
    
}
