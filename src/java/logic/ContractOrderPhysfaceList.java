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
public class ContractOrderPhysfaceList {
    private Map<Integer, ArrayList<ContractOrderPhysface>> allContractList=new HashMap<Integer, ArrayList<ContractOrderPhysface>>();
    private ArrayList <ContractOrderPhysface> data;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private Set<Map.Entry<Integer, ArrayList<ContractOrderPhysface>>> getAllContractYurface() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_physfaces.ContractsOrdersPhysfaces_ID, \n" +
"contracts_orders_physfaces.DateContract, physfaces.FIO, cources.Cource, \n" +
"contracts_orders_physfaces.Number, contracts_orders_physfaces.Price, \n" +
"contracts_orders_physfaces.DatePay, contracts_orders_physfaces.Ticket_ID, \n" +
"contracts_orders_physfaces.DetailsContract, contracts_orders_physfaces.Comment, \n" +
"contracts_orders_physfaces.CloseContract FROM contracts_orders_physfaces \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=(SELECT Phys_ID FROM app_teach \n" +
"WHERE app_teach.AppTeach_ID=contracts_orders_physfaces.AppTeach_ID) \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM app_teach \n" +
"WHERE app_teach.AppTeach_ID=contracts_orders_physfaces.AppTeach_ID)");
            while(rs.next()){
                ContractOrderPhysface contractphysface=new ContractOrderPhysface();
                data=new ArrayList<ContractOrderPhysface>();
                contractphysface.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                contractphysface.setDateContract(rs.getDate("DateContract"));
                contractphysface.setFIO(rs.getString("FIO"));
                contractphysface.setCource(rs.getString("Cource"));
                contractphysface.setNumber(rs.getInt("Number"));
                contractphysface.setPrice(rs.getDouble("Price"));
                contractphysface.setDatePay(rs.getDate("DatePay"));
                contractphysface.setTicket_ID(rs.getInt("Ticket_ID"));
                contractphysface.setDetailsContract(rs.getString("DetailsContract"));
                contractphysface.setComment(rs.getString("Comment"));
                contractphysface.setCloseContract(rs.getByte("CloseContract"));
                data.add(contractphysface);
                allContractList.put(contractphysface.getContractsOrdersPhysfaces_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allContractList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<ContractOrderPhysface>>> getAllContractList() throws NamingException, SQLException{
        if(!allContractList.isEmpty()){
            return allContractList.entrySet();
        } else {
            return getAllContractYurface();
        }
    }
    
}
