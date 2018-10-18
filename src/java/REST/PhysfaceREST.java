/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
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
import logic.dao.PhysfaceDAO;
import logic.entity.Physface;

/**
 *
 * @author Admin
 */

@Path("Physface")
public class PhysfaceREST {
    private PhysfaceDAO physfacedao;

    public PhysfaceDAO getPhysfacedao() {
        return physfacedao;
    }

    public void setPhysfacedao(PhysfaceDAO physfacedao) {
        this.physfacedao = physfacedao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPhysfaceList() throws NamingException, SQLException{
        physfacedao=new PhysfaceDAO();
        ArrayList<Physface> physfacelist=physfacedao.getAllPhysfaceList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(physfacelist);
        return json;
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertPhysface(String physfacejson) throws NamingException{
        physfacedao=new PhysfaceDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Physface physface=gson.fromJson(physfacejson, Physface.class);
            physfacedao.insertPhysface(physface);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePhysface(String physfacejson) throws NamingException{
        physfacedao=new PhysfaceDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Physface physface=gson.fromJson(physfacejson, Physface.class);
            physfacedao.updatePhysface(physface);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    
    @PUT
    @Path("UpdateList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePhysfaceList(String physfacelistjson) throws NamingException{
            physfacedao=new PhysfaceDAO();
            String json="";
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Type type=new TypeToken<ArrayList<Physface>>() {}.getType();
            ArrayList<Physface> physfacelist=gson.fromJson(physfacelistjson, type);
            physfacedao.updatePhysfaceList(physfacelist);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    @POST
    @Path("Delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePhysface(String physfacejson){
        physfacedao=new PhysfaceDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Physface physface=gson.fromJson(physfacejson, Physface.class);
            physfacedao.deletePhysface(physface);
            json=gson.toJson("Данные успешно удалены!");
        } catch (NamingException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    
    @POST
    @Path("DeleteList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePhysfaceList(String physfacelistjson){
            physfacedao=new PhysfaceDAO();
            String json="";
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Type type=new TypeToken<ArrayList<Physface>>() {}.getType();
            ArrayList<Physface> physfacelist=gson.fromJson(physfacelistjson, type);
            physfacedao.deletePhysfaceList(physfacelist);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (NamingException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
}
