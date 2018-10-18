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
import logic.dao.GroupAppDAO;
import logic.entity.GroupApp;
import logic.entity.Physface;

/**
 *
 * @author Admin
 */

@Path("GroupApp")
public class GroupAppREST {
    private GroupAppDAO groupappdao;

    public GroupAppDAO getGroupappdao() {
        return groupappdao;
    }

    public void setGroupappdao(GroupAppDAO groupappdao) {
        this.groupappdao = groupappdao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGroupAppList() throws NamingException, SQLException{
        groupappdao=new GroupAppDAO();
        ArrayList<GroupApp> groupapplist=groupappdao.getAllGroupAppList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(groupapplist);
        return json;
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertGroupApp(String groupappjson) throws NamingException{
        groupappdao=new GroupAppDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            GroupApp groupapp=gson.fromJson(groupappjson, GroupApp.class);
            groupappdao.insertGroupApp(groupapp);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(GroupAppREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    @POST
    @Path("InsertInGroup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertPhysfaceInGroupApp(String groupappjson) throws NamingException{
        groupappdao=new GroupAppDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            GroupApp groupapp=gson.fromJson(groupappjson, GroupApp.class);
            groupappdao.insertPhysfaceInGroupApp(groupapp);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(GroupAppREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateGroupApp(String groupappjson) throws NamingException{
        groupappdao=new GroupAppDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            GroupApp groupapp=gson.fromJson(groupappjson, GroupApp.class);
            groupappdao.insertGroupApp(groupapp);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(GroupAppREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
    
    @POST
    @Path("Delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteGroupApp(String groupappjson) throws NamingException{
        groupappdao=new GroupAppDAO();
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            GroupApp groupapp=gson.fromJson(groupappjson, GroupApp.class);
            groupappdao.insertGroupApp(groupapp);
            json=gson.toJson("Данные добавлены успешно!");
        } catch (SQLException ex) {
            Logger.getLogger(GroupAppREST.class.getName()).log(Level.SEVERE, null, ex);
            json=gson.toJson("Ошибка: "+ex);
        }
        return json;
    }
}
