package org.dialog.hack.rest.resources;

import org.dialog.hack.model.EmployeeSupervisor;

/**
 * Created by sasini on 5/24/17.
 */
public class EmployeeSupervisorResource {
    private Integer sup_ID;
    private String sup_firstname;
    private String sup_lastname;
    private String sup_staffNo;

    public EmployeeSupervisorResource(EmployeeSupervisor employee_supervisor){
        this.sup_ID = employee_supervisor.getSup_ID();
        this.sup_firstname = employee_supervisor.getSup_firstname();
        this.sup_lastname = employee_supervisor.getSup_lastname();
        this.sup_staffNo = employee_supervisor.getSup_staffNo();
    }
}
