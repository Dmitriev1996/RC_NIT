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
import logic.entity.ActOrderYurface;

/**
 *
 * @author Admin
 */
public class ActOrderYurfaceValidate {
    private ActOrderYurface insertActYurface;
    private ActOrderYurface updateActYurface;
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    
    public String getInsertColumnList(ActOrderYurface actyurface){
        insertList=new ArrayList<String>();
        setInsertActYurface(actyurface);
        int sumColumn=0;
        if(insertActYurface.getContractsOrdersYurfaces_ID()!=0){
            insertList.add("ContractsOrdersYurfaces_ID");
            sumColumn++;
        }
        if(!(insertActYurface.getDateAct()+"").equals("null")){
            insertList.add("DateAct");
            sumColumn++;
        }
        if(insertActYurface.getPrice()!=0){
            insertList.add("Price");
            sumColumn++;
        }
        if(!(insertActYurface.getDatePay()+"").equals("")){
            insertList.add("DatePay");
            sumColumn++;
        }
        if(!insertActYurface.getComment().equals("")){
            insertList.add("Comment");
            sumColumn++;
        }
        insertList.add("ReturnAct");
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
                case "ContractsOrdersYurfaces_ID":
                    fillPrepStmt.setInt(i, insertActYurface.getContractsOrdersYurfaces_ID());
                    i++;
                    break;
                case "DateAct":
                    fillPrepStmt.setDate(i, insertActYurface.getDateAct());
                    i++;
                    break;
                case "Price":
                    fillPrepStmt.setDouble(i, insertActYurface.getPrice());
                    i++;
                    break;
                case "DatePay":
                    fillPrepStmt.setDate(i, insertActYurface.getDatePay());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, insertActYurface.getComment());
                    i++;
                    break;
                case "ReturnAct":
                    fillPrepStmt.setByte(i, insertActYurface.getReturnAct());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(ActOrderYurface actyurface){
        setUpdateActYurface(actyurface);
        String values="";
        int sumColumn=0;
        updateList=new LinkedHashMap<String,String>();
        if(updateActYurface.getContractsOrdersYurfaces_ID()!=0){
            updateList.put("ContractsOrdersYurfaces_ID", "ContractsOrdersYurfaces_ID=?");
            sumColumn++;
        }
        if(!(updateActYurface.getDateAct()+"").equals("null")){
            updateList.put("DateAct", "DateAct=?");
            sumColumn++;
        }
        if(updateActYurface.getPrice()!=0){
            updateList.put("Price", "Price=?");
            sumColumn++;
        }
        if(!(updateActYurface.getDatePay()+"").equals("")){
            updateList.put("DatePay", "DatePay=?");
            sumColumn++;
        }
        updateList.put("Comment", "Comment=?");
        sumColumn++;
        updateList.put("ReturnAct", "ReturnAct=?");
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
        updateList.put("ActOrderYurface_ID", "ActOrderYurface_ID");
        sumColumn++;
        return values;
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "CobtractsOrdersYurfaces_ID":
                    fillPrepStmt.setInt(i, updateActYurface.getContractsOrdersYurfaces_ID());
                    i++;
                    break;
                case "DateAct":
                    fillPrepStmt.setDate(i, updateActYurface.getDateAct());
                    i++;
                    break;
                case "Price":
                    fillPrepStmt.setDouble(i, updateActYurface.getPrice());
                    i++;
                    break;
                case "DatePay":
                    fillPrepStmt.setDate(i, updateActYurface.getDatePay());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, updateActYurface.getComment());
                    i++;
                    break;
                case "ReturnAct":
                    fillPrepStmt.setByte(i, updateActYurface.getReturnAct());
                    i++;
                    break;
                case "ActOrderYurface_ID":
                    fillPrepStmt.setInt(i, updateActYurface.getActsOrdersYurface_ID());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    private void setInsertActYurface(ActOrderYurface actyurface){
        this.insertActYurface=actyurface;
    }
    
    private void setUpdateActYurface(ActOrderYurface actyurface){
        this.updateActYurface=actyurface;
    }
    
}
