/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.ContractOrderYurface;
import logic.entity.OrderAdmission;
import logic.valid.ContractYurfaceValidate;
/**
 *
 * @author Admin
 */
public class ContractOrderYurfaceDAO {
    private ArrayList<ContractOrderYurface> allContractList=new ArrayList<ContractOrderYurface>();
    private ArrayList<ContractOrderYurface> atParamsList=new ArrayList<ContractOrderYurface>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private OrderAdmissionYurfaceDAO orderdao=new OrderAdmissionYurfaceDAO();
    private CourceDAO courcedao=new CourceDAO();
    private TypeContractDAO typecontractdao=new TypeContractDAO();
    private PayTypeDAO paytypedao=new PayTypeDAO();
    private PayPeriodDAO payperioddao=new PayPeriodDAO();
    private ContractYurfaceValidate contractvalid=new ContractYurfaceValidate();
        private ArrayList<ContractOrderYurface> getAllContractYurface() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_yurfaces.ContractsOrdersYurfaces_ID, \n" +
"contracts_orders_yurfaces.DateContract, contracts_orders_yurfaces.AppTeach_ID, \n" +
"contracts_orders_yurfaces.Yur_ID, contracts_orders_yurfaces.Cource_ID, \n" +
"yurfaces.NameOrganization, cources.Cource, type_contract.TypeContract, \n" +
"pay_type.PayType, contracts_orders_yurfaces.DateBegin, contracts_orders_yurfaces.DateEnd, \n" +
"contracts_orders_yurfaces.Price, pay_period.PayPeriod, \n" +
"contracts_orders_yurfaces.SumPay, contracts_orders_yurfaces.SumYear, \n" +
"contracts_orders_yurfaces.Comment, contracts_orders_yurfaces.DetailsContract, \n" +
"contracts_orders_yurfaces.CloseContract FROM contracts_orders_yurfaces \n" +
"LEFT OUTER JOIN yurfaces ON yurfaces.Yur_ID=contracts_orders_yurfaces.Yur_ID \n" +
"LEFT OUTER JOIN cources ON cources.Cource_ID=contracts_orders_yurfaces.Cource_ID\n" +
"LEFT OUTER JOIN type_contract ON \n" +
"type_contract.TypeContract_ID=contracts_orders_yurfaces.TypeContract_ID \n" +
"LEFT OUTER JOIN pay_type ON pay_type.PayType_ID=contracts_orders_yurfaces.PayType_ID \n" +
"LEFT OUTER JOIN pay_period ON \n" +
"pay_period.PayPeriod_ID=contracts_orders_yurfaces.PayPeriod_ID");
            while(rs.next()){
                ContractOrderYurface contractyurface=new ContractOrderYurface();
                contractyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                contractyurface.setDateContract(rs.getDate("DateContract"));
                contractyurface.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                contractyurface.setYur_ID(rs.getInt("Yur_ID"));
                contractyurface.setCource_ID(rs.getInt("Cource_ID"));
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
                allContractList.add(contractyurface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allContractList;
    }
    public ArrayList<ContractOrderYurface> getAllContractList() throws NamingException, SQLException{
        if(!allContractList.isEmpty()){
            return allContractList;
        } else {
            return getAllContractYurface();
        }
    }
    
    public ArrayList<ContractOrderYurface> getContractYurfaceListAtParams(String params) throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_yurfaces.ContractsOrdersYurfaces_ID, \n" +
"contracts_orders_yurfaces.DateContract, contracts_orders_yurfaces.AppTeach_ID," +
"contracts_orders_yurfaces.Yur_ID, contracts_orders_yurfaces.Cource_ID, yurfaces.NameOrganization, \n" +
"cources.Cource, type_contract.TypeContract, pay_type.PayType, \n" +
"contracts_orders_yurfaces.DateBegin, contracts_orders_yurfaces.DateEnd, \n" +
"contracts_orders_yurfaces.Price, pay_period.PayPeriod, \n" +
"contracts_orders_yurfaces.SumPay, contracts_orders_yurfaces.SumYear, \n" +
"contracts_orders_yurfaces.Comment, contracts_orders_yurfaces.DetailsContract, \n" +
"contracts_orders_yurfaces.CloseContract FROM contracts_orders_yurfaces \n" +
"INNER JOIN yurfaces ON yurfaces.Yur_ID=contracts_orders_yurfaces.Yur_ID \n" +
"INNER JOIN cources ON cources.Cource_ID=contracts_orders_yurfaces.Cource_ID\n" +
"INNER JOIN type_contract ON \n" +
"type_contract.TypeContract_ID=contracts_orders_yurfaces.TypeContract_ID \n" +
"INNER JOIN pay_type ON pay_type.PayType_ID=contracts_orders_yurfaces.PayType_ID \n" +
"INNER JOIN pay_period ON \n" +
"pay_period.PayPeriod_ID=contracts_orders_yurfaces.PayPeriod_ID WHERE "+params);
            while(rs.next()){
                ContractOrderYurface contractyurface=new ContractOrderYurface();
                contractyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                contractyurface.setDateContract(rs.getDate("DateContract"));
                contractyurface.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                contractyurface.setYur_ID(rs.getInt("Yur_ID"));
                contractyurface.setCource_ID(rs.getInt("Cource_ID"));
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
                atParamsList.add(contractyurface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ContractOrderYurface getContractYurfaceById(int id) throws NamingException, SQLException{
        ContractOrderYurface contractyurface=new ContractOrderYurface();
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_yurfaces.ContractsOrdersYurfaces_ID, \n" +
"contracts_orders_yurfaces.DateContract, contracts_orders_yurfaces.AppTeach_ID," +
"contracts_orders_yurfaces.Yur_ID, contracts_orders_yurfaces.Cource_ID, yurfaces.NameOrganization, \n" +
"cources.Cource, type_contract.TypeContract, pay_type.PayType, \n" +
"contracts_orders_yurfaces.DateBegin, contracts_orders_yurfaces.DateEnd, \n" +
"contracts_orders_yurfaces.Price, pay_period.PayPeriod, \n" +
"contracts_orders_yurfaces.SumPay, contracts_orders_yurfaces.SumYear, \n" +
"contracts_orders_yurfaces.Comment, contracts_orders_yurfaces.DetailsContract, \n" +
"contracts_orders_yurfaces.CloseContract FROM contracts_orders_yurfaces \n" +
"LEFT OUTER JOIN yurfaces ON yurfaces.Yur_ID=contracts_orders_yurfaces.Yur_ID \n"+
"LEFT OUTER JOIN cources ON cources.Cource_ID=contracts_orders_yurfaces.Cource_ID \n" +
"LEFT OUTER JOIN type_contract ON \n" +
"type_contract.TypeContract_ID=contracts_orders_yurfaces.TypeContract_ID \n" +
"LEFT OUTER JOIN pay_type ON pay_type.PayType_ID=contracts_orders_yurfaces.PayType_ID \n" +
"LEFT OUTER JOIN pay_period ON \n" +
"pay_period.PayPeriod_ID=contracts_orders_yurfaces.PayPeriod_ID "
                    + "WHERE contracts_orders_yurfaces.ContractsOrdersYurfaces_ID="+id);
            while(rs.next()){
                contractyurface.setContractsOrdersYurfaces_ID(rs.getInt("ContractsOrdersYurfaces_ID"));
                contractyurface.setDateContract(rs.getDate("DateContract"));
                contractyurface.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                contractyurface.setYur_ID(rs.getInt("Yur_ID"));
                contractyurface.setCource_ID(rs.getInt("Cource_ID"));
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
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return contractyurface;
    }
    
    public void insertContractYurface(ContractOrderYurface contractyurface) throws SQLException, NamingException{
        conn=Database.getConnection();
        String values=contractvalid.getInsertColumnList(contractyurface);
        String sql="";
            sql="INSERT INTO contracts_orders_yurfaces "+values;
            prepstmt=conn.prepareStatement(sql);
            contractvalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    public void insertContractYurfaceOfAppTeach(ContractOrderYurface contractyurface) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="SELECT Cource_ID FROM cources WHERE Cource=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setString(1, contractyurface.getCource());
        rs=prepstmt.executeQuery();
        while(rs.next()){
            contractyurface.setCource_ID(rs.getInt("Cource_ID"));
        }
        sql="INSERT INTO contracts_orders_yurfaces (DateContract, AppTeach_ID, "
                + "Yur_ID, Cource_ID, Price, DetailsContract, Comment, CloseContract) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            prepstmt=conn.prepareStatement(sql);
            prepstmt.setDate(1, contractyurface.getDateContract());
            prepstmt.setInt(2, contractyurface.getAppTeach_ID());
            prepstmt.setInt(3, contractyurface.getYur_ID());
            prepstmt.setInt(4, contractyurface.getCource_ID());
            prepstmt.setDouble(5, contractyurface.getPrice());
            prepstmt.setString(6, contractyurface.getDetailsContract());
            prepstmt.setString(7, contractyurface.getComment());
            prepstmt.setByte(8, contractyurface.getCloseContract());
            prepstmt.executeUpdate();
    }
    
    public void updateContractYurface(ContractOrderYurface contractyurface) 
            throws NamingException, SQLException{
        conn=Database.getConnection();
        ContractOrderYurface beforeContract
                =getContractYurfaceById(contractyurface.getContractsOrdersYurfaces_ID());
        String values=contractvalid.getUpdateColumnList(contractyurface);
        String sql="";
        sql="UPDATE contracts_orders_yurfaces SET "+values
        + " WHERE ContractsOrdersYurfaces_ID=?"; 
        System.out.println(sql);
        prepstmt=conn.prepareStatement(sql);
        contractvalid.fillUpdateData(prepstmt).executeUpdate();
        byte beforeClose=beforeContract.getCloseContract();
        byte afterClose=contractyurface.getCloseContract();
        if((beforeClose!=afterClose)&&(beforeClose==0)){
            OrderAdmission order=new OrderAdmission();
            order.setContractsOrdersYurfaces_ID(contractyurface.getContractsOrdersYurfaces_ID());
            orderdao.insertOrder(order);
        }
    }
    
    private int countNum(Map<String, String> list){
        int count=0;
        if(list.isEmpty()){
            count=1;
        } else {
            count=list.size()+1;
        }
        return count;
    }
    
    private void createStringSql(ContractOrderYurface contract){
        
    }
}
