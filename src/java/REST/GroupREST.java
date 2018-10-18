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
import logic.dao.GroupDAO;
import logic.entity.Group;

/**
 *
 * @author Admin
 */

@Path("Group")
public class GroupREST {
    private GroupDAO groupdao;

    public GroupDAO getGroupDAO() {
        return groupdao;
    }

    public void setGroupDAO(GroupDAO groupdao) {
        this.groupdao = groupdao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGroupList() throws NamingException, SQLException{
        groupdao=new GroupDAO();
        ArrayList<Group> grouplist=groupdao.getAllGroupList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(grouplist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getGroupListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        groupdao=new GroupDAO();
        ArrayList<Group> grouplist=groupdao.getGroupListAtParams(query);
        json=gson.toJson(grouplist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getGroupById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        groupdao=new GroupDAO();
        int id=gson.fromJson(idjson, int.class);
        Group group=groupdao.getGroupById(id);
        return gson.toJson(group);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertGroup(String groupjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Group group=gson.fromJson(groupjson, Group.class);
            groupdao=new GroupDAO();
            groupdao.insertGroup(group);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(GroupREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(GroupREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateGroup(String groupjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Group group=gson.fromJson(groupjson, Group.class);
            groupdao=new GroupDAO();
            groupdao.updateGroup(group);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(GroupREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
}
