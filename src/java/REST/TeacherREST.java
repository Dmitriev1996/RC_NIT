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
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import logic.dao.TeacherDAO;
import logic.entity.Teacher;

/**
 *
 * @author Admin
 */
@Path("Teacher")
public class TeacherREST {
    private TeacherDAO teacherdao;
    
    @Context
    private HttpHeaders requestHeaders;

    public TeacherDAO getTeacherDAO() {
        return teacherdao;
    }

    public void setTeacherDAO(TeacherDAO teacherdao) {
        this.teacherdao = teacherdao;
    }

    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeacherList() throws NamingException, SQLException{
        teacherdao=new TeacherDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Teacher> teacherlist=teacherdao.getAllTeacherList();
        String json=gson.toJson(teacherlist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeacherById(String idjson) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        teacherdao=new TeacherDAO();
        int id=gson.fromJson(idjson, int.class);
        Teacher teacher=teacherdao.getTeacherById(id);
        return gson.toJson(teacher);
    }
}
