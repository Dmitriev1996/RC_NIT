/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ActOrderYurface {
    private int ActsOrdersYurface_ID;
    private Date DateAct;
    private String NameOrganization;
    private String Cource;
    private double Price;
    private Date DatePay;
    private String Comment;
    private byte ReturnAct;

    public int getActsOrdersYurface_ID() {
        return ActsOrdersYurface_ID;
    }

    public void setActsOrdersYurface_ID(int ActsOrdersYurface_ID) {
        this.ActsOrdersYurface_ID = ActsOrdersYurface_ID;
    }

    public Date getDateAct() {
        return DateAct;
    }

    public void setDateAct(Date DateAct) {
        this.DateAct = DateAct;
    }

    public String getNameWork() {
        return NameOrganization;
    }

    public void setNameWork(String NameWork) {
        this.NameOrganization = NameWork;
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

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public byte getReturnAct() {
        return ReturnAct;
    }

    public void setReturnAct(byte ReturnAct) {
        this.ReturnAct = ReturnAct;
    }

    public String getNameOrganization() {
        return NameOrganization;
    }

    public void setNameOrganization(String NameOrganization) {
        this.NameOrganization = NameOrganization;
    }

    public String getCource() {
        return Cource;
    }

    public void setCource(String Cource) {
        this.Cource = Cource;
    }
    
}
