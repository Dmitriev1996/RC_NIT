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
public class AppTeach {
    private int AppTeach_ID;
    private int Phys_ID;
    private String FIO;
    private int Yur_ID;
    private Yurface Yurface;
    private Physface Physface;
    private ArrayList<Physface> PhysfaceList;
    private String NameOrganization;
    private int Cource_ID;
    private String Cource;
    private byte Certification_ID;
    private String Certification;
    private int Pay_ID;
    private String Pay;
    private int TypeScience_ID;
    private String TypeScience;
    private int StatusApp_ID;
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

    public int getPhys_ID() {
        return Phys_ID;
    }

    public void setPhys_ID(int Phys_ID) {
        this.Phys_ID = Phys_ID;
    }

    public int getYur_ID() {
        return Yur_ID;
    }

    public void setYur_ID(int Yur_ID) {
        this.Yur_ID = Yur_ID;
    }

    public int getCource_ID() {
        return Cource_ID;
    }

    public void setCource_ID(int Cource_ID) {
        this.Cource_ID = Cource_ID;
    }

    public byte getCertification_ID() {
        return Certification_ID;
    }

    public void setCertification_ID(byte Certification_ID) {
        this.Certification_ID = Certification_ID;
    }

    public int getPay_ID() {
        return Pay_ID;
    }

    public void setPay_ID(int Pay_ID) {
        this.Pay_ID = Pay_ID;
    }

    public int getTypeScience_ID() {
        return TypeScience_ID;
    }

    public void setTypeScience_ID(int TypeScience_ID) {
        this.TypeScience_ID = TypeScience_ID;
    }

    public int getStatusApp_ID() {
        return StatusApp_ID;
    }

    public void setStatusApp_ID(int StatusApp_ID) {
        this.StatusApp_ID = StatusApp_ID;
    }

    public Yurface getYurface() {
        return Yurface;
    }

    public void setYurface(Yurface Yurface) {
        this.Yurface = Yurface;
    }

    public ArrayList<Physface> getPhysfaceList() {
        return PhysfaceList;
    }

    public void setPhysfaceList(ArrayList<Physface> PhysfaceList) {
        this.PhysfaceList = PhysfaceList;
    }

    public Physface getPhysface() {
        return Physface;
    }

    public void setPhysface(Physface Physface) {
        this.Physface = Physface;
    }
    
}
