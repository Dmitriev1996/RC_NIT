/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Admin
 */
public class AppTeach {
    private int AppTeach_ID;
    private String FIO;
    private String NameOrganization;
    private String Cource;
    private String Certification;
    private String Pay;
    private String TypeScience;
    private String StatusApp;
    private String Comment;

    public int getAppTeach_ID() {
        return AppTeach_ID;
    }

    public void setAppTeach_ID(int AppTeach_ID) {
        this.AppTeach_ID = AppTeach_ID;
    }


    public String getCertification() {
        return Certification;
    }

    public void setCertification(String Certification) {
        this.Certification = Certification;
    }
    
    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
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

    public String getPay() {
        return Pay;
    }

    public void setPay(String Pay) {
        this.Pay = Pay;
    }

    public String getTypeScience() {
        return TypeScience;
    }

    public void setTypeScience(String TypeScience) {
        this.TypeScience = TypeScience;
    }

    public String getStatusApp() {
        return StatusApp;
    }

    public void setStatusApp(String StatusApp) {
        this.StatusApp = StatusApp;
    }
    
}
