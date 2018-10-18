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
import logic.dao.StudentDAO;
import logic.entity.Student;

/**
 *
 * @author Admin
 */

@Path("Student")
public class StudentREST {
    private StudentDAO studentdao;

    public StudentDAO getStudentDAO() {
        return studentdao;
    }

    public void setStudentDAO(StudentDAO studentdao) {
        this.studentdao = studentdao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudentList() throws NamingException, SQLException{
        studentdao=new StudentDAO();
        ArrayList<Student> studentlist=studentdao.getAllStudentList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(studentlist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudentListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        studentdao=new StudentDAO();
        ArrayList<Student> studentlist=studentdao.getStudentListAtParams(query);
        json=gson.toJson(studentlist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudentById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        studentdao=new StudentDAO();
        int id=gson.fromJson(idjson, int.class);
        Student student=studentdao.getStudentById(id);
        return gson.toJson(student);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertStudent(String studentjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Student student=gson.fromJson(studentjson, Student.class);
            studentdao=new StudentDAO();
            studentdao.insertStudent(student);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(StudentREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(StudentREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStudent(String studentjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Student student=gson.fromJson(studentjson, Student.class);
            studentdao=new StudentDAO();
            studentdao.updateStudent(student);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(StudentREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
    @POST
    @Path("Delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteStudent(String idjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            studentdao=new StudentDAO();
            int id=gson.fromJson(idjson, int.class);
            studentdao.deleteStudent(id);
            json="Данные успешно удалены!";
        } catch (SQLException ex) {
            Logger.getLogger(StudentREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
}
