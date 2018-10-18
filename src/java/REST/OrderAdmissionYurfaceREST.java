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
import logic.dao.OrderAdmissionYurfaceDAO;
import logic.entity.OrderAdmission;

/**
 *
 * @author Admin
 */

@Path("OrderAdmissionYurface")
public class OrderAdmissionYurfaceREST {
    private OrderAdmissionYurfaceDAO orderdao;

    public OrderAdmissionYurfaceDAO getOrderDAO() {
        return orderdao;
    }

    public void setOrderDAO(OrderAdmissionYurfaceDAO orderado) {
        this.orderdao = orderdao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrderList() throws NamingException, SQLException{
        orderdao=new OrderAdmissionYurfaceDAO();
        ArrayList<OrderAdmission> orderlist=orderdao.getAllOrderList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(orderlist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getClassListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        orderdao=new OrderAdmissionYurfaceDAO();
        ArrayList<OrderAdmission> orderlist=orderdao.getOrderListAtParams(query);
        json=gson.toJson(orderlist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrderById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        orderdao=new OrderAdmissionYurfaceDAO();
        int id=gson.fromJson(idjson, int.class);
        OrderAdmission order=orderdao.getOrderById(id);
        return gson.toJson(order);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertOrder(String orderjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            OrderAdmission order=gson.fromJson(orderjson, OrderAdmission.class);
            orderdao=new OrderAdmissionYurfaceDAO();
            orderdao.insertOrder(order);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(OrderAdmissionYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(OrderAdmissionYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateOrder(String orderjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            OrderAdmission order=gson.fromJson(orderjson, OrderAdmission.class);
            orderdao=new OrderAdmissionYurfaceDAO();
            orderdao.updateOrder(order);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(OrderAdmissionYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
    
}
