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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.AppTeach;
import logic.entity.ContractOrderPhysface;
import logic.entity.Cource;
import logic.entity.Physface;
import logic.valid.PhysfaceAppTeachValidate;

/**
 *
 * @author Admin
 */
public class PhysfaceAppTeachDAO {
    private ArrayList<AppTeach> allPhysfaceAppTeachList=new ArrayList<AppTeach>();
    private ArrayList<AppTeach> atParamsList=new ArrayList<AppTeach>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private PhysfaceAppTeachValidate appteachvalid=new PhysfaceAppTeachValidate();
    private ArrayList<AppTeach> getAllPhysfaceAppTeach() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT app_teach.AppTeach_ID, physfaces.FIO,  \n" +
"            cources.Cource, app_teach.Certification, pay.Pay, type_science.TypeScience, \n" +
"            status_app.StatusApp, app_teach.Comment FROM app_teach \n" +
"            INNER JOIN physfaces ON physfaces.Phys_ID=app_teach.Phys_ID\n" +
"            INNER JOIN cources ON cources.Cource_ID=app_teach.Cource_ID\n" +
"            INNER JOIN pay ON pay.Pay_ID=app_teach.Pay_ID\n" +
"            INNER JOIN type_science ON type_science.TypeScience_ID=app_teach.TypeScience_ID\n" +
"            INNER JOIN status_app ON status_app.StatusApp_ID=app_teach.StatusApp_ID");
            while(rs.next()){
                AppTeach appteach=new AppTeach();
                appteach.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                appteach.setFIO(rs.getString("FIO"));
                appteach.setCource(rs.getString("Cource"));
                if(rs.getByte("Certification")==1){
                    appteach.setCertification("Да");
                } else if(rs.getByte("Certification")==0){
                    appteach.setCertification("Нет");
                }
                appteach.setPay(rs.getString("Pay"));
                appteach.setTypeScience(rs.getString("TypeScience"));
                appteach.setStatusApp(rs.getString("StatusApp"));
                appteach.setComment(rs.getString("Comment"));
                allPhysfaceAppTeachList.add(appteach);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allPhysfaceAppTeachList;
    }
    
    public ArrayList<AppTeach> getPhysfaceAppTeachAtParams(String params) throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT app_teach.AppTeach_ID, physfaces.FIO,  \n" +
