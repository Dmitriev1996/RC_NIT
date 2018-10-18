/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import logic.dao.StatusAppDAO;
import logic.entity.StatusApp;

/**
 *
 * @author Admin
 */

@Path("StatusApp")
public class StatusAppREST {
    private StatusAppDAO statusappDAO;
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusAppList() throws NamingException{
        statusappDAO=new StatusAppDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<StatusApp> statusapplist=statusappDAO.getStausAppList();
        String json=gson.toJson(statusapplist);
        return json;
    }
    
}
