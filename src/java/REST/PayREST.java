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
import logic.entity.Cource;
import logic.entity.Pay;

/**
 *
 * @author Admin
 */

@Path("Pay")
public class PayREST {
    private PayDAO payDAO;
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public PayDAO getPayDAO() {
        return payDAO;
    }

    public void setPayDAO(PayDAO payDAO) {
        this.payDAO = payDAO;
    }

    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPayList() throws NamingException, SQLException{
        payDAO=new PayDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Pay> paylist=payDAO.getAllPayList();
        String json=gson.toJson(paylist);
        return json;
    }
    
}
