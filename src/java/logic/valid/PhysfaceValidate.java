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
import logic.entity.Physface;

/**
 *
 * @author Admin
 */
public class PhysfaceValidate {
    private Physface insertPhysface;
    private Physface updatePhysface;
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    
    public String getInsertColumnList(Physface physface){
        insertList=new ArrayList<String>();
        setInsertPhysface(physface);
        int sumColumn=0;
        if(!insertPhysface.getFIO().equals("")){
            insertList.add("FIO");
            sumColumn++;
        }
        if(!insertPhysface.getPost().equals("")){
            insertList.add("Post");
            sumColumn++;
        }
        if(!insertPhysface.getDocumentScience().equals("")){
            insertList.add("DocumentScience");
            sumColumn++;
        }
        if(!insertPhysface.getSerialNumberDocument().equals("")){
            insertList.add("SerialNumberDocument");
            sumColumn++;
        }
        if(!insertPhysface.getPhoneFax().equals("")){
            insertList.add("PhoneFax");
            sumColumn++;
        }
        if(!insertPhysface.getWebsite().equals("")){
            insertList.add("Website");
            sumColumn++;
        }
        if(!(insertPhysface.getINN()+"").equals("null")){
            insertList.add("INN");
            sumColumn++;
        }
        if(!(insertPhysface.getKPP()+"").equals("null")){
            insertList.add("KPP");
            sumColumn++;
        }
        if(!(insertPhysface.getBIK()+"").equals("null")){
            insertList.add("BIK");
            sumColumn++;
        }
        if(!(insertPhysface.getRS()+"").equals("null")){
            insertList.add("RS");
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
                case "FIO":
                    fillPrepStmt.setString(i, insertPhysface.getFIO());
                    i++;
                    break;
                case "Post":
                    fillPrepStmt.setString(i, insertPhysface.getPost());
                    i++;
                    break;
                case "DocumentScience":
                    fillPrepStmt.setString(i, insertPhysface.getDocumentScience());
                    i++;
                    break;
                case "SerialNumberDocument":
                    fillPrepStmt.setString(i, insertPhysface.getSerialNumberDocument());
                    i++;
                    break;
                case "PhoneFax":
                    fillPrepStmt.setString(i, insertPhysface.getPhoneFax());
                    i++;
                    break;
                case "Website":
                    fillPrepStmt.setString(i, insertPhysface.getWebsite());
                    i++;
                    break;
                case "INN":
                    fillPrepStmt.setLong(i, insertPhysface.getINN());
                    i++;
                    break;
                case "KPP":
                    fillPrepStmt.setLong(i, insertPhysface.getKPP());
                    i++;
                    break;
                case "BIK":
                    fillPrepStmt.setLong(i, insertPhysface.getBIK());
                    i++;
                    break;
                case "RS":
                    fillPrepStmt.setLong(i, insertPhysface.getRS());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getupdateColumnList(Physface physface){
        String values="";
        setUpdatePhysface(physface);
        updateList=new LinkedHashMap<String,String>();
        int sumColumn=0;
        updateList.put("FIO", "FIO=?");
        sumColumn++;
        updateList.put("Post", "Post=?");
        sumColumn++;
        updateList.put("DocumentScience", "DocumentScience=?");
        sumColumn++;
        updateList.put("SerialNumberDocument", "SerialNumberDocument=?");
        sumColumn++;
        updateList.put("PhoneFax", "PhoneFax=?");
        sumColumn++;
        updateList.put("Website", "Website=?");
        sumColumn++;
        if(!(updatePhysface.getINN()+"").equals("null")){
            updateList.put("INN", "INN=?");
            sumColumn++;
        }
        if(!(updatePhysface.getKPP()+"").equals("null")){
            updateList.put("KPP", "KPP=?");
            sumColumn++;
        }
        if(!(updatePhysface.getBIK()+"").equals("null")){
            updateList.put("BIK", "BIK=?");
            sumColumn++;
        }
        if(!(updatePhysface.getRS()+"").equals("null")){
            updateList.put("RS", "RS=?");
            sumColumn++;
        }
        int iter=0;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            iter++;
            if(iter!=sumColumn){
                values+=str.getValue()+", ";
            } else {
                values+=str.getValue();
            }
        }
        updateList.put("Phys_ID", "Phys_ID");
        return values;
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "FIO":
                    fillPrepStmt.setString(i, updatePhysface.getFIO());
                    i++;
                    break;
                case "Post":
                    fillPrepStmt.setString(i, updatePhysface.getPost());
                    i++;
                    break;
                case "DocumentScience":
                    fillPrepStmt.setString(i, updatePhysface.getDocumentScience());
                    i++;
                    break;
                case "SerialNumberDocument":
                    fillPrepStmt.setString(i, updatePhysface.getSerialNumberDocument());
                    i++;
                    break;
                case "PhoneFax":
                    fillPrepStmt.setString(i, updatePhysface.getPhoneFax());
                    i++;
                    break;
                case "Website":
                    fillPrepStmt.setString(i, updatePhysface.getWebsite());
                    i++;
                    break;
                case "INN":
                    fillPrepStmt.setLong(i, updatePhysface.getINN());
                    i++;
                    break;
                case "KPP":
                    fillPrepStmt.setLong(i, updatePhysface.getKPP());
                    i++;
                    break;
                case "BIK":
                    fillPrepStmt.setLong(i, updatePhysface.getBIK());
                    i++;
                    break;
                case "RS":
                    fillPrepStmt.setLong(i, updatePhysface.getRS());
                    i++;
                    break;
                case "Phys_ID":
                    fillPrepStmt.setInt(i, updatePhysface.getPhys_ID());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    private void setInsertPhysface(Physface physface){
        this.insertPhysface=physface;
    }
    
    private void setUpdatePhysface(Physface physface){
        this.updatePhysface=physface;
    }
}
