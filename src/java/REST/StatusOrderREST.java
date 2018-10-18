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
import logic.dao.StatusOrderDAO;
import logic.entity.StatusOrder;

/**
 *
 * @author Admin
 */

@Path("StatusOrder")
public class StatusOrderREST {
    private StatusOrderDAO statusdao;

    public StatusOrderDAO getStatusDAO() {
        return statusdao;
    }

    public void setStatusDAO(StatusOrderDAO statusdao) {
        this.statusdao = statusdao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusList() throws NamingException, SQLException{
        statusdao=new StatusOrderDAO();
        ArrayList<StatusOrder> statuslist=statusdao.getAllStatusList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(statuslist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        statusdao=new StatusOrderDAO();
        ArrayList<StatusOrder> statuslist=statusdao.getStatusListAtParams(query);
        json=gson.toJson(statuslist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        statusdao=new StatusOrderDAO();
        int id=gson.fromJson(idjson, int.class);
        StatusOrder status=statusdao.getStatusById(id);
        return gson.toJson(status);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertStatus(String statusjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            StatusOrder status=gson.fromJson(statusjson, StatusOrder.class);
            statusdao=new StatusOrderDAO();
            statusdao.insertStatus(status);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(StatusOrderREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(StatusOrderREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStatus(String statusjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            StatusOrder status=gson.fromJson(statusjson, StatusOrder.class);
            statusdao=new StatusOrderDAO();
            statusdao.updateStatus(status);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(StatusOrderREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    } 
    
}
