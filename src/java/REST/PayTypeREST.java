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
import logic.dao.PayTypeDAO;
import logic.entity.PayType;

/**
 *
 * @author Admin
 */

@Path("PayType")
public class PayTypeREST {
    private PayTypeDAO paytypedao;
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public PayTypeDAO getPayTypeDAO() {
        return this.paytypedao;
    }

    public void setPayTypeDAO(PayTypeDAO paytypedao) {
        this.paytypedao = paytypedao;
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPayTypeList() throws NamingException, SQLException{
        paytypedao=new PayTypeDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<PayType> typelist=paytypedao.getAllPayTypeList();
        String json=gson.toJson(typelist);
        return json;
    }
    
}
