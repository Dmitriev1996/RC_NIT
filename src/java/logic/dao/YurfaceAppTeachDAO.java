/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import logic.dao.PhysfaceDAO;
import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.AppTeach;
import logic.entity.ContractOrderYurface;
import logic.entity.Cource;
import logic.entity.GroupApp;
import logic.entity.Physface;
import logic.entity.Yurface;
import logic.valid.YurfaceAppTeachValidate;

/**
 *
 * @author Admin
 */
public class YurfaceAppTeachDAO {
    private ArrayList<AppTeach> allYurfaceAppTeachList=new ArrayList<AppTeach>();
    private ArrayList<AppTeach> atParamsList=new ArrayList<AppTeach>();
    private Connection conn=null;
    private Statement stmt=null; 
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private YurfaceAppTeachValidate appteachvalid=new YurfaceAppTeachValidate();
    private ArrayList<AppTeach> getAllYurfaceAppTeach() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT app_teach.AppTeach_ID, app_teach.Yur_ID, "
                    + "yurfaces.NameOrganization,  \n" +
"            app_teach.Cource_ID, cources.Cource, app_teach.Certification, "
                    + "app_teach.Pay_ID, pay.Pay, app_teach.TypeScience_ID, "
                    + "type_science.TypeScience, \n" +
"            app_teach.StatusApp_ID, status_app.StatusApp, app_teach.Comment FROM app_teach \n" +
"            INNER JOIN yurfaces ON yurfaces.Yur_ID=app_teach.Yur_ID \n" +
"            INNER JOIN cources ON cources.Cource_ID=app_teach.Cource_ID\n" +
"            INNER JOIN pay ON pay.Pay_ID=app_teach.Pay_ID\n" +
"            INNER JOIN type_science ON type_science.TypeScience_ID=app_teach.TypeScience_ID\n" +
"            INNER JOIN status_app ON status_app.StatusApp_ID=app_teach.StatusApp_ID");
            while(rs.next()){
                AppTeach appteach=new AppTeach();
                appteach.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                appteach.setYur_ID(rs.getInt("Yur_ID"));
                appteach.setNameOrganization(rs.getString("NameOrganization"));
                appteach.setCource_ID(rs.getInt("Cource_ID"));
                appteach.setCource(rs.getString("Cource"));
                if(rs.getByte("Certification")==1){
                    appteach.setCertification("Да");
                } else if(rs.getByte("Certification")==0){
                    appteach.setCertification("Нет");
                }
                appteach.setPay_ID(rs.getInt("Pay_ID"));
                appteach.setPay(rs.getString("Pay"));
                appteach.setTypeScience_ID(rs.getInt("TypeScience_ID"));
                appteach.setTypeScience(rs.getString("TypeScience"));
                appteach.setStatusApp_ID(rs.getInt("StatusApp_ID"));
                appteach.setStatusApp(rs.getString("StatusApp"));
                appteach.setComment(rs.getString("Comment"));
                YurfaceDAO yurfacedao=new YurfaceDAO();
                Yurface yurface=yurfacedao.getYurfaceById(rs.getInt("Yur_ID"));
                appteach.setYurface(yurface);
                ArrayList<Physface> physfacelist=new ArrayList<Physface>();
                String sql="SELECT group_app.AppTeach_ID, physfaces.Phys_ID, physfaces.FIO, physfaces.Post, physfaces.DocumentScience, \n" +
"physfaces.SerialNumberDocument, physfaces.PhoneFax, physfaces.Website, physfaces.INN, \n" +
"physfaces.KPP, physfaces.BIK, physfaces.RS FROM group_app \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=group_app.Phys_ID\n" +
"WHERE AppTeach_ID=?";
                prepstmt=conn.prepareStatement(sql);
                prepstmt.setInt(1, rs.getInt("AppTeach_ID"));
                ResultSet rs1=prepstmt.executeQuery();
                while(rs1.next()){
                    Physface physface=new Physface();
                    physface.setPhys_ID(rs1.getInt("Phys_ID"));
                    physface.setFIO(rs1.getString("FIO"));
                    physface.setPost(rs1.getString("Post"));
                    physface.setDocumentScience(rs1.getString("DocumentScience"));
                    physface.setSerialNumberDocument(rs1.getString("SerialNumberDocument"));
                    physface.setPhoneFax(rs1.getString("PhoneFax"));
                    physface.setWebsite(rs1.getString("Website"));
                    physface.setINN(rs1.getLong("INN"));
                    physface.setKPP(rs1.getLong("KPP"));
                    physface.setBIK(rs1.getLong("BIK"));
                    physface.setRS(rs1.getLong("RS"));
                    physfacelist.add(physface);
                }
                appteach.setPhysfaceList(physfacelist);
                allYurfaceAppTeachList.add(appteach);
            }
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allYurfaceAppTeachList;
    }
    
    public ArrayList<AppTeach> getYurfaceAppTeachListAtParams(String params) throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT app_teach.AppTeach_ID, app_teach.Yur_ID, "
                    + "yurfaces.NameOrganization,  \n" +
