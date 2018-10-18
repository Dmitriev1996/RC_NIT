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
import logic.dao.PayPeriodDAO;
import logic.entity.PayPeriod;

/**
 *
 * @author Admin
 */

@Path("PayPeriod")
public class PayPeriodREST {
    private PayPeriodDAO payperioddao;
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    public PayPeriodDAO getPayPeriodDAO() {
        return this.payperioddao;
    }

    public void setPayPeriodDAO(PayPeriodDAO payperioddao) {
        this.payperioddao = payperioddao;
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPayPeriodList() throws NamingException, SQLException{
        payperioddao=new PayPeriodDAO();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        ArrayList<PayPeriod> periodlist=payperioddao.getAllPayPeriodList();
        String json=gson.toJson(periodlist);
        return json;
    }
}
