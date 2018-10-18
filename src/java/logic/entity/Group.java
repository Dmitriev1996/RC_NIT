/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Group {
    private int Group_ID;
    private int Cource_ID;
    private Cource Cource;
    private byte Certification;
    private int Teacher_ID;
    private Teacher Teacher;
    private ArrayList<Student> StudentList;
    private int StatusScience_ID;
    private String StatusScience;

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
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

    public byte getCertification() {
        return Certification;
    }

    public void setCertification(byte Certification) {
        this.Certification = Certification;
    }

    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public int getStatusScience_ID() {
        return StatusScience_ID;
    }

    public void setStatusScience_ID(int StatusScience_ID) {
        this.StatusScience_ID = StatusScience_ID;
    }

    public String getStatusScience() {
        return StatusScience;
    }

    public void setStatusScience(String StatusScience) {
        this.StatusScience = StatusScience;
    }
    
    
    
    
    
    
    
}
