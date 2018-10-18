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
import logic.dao.ContractOrderYurfaceDAO;
import logic.entity.ContractOrderYurface;

/**
 *
 * @author Admin
 */
@Path("ContractOrderYurface")
public class ContractOrderYurfaceREST {
    private ContractOrderYurfaceDAO contractyurfacedao;
    
    public ContractOrderYurfaceDAO getContractyurfacedao() {
        return contractyurfacedao;
    }

    public void setContractyurfacedao(ContractOrderYurfaceDAO contractyurfacedao) {
        this.contractyurfacedao = contractyurfacedao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContractOrderYurfaceList() throws NamingException, SQLException{
        contractyurfacedao=new ContractOrderYurfaceDAO();
        ArrayList<ContractOrderYurface> contractyurfacelist=contractyurfacedao.getAllContractList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(contractyurfacelist);
        return json;
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getContractOrderYurfaceListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        contractyurfacedao=new ContractOrderYurfaceDAO();
        ArrayList<ContractOrderYurface> contractyurfacelist=contractyurfacedao.getContractYurfaceListAtParams(query);
        json=gson.toJson(contractyurfacelist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getContractOrderPhysfaceById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        contractyurfacedao=new ContractOrderYurfaceDAO();
        int id=gson.fromJson(idjson, int.class);
        ContractOrderYurface contract=contractyurfacedao.getContractYurfaceById(id);
        return gson.toJson(contract);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertContractOrderYurface(String contractjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            ContractOrderYurface contract=gson.fromJson(contractjson, ContractOrderYurface.class);
            contractyurfacedao=new ContractOrderYurfaceDAO();
            contractyurfacedao.insertContractYurface(contract);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(ContractOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(ContractOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateContractOrderYurface(String contractjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            ContractOrderYurface contract=gson.fromJson(contractjson, ContractOrderYurface.class);
            contractyurfacedao=new ContractOrderYurfaceDAO();
            contractyurfacedao.updateContractYurface(contract);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(ContractOrderYurfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }


    
}
