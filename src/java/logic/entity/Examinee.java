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
public class Examinee {
    private int Examinee_ID;
    private int Examine_ID;
    private int Student_ID;
    private String FIO;
    private int Mark_ID;
    private String Mark;

    public int getExaminee_ID() {
        return Examinee_ID;
    }

    public void setExaminee_ID(int Examinee_ID) {
        this.Examinee_ID = Examinee_ID;
    }

    public int getExamine_ID() {
        return Examine_ID;
    }

    public void setExamine_ID(int Examine_ID) {
        this.Examine_ID = Examine_ID;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getMark_ID() {
        return Mark_ID;
    }

    public void setMark_ID(int Mark_ID) {
        this.Mark_ID = Mark_ID;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String Mark) {
        this.Mark = Mark;
    }
    
    
    
}
