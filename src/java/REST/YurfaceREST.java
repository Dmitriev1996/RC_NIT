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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import logic.dao.YurfaceDAO;
import logic.entity.Yurface;

/**
 *
 * @author Admin
 */
@Path("Yurface")
public class YurfaceREST {
    private YurfaceDAO yurfacedao;
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public YurfaceDAO getYurfacedao() {
        return yurfacedao;
    }

    public void setYurfacedao(YurfaceDAO yurfacedao) {
        this.yurfacedao = yurfacedao;
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getYurfaceList() throws NamingException, SQLException{
        String json="";
        yurfacedao=new YurfaceDAO();
        ArrayList<Yurface> yurfacelist=yurfacedao.getYurfaceList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        json=gson.toJson(yurfacelist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getYurfaceById(String idjson) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        yurfacedao=new YurfaceDAO();
        int id=gson.fromJson(idjson, int.class);
        Yurface yurface=yurfacedao.getYurfaceById(id);
        return gson.toJson(yurface);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertYurface(String yurfacejson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            Yurface yurface=gson.fromJson(yurfacejson, Yurface.class);
            yurfacedao=new YurfaceDAO();
            yurfacedao.insertYurface(yurface);
            json+="Данные добавлены успешно!";
        } catch (NamingException ex) {
            Logger.getLogger(YurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+="Ошибка: "+ex;
        } catch (SQLException ex) {
            Logger.getLogger(YurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
    
    
    
}
