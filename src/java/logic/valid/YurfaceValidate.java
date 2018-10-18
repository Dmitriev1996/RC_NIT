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
import logic.entity.Yurface;

/**
 *
 * @author Admin
 */
public class YurfaceValidate {
    private Yurface insertYurface;
    private Yurface updateYurface;
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    
    public String getInsertColumnList(Yurface yurface){
        insertList=new ArrayList<String>();
        setInsertYurface(yurface);
        int sumColumn=0;
        if(!insertYurface.getNameOrganization().equals("")){
            insertList.add("NameOrganization");
            sumColumn++;
        }
        if(!insertYurface.getDirector().equals("")){
            insertList.add("Director");
            sumColumn++;
        }
        if(!insertYurface.getYurAdress().equals("")){
            insertList.add("YurAdress");
            sumColumn++;
        }
        if(!insertYurface.getFactAdress().equals("")){
            insertList.add("FactAdress");
            sumColumn++;
        }
        if(!insertYurface.getPhoneFax().equals("")){
            insertList.add("PhoneFax");
            sumColumn++;
        }
        if(!insertYurface.getEmail().equals("")){
            insertList.add("Email");
            sumColumn++;
        }
        if(!(insertYurface.getRS()+"").equals("null")){
            insertList.add("RS");
            sumColumn++;
        }
        if(!(insertYurface.getKS()+"").equals("null")){
            insertList.add("KS");
            sumColumn++;
        }
        if(!(insertYurface.getBIK()+"").equals("null")){
            insertList.add("BIK");
            sumColumn++;
        }
        if(!(insertYurface.getINN()+"").equals("null")){
            insertList.add("INN");
            sumColumn++;
        }
        if(!(insertYurface.getKPP()+"").equals("null")){
            insertList.add("KPP");
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
                case "NameOrganization":
                    fillPrepStmt.setString(i, insertYurface.getNameOrganization());
                    i++;
                    break;
                case "Director":
                    fillPrepStmt.setString(i, insertYurface.getDirector());
                    i++;
                    break;
                case "YurAdress":
                    fillPrepStmt.setString(i, insertYurface.getYurAdress());
                    i++;
                    break;
                case "FactAdress":
                    fillPrepStmt.setString(i, insertYurface.getFactAdress());
                    i++;
                    break;
                case "PhoneFax":
                    fillPrepStmt.setString(i, insertYurface.getPhoneFax());
                    i++;
                    break;
                case "Email":
                    fillPrepStmt.setString(i, insertYurface.getEmail());
                    i++;
                    break;
                case "RS":
                    fillPrepStmt.setLong(i, insertYurface.getRS());
                    i++;
                    break;
                case "KS":
                    fillPrepStmt.setLong(i, insertYurface.getKS());
                    i++;
                    break;
                case "BIK":
                    fillPrepStmt.setLong(i, insertYurface.getBIK());
                    i++;
                    break;
                case "INN":
                    fillPrepStmt.setLong(i, insertYurface.getINN());
                    i++;
                    break;
                case "KPP":
                    fillPrepStmt.setLong(i, insertYurface.getKPP());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(Yurface yurface){
        String values="";
        updateList=new LinkedHashMap<String, String>();
        setUpdateYurface(yurface);
        int sumColumn=0;
        if(!(updateYurface.getNameOrganization()+"").equals("null")){
            updateList.put("NameOrganization", "NameOrganization=?");
            sumColumn++;
        }
        if(!(updateYurface.getDirector()+"").equals("null")){
            updateList.put("Director", "Director=?");
            sumColumn++;
        }
        if(!(updateYurface.getYurAdress()+"").equals("null")){
            updateList.put("YurAdress", "YurAdress=?");
            sumColumn++;
        }
        if(!(updateYurface.getFactAdress()+"").equals("null")){
            updateList.put("FactAdress", "FactAdress=?");
            sumColumn++;
        }
        if(!(updateYurface.getPhoneFax()+"").equals("null")){
            updateList.put("PhoneFax", "PhoneFax=?");
            sumColumn++;
        }
        if(!(updateYurface.getEmail()+"").equals("null")){
            updateList.put("Email", "Email=?");
            sumColumn++;
        }
        if(updateYurface.getRS()!=0){
            updateList.put("RS", "RS=?");
            sumColumn++;
        }
        if(updateYurface.getKS()!=0){
            updateList.put("KS", "KS=?");
            sumColumn++;
        }
        if(updateYurface.getBIK()!=0){
            updateList.put("BIK", "BIK=?");
            sumColumn++;
        }
        if(updateYurface.getINN()!=0){
            updateList.put("INN", "INN=?");
            sumColumn++;
        }
        if(updateYurface.getKPP()!=0){
            updateList.put("KPP", "KPP=?");
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
        updateList.put("Yur_ID", "Yur_ID");
        sumColumn++;
        return values; 
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "NameOrganization":
                    fillPrepStmt.setString(i, updateYurface.getNameOrganization());
                    i++;
                    break;
                case "Director":
                    fillPrepStmt.setString(i, updateYurface.getDirector());
                    i++;
                    break;
                case "YurAdress":
                    fillPrepStmt.setString(i, updateYurface.getYurAdress());
                    i++;
                    break;
                case "FactAdress":
                    fillPrepStmt.setString(i, updateYurface.getFactAdress());
                    i++;
                    break;
                case "PhoneFax":
                    fillPrepStmt.setString(i, updateYurface.getPhoneFax());
                    i++;
                    break;
                case "Email":
                    fillPrepStmt.setString(i, updateYurface.getEmail());
                    i++;
                    break;
                case "RS":
                    fillPrepStmt.setLong(i, updateYurface.getRS());
                    i++;
                    break;
                case "KS":
                    fillPrepStmt.setLong(i, updateYurface.getKS());
                    i++;
                    break;
                case "BIK":
                    fillPrepStmt.setLong(i, updateYurface.getBIK());
                    i++;
                    break;
                case "INN":
                    fillPrepStmt.setLong(i, updateYurface.getINN());
                    i++;
                    break;
                case "KPP":
                    fillPrepStmt.setLong(i, updateYurface.getKPP());
                    i++;
                    break;
                case "Yur_ID":
                    fillPrepStmt.setInt(i, updateYurface.getYur_ID());
                    i++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(i);
        if(i<=2) {
            fillPrepStmt=null;
        }
        return fillPrepStmt;
    }
    
    private void setInsertYurface(Yurface yurface){
        this.insertYurface=yurface;
    }
    
    private void setUpdateYurface(Yurface yurface){
        this.updateYurface=yurface;
    }
    
    
}
