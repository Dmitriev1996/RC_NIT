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
public class Examine {
    private int Examine_ID;
    private int Cource_ID;
    private String Cource;
    private int NumberHours;
    private Date DateExamine;
    private int Teacher_ID;
    private String Teacher;
    private ArrayList<Examinee> StudentList;

    public int getExamine_ID() {
        return Examine_ID;
    }

    public void setExamine_ID(int Examine_ID) {
        this.Examine_ID = Examine_ID;
    }

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

    public Date getDateExamine() {
        return DateExamine;
    }

    public void setDateExamine(Date DateExamine) {
        this.DateExamine = DateExamine;
    }

    public ArrayList<Examinee> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Examinee> StudentList) {
        this.StudentList = StudentList;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }
    
    
    
    
    
}
