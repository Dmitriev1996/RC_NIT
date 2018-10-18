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
public class Student {
    private int Student_ID;
    private Date DateCertification;
    private int Group_ID;
    private String Group;
    private int Phys_ID;
    private Physface Physface;

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public Date getDateCertification() {
        return DateCertification;
    }

    public void setDateCertification(Date DateCertification) {
        this.DateCertification = DateCertification;
    }

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    public int getPhys_ID() {
        return Phys_ID;
    }

    public void setPhys_ID(int Phys_ID) {
        this.Phys_ID = Phys_ID;
    }

    public Physface getPhysface() {
        return Physface;
    }

    public void setPhysface(Physface Physface) {
        this.Physface = Physface;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }
    
    
    
    
    
}
