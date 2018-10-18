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
import logic.dao.ActOrderYurfaceDAO;
import logic.entity.ActOrderYurface;

/**
 *
 * @author Admin
 */

@Path("ActOrderYurface")
public class ActOrderYurfaceREST {
    private ActOrderYurfaceDAO actyurfacedao;
    
    public ActOrderYurfaceDAO getActyurfacedao() {
        return actyurfacedao;
    }

    public void setActyurfacedao(ActOrderYurfaceDAO actyurfacedao) {
        this.actyurfacedao = actyurfacedao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getActOrderYurfaceList() throws NamingException, SQLException{
        actyurfacedao=new ActOrderYurfaceDAO();
        ArrayList<ActOrderYurface> actyurfacelist=actyurfacedao.getAllActList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(actyurfacelist);
        return json;
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getActOrderYurfaceListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        actyurfacedao=new ActOrderYurfaceDAO();
        ArrayList<ActOrderYurface> actyurfacelist=actyurfacedao.getAllActYurfaceAtParams(query);
        json=gson.toJson(actyurfacelist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getActOrderYurfaceById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        actyurfacedao=new ActOrderYurfaceDAO();
        int id=gson.fromJson(idjson, int.class);
        ActOrderYurface act=actyurfacedao.getActOrderYurfaceById(id);
        return gson.toJson(act);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertActOrderYurface(String actjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            ActOrderYurface act=gson.fromJson(actjson, ActOrderYurface.class);
            actyurfacedao=new ActOrderYurfaceDAO();
            actyurfacedao.insertActOrderYurface(act);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(ActOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(ActOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateActOrderYurface(String actjson) {
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            ActOrderYurface act=gson.fromJson(actjson, ActOrderYurface.class);
            actyurfacedao=new ActOrderYurfaceDAO();
            actyurfacedao.updateActOrderYurface(act);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(ActOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        } catch (NamingException ex) {
            Logger.getLogger(ActOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return gson.toJson(json);
    }
}
