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
public class ContractOrderYurfaceList {
    private Map<Integer, ArrayList<ContractOrderYurface>> allContractList=new HashMap<Integer, ArrayList<ContractOrderYurface>>();
    private ArrayList <ContractOrderYurface> data;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
        private Set<Map.Entry<Integer, ArrayList<ContractOrderYurface>>> getAllContractYurface() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_yurfaces.ContractsOrdersYurfaces_ID, \n" +
"contracts_orders_yurfaces.DateContract, yurfaces.NameOrganization, \n" +
"cources.Cource, type_contract.TypeContract, pay_type.PayType, \n" +
"contracts_orders_yurfaces.DateBegin, contracts_orders_yurfaces.DateEnd, \n" +
"contracts_orders_yurfaces.Price, pay_period.PayPeriod, \n" +
"contracts_orders_yurfaces.SumPay, contracts_orders_yurfaces.SumYear, \n" +
"contracts_orders_yurfaces.Comment, contracts_orders_yurfaces.DetailsContract, \n" +
"contracts_orders_yurfaces.CloseContract FROM contracts_orders_yurfaces \n" +
"INNER JOIN yurfaces ON yurfaces.Yur_ID=(SELECT Yur_ID FROM app_teach \n" +
"WHERE app_teach.AppTeach_ID=contracts_orders_yurfaces.AppTeach_ID)\n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM app_teach \n" +
"WHERE app_teach.AppTeach_ID=contracts_orders_yurfaces.AppTeach_ID)\n" +
"INNER JOIN type_contract ON \n" +
"type_contract.TypeContract_ID=contracts_orders_yurfaces.TypeContract_ID \n" +
"INNER JOIN pay_type ON pay_type.PayType_ID=contracts_orders_yurfaces.PayType_ID \n" +
"INNER JOIN pay_period ON \n" +
"pay_period.PayPeriod_ID=contracts_orders_yurfaces.PayPeriod_ID");
            while(rs.next()){
                ContractOrderYurface contractyurface=new ContractOrderYurface();
                data=new ArrayList<ContractOrderYurface>();
                contractyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                contractyurface.setDateContract(rs.getDate("DateContract"));
                contractyurface.setNameOrganization(rs.getString("NameOrganization"));
                contractyurface.setCource(rs.getString("Cource"));
                contractyurface.setTypeContract(rs.getString("TypeContract"));
                contractyurface.setTypeContract(rs.getString("TypeContract"));
                contractyurface.setPayType(rs.getString("PayType"));
                contractyurface.setDateBegin(rs.getDate("DateBegin"));
                contractyurface.setDateEnd(rs.getDate("DateEnd"));
                contractyurface.setPrice(rs.getDouble("Price"));
                contractyurface.setPayPeriod(rs.getString("PayPeriod"));
                contractyurface.setSumPay(rs.getDouble("SumPay"));
                contractyurface.setSumYear(rs.getDouble("SumYear"));
                contractyurface.setComment(rs.getString("Comment"));
                contractyurface.setDetailsContract(rs.getString("DetailsContract"));
                contractyurface.setCloseContract(rs.getByte("CloseContract"));
                data.add(contractyurface);
                allContractList.put(contractyurface.getContractsOrdersYurfaces_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allContractList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<ContractOrderYurface>>> getAllContractList() throws NamingException, SQLException{
        if(!allContractList.isEmpty()){
            return allContractList.entrySet();
        } else {
            return getAllContractYurface();
        }
    }
}
