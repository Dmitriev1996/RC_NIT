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
import logic.dao.ExamineDAO;
import logic.entity.Examine;

/**
 *
 * @author Admin
 */

@Path("Examine")
public class ExamineREST {
    private ExamineDAO examinedao;

    public ExamineDAO getExamineDAO() {
        return examinedao;
    }

    public void setExamineDAO(ExamineDAO examinedao) {
        this.examinedao = examinedao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getExamineList() throws NamingException, SQLException{
        examinedao=new ExamineDAO();
        ArrayList<Examine> examinelist=examinedao.getAllExamineList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(examinelist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getExamineListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        examinedao=new ExamineDAO();
        ArrayList<Examine> examinelist=examinedao.getExamineListAtParams(query);
        json=gson.toJson(examinelist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getExamineById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        examinedao=new ExamineDAO();
        int id=gson.fromJson(idjson, int.class);
        Examine examine=examinedao.getExamineById(id);
        return gson.toJson(examine);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertExamine(String examinejson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Examine examine=gson.fromJson(examinejson, Examine.class);
            examinedao=new ExamineDAO();
            examinedao.insertExamine(examine);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(ExamineREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(ExamineREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateExamine(String examinejson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Examine examine=gson.fromJson(examinejson, Examine.class);
            examinedao=new ExamineDAO();
            examinedao.updateExamine(examine);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(ExamineREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
}
