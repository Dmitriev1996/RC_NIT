/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Admin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(REST.ActOrderYurfaceREST.class);
        resources.add(REST.ContractOrderPhysfaceREST.class);
        resources.add(REST.ContractOrderYurfaceREST.class);
        resources.add(REST.CourceREST.class);
        resources.add(REST.ExamineREST.class);
        resources.add(REST.GroupAppREST.class);
        resources.add(REST.GroupClassREST.class);
        resources.add(REST.GroupREST.class);
        resources.add(REST.IndividualClassREST.class);
        resources.add(REST.IndividualStudentREST.class);
        resources.add(REST.OrderAdmissionPhysfaceREST.class);
        resources.add(REST.OrderAdmissionYurfaceREST.class);
        resources.add(REST.PayPeriodREST.class);
        resources.add(REST.PayREST.class);
        resources.add(REST.PayTypeREST.class);
        resources.add(REST.PhysfaceAppTeachREST.class);
        resources.add(REST.PhysfaceREST.class);
        resources.add(REST.StatusAppREST.class);
        resources.add(REST.StatusOrderREST.class);
        resources.add(REST.StatusScienceREST.class);
        resources.add(REST.StudentREST.class);
        resources.add(REST.TeacherREST.class);
        resources.add(REST.TypeContractREST.class);
        resources.add(REST.TypeScienceREST.class);
        resources.add(REST.YurfaceAppTeachREST.class);
        resources.add(REST.YurfaceREST.class);
    }
    
}
