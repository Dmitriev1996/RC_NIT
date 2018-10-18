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
import logic.dao.PayDAO;
import logic.dao.PayPeriodDAO;
import logic.dao.PayTypeDAO;
import logic.dao.StatusAppDAO;
import logic.dao.TypeContractDAO;
import logic.dao.TypeScienceDAO;
import logic.entity.AppTeach;

/**
 *
 * @author Admin
 */
public class PhysfaceAppTeachValidate {
    private AppTeach insertPhysfaceAppTeach;
    private AppTeach updatePhysfaceAppTeach;
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    private CourceDAO courcedao=new CourceDAO();
    private PayDAO paydao=new PayDAO();
    private TypeScienceDAO typesciencedao=new TypeScienceDAO();
    private StatusAppDAO statusappdao=new StatusAppDAO();
    PayPeriodDAO payperioddao=new PayPeriodDAO();
    
    public String getInsertColumnList(AppTeach physfaceappteach) throws SQLException, NamingException{
        insertList=new ArrayList<String>();
        setInsertPhysfaceAppTeach(physfaceappteach);
        int sumColumn=0;
        int Cource_ID=0;
        int Pay_ID=0;
        int TypeScience_ID=0;
        int StatusApp_ID=0;
        byte Certification_ID=0;
        if(!insertPhysfaceAppTeach.getCource().equals("")){
            Cource_ID=courcedao.getIdByCource(insertPhysfaceAppTeach.getCource());
        }
        if(!insertPhysfaceAppTeach.getPay().equals("")){
            Pay_ID=paydao.getIdByPay(insertPhysfaceAppTeach.getPay());
        }
        if(!insertPhysfaceAppTeach.getTypeScience().equals("")){
            TypeScience_ID=typesciencedao.getIdByTypeScience(insertPhysfaceAppTeach.getTypeScience());
        }
        if(!insertPhysfaceAppTeach.getStatusApp().equals("")){
            StatusApp_ID=statusappdao.getIdByStatusApp(insertPhysfaceAppTeach.getStatusApp());
        }
        if(insertPhysfaceAppTeach.getCertification().equals("Да")){
            Certification_ID=1;
        } else {
            Certification_ID=0;
        }
        insertPhysfaceAppTeach.setCource_ID(Cource_ID);
        insertPhysfaceAppTeach.setPay_ID(Pay_ID);
        insertPhysfaceAppTeach.setTypeScience_ID(TypeScience_ID);
        insertPhysfaceAppTeach.setStatusApp_ID(StatusApp_ID);
        insertPhysfaceAppTeach.setCertification_ID(Certification_ID);
        if(insertPhysfaceAppTeach.getPhys_ID()!=0){
            insertList.add("Phys_ID");
            sumColumn++;
        }
        if(insertPhysfaceAppTeach.getCource_ID()!=0){
            insertList.add("Cource_ID");
            sumColumn++;
        }
        if(!insertPhysfaceAppTeach.getCertification().equals("")){
            insertList.add("Certification");
            sumColumn++;
        }
        if(insertPhysfaceAppTeach.getPay_ID()!=0){
            insertList.add("Pay_ID");
            sumColumn++;
        }
        if(insertPhysfaceAppTeach.getTypeScience_ID()!=0){
            insertList.add("TypeScience_ID");
            sumColumn++;
        }
        if(insertPhysfaceAppTeach.getStatusApp_ID()!=0){
            insertList.add("StatusApp_ID");
            sumColumn++;
        }
        if(!insertPhysfaceAppTeach.getComment().equals("")){
            insertList.add("Comment");
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
                case "Phys_ID":
                    fillPrepStmt.setInt(i, insertPhysfaceAppTeach.getPhys_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, insertPhysfaceAppTeach.getCource_ID());
                    i++;
                    break;
                case "Certification":
                    fillPrepStmt.setByte(i, insertPhysfaceAppTeach.getCertification_ID());
                    i++;
                    break;
                case "Pay_ID":
                    fillPrepStmt.setInt(i, insertPhysfaceAppTeach.getPay_ID());
                    i++;
                    break;
                case "TypeScience_ID":
                    fillPrepStmt.setInt(i, insertPhysfaceAppTeach.getTypeScience_ID());
                    i++;
                    break;
                case "StatusApp_ID":
                    fillPrepStmt.setInt(i, insertPhysfaceAppTeach.getStatusApp_ID());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, insertPhysfaceAppTeach.getComment());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(AppTeach appteach) throws SQLException, NamingException{
        setUpdatePhysfaceAppTeach(appteach);
        String values="";
        int sumColumn=0;
        int Cource_ID=0;
        int Pay_ID=0;
        int TypeScience_ID=0;
        int StatusApp_ID=0;
        byte Certification_ID=0;
        if(!updatePhysfaceAppTeach.getCource().equals("")){
            Cource_ID=courcedao.getIdByCource(updatePhysfaceAppTeach.getCource());
        }
        if(!updatePhysfaceAppTeach.getPay().equals("")){
            Pay_ID=paydao.getIdByPay(updatePhysfaceAppTeach.getPay());
        }
        if(!updatePhysfaceAppTeach.getTypeScience().equals("")){
            TypeScience_ID=typesciencedao.getIdByTypeScience(updatePhysfaceAppTeach.getTypeScience());
        }
        if(!updatePhysfaceAppTeach.getStatusApp().equals("")){
            StatusApp_ID=statusappdao.getIdByStatusApp(updatePhysfaceAppTeach.getStatusApp());
        }
        if(updatePhysfaceAppTeach.getCertification().equals("Да")){
            Certification_ID=1;
        } else {
            Certification_ID=0;
        }
        updatePhysfaceAppTeach.setCource_ID(Cource_ID);
        updatePhysfaceAppTeach.setPay_ID(Pay_ID);
        updatePhysfaceAppTeach.setTypeScience_ID(TypeScience_ID);
        updatePhysfaceAppTeach.setStatusApp_ID(StatusApp_ID);
        updateList=new LinkedHashMap<String,String>();
        if(updatePhysfaceAppTeach.getPhys_ID()!=0){
            updateList.put("Phys_ID", "Phys_ID=?");
            sumColumn++;
        }
        if(updatePhysfaceAppTeach.getCource_ID()!=0){
            updateList.put("Cource_ID", "Cource_ID=?");
            sumColumn++;
        }
        if(!updatePhysfaceAppTeach.getCertification().equals("")){
            updateList.put("Certification", "Certification=?");
            sumColumn++;
        }
        if(updatePhysfaceAppTeach.getPay_ID()!=0){
            updateList.put("Pay_ID", "Pay_ID=?");
            sumColumn++;
        }
        if(updatePhysfaceAppTeach.getTypeScience_ID()!=0){
            updateList.put("TypeScience_ID", "TypeScience_ID=?");
            sumColumn++;
        }
        if(updatePhysfaceAppTeach.getStatusApp_ID()!=0){
            updateList.put("StatusApp_ID", "StatusApp_ID=?");
            sumColumn++;
        }
        updateList.put("Comment", "Comment=?");
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
        updateList.put("AppTeach_ID", "AppTeach");
        sumColumn++;
        return values;
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "Phys_ID":
                    fillPrepStmt.setInt(i, updatePhysfaceAppTeach.getPhys_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, updatePhysfaceAppTeach.getCource_ID());
                    i++;
                    break;
                case "Certification":
                    fillPrepStmt.setByte(i, updatePhysfaceAppTeach.getCertification_ID());
                    i++;
                    break;
                case "Pay_ID":
                    fillPrepStmt.setInt(i, updatePhysfaceAppTeach.getPay_ID());
                    i++;
                    break;
                case "TypeScience_ID":
                    fillPrepStmt.setInt(i, updatePhysfaceAppTeach.getTypeScience_ID());
                    i++;
                    break;
                case "StatusApp_ID":
                    fillPrepStmt.setInt(i, updatePhysfaceAppTeach.getStatusApp_ID());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, updatePhysfaceAppTeach.getComment());
                    i++;
                    break;
                case "AppTeach_ID":
                    fillPrepStmt.setInt(i, updatePhysfaceAppTeach.getAppTeach_ID());
                    i++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(i);
        return fillPrepStmt;
    }
    
    private void setInsertPhysfaceAppTeach(AppTeach appteach){
        this.insertPhysfaceAppTeach=appteach;
    }
    
    private void setUpdatePhysfaceAppTeach(AppTeach appteach){
        this.updatePhysfaceAppTeach=appteach;
    }
}
