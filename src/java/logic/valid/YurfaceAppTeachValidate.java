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
import logic.dao.StatusAppDAO;
import logic.dao.TypeScienceDAO;
import logic.entity.AppTeach;

/**
 *
 * @author Admin
 */
public class YurfaceAppTeachValidate {
    private AppTeach insertYurfaceAppTeach;
    private AppTeach updateYurfaceAppTeach;
    private ArrayList<String> insertList;
    private Map<String, String> updateList;
    private CourceDAO courcedao=new CourceDAO();
    private PayDAO paydao=new PayDAO();
    private TypeScienceDAO typesciencedao=new TypeScienceDAO();
    private StatusAppDAO statusappdao=new StatusAppDAO();
    
    private void setInsertAppTeach(AppTeach appteach){
        this.insertYurfaceAppTeach=appteach;
    }
    
    private void setUpdateAppTeach(AppTeach appteach){
        this.updateYurfaceAppTeach=appteach;
    }
    
    public String getInsertColumnList(AppTeach appteach) throws SQLException, NamingException{
        int Cource_ID=0;
        int Pay_ID=0;
        int TypeScience_ID=0;
        int StatusApp_ID=0;
        byte Certification_ID=0;
        setInsertAppTeach(appteach);
        insertList=new ArrayList<String>();
        int sumColumn=0;
        if(!insertYurfaceAppTeach.getCource().equals("")){
            Cource_ID=courcedao.getIdByCource(insertYurfaceAppTeach.getCource());
        }
        if(!insertYurfaceAppTeach.getPay().equals("")){
            Pay_ID=paydao.getIdByPay(insertYurfaceAppTeach.getPay());
        }
        if(!insertYurfaceAppTeach.getTypeScience().equals("")){
            TypeScience_ID=typesciencedao.getIdByTypeScience(insertYurfaceAppTeach.getTypeScience());
        }
        if(!insertYurfaceAppTeach.getStatusApp().equals("")){
            StatusApp_ID=statusappdao.getIdByStatusApp(insertYurfaceAppTeach.getStatusApp());
        }
        if(insertYurfaceAppTeach.getCertification().equals("Да")){
            Certification_ID=1;
        } else {
            Certification_ID=0;
        }
        insertYurfaceAppTeach.setCource_ID(Cource_ID);
        insertYurfaceAppTeach.setPay_ID(Pay_ID);
        insertYurfaceAppTeach.setTypeScience_ID(TypeScience_ID);
        insertYurfaceAppTeach.setStatusApp_ID(StatusApp_ID);
        insertYurfaceAppTeach.setCertification_ID(Certification_ID);
        if(insertYurfaceAppTeach.getYur_ID()!=0){
            insertList.add("Yur_ID");
            sumColumn++;
        }
        if(insertYurfaceAppTeach.getCource_ID()!=0){
            insertList.add("Cource_ID");
            sumColumn++;
        }
        if(!insertYurfaceAppTeach.getCertification().equals("")){
            insertList.add("Certification");
            sumColumn++;
        }
        if(insertYurfaceAppTeach.getPay_ID()!=0){
            insertList.add("Pay_ID");
            sumColumn++;
        }
        if(insertYurfaceAppTeach.getTypeScience_ID()!=0){
            insertList.add("TypeScience_ID");
            sumColumn++;
        }
        if(insertYurfaceAppTeach.getStatusApp_ID()!=0){
            insertList.add("StatusApp_ID");
            sumColumn++;
        }
        if(!insertYurfaceAppTeach.getComment().equals("")){
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
                case "Yur_ID":
                    fillPrepStmt.setInt(i, insertYurfaceAppTeach.getYur_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, insertYurfaceAppTeach.getCource_ID());
                    i++;
                    break;
                case "Certification":
                    fillPrepStmt.setByte(i, insertYurfaceAppTeach.getCertification_ID());
                    i++;
                    break;
                case "Pay_ID":
                    fillPrepStmt.setInt(i, insertYurfaceAppTeach.getPay_ID());
                    i++;
                    break;
                case "TypeScience_ID":
                    fillPrepStmt.setInt(i, insertYurfaceAppTeach.getTypeScience_ID());
                    i++;
                    break;
                case "StatusApp_ID":
                    fillPrepStmt.setInt(i, insertYurfaceAppTeach.getStatusApp_ID());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, insertYurfaceAppTeach.getComment());
                    i++;
                    break;
                default:
                    break;
            }
        }
        return fillPrepStmt;
    }
    
    public String getUpdateColumnList(AppTeach appteach) throws SQLException, NamingException{
        String values="";
        int Cource_ID=0;
        int Pay_ID=0;
        int TypeScience_ID=0;
        int StatusApp_ID=0;
        byte Certification_ID=0;
        setUpdateAppTeach(appteach);
        updateList=new LinkedHashMap<String,String>();
        int sumColumn=0;
        if(!updateYurfaceAppTeach.getCource().equals("")){
            Cource_ID=courcedao.getIdByCource(updateYurfaceAppTeach.getCource());
        }
        if(!updateYurfaceAppTeach.getPay().equals("")){
            Pay_ID=paydao.getIdByPay(updateYurfaceAppTeach.getPay());
        }
        if(!updateYurfaceAppTeach.getTypeScience().equals("")){
            TypeScience_ID=typesciencedao.getIdByTypeScience(updateYurfaceAppTeach.getTypeScience());
        }
        if(!updateYurfaceAppTeach.getStatusApp().equals("")){
            StatusApp_ID=statusappdao.getIdByStatusApp(updateYurfaceAppTeach.getStatusApp());
        }
        if(updateYurfaceAppTeach.getCertification().equals("Да")){
            Certification_ID=1;
        } else {
            Certification_ID=0;
        }
        updateYurfaceAppTeach.setCource_ID(Cource_ID);
        updateYurfaceAppTeach.setPay_ID(Pay_ID);
        updateYurfaceAppTeach.setTypeScience_ID(TypeScience_ID);
        updateYurfaceAppTeach.setStatusApp_ID(StatusApp_ID);
        updateYurfaceAppTeach.setCertification_ID(Certification_ID);
        if(updateYurfaceAppTeach.getYur_ID()!=0){
            updateList.put("Yur_ID", "Yur_ID=?");
            sumColumn++;
        }
        if(updateYurfaceAppTeach.getCource_ID()!=0){
            updateList.put("Cource_ID", "Cource_ID=?");
            sumColumn++;
        }
        if(!updateYurfaceAppTeach.getCertification().equals("")){
            updateList.put("Certification", "Certification=?");
            sumColumn++;
        }
        if(updateYurfaceAppTeach.getPay_ID()!=0){
            updateList.put("Pay_ID", "Pay_ID=?");
            sumColumn++;
        }
        if(updateYurfaceAppTeach.getTypeScience_ID()!=0){
            updateList.put("TypeScience_ID", "TypeScience_ID=?");
            sumColumn++;
        }
        if(updateYurfaceAppTeach.getStatusApp_ID()!=0){
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
        updateList.put("AppTeach", "AppTeach");
        sumColumn++;
        return values;
    }
    
    public PreparedStatement fillUpdateData(PreparedStatement prepstmt) throws SQLException{
        PreparedStatement fillPrepStmt=prepstmt;
        int i=1;
        for(Map.Entry<String, String> str : updateList.entrySet()){
            String columnName=str.getKey();
            switch(columnName){
                case "Yur_ID":
                    fillPrepStmt.setInt(i, updateYurfaceAppTeach.getYur_ID());
                    i++;
                    break;
                case "Cource_ID":
                    fillPrepStmt.setInt(i, updateYurfaceAppTeach.getCource_ID());
                    i++;
                    break;
                case "Certification":
                    fillPrepStmt.setByte(i, updateYurfaceAppTeach.getCertification_ID());
                    i++;
                    break;
                case "Pay_ID":
                    fillPrepStmt.setInt(i, updateYurfaceAppTeach.getPay_ID());
                    i++;
                    break;
                case "TypeScience_ID":
                    fillPrepStmt.setInt(i, updateYurfaceAppTeach.getTypeScience_ID());
                    i++;
                    break;
                case "StatusApp_ID":
                    fillPrepStmt.setInt(i, updateYurfaceAppTeach.getStatusApp_ID());
                    i++;
                    break;
                case "Comment":
                    fillPrepStmt.setString(i, updateYurfaceAppTeach.getComment());
                    i++;
                    break;
                case "AppTeach":
                    fillPrepStmt.setInt(i, updateYurfaceAppTeach.getAppTeach_ID());
                default:
                    break;
            }
        }
        return fillPrepStmt;
        
    }

    
    
}
