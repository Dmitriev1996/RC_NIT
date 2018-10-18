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
public class Student {
    private int Student_ID;
    private int AppTeach_ID;
    private Date DateCertification;
    private int Group_ID;

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public int getAppTeach_ID() {
        return AppTeach_ID;
    }

    public void setAppTeach_ID(int AppTeach_ID) {
        this.AppTeach_ID = AppTeach_ID;
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
    
}
