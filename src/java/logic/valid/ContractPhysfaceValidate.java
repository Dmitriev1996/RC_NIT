/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.valid;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.naming.NamingException;
import logic.dao.CourceDAO;
import logic.dao.PayPeriodDAO;
import logic.dao.PayTypeDAO;
import logic.dao.TypeContractDAO;
import logic.entity.ContractOrderPhysface;

/**
 *
 * @author Admin
 */
public class ContractPhysfaceValidate {
    private ContractOrderPhysface insertContractPhysface;
    private ContractOrderPhysface updateContractPhysface;
    private CourceDAO courcedao=new CourceDAO();
    private TypeContractDAO typecontractdao=new TypeContractDAO();
    private PayTypeDAO paytypedao=new PayTypeDAO();
    private PayPeriodDAO payperioddao=new PayPeriodDAO();
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    
    public String getInsertColumnList(ContractOrderPhysface contractphysface) throws SQLException, NamingException{
        setInsertContractPhysface(contractphysface);
        int sumColumn=0;
        insertList=new ArrayList<String>();
        int Cource_ID=0;
        if(!(insertContractPhysface.getCource()+"").equals("null")){
                Cource_ID=courcedao.getIdByCource(insertContractPhysface.getCource());
        }
        insertContractPhysface.setCource_ID(Cource_ID);
        if(!(insertContractPhysface.getDateContract()+"").equals("null")){
            insertList.add("DateContract");
            sumColumn++;
        }
        if(insertContractPhysface.getAppTeach_ID()!=0){
            insertList.add("AppTeach_ID");
            sumColumn++;
        }
        if(insertContractPhysface.getPhys_ID()!=0){
            insertList.add("Phys_ID");
            sumColumn++;
        }
        if(insertContractPhysface.getCource_ID()!=0){
            insertList.add("Cource_ID");
            sumColumn++;
        }
        if(insertContractPhysface.getNumber()!=0){
            insertList.add("Number");
            sumColumn++;
        }
        if(insertContractPhysface.getPrice()!=0){
            insertList.add("Price");
            sumColumn++;
        }
        if(!(insertContractPhysface.getDatePay()+"").equals("null")){
            insertList.add("DatePay");
            sumColumn++;
        }
        if(!insertContractPhysface.getDetailsContract().equals("")){
            insertList.add("DetailsContract");
            sumColumn++;
        }
        if(!insertContractPhysface.getComment().equals("")){
            insertList.add("Comment");
            sumColumn++;
        }
        insertList.add("CloseContract");
        sumColumn++;
        String query="(";
        int iter=0;
        if(!insertList.isEmpty()){
            for(String str : insertList){
            iter++;
            if(iter!=sumColumn){
                query+=str+", ";
            } else {
                query+=str;
            }
        }
        }
        
        query+=") VALUES (";
        for(int i=0;i<sumColumn;i++){
            if(i!=sumColumn-1){
                query+="?, ";
            } else {
                query+="?";
            }
        }
        query+=")";
        return query; 
    }
    
