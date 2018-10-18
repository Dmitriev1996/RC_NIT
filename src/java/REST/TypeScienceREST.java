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
import logic.dao.PayDAO;
import logic.dao.TypeScienceDAO;
import logic.entity.Pay;
import logic.entity.TypeScience;

/**
 *
 * @author Admin
 */

@Path("TypeScience")
public class TypeScienceREST {
    private TypeScienceDAO typescienceDAO;
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public TypeScienceDAO getTypescienceDAO() {
        return typescienceDAO;
    }

    public void setTypescienceDAO(TypeScienceDAO typescienceDAO) {
        this.typescienceDAO = typescienceDAO;
    }

    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTypeScienceList() throws NamingException, SQLException{
        typescienceDAO=new TypeScienceDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<TypeScience> typelist=typescienceDAO.getAllTypeScienceList();
        String json=gson.toJson(typelist);
        return json;
    }
    

    
}
