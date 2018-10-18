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
import logic.dao.TypeContractDAO;
import logic.entity.TypeContract;

/**
 *
 * @author Admin
 */

@Path("TypeContract")
public class TypeContractREST {
    private TypeContractDAO typecontractDAO;
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public TypeContractDAO getTypecontractDAO() {
        return typecontractDAO;
    }

    public void setTypecontractDAO(TypeContractDAO typecontractDAO) {
        this.typecontractDAO = typecontractDAO;
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTypeContractList() throws NamingException, SQLException{
        typecontractDAO=new TypeContractDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<TypeContract> typelist=typecontractDAO.getAllTypeContractList();
        String json=gson.toJson(typelist);
        return json;
    }
    
}