"            cources.Cource, app_teach.Certification, pay.Pay, type_science.TypeScience, \n" +
"            status_app.StatusApp, app_teach.Comment FROM app_teach \n" +
"            INNER JOIN physfaces ON physfaces.Phys_ID=app_teach.Phys_ID\n" +
"            INNER JOIN cources ON cources.Cource_ID=app_teach.Cource_ID\n" +
"            INNER JOIN pay ON pay.Pay_ID=app_teach.Pay_ID\n" +
"            INNER JOIN type_science ON type_science.TypeScience_ID=app_teach.TypeScience_ID\n" +
"            INNER JOIN status_app ON status_app.StatusApp_ID=app_teach.StatusApp_ID WHERE "+params);
            while(rs.next()){
                AppTeach appteach=new AppTeach();
                appteach.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                appteach.setFIO(rs.getString("FIO"));
                appteach.setCource(rs.getString("Cource"));
                if(rs.getByte("Certification")==1){
                    appteach.setCertification("Да");
                } else if(rs.getByte("Certification")==0){
                    appteach.setCertification("Нет");
                }
                appteach.setPay(rs.getString("Pay"));
                appteach.setTypeScience(rs.getString("TypeScience"));
                appteach.setStatusApp(rs.getString("StatusApp"));
                appteach.setComment(rs.getString("Comment"));
                atParamsList.add(appteach);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ArrayList<AppTeach> getAllPhysfaceAppTeachList() throws NamingException, SQLException{
        if(!allPhysfaceAppTeachList.isEmpty()){
            return allPhysfaceAppTeachList;
        } else {
            return getAllPhysfaceAppTeach();
        }
    }
    
    public void insertPhysfaceAppTeach(AppTeach appteach) throws NamingException, SQLException{
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        physfacedao.insertPhysface(appteach.getPhysface());
        conn=Database.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery("SELECT Phys_ID FROM physfaces ORDER BY Phys_ID DESC LIMIT 1");
        while(rs.next()){
            appteach.setPhys_ID(rs.getInt("Phys_ID"));
        }
        String values=appteachvalid.getInsertColumnList(appteach);
        String sql="";
        sql="INSERT INTO app_teach "+values;
        prepstmt=conn.prepareStatement(sql);
        appteachvalid.fillInsertData(prepstmt).executeUpdate();
    }
    
    public void updatePhysfaceAppTeach(AppTeach appteach) throws NamingException, SQLException{
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        physfacedao.updatePhysface(appteach.getPhysface());
        conn=Database.getConnection();
        String sql="";
        int beforeStatus=getPhysfaceAppTeachById(appteach.getAppTeach_ID()).getStatusApp_ID();
        int afterStatus=appteach.getStatusApp_ID();
        int statusPay=appteach.getPay_ID();
        String values=appteachvalid.getUpdateColumnList(appteach);
        sql="UPDATE app_teach SET "+values+" WHERE "
                + "AppTeach_ID=?";
        prepstmt=conn.prepareStatement(sql);
        appteachvalid.fillUpdateData(prepstmt).executeUpdate();
        if((beforeStatus!=afterStatus)&&(afterStatus==2)&&(statusPay==1)){
            ContractOrderPhysface contractphysface=new ContractOrderPhysface();
            Date udate=new Date();
            java.sql.Date sdate=new java.sql.Date(udate.getTime());
            contractphysface.setDateContract(sdate);
            contractphysface.setAppTeach_ID(appteach.getAppTeach_ID());
            contractphysface.setPhys_ID(appteach.getPhys_ID());
            contractphysface.setCource_ID(appteach.getCource_ID());
            contractphysface.setNumber(1);
            CourceDAO courcedao=new CourceDAO();
            Cource cource=courcedao.getCourceById(appteach.getCource_ID());
            contractphysface.setPrice(cource.getPrice()*contractphysface.getNumber());
            contractphysface.setDatePay(sdate);
            //contractphysface.setTicket_ID(0);
            contractphysface.setDetailsContract(appteach.getAppTeach_ID()+"/"+contractphysface.getDateContract());
            contractphysface.setComment("");
            byte close=0;
            contractphysface.setCloseContract(close);
            ContractOrderPhysfaceDAO contractphysfacedao=new ContractOrderPhysfaceDAO();
            contractphysfacedao.insertContractOrderPhysface(contractphysface);
        }
    }
    
    public void deletePhysfaceAppTeach(int id) throws NamingException, SQLException{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            stmt.execute("DELETE FROM app_teach WHERE AppTeach_ID="+id);
    }
    
    public AppTeach getPhysfaceAppTeachById(int id) throws NamingException, SQLException{
        AppTeach appteach=new AppTeach();
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM app_teach WHERE AppTeach_ID="+id);
            while(rs.next()){
                appteach.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                appteach.setPhys_ID(rs.getInt("Phys_ID"));
                appteach.setCertification_ID(rs.getByte("Certification"));
                appteach.setCource_ID(rs.getInt("Cource_ID"));
                appteach.setPay_ID(rs.getInt("Pay_ID"));
                appteach.setTypeScience_ID(rs.getInt("TypeScience_ID"));
                appteach.setStatusApp_ID(rs.getInt("StatusApp_ID"));
                appteach.setComment(rs.getString("Comment"));
            }
            String sql="";
            sql="SELECT FIO, Cource, Pay, TypeScience, StatusApp FROM "
                    + "physfaces, cources, pay, type_science, status_app "
                    + "WHERE Phys_ID=? AND Cource_ID=? AND Pay_ID=? AND TypeScience_ID=? AND "
                    + "StatusApp_ID=?";
            prepstmt=conn.prepareStatement(sql);
            prepstmt.setInt(1, appteach.getPhys_ID());
            prepstmt.setInt(2, appteach.getCource_ID());
            prepstmt.setInt(3, appteach.getPay_ID());
            prepstmt.setInt(4, appteach.getTypeScience_ID());
            prepstmt.setInt(5, appteach.getStatusApp_ID());
            rs=prepstmt.executeQuery();
            while(rs.next()){
                appteach.setFIO(rs.getString("FIO"));
                appteach.setCource(rs.getString("Cource"));
                appteach.setPay(rs.getString("Pay"));
                appteach.setTypeScience(rs.getString("TypeScience"));
                appteach.setStatusApp(rs.getString("StatusApp"));
            }
            Physface physface=new Physface();
            sql="SELECT * FROM physfaces WHERE Phys_ID=?";
            prepstmt=conn.prepareStatement(sql);
            prepstmt.setInt(1, appteach.getPhys_ID());
            rs=prepstmt.executeQuery();
            while(rs.next()){
                physface.setPhys_ID(rs.getInt("Phys_ID"));
                physface.setFIO(rs.getString("FIO"));
                physface.setPost(rs.getString("Post"));
                physface.setDocumentScience(rs.getString("DocumentScience"));
                physface.setSerialNumberDocument(rs.getString("SerialNumberDocument"));
                physface.setPhoneFax(rs.getString("PhoneFax"));
                physface.setWebsite(rs.getString("Website"));
                physface.setINN(rs.getLong("INN"));
                physface.setKPP(rs.getLong("KPP"));
                physface.setBIK(rs.getLong("BIK"));
                physface.setRS(rs.getLong("RS"));
            }
            appteach.setPhysface(physface);
            appteach.setFIO(appteach.getPhysface().getFIO());
            if(appteach.getCertification_ID()==1){
                appteach.setCertification("Да");
            } else if(appteach.getCertification_ID()==0){
                appteach.setCertification("Нет");
            }
        return appteach;
    }
    
}
