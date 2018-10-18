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
public class ContractOrderYurface {
    private int ContractsOrdersYurfaces_ID;
    private Date DateContract;
    private String NameOrganization;
    private String Cource;
    private String TypeContract;
    private String PayType;
    private Date DateBegin;
    private Date DateEnd;
    private double Price;
    private String PayPeriod;
    private double SumPay;
    private double SumYear;
    private String DetailsContract;
    private String Comment;
    private byte CloseContract;

    public int getContractsOrdersYurfaces_ID() {
        return ContractsOrdersYurfaces_ID;
    }

    public void setContractsOrdersYurfaces_ID(int ContractsOrdersYurfaces_ID) {
        this.ContractsOrdersYurfaces_ID = ContractsOrdersYurfaces_ID;
    }

    public Date getDateContract() {
        return DateContract;
    }

    public void setDateContract(Date DateContract) {
        this.DateContract = DateContract;
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

    public String getTypeContract() {
        return TypeContract;
    }

    public void setTypeContract(String TypeContract) {
        this.TypeContract = TypeContract;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String PayType) {
        this.PayType = PayType;
    }

    public Date getDateBegin() {
        return DateBegin;
    }

    public void setDateBegin(Date DateBegin) {
        this.DateBegin = DateBegin;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date DateEnd) {
        this.DateEnd = DateEnd;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getPayPeriod() {
        return PayPeriod;
    }

    public void setPayPeriod(String PayPeriod) {
        this.PayPeriod = PayPeriod;
    }

    public double getSumPay() {
        return SumPay;
    }

    public void setSumPay(double SumPay) {
        this.SumPay = SumPay;
    }

    public double getSumYear() {
        return SumYear;
    }

    public void setSumYear(double SumYear) {
        this.SumYear = SumYear;
    }

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

 
    
}