"            app_teach.Cource_ID, cources.Cource, app_teach.Certification, "
                    + "app_teach.Pay_ID, pay.Pay, app_teach.TypeScience_ID, "
                    + "type_science.TypeScience, \n" +
"            app_teach.StatusApp_ID, status_app.StatusApp, app_teach.Comment FROM app_teach \n" +
"            INNER JOIN yurfaces ON yurfaces.Yur_ID=app_teach.Yur_ID \n" +
"            INNER JOIN cources ON cources.Cource_ID=app_teach.Cource_ID\n" +
"            INNER JOIN pay ON pay.Pay_ID=app_teach.Pay_ID\n" +
"            INNER JOIN type_science ON type_science.TypeScience_ID=app_teach.TypeScience_ID\n" +
"            INNER JOIN status_app ON status_app.StatusApp_ID=app_teach.StatusApp_ID WHERE "+params);
            while(rs.next()){
                AppTeach appteach=new AppTeach();
                appteach.setAppTeach_ID(rs.getInt("AppTeach_ID"));
                appteach.setYur_ID(rs.getInt("Yur_ID"));
                appteach.setNameOrganization(rs.getString("NameOrganization"));
                appteach.setCource_ID(rs.getInt("Cource_ID"));
                appteach.setCource(rs.getString("Cource"));
                if(rs.getByte("Certification")==1){
                    appteach.setCertification("Да");
                } else if(rs.getByte("Certification")==0){
                    appteach.setCertification("Нет");
                }
                appteach.setPay_ID(rs.getInt("Pay_ID"));
                appteach.setPay(rs.getString("Pay"));
                appteach.setTypeScience_ID(rs.getInt("TypeScience_ID"));
                appteach.setTypeScience(rs.getString("TypeScience"));
                appteach.setStatusApp_ID(rs.getInt("StatusApp_ID"));
                appteach.setStatusApp(rs.getString("StatusApp"));
                appteach.setComment(rs.getString("Comment"));
                YurfaceDAO yurfacedao=new YurfaceDAO();
                Yurface yurface=yurfacedao.getYurfaceById(rs.getInt("Yur_ID"));
                appteach.setYurface(yurface);
                ArrayList<Physface> physfacelist=new ArrayList<Physface>();
                String sql="SELECT group_app.AppTeach_ID, physfaces.Phys_ID, physfaces.FIO, physfaces.Post, physfaces.DocumentScience, \n" +
"physfaces.SerialNumberDocument, physfaces.PhoneFax, physfaces.Website, physfaces.INN, \n" +
"physfaces.KPP, physfaces.BIK, physfaces.RS FROM group_app \n" +
"INNER JOIN physfaces ON physfaces.Phys_ID=group_app.Phys_ID\n" +
"WHERE AppTeach_ID=?";
                prepstmt=conn.prepareStatement(sql);
                prepstmt.setInt(1, rs.getInt("AppTeach_ID"));
                ResultSet rs1=prepstmt.executeQuery();
                while(rs1.next()){
                    Physface physface=new Physface();
                    physface.setPhys_ID(rs1.getInt("Phys_ID"));
                    physface.setFIO(rs1.getString("FIO"));
                    physface.setPost(rs1.getString("Post"));
                    physface.setDocumentScience(rs1.getString("DocumentScience"));
                    physface.setSerialNumberDocument(rs1.getString("SerialNumberDocument"));
                    physface.setPhoneFax(rs1.getString("PhoneFax"));
                    physface.setWebsite(rs1.getString("Website"));
                    physface.setINN(rs1.getLong("INN"));
                    physface.setKPP(rs1.getLong("KPP"));
                    physface.setBIK(rs1.getLong("BIK"));
                    physface.setRS(rs1.getLong("RS"));
                    physfacelist.add(physface);
                }
                appteach.setPhysfaceList(physfacelist);
                atParamsList.add(appteach);
            }
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public ArrayList<AppTeach> getAllYurfaceAppTeachList() throws NamingException, SQLException{
        if(!allYurfaceAppTeachList.isEmpty()){
            return allYurfaceAppTeachList;
        } else {
            return getAllYurfaceAppTeach();
        }
    }
    
    public void insertYurfaceAppTeach(AppTeach appteach) throws NamingException, SQLException{
        Yurface yurface=appteach.getYurface();
        PhysfaceDAO physfacedao=new PhysfaceDAO();
        ArrayList<Physface> physfacelist=appteach.getPhysfaceList();
        GroupAppDAO groupappdao=new GroupAppDAO();
        conn=Database.getConnection();
        stmt=conn.createStatement();
        String sql="";
        String values=appteachvalid.getInsertColumnList(appteach);
        sql="INSERT INTO app_teach "+values;
        prepstmt=conn.prepareStatement(sql);
        appteachvalid.fillInsertData(prepstmt).executeUpdate();
        rs=stmt.executeQuery("SELECT AppTeach_ID FROM app_teach ORDER BY AppTeach_ID DESC LIMIT 1");
        int appid=0;
        while(rs.next()){
            appid=rs.getInt("AppTeach_ID");
        }
        for(Physface obj : physfacelist){
            GroupApp groupapp=new GroupApp();
            physfacedao.insertPhysface(obj);
            rs=stmt.executeQuery("SELECT Phys_ID FROM physfaces ORDER BY Phys_ID DESC LIMIT 1");
            int ID=0;
            while(rs.next()){
                ID=rs.getInt("Phys_ID");
            }
            groupapp.setAppTeach_ID(appid);
            groupapp.setYur_ID(appteach.getYur_ID());
            groupapp.setPhys_ID(ID);
            groupappdao.insertGroupApp(groupapp);
        } 
    }
    
    public void updateYurfaceAppTeach(AppTeach appteach) throws NamingException, SQLException{
        YurfaceDAO yurfacedao=new YurfaceDAO();
        yurfacedao.updateYurface(appteach.getYurface());
        conn=Database.getConnection();
        stmt=conn.createStatement();
        String sql="";
        int beforeStatus=getYurfaceAppTeachById(appteach.getAppTeach_ID()).getStatusApp_ID();
        int afterStatus=appteach.getStatusApp_ID();
        int statusPay=appteach.getPay_ID();
        String values=appteachvalid.getUpdateColumnList(appteach);
        sql="UPDATE app_teach SET "+values+" WHERE AppTeach_ID=?";
        prepstmt=conn.prepareStatement(sql);
        appteachvalid.fillUpdateData(prepstmt).executeUpdate();
        if((beforeStatus!=afterStatus)&&(afterStatus==2)&&(statusPay==2)){
            ContractOrderYurface contractyurface=new ContractOrderYurface();
            Date udate=new Date();
            java.sql.Date sdate=new java.sql.Date(udate.getTime());
            contractyurface.setDateContract(sdate);
            contractyurface.setAppTeach_ID(appteach.getAppTeach_ID());
            contractyurface.setYur_ID(appteach.getYur_ID());
            contractyurface.setCource_ID(appteach.getCource_ID());
            CourceDAO courcedao=new CourceDAO();
            Cource cource=courcedao.getCourceById(appteach.getCource_ID());
            contractyurface.setPrice(cource.getPrice());
            contractyurface.setDetailsContract(appteach.getAppTeach_ID()+"/"+contractyurface.getDateContract());
            contractyurface.setComment("");
            byte close=0;
            contractyurface.setCloseContract(close);
            ContractOrderYurfaceDAO contractyurfacedao=new ContractOrderYurfaceDAO();
            contractyurfacedao.insertContractYurfaceOfAppTeach(contractyurface);
        }
    }
    
    public void deleteYurfaceAppTeachDAO(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM app_teach WHERE AppTeach_ID="+id);
        stmt.execute("DELETE FROM group_app WHERE AppTeach_ID="+id);
    }
    
    public AppTeach getYurfaceAppTeachById(int id) throws NamingException, SQLException{
       AppTeach result=null;
       for(AppTeach appteach : getAllYurfaceAppTeach()){
           if(appteach.getAppTeach_ID()==id){
               result=appteach;
           }
       }
       return result;
    }
    
}
