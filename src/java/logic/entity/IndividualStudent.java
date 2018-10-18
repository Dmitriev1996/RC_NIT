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
public class IndividualStudent {
    private int IndividualStudent_ID;
    private int Phys_ID;
    private Physface Physface;
    private int Cource_ID;
    private Cource Cource;
    private Date DateCertification;
    private byte Certificaton;
    private int Teacher_ID;
    private String Teacher;

    public int getIndividualStudent_ID() {
        return IndividualStudent_ID;
    }

    public void setIndividualStudent_ID(int IndividualStudent_ID) {
        this.IndividualStudent_ID = IndividualStudent_ID;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
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

    public Date getDateCertification() {
        return DateCertification;
    }

    public void setDateCertification(Date DateCertification) {
        this.DateCertification = DateCertification;
    }

    public byte getCertificaton() {
        return Certificaton;
    }

    public void setCertificaton(byte Certificaton) {
        this.Certificaton = Certificaton;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    public int getCource_ID() {
        return Cource_ID;
    }

    public void setCource_ID(int Cource_ID) {
        this.Cource_ID = Cource_ID;
    }

    public Cource getCource() {
        return Cource;
    }

    public void setCource(Cource Cource) {
        this.Cource = Cource;
    }
    
    
    
    
    
    
    
}
