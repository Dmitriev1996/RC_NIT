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
import logic.dao.ContractOrderPhysfaceDAO;
import logic.entity.ContractOrderPhysface;

/**
 *
 * @author Admin
 */

@Path("ContractOrderPhysface")
public class ContractOrderPhysfaceREST {
    private ContractOrderPhysfaceDAO contractphysfacedao;

    public ContractOrderPhysfaceDAO getContractphysfacedao() {
        return contractphysfacedao;
    }

    public void setContractphysfacedao(ContractOrderPhysfaceDAO contractphysfacedao) {
        this.contractphysfacedao = contractphysfacedao;
    }
    
    @Context
    private HttpHeaders requestHeaders;
    
    private String getHeaderVersion(){
        return requestHeaders.getRequestHeader("version").get(0);
    }
    
    @GET
    @Path("List")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContractOrderPhysfaceList() throws NamingException, SQLException{
        contractphysfacedao=new ContractOrderPhysfaceDAO();
        ArrayList<ContractOrderPhysface> contractphysfacelist=contractphysfacedao.getAllContractList();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(contractphysfacelist);
        return json;
        
    }
    
    @POST
    @Path("ListAtParams")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getContractOrderPhysfaceListAtParams(String params) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String query=gson.fromJson(params, String.class);
        contractphysfacedao=new ContractOrderPhysfaceDAO();
        ArrayList<ContractOrderPhysface> contractphysfacelist=contractphysfacedao.getContractListAtParams(query);
        json=gson.toJson(contractphysfacelist);
        return json;
    }
    
    @POST
    @Path("GetById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getContractOrderPhysfaceById(String idjson) throws SQLException, NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        contractphysfacedao=new ContractOrderPhysfaceDAO();
        int id=gson.fromJson(idjson, int.class);
        ContractOrderPhysface contract=contractphysfacedao.getContractOrderPhysfaceById(id);
        return gson.toJson(contract);
    }
    
    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertContractOrderPhysface(String contractjson){
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            ContractOrderPhysface contract=gson.fromJson(contractjson, ContractOrderPhysface.class);
            contractphysfacedao=new ContractOrderPhysfaceDAO();
            contractphysfacedao.insertContractOrderPhysface(contract);
            json=gson.toJson("Данные добавлены успешно");
        } catch (SQLException ex) {
            Logger.getLogger(ContractOrderPhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        } catch (NamingException ex) {
            Logger.getLogger(ContractOrderPhysfaceREST.class.getName()).log(Level.SEVERE, null, ex);
            json+=gson.toJson("Ошибка"+ex);
        }
        return json;
    }
    
    @PUT
    @Path("Update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateContractOrderPhysface(String contractjson) throws NamingException{
        String json="";
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            ContractOrderPhysface contract=gson.fromJson(contractjson, ContractOrderPhysface.class);
            contractphysfacedao=new ContractOrderPhysfaceDAO();
            contractphysfacedao.updateContractOrderPhysface(contract);
            json="Данные обновлены успешно!";
        } catch (SQLException ex) {
            Logger.getLogger(PhysfaceAppTeachREST.class.getName()).log(Level.SEVERE, null, ex);
            json="Ошибка: "+ex;
        }
        return gson.toJson(json);
    }
}
