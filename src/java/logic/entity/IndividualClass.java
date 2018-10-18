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
public class IndividualClass {
    private int IndividualClass_ID;
    private int IndividualStudent_ID;
    private IndividualStudent IndividualStudent;
    private Date DateClass;
    private int NumberAudience;

    public int getIndividualClass_ID() {
        return IndividualClass_ID;
    }

    public void setIndividualClass_ID(int IndividualClass_ID) {
        this.IndividualClass_ID = IndividualClass_ID;
    }

    public int getIndividualStudent_ID() {
        return IndividualStudent_ID;
    }

    public void setIndividualStudent_ID(int IndividualStudent_ID) {
        this.IndividualStudent_ID = IndividualStudent_ID;
    }

    public Date getDateClass() {
        return DateClass;
    }

    public void setDateClass(Date DateClass) {
        this.DateClass = DateClass;
    }

    public int getNumberAudience() {
        return NumberAudience;
    }

    public void setNumberAudience(int NumberAudience) {
        this.NumberAudience = NumberAudience;
    }

    public IndividualStudent getIndividualStudent() {
        return IndividualStudent;
    }

    public void setIndividualStudent(IndividualStudent IndividualStudent) {
        this.IndividualStudent = IndividualStudent;
    }
    
    
    
}
