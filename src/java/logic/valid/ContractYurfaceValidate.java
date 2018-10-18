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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.dao.CourceDAO;
import logic.dao.PayPeriodDAO;
import logic.dao.PayTypeDAO;
import logic.dao.TypeContractDAO;
import logic.entity.ContractOrderYurface;

/**
 *
 * @author Admin
 */
public class ContractYurfaceValidate {
    private ContractOrderYurface insertContractYurface;
    private ContractOrderYurface updateContractYurface;
    private CourceDAO courcedao=new CourceDAO();
    private TypeContractDAO typecontractdao=new TypeContractDAO();
    private PayTypeDAO paytypedao=new PayTypeDAO();
    private PayPeriodDAO payperioddao=new PayPeriodDAO();
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    
    public String getInsertColumnList(ContractOrderYurface contract) throws SQLException, NamingException{
        int sumColumn=0;
        setInsertContractOrderYurface(contract);
        insertList=new ArrayList<String>();
        int Cource_ID=0;
        int TypeContract_ID=0;
        int PayType_ID=0;
        int PayPeriod_ID=0;
        if(!(insertContractYurface.getCource()+"").equals("null")){
                Cource_ID=courcedao.getIdByCource(insertContractYurface.getCource());
        }
        if(!(insertContractYurface.getTypeContract()+"").equals("null")){
                TypeContract_ID=typecontractdao
                        .getIdByTypeContract(insertContractYurface.getTypeContract());
        }
        if(!(insertContractYurface.getPayType()+"").equals("null")){
                PayType_ID=paytypedao.getIdByPayType(insertContractYurface.getPayType());
        }
        if(!(insertContractYurface.getPayPeriod()+"").equals("null")){
                PayPeriod_ID=payperioddao
                        .getIdByPayPeriod(insertContractYurface.getPayPeriod());
        }
        insertContractYurface.setCource_ID(Cource_ID);
        insertContractYurface.setTypeContract_ID(TypeContract_ID);
        insertContractYurface.setTypeContract_ID(TypeContract_ID);
        insertContractYurface.setPayType_ID(PayType_ID);
        insertContractYurface.setPayPeriod_ID(PayPeriod_ID);
        if(!(insertContractYurface.getDateContract()+"").equals("null")){
            insertList.add("DateContract");
            sumColumn++;
        }
        if(insertContractYurface.getAppTeach_ID()!=0){
            insertList.add("AppTeach_ID");
            sumColumn++;
        }
        if(insertContractYurface.getYur_ID()!=0){
            insertList.add("Yur_ID");
            sumColumn++;
        }
        if(insertContractYurface.getCource_ID()!=0){
            insertList.add("Cource_ID");
            sumColumn++;
        }
        if(insertContractYurface.getTypeContract_ID()!=0){
            insertList.add("TypeContract_ID");
            sumColumn++;
        }
        if(insertContractYurface.getPayType_ID()!=0){
            insertList.add("PayType_ID");
            sumColumn++;
        }
        if(!(insertContractYurface.getDateBegin()+"").equals("null")){
            insertList.add("DateBegin");
            sumColumn++;
        }
        if(!(insertContractYurface.getDateEnd()+"").equals("null")){
            insertList.add("DateEnd");
            sumColumn++;
        }
        if(insertContractYurface.getPrice()!=0){
            insertList.add("Price");
            sumColumn++;
        }
        if(insertContractYurface.getPayPeriod_ID()!=0){
            insertList.add("PayPeriod_ID");
            sumColumn++;
        }
        if(insertContractYurface.getSumPay()!=0){
            insertList.add("SumPay");
            sumColumn++;
        }
        if(insertContractYurface.getSumYear()!=0){
            insertList.add("SumYear");
            sumColumn++;
        }
        if(!(insertContractYurface.getDetailsContract()+"").equals("null")){
            insertList.add("DetailsContract");
            sumColumn++;
        }
        if(!(insertContractYurface.getComment()+"").equals("null")){
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
                    fillPrepStmt.setDate(i, insertContractYurface.getDateContract());
                    i++;
                    break;
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, insertContractYurface.getAppTeach_ID());
                    i++;
                    break;
                case "Yur_ID":
                    fillPrepStmt.setInt(i, insertContractYurface.getYur_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, insertContractYurface.getCource_ID());
                    i++;
                    break;
                case "TypeContract_ID":
                    fillPrepStmt.setInt(i, insertContractYurface.getTypeContract_ID());
                    i++;
                    break;
                case "PayType_ID":
                    fillPrepStmt.setInt(i, insertContractYurface.getPayType_ID());
                    i++;
                    break;
                case "DateBegin":
                    fillPrepStmt.setDate(i, insertContractYurface.getDateBegin());
                    i++;
                    break;
                case "DateEnd":
                    fillPrepStmt.setDate(i, insertContractYurface.getDateEnd());
                    i++;
                    break;
                case "Price":
                    fillPrepStmt.setDouble(i, insertContractYurface.getPrice());
                    i++;
                    break;
                case "PayPeriod_ID":
                    fillPrepStmt.setInt(i, insertContractYurface.getPayPeriod_ID());
                    i++;
                    break;
                case "SumPay":
                    fillPrepStmt.setDouble(i, insertContractYurface.getSumPay());
                    i++;
                    break;
                case "SumYear":
                    fillPrepStmt.setDouble(i, insertContractYurface.getSumYear());
                    i++;
                    break;
                case "DetailsContract":
                    fillPrepStmt.setString(i, insertContractYurface.getDetailsContract());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, insertContractYurface.getComment());
                    i++;
                    break;
                case "CloseContract":
                    fillPrepStmt.setByte(i, insertContractYurface.getCloseContract());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(ContractOrderYurface contract) throws SQLException, NamingException{
        String values="";
        setUpdateContractOrderYurface(contract);
        updateList=new LinkedHashMap<String,String>();
        int Cource_ID=0;
        int TypeContract_ID=0;
        int PayType_ID=0;
        int PayPeriod_ID=0;
        if(!(updateContractYurface.getCource()+"").equals("null")){
                Cource_ID=courcedao.getIdByCource(updateContractYurface.getCource());
        }
        if(!(updateContractYurface.getTypeContract()+"").equals("null")){
                TypeContract_ID=typecontractdao
                        .getIdByTypeContract(updateContractYurface.getTypeContract());
        }
        if(!(updateContractYurface.getPayType()+"").equals("null")){
                PayType_ID=paytypedao.getIdByPayType(updateContractYurface.getPayType());
        }
        if(!(updateContractYurface.getPayPeriod()+"").equals("null")){
                PayPeriod_ID=payperioddao
                        .getIdByPayPeriod(updateContractYurface.getPayPeriod());
        }
        updateContractYurface.setCource_ID(Cource_ID);
        updateContractYurface.setTypeContract_ID(TypeContract_ID);
        updateContractYurface.setTypeContract_ID(TypeContract_ID);
        updateContractYurface.setPayType_ID(PayType_ID);
        updateContractYurface.setPayPeriod_ID(PayPeriod_ID);
        if(!(updateContractYurface.getDateContract()+"").equals("null")){
            updateList.put("DateContract", "DateContract=?");
        }
        if(updateContractYurface.getAppTeach_ID()!=0){
            updateList.put("AppTeach_ID", "AppTeach_ID=?");
        }
        if(updateContractYurface.getYur_ID()!=0){
            updateList.put("Yur_ID", "Yur_ID=?");
        }
        if(updateContractYurface.getCource_ID()!=0){
            updateList.put("Cource_ID", "Cource_ID=?");
        }
        if(updateContractYurface.getTypeContract_ID()!=0){
            updateList.put("TypeContract_ID", "TypeContract_ID=?");
        }
        if(updateContractYurface.getPayType_ID()!=0){
            updateList.put("PayType_ID", "PayType_ID=?");
        }
        if(!(updateContractYurface.getDateBegin()+"").equals("null")){
            updateList.put("DateBegin", "DateBegin=?");
        }
        if(!(updateContractYurface.getDateEnd()+"").equals("null")){
            updateList.put("DateEnd", "DateEnd=?");
        }
        if(updateContractYurface.getPrice()!=0){
            updateList.put("Price", "Price=?");
        }
        if(updateContractYurface.getPayPeriod_ID()!=0){
            updateList.put("PayPeriod_ID", "PayPeriod_ID=?");
        }
        if(updateContractYurface.getSumPay()!=0){
            updateList.put("SumPay", "SumPay=?");
        }
        if(updateContractYurface.getSumYear()!=0){
            updateList.put("SumYear", "SumYear=?");
        }
        if(!(updateContractYurface.getDetailsContract()+"").equals("null")){
            updateList.put("DetailsContract", "DetailsContract=?");
        }
        if(!(updateContractYurface.getComment()+"").equals("null")){
            updateList.put("Comment", "Comment=?");
        }
        updateList.put("CloseContract", "CloseContract=?");
        for(Map.Entry<String, String> str : updateList.entrySet()){
            if(!str.getKey().equals("CloseContract")){
                values+=str.getValue()+", ";
            } else {
                values+=str.getValue();
            }
        }
        updateList.put("ContractYurface", "ContractYurface");
        return values;
        
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        String keys="";
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "DateContract":
                    fillPrepStmt.setDate(i, updateContractYurface.getDateContract());
                    keys+=i+" ";
                    i++;
                    break;
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, updateContractYurface.getAppTeach_ID());
                    keys+=i+" ";
                    i++;
                    break;
                case "Yur_ID":
                    fillPrepStmt.setInt(i, updateContractYurface.getYur_ID());
                    keys+=i+" ";
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, updateContractYurface.getCource_ID());
                    keys+=i+" ";
                    i++;
                    break;
                case "TypeContract_ID":
                    fillPrepStmt.setInt(i, updateContractYurface.getTypeContract_ID());
                    keys+=i+" ";
                    i++;
                    break;
                case "PayType_ID":
                    fillPrepStmt.setInt(i, updateContractYurface.getPayType_ID());
                    keys+=i+" ";
                    i++;
                    break;
                case "DateBegin":
                    fillPrepStmt.setDate(i, updateContractYurface.getDateBegin());
                    keys+=i+" ";
                    i++;
                    break;
                case "DateEnd":
                    fillPrepStmt.setDate(i, updateContractYurface.getDateEnd());
                    keys+=i+" ";
                    i++;
                    break;
                case "Price":
                    fillPrepStmt.setDouble(i, updateContractYurface.getPrice());
                    keys+=i+" ";
                    i++;
                    break;
                case "PayPeriod_ID":
                    fillPrepStmt.setInt(i, updateContractYurface.getPayPeriod_ID());
                    keys+=i+" ";
                    i++;
                    break;
                case "SumPay":
                    fillPrepStmt.setDouble(i, updateContractYurface.getSumPay());
                    keys+=i+" ";
                    i++;
                    break;
                case "SumYear":
                    fillPrepStmt.setDouble(i, updateContractYurface.getSumYear());
                    keys+=i+" ";
                    i++;
                    break;
                case "DetailsContract":
                    fillPrepStmt.setString(i, updateContractYurface.getDetailsContract());
                    keys+=i+" ";
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, updateContractYurface.getComment());
                    keys+=i+" ";
                    i++;
                    break;
                case "CloseContract":
                    fillPrepStmt.setByte(i, updateContractYurface.getCloseContract());
                    keys+=i+" ";
                    i++;
                    break;
                case "ContractYurface":
                    fillPrepStmt.setInt(i, updateContractYurface.getContractsOrdersYurfaces_ID());
                    keys+=i+" ";
                    i++;
                    break;
                default:
                    break;
            }
        }
        
        return fillPrepStmt;
    }
    
    private void setInsertContractOrderYurface(ContractOrderYurface contract){
        this.insertContractYurface=contract;
    }
    
    private void setUpdateContractOrderYurface(ContractOrderYurface contract){
        this.updateContractYurface=contract;
    }
    
}
