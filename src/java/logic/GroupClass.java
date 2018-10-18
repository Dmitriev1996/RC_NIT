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
public class GroupClass {
    private int GroupClasses_ID;
    private int Group_ID;
    private Date DateClass;
    private int NumberAudience;

    public int getGroupClasses_ID() {
        return GroupClasses_ID;
    }

    public void setGroupClasses_ID(int GroupClasses_ID) {
        this.GroupClasses_ID = GroupClasses_ID;
    }

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
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
    
}
