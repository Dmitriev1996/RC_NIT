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
import logic.dao.GroupClassDAO;
import logic.entity.GroupClass;

/**
 *
 * @author Admin
 */

@Path("GroupClass")
public class GroupClassREST {
    private GroupClassDAO classdao;

    public GroupClassDAO getClassDAO() {
        return classdao;
    }

    public void setClassDAO(GroupClassDAO classdao) {
        this.classdao = classdao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClassList() throws NamingException, SQLException{
        classdao=new GroupClassDAO();
        ArrayList<GroupClass> classlist=classdao.getAllClassList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(classlist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getClassListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        classdao=new GroupClassDAO();
        ArrayList<GroupClass> classlist=classdao.getClassListAtParams(query);
        json=gson.toJson(classlist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getClassById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        classdao=new GroupClassDAO();
        int id=gson.fromJson(idjson, int.class);
        GroupClass classes=classdao.getClassById(id);
        return gson.toJson(classes);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertClass(String classjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            GroupClass classes=gson.fromJson(classjson, GroupClass.class);
            classdao=new GroupClassDAO();
            classdao.insertClass(classes);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(GroupClassREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(GroupClassREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateClass(String classjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            GroupClass classes=gson.fromJson(classjson, GroupClass.class);
            classdao=new GroupClassDAO();
            classdao.updateClass(classes);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(GroupClassREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    } 
}
