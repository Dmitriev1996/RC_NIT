/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class PhysfaceAppTeachDAO {
    private Map<Integer, ArrayList<AppTeach>> allPhysfaceAppTeachList=new HashMap<Integer, ArrayList<AppTeach>>();
    private ArrayList <AppTeach> data;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private Set<Map.Entry<Integer, ArrayList<AppTeach>>> getAllPhysfaceAppTeach() throws NamingException, SQLException{
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
                data=new ArrayList<AppTeach>();
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
                data.add(appteach);
                allPhysfaceAppTeachList.put(appteach.getAppTeach_ID(), data);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(PhysfaceList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allPhysfaceAppTeachList.entrySet();
    }
    public Set<Map.Entry<Integer, ArrayList<AppTeach>>> getAllPhysfaceAppTeachList() throws NamingException, SQLException{
        if(!allPhysfaceAppTeachList.isEmpty()){
            return allPhysfaceAppTeachList.entrySet();
        } else {
            return getAllPhysfaceAppTeach();
        }
    }
    public void insertPhysfaceAppTeach(AppTeach appteach){
        
    }
    
}