    public PreparedStatement fillInsertData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(String str : insertList){
            switch(str){
                case "DateContract":
                    fillPrepStmt.setDate(i, insertContractPhysface.getDateContract());
                    i++;
                    break;
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, insertContractPhysface.getAppTeach_ID());
                    i++;
                    break;
                case "Phys_ID":
                    fillPrepStmt.setInt(i, insertContractPhysface.getPhys_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, insertContractPhysface.getCource_ID());
                    i++;
                    break;
                case "Number":
                    fillPrepStmt.setInt(i, insertContractPhysface.getNumber());
                    i++;
                    break;
                case "Price":
                    fillPrepStmt.setDouble(i, insertContractPhysface.getPrice());
                    i++;
                    break;
                case "DatePay":
                    fillPrepStmt.setDate(i, insertContractPhysface.getDatePay());
                    i++;
                    break;
                case "DetailsContract":
                    fillPrepStmt.setString(i, insertContractPhysface.getDetailsContract());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, insertContractPhysface.getComment());
                    i++;
                    break;
                case "CloseContract":
                    fillPrepStmt.setByte(i, insertContractPhysface.getCloseContract());
                    i++;
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(ContractOrderPhysface contractphysface) throws SQLException, NamingException{
        String values="";
        int sumColumn=0;
        setUpdateContractPhysface(contractphysface);
        updateList=new LinkedHashMap<String,String>();
        int Cource_ID=0;
        if(!(updateContractPhysface.getCource()+"").equals("null")){
                Cource_ID=courcedao.getIdByCource(updateContractPhysface.getCource());
        }
        updateContractPhysface.setCource_ID(Cource_ID);
        if(!(updateContractPhysface.getDateContract()+"").equals("null")){
            updateList.put("DateContract", "DateContract=?");
            sumColumn++;
        }
        if(updateContractPhysface.getAppTeach_ID()!=0){
            updateList.put("AppTeach_ID", "AppTeach_ID=?");
            sumColumn++;
        }
        if(updateContractPhysface.getPhys_ID()!=0){
            updateList.put("Phys_ID", "Phys_ID=?");
            sumColumn++;
        }
        if(updateContractPhysface.getCource_ID()!=0){
            updateList.put("Cource_ID", "Cource_ID=?");
            sumColumn++;
        }
        if(updateContractPhysface.getNumber()!=0){
            updateList.put("Number", "Number=?");
            sumColumn++;
        }
        if(updateContractPhysface.getPrice()!=0){
            updateList.put("Price", "Price=?");
            sumColumn++;
        }
        if(!(updateContractPhysface.getDatePay()+"").equals("null")){
            updateList.put("DatePay", "DatePay=?");
            sumColumn++;
        }
        updateList.put("DetailsContract", "DetailsContract=?");
        sumColumn++;
        updateList.put("Comment", "Comment=?");
        sumColumn++;
        updateList.put("CloseContract", "CloseContract=?");
        sumColumn++;
        int iter=0;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            iter++;
            if(iter!=sumColumn){
                values+=str.getValue()+", ";
            } else {
                values+=str.getValue();
            }
        }
        updateList.put("ContractOrderPhysface_ID", "ContractOrderPhysface_ID");
        return values;
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "DateContract":
                    fillPrepStmt.setDate(i, updateContractPhysface.getDateContract());
                    i++;
                    break;
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, updateContractPhysface.getAppTeach_ID());
                    i++;
                    break;
                case "Phys_ID":
                    fillPrepStmt.setInt(i, updateContractPhysface.getPhys_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, updateContractPhysface.getCource_ID());
                    i++;
                    break;
                case "Number":
                    fillPrepStmt.setInt(i, updateContractPhysface.getNumber());
                    i++;
                    break;
                case "Price":
                    fillPrepStmt.setDouble(i, updateContractPhysface.getPrice());
                    i++;
                    break;
                case "DatePay":
                    fillPrepStmt.setDate(i, updateContractPhysface.getDatePay());
                    i++;
                    break;
                case "DetailsContract":
                    fillPrepStmt.setString(i, updateContractPhysface.getDetailsContract());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, updateContractPhysface.getComment());
                    i++;
                    break;
                case "CloseContract":
                    fillPrepStmt.setByte(i, updateContractPhysface.getCloseContract());
                    i++;
                    break;
                case "ContractOrderPhysface_ID":
                    fillPrepStmt.setInt(i, updateContractPhysface.getContractsOrdersPhysfaces_ID());
                    i++;
                    break;
                default:
                    break;
                
            }
        }
        return fillPrepStmt;
    }
    
    private void setInsertContractPhysface(ContractOrderPhysface contractphysface){
        this.insertContractPhysface=contractphysface;
    }
    
    private void setUpdateContractPhysface(ContractOrderPhysface contractphysface){
        this.updateContractPhysface=contractphysface;
    }
}
