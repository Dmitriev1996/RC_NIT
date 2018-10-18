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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import logic.dao.StatusScienceDAO;
import logic.entity.StatusScience;

/**
 *
 * @author Admin
 */
@Path("StatusScience")
public class StatusScienceREST {
    private StatusScienceDAO statusdao;
    
    @Context
    private HttpHeaders requestHeaders;

    public StatusScienceDAO getStatusSciencedao() {
        return statusdao;
    }

    public void setStatusScienceDAO(StatusScienceDAO statusdao) {
        this.statusdao = statusdao;
    }

    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusList() throws NamingException, SQLException{
        statusdao=new StatusScienceDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<StatusScience> statuslist=statusdao.getAllStatusList();
        String json=gson.toJson(statuslist);
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusById(String idjson) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        statusdao=new StatusScienceDAO();
        int id=gson.fromJson(idjson, int.class);
        StatusScience status=statusdao.getSttausScienceById(id);
        return gson.toJson(status);
    }
}
