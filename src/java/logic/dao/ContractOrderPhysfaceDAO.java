/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import db.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
import logic.entity.ContractOrderPhysface;
import logic.entity.Cource;
import logic.entity.Physface;
import logic.valid.ContractPhysfaceValidate;

/**
 *
 * @author Admin
 */
public class ContractOrderPhysfaceDAO {
    private ArrayList<ContractOrderPhysface> allContractList=new ArrayList<ContractOrderPhysface>();
    private ArrayList<ContractOrderPhysface> atParamsList=new ArrayList<ContractOrderPhysface>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private ContractPhysfaceValidate contractvalid=new ContractPhysfaceValidate();
    private ArrayList<ContractOrderPhysface> getAllContractYurface() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_physfaces.ContractsOrdersPhysfaces_ID, \n" +
"contracts_orders_physfaces.DateContract, contracts_orders_physfaces.AppTeach_ID," +
" physfaces.FIO, cources.Cource, \n" +
"contracts_orders_physfaces.Number, contracts_orders_physfaces.Price, \n" +
"contracts_orders_physfaces.DatePay, \n" +
"contracts_orders_physfaces.DetailsContract, contracts_orders_physfaces.Comment, \n" +
"contracts_orders_physfaces.CloseContract FROM contracts_orders_physfaces \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=contracts_orders_physfaces.Phys_ID \n"+
"INNER JOIN cources ON cources.Cource_ID=contracts_orders_physfaces.Cource_ID");
            while(rs.next()){
                ContractOrderPhysface contractphysface=new ContractOrderPhysface();
                contractphysface.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                contractphysface.setDateContract(rs.getDate("DateContract"));
                contractphysface.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                contractphysface.setFIO(rs.getString("FIO"));
                contractphysface.setCource(rs.getString("Cource"));
                contractphysface.setNumber(rs.getInt("Number"));
                contractphysface.setPrice(rs.getDouble("Price"));
                contractphysface.setDatePay(rs.getDate("DatePay"));
                //contractphysface.setTicket_ID(rs.getInt("Ticket_ID"));
                contractphysface.setDetailsContract(rs.getString("DetailsContract"));
                contractphysface.setComment(rs.getString("Comment"));
                contractphysface.setCloseContract(rs.getByte("CloseContract"));
                allContractList.add(contractphysface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allContractList;
    }
    public ArrayList<ContractOrderPhysface> getAllContractList() throws NamingException, SQLException{
        if(!allContractList.isEmpty()){
            return allContractList;
        } else {
            return getAllContractYurface();
        }
    }
    
    public ArrayList<ContractOrderPhysface> getContractListAtParams(String params) throws SQLException, NamingException{
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_physfaces.ContractsOrdersPhysfaces_ID, \n" +
"contracts_orders_physfaces.DateContract, physfaces.FIO, cources.Cource, \n" +
"contracts_orders_physfaces.Number, contracts_orders_physfaces.Price, \n" +
"contracts_orders_physfaces.DatePay, \n" +
"contracts_orders_physfaces.DetailsContract, contracts_orders_physfaces.Comment, \n" +
"contracts_orders_physfaces.CloseContract FROM contracts_orders_physfaces \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=contracts_orders_physfaces.Phys_ID \n"+ 
"INNER JOIN cources ON cources.Cource_ID=contracts_orders_physfaces.Cource_ID WHERE "+params);
            while(rs.next()){
                ContractOrderPhysface contractphysface=new ContractOrderPhysface();
                contractphysface.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                contractphysface.setDateContract(rs.getDate("DateContract"));
                contractphysface.setFIO(rs.getString("FIO"));
                contractphysface.setCource(rs.getString("Cource"));
                contractphysface.setNumber(rs.getInt("Number"));
                contractphysface.setPrice(rs.getDouble("Price"));
                contractphysface.setDatePay(rs.getDate("DatePay"));
                //contractphysface.setTicket_ID(rs.getInt("Ticket_ID"));
                contractphysface.setDetailsContract(rs.getString("DetailsContract"));
                contractphysface.setComment(rs.getString("Comment"));
                contractphysface.setCloseContract(rs.getByte("CloseContract"));
                atParamsList.add(contractphysface);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(ContractOrderYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ContractOrderPhysface getContractOrderPhysfaceById(int id) throws SQLException, NamingException{
        ContractOrderPhysface contractphysface=new ContractOrderPhysface();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT contracts_orders_physfaces.ContractsOrdersPhysfaces_ID, \n" +
                    "contracts_orders_physfaces.DateContract, contracts_orders_physfaces.Phys_ID, "+
                    "physfaces.FIO, contracts_orders_physfaces.Cource_ID, cources.Cource, \n" +
                    "contracts_orders_physfaces.Number, contracts_orders_physfaces.Price, \n" +
                    "contracts_orders_physfaces.DatePay, \n" +
                    "contracts_orders_physfaces.DetailsContract, contracts_orders_physfaces.Comment, \n" +
                    "contracts_orders_physfaces.CloseContract FROM contracts_orders_physfaces \n" +
                    "INNER JOIN physfaces ON physfaces.Phys_ID=contracts_orders_physfaces.Phys_ID \n"+
                    "INNER JOIN cources ON cources.Cource_ID=contracts_orders_physfaces.Cource_ID "+
                    "WHERE contracts_orders_physfaces.ContractsOrdersPhysfaces_ID="+id);
            while(rs.next()){
                contractphysface.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                contractphysface.setDateContract(rs.getDate("DateContract"));
                contractphysface.setPhys_ID(rs.getInt("Phys_ID"));
                contractphysface.setFIO(rs.getString("FIO"));
                contractphysface.setCource_ID(rs.getInt("Cource_ID"));
                contractphysface.setCource(rs.getString("Cource"));
                contractphysface.setNumber(rs.getInt("Number"));
                contractphysface.setPrice(rs.getDouble("Price"));
                contractphysface.setDatePay(rs.getDate("DatePay"));
                //contractphysface.setTicket_ID(rs.getInt("Ticket_ID"));
                contractphysface.setDetailsContract(rs.getString("DetailsContract"));
                contractphysface.setComment(rs.getString("Comment"));
                contractphysface.setCloseContract(rs.getByte("CloseContract"));
                PhysfaceDAO physfacedao=new PhysfaceDAO();
                Physface physface=physfacedao.getPhysfaceById(contractphysface.getPhys_ID());
                CourceDAO courcedao=new CourceDAO();
                Cource cource=courcedao.getCourceById(contractphysface.getCource_ID());
                contractphysface.setCourceObj(cource);
                contractphysface.setPhysface(physface);
            }
        } catch (NamingException ex) {
            Logger.getLogger(ContractOrderPhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContractOrderPhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contractphysface;
    }
    
    public void insertContractOrderPhysface(ContractOrderPhysface contractphysface) throws SQLException, NamingException{
        conn=Database.getConnection();
        String values=contractvalid.getInsertColumnList(contractphysface);
        String sql="";
        sql="INSERT INTO contracts_orders_physfaces "+values;
        prepstmt=conn.prepareStatement(sql);
        contractvalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    public void updateContractOrderPhysface(ContractOrderPhysface contractphysface) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        String values=contractvalid.getUpdateColumnList(contractphysface);
        sql="UPDATE contracts_orders_physfaces SET "+values+" WHERE ContractsOrdersPhysfaces_ID=?";
        prepstmt=conn.prepareStatement(sql);
        contractvalid.fillUpdateData(prepstmt).executeUpdate();
    }
    
    public void deleteContractOrderPhysface(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM contracts_orders_physfaces WHERE AppTeach_ID="+id);
    }
    
}
