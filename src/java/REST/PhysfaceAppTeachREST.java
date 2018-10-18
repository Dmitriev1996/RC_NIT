/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logic.dao.AppTeachDAO;
import logic.dao.PhysfaceAppTeachDAO;
import logic.dao.PhysfaceDAO;
import logic.entity.AppTeach;
import logic.entity.Physface;

/**
 *
 * @author Admin
 */
@Path("PhysfaceAppTeach")
public class PhysfaceAppTeachREST {
    private AppTeachDAO appteachDAO;
    private PhysfaceAppTeachDAO physfaceappteachdao;
    public AppTeachDAO getAppteachDAO() {
        return appteachDAO;
    }

    public void setAppteachDAO(AppTeachDAO appteachDAO) {
        this.appteachDAO = appteachDAO;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPhysfaceAppTeachList() throws NamingException, SQLException{
        physfaceappteachdao=new PhysfaceAppTeachDAO();
        ArrayList<AppTeach> appteachlist=physfaceappteachdao.getAllPhysfaceAppTeachList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(appteachlist);
        return json;
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getPhysfaceAppTeachListAtParams(String params) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        physfaceappteachdao=new PhysfaceAppTeachDAO();
        ArrayList<AppTeach> appteachlist=physfaceappteachdao.getPhysfaceAppTeachAtParams(query);
        json=gson.toJson(appteachlist);
        return json;
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertPhysfaceAppTeach(String appteachjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            AppTeach appteach=gson.fromJson(appteachjson, AppTeach.class);
            physfaceappteachdao=new PhysfaceAppTeachDAO();
            physfaceappteachdao.insertPhysfaceAppTeach(appteach);
            json=gson.toJson("Данные добавлены успешно!");
            return json;
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePhysfaceAppTeach(String appteachjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            AppTeach appteach=gson.fromJson(appteachjson, AppTeach.class);
            physfaceappteachdao=new PhysfaceAppTeachDAO();
            physfaceappteachdao.updatePhysfaceAppTeach(appteach);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getPhysfaceAppTeachById(String idjson) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        physfaceappteachdao=new PhysfaceAppTeachDAO();
        int id=gson.fromJson(idjson, int.class);
        AppTeach appteach=physfaceappteachdao.getPhysfaceAppTeachById(id);
        return gson.toJson(appteach);
    }
    
    @POST
    @Path("Delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePhysfaceAppTeach(String idjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            physfaceappteachdao=new PhysfaceAppTeachDAO();
            int id=gson.fromJson(idjson, int.class);
            physfaceappteachdao.deletePhysfaceAppTeach(id);
            json="Данные успешно удалены!";
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
    
}
