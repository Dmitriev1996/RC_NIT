/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class OrderAdmission {
    private int OrderAdmission_ID;
    private int ContractsOrdersPhysfaces_ID;
    private ContractOrderPhysface ContractOrderPhysface;
    private int ContractsOrdersYurfaces_ID;
    private ContractOrderYurface ContractOrderYurface;
    private String Cource;
    private Date DateBeginScience;
    private Date DateEndScience;
    private int Teacher_ID;
    private String Teacher;
    private int StatusOrder_ID;
    private String StatusOrder;

    public int getOrderAdmission_ID() {
        return OrderAdmission_ID;
    }

    public void setOrderAdmission_ID(int OrderAdmission_ID) {
        this.OrderAdmission_ID = OrderAdmission_ID;
    }

    public int getContractsOrdersPhysfaces_ID() {
        return ContractsOrdersPhysfaces_ID;
    }

    public void setContractsOrdersPhysfaces_ID(int ContractsOrdersPhysfaces_ID) {
        this.ContractsOrdersPhysfaces_ID = ContractsOrdersPhysfaces_ID;
    }

    public ContractOrderPhysface getContractOrderPhysface() {
        return ContractOrderPhysface;
    }

    public void setContractOrderPhysface(ContractOrderPhysface ContractOrderPhysface) {
        this.ContractOrderPhysface = ContractOrderPhysface;
    }

    public int getContractsOrdersYurfaces_ID() {
        return ContractsOrdersYurfaces_ID;
    }

    public void setContractsOrdersYurfaces_ID(int ContractsOrdersYurfaces_ID) {
        this.ContractsOrdersYurfaces_ID = ContractsOrdersYurfaces_ID;
    }

    public ContractOrderYurface getContractOrderYurface() {
        return ContractOrderYurface;
    }

    public void setContractOrderYurface(ContractOrderYurface ContractOrderYurface) {
        this.ContractOrderYurface = ContractOrderYurface;
    }

    public Date getDateBeginScience() {
        return DateBeginScience;
    }

    public void setDateBeginScience(Date DateBeginScience) {
        this.DateBeginScience = DateBeginScience;
    }

    public Date getDateEndScience() {
        return DateEndScience;
    }

    public void setDateEndScience(Date DateEndScience) {
        this.DateEndScience = DateEndScience;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    public String getCource() {
        return Cource;
    }

    public void setCource(String Cource) {
        this.Cource = Cource;
    }

    public int getStatusOrder_ID() {
        return StatusOrder_ID;
    }

    public void setStatusOrder_ID(int StatusOrder_ID) {
        this.StatusOrder_ID = StatusOrder_ID;
    }

    public String getStatusOrder() {
        return StatusOrder;
    }

    public void setStatusOrder(String StatusOrder) {
        this.StatusOrder = StatusOrder;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
    }
    
    
    
    
    
    
    
}
