/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

/**
 *
 * @author Admin
 */
public class Cource {
    private int Cource_ID;
    private String Cource;
    private int NumberHours;
    private double Price;

    public int getCource_ID() {
        return Cource_ID;
    }

    public void setCource_ID(int Cource_ID) {
        this.Cource_ID = Cource_ID;
    }

    public String getCource() {
        return Cource;
    }

    public void setCource(String Cource) {
        this.Cource = Cource;
    }

    public int getNumberHours() {
        return NumberHours;
    }

    public void setNumberHours(int NumberHours) {
        this.NumberHours = NumberHours;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    
    
    
}
