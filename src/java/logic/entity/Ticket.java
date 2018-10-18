/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Ticket {
    private int Ticket_ID;
    private String Serial;
    private Date Date;
    private String Client;
    private String NameWork;
    private int Number;
    private double Price;
    private String Worker;
    private int NumberContract;
    private Date DatePay;

    public int getTicket_ID() {
        return Ticket_ID;
    }

    public void setTicket_ID(int Ticket_ID) {
        this.Ticket_ID = Ticket_ID;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String Client) {
        this.Client = Client;
    }

    public String getNameWork() {
        return NameWork;
    }

    public void setNameWork(String NameWork) {
        this.NameWork = NameWork;
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

    public String getWorker() {
        return Worker;
    }

    public void setWorker(String Worker) {
        this.Worker = Worker;
    }

    public int getNumberContract() {
        return NumberContract;
    }

    public void setNumberContract(int NumberContract) {
        this.NumberContract = NumberContract;
    }

    public Date getDatePay() {
        return DatePay;
    }

    public void setDatePay(Date DatePay) {
        this.DatePay = DatePay;
    }
    
}
