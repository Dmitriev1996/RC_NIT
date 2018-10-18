/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ContractOrderYurface {
    private int ContractsOrdersYurfaces_ID;
    private Date DateContract;
    private int AppTeach_ID;
    private int Yur_ID;
    private int Cource_ID;
    private String NameOrganization;
    private String Cource;
    private String TypeContract;
    private int TypeContract_ID;
    private String PayType;
    private int PayType_ID;
    private Date DateBegin;
    private Date DateEnd;
    private double Price;
    private String PayPeriod;
    private int PayPeriod_ID;
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

    public int getAppTeach_ID() {
        return AppTeach_ID;
    }

    public void setAppTeach_ID(int AppTeach_ID) {
        this.AppTeach_ID = AppTeach_ID;
    }

    public int getYur_ID() {
        return Yur_ID;
    }

    public void setYur_ID(int Yur_ID) {
        this.Yur_ID = Yur_ID;
    }

    public int getCource_ID() {
        return Cource_ID;
    }

    public void setCource_ID(int Cource_ID) {
        this.Cource_ID = Cource_ID;
    }

    public int getTypeContract_ID() {
        return TypeContract_ID;
    }

    public void setTypeContract_ID(int TypeContract_ID) {
        this.TypeContract_ID = TypeContract_ID;
    }

    public int getPayType_ID() {
        return PayType_ID;
    }

    public void setPayType_ID(int PayType_ID) {
        this.PayType_ID = PayType_ID;
    }

    public int getPayPeriod_ID() {
        return PayPeriod_ID;
    }

    public void setPayPeriod_ID(int PayPeriod_ID) {
        this.PayPeriod_ID = PayPeriod_ID;
    }
    
    public void getColumnString(){
        ArrayList<String> columnString=new ArrayList<String>();
        ArrayList<String> valueString=new ArrayList<String>();
        if(ContractsOrdersYurfaces_ID!=0){
            columnString.add("ContractsOrdersYurfaces_ID");
            valueString.add(ContractsOrdersYurfaces_ID+"");
        }
        if(DateContract!=null){
            columnString.add("DateContract");
            valueString.add("'"+DateContract+"'");
        }
        if(AppTeach_ID!=0){
            columnString.add("AppTeach_ID");
            valueString.add(AppTeach_ID+"");
        }
        if(Yur_ID!=0){
            columnString.add("Yur_ID");
        }
    }

 
    
}
