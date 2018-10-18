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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import logic.dao.CourceDAO;
import logic.entity.Cource;

/**
 *
 * @author Admin
 */

@Path("Cource")
public class CourceREST {
    private CourceDAO courcedao;
    
    @Context
    private HttpHeaders requestHeaders;

    public CourceDAO getCourcedao() {
        return courcedao;
    }

    public void setCourcedao(CourceDAO courcedao) {
        this.courcedao = courcedao;
    }

    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCourceList() throws NamingException, SQLException{
        courcedao=new CourceDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Cource> courcelist=courcedao.getAllCourceList();
        String json=gson.toJson(courcelist);
        return json;
    }
    
    public String getCourceById(String idjson) throws NamingException, SQLException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        courcedao=new CourceDAO();
        int id=gson.fromJson(idjson, int.class);
        Cource cource=courcedao.getCourceById(id);
        return gson.toJson(cource);
    }

    
}
