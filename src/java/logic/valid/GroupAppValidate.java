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
import logic.entity.GroupApp;

/**
 *
 * @author Admin
 */
public class GroupAppValidate {
    private GroupApp insertGroupApp;
    private GroupApp updateGroupApp;
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    
    public String getInsertColumnList(GroupApp groupapp){
        int sumColumn=0;
        setInsertGroupApp(groupapp);
        insertList=new ArrayList<String>();
        if(insertGroupApp.getAppTeach_ID()!=0){
            insertList.add("AppTeach_ID");
            sumColumn++;
        }
        if(insertGroupApp.getYur_ID()!=0){
            insertList.add("Yur_ID");
            sumColumn++;
        }
        if(insertGroupApp.getPhys_ID()!=0){
            insertList.add("Phys_ID");
            sumColumn++;
        }
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
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, insertGroupApp.getAppTeach_ID());
                    i++;
                    break;
                case "Yur_ID":
                    fillPrepStmt.setInt(i, insertGroupApp.getYur_ID());
                    i++;
                    break;
                case "Phys_ID":
                    fillPrepStmt.setInt(i, insertGroupApp.getPhys_ID());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(GroupApp groupapp){
        int sumColumn=0;
        setUpdateGroupApp(groupapp);
        updateList=new LinkedHashMap<String, String>();
        if(updateGroupApp.getYur_ID()!=0){
            updateList.put("Yur_ID", "Yur_ID=?");
            sumColumn++;
        }
        if(updateGroupApp.getPhys_ID()!=0){
            updateList.put("Phys_ID", "Phys_ID=?");
            sumColumn++;
        }
        String values="";
        int iter=0;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            iter++;
            if(iter!=sumColumn){
                values+=str.getValue()+", ";
            } else {
                values+=str.getValue();
            }
        }
        updateList.put("GroupApp_ID", "GroupApp_ID");
        sumColumn++;
        return values;
        
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, updateGroupApp.getAppTeach_ID());
                    i++;
                    break;
                case "Yur_ID":
                    fillPrepStmt.setInt(i, updateGroupApp.getYur_ID());
                    i++;
                    break;
                case "Phys_ID":
                    fillPrepStmt.setInt(i, updateGroupApp.getPhys_ID());
                    i++;
                    break;
                case "GroupApp_ID":
                    fillPrepStmt.setInt(i, updateGroupApp.getGroupApp_ID());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    private void setInsertGroupApp(GroupApp groupapp){
        this.insertGroupApp=groupapp;
    }
    
    private void setUpdateGroupApp(GroupApp groupapp){
        this.updateGroupApp=groupapp;
    }
}
