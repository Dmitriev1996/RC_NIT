/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import logic.dao.PhysfaceAppTeachDAO;
import logic.dao.YurfaceAppTeachDAO;
import logic.entity.AppTeach;

/**
 *
 * @author Admin
 */
@Path("YurfaceAppTeach")
public class YurfaceAppTeachREST {
    private YurfaceAppTeachDAO yurfaceappteachdao;
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public YurfaceAppTeachDAO getYurfaceappteachdao() {
        return yurfaceappteachdao;
    }

    public void setYurfaceappteachdao(YurfaceAppTeachDAO yurfaceappteachdao) {
        this.yurfaceappteachdao = yurfaceappteachdao;
    }
 
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getYurfaceAppTeachList(){
        String json="";
        try {
            yurfaceappteachdao=new YurfaceAppTeachDAO();
            ArrayList<AppTeach> appteachlist=yurfaceappteachdao.getAllYurfaceAppTeachList();
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            json=gson.toJson(appteachlist);
        } catch (NamingException ex) {
            Logger.getLogger(YurfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=ex;
        } catch (SQLException ex) {
            Logger.getLogger(YurfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=ex;
        }
        return json;
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getYurfaceAppTeachListAtParams(String params) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        yurfaceappteachdao=new YurfaceAppTeachDAO();
        ArrayList<AppTeach> appteachlist=yurfaceappteachdao.getYurfaceAppTeachListAtParams(query);
        json=gson.toJson(appteachlist);
        return json;
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertYurfaceAppTeach(String appteachjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            yurfaceappteachdao=new YurfaceAppTeachDAO();
            AppTeach appteach=gson.fromJson(appteachjson, AppTeach.class);
            yurfaceappteachdao.insertYurfaceAppTeach(appteach);
            json+="Данные вставлены успешно!";
        } catch (NamingException ex) {
            Logger.getLogger(YurfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=ex;
        } catch (SQLException ex) {
            Logger.getLogger(YurfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=ex;
        }
        return gson.toJson(json);
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateYurfaceAppTeach(String appteachjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            AppTeach appteach=gson.fromJson(appteachjson, AppTeach.class);
            yurfaceappteachdao=new YurfaceAppTeachDAO();
            yurfaceappteachdao.updateYurfaceAppTeach(appteach);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(YurfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
    
}
