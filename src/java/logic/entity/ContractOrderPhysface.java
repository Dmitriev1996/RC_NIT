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
public class ContractOrderPhysface {
    private int ContractsOrdersPhysfaces_ID;
    private Date DateContract;
    private int AppTeach_ID;
    private int Phys_ID;
    private int Cource_ID;
    private Physface Physface;
    private Cource CourceObj;
    private String FIO;
    private String Cource;
    private int Number;
    private double Price;
    private Date DatePay;
    //private int Ticket_ID;
    private String DetailsContract;
    private String Comment;
    private byte CloseContract;

    public int getContractsOrdersPhysfaces_ID() {
        return ContractsOrdersPhysfaces_ID;
    }

    public void setContractsOrdersPhysfaces_ID(int ContractsOrdersPhysfaces_ID) {
        this.ContractsOrdersPhysfaces_ID = ContractsOrdersPhysfaces_ID;
    }

    public Date getDateContract() {
        return DateContract;
    }

    public void setDateContract(Date DateContract) {
        this.DateContract = DateContract;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Date getDatePay() {
        return DatePay;
    }

    public void setDatePay(Date DatePay) {
        this.DatePay = DatePay;
    }

    /*public int getTicket_ID() {
        return Ticket_ID;
    }*/

    /*public void setTicket_ID(int Ticket_ID) {
        this.Ticket_ID = Ticket_ID;
    }*/

    public String getDetailsContract() {
        return DetailsContract;
    }

    public void setDetailsContract(String DetailsContract) {
        this.DetailsContract = DetailsContract;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public byte getCloseContract() {
        return CloseContract;
    }

    public void setCloseContract(byte CloseContract) {
        this.CloseContract = CloseContract;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getCource() {
        return Cource;
    }

    public void setCource(String Cource) {
        this.Cource = Cource;
    }

    public int getAppTeach_ID() {
        return AppTeach_ID;
    }

    public void setAppTeach_ID(int AppTeach_ID) {
        this.AppTeach_ID = AppTeach_ID;
    }

    public int getPhys_ID() {
        return Phys_ID;
    }

    public void setPhys_ID(int Phys_ID) {
        this.Phys_ID = Phys_ID;
    }

    public int getCource_ID() {
        return Cource_ID;
    }

    public void setCource_ID(int Cource_ID) {
        this.Cource_ID = Cource_ID;
    }

    public Physface getPhysface() {
        return Physface;
    }

    public void setPhysface(Physface Physface) {
        this.Physface = Physface;
    }

    public Cource getCourceObj() {
        return CourceObj;
    }

    public void setCourceObj(Cource CourceObj) {
        this.CourceObj = CourceObj;
    }
    
}
