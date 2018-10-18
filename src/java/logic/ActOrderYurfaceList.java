/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class ActOrderYurfaceList {
    private Map<Integer, ArrayList<ActOrderYurface>> allActList=new HashMap<Integer, ArrayList<ActOrderYurface>>();
    private ArrayList <ActOrderYurface> data;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
        private Set<Map.Entry<Integer, ArrayList<ActOrderYurface>>> getAllActtYurface() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT acts_orders_yurfaces.ActsOrdersYurfaces_ID, acts_orders_yurfaces.DateAct, \n" +
"yurfaces.NameOrganization, cources.Cource, contracts_orders_yurfaces.Price, \n" +
"acts_orders_yurfaces.DatePay, acts_orders_yurfaces.Comment, \n" +
"acts_orders_yurfaces.ReturnAct FROM acts_orders_yurfaces \n" +
"INNER JOIN yurfaces ON yurfaces.Yur_ID=(SELECT Yur_ID FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource FROM \n" +
"contracts_orders_yurfaces \n" +
"WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID) \n" +
"INNER JOIN contracts_orders_yurfaces ON \n" +
"contracts_orders_yurfaces.ContractsOrdersYurfaces_ID=\n" +
"acts_orders_yurfaces.ContractsOrdersYurfaces_ID");
            while(rs.next()){
                ActOrderYurface actyurface=new ActOrderYurface();
                data=new ArrayList<ActOrderYurface>();
                actyurface.setActsOrdersYurface_ID(rs.getInt("ActsOrdersYurfaces_ID"));
                actyurface.setDateAct(rs.getDate("DateAct"));
                actyurface.setNameOrganization(rs.getString("NameOrganization"));
                actyurface.setCource(rs.getString("Cource"));
                actyurface.setPrice(rs.getDouble("Price"));
                actyurface.setDatePay(rs.getDate("DatePay"));
                actyurface.setComment(rs.getString("Comment"));
                actyurface.setReturnAct(rs.getByte("ReturnAct"));
                data.add(actyurface);
                allActList.put(actyurface.getActsOrdersYurface_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allActList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<ActOrderYurface>>> getAllActList() throws NamingException, SQLException{
        if(!allActList.isEmpty()){
            return allActList.entrySet();
        } else {
            return getAllActtYurface();
        }
    }
    
}
