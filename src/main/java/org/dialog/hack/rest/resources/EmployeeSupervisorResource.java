package org.dialog.hack.rest.resources;

import org.dialog.hack.model.EmployeeProfile;
import org.dialog.hack.model.EmployeeSupervisor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by sasini on 5/24/17.
 */
public class EmployeeSupervisorResource {

    private Long id;
    private String supFirstname;
    private String supLastname;
    private String supStaffNo;

    Collection<EmployeeProfileResource> employeeProfileResources;

    public EmployeeSupervisorResource(EmployeeSupervisor employeeSupervisor){
        this.id = employeeSupervisor.getId();
        this.supFirstname = employeeSupervisor.getSupFirstname();
        this.supLastname = employeeSupervisor.getSupLastname();
        this.supStaffNo = employeeSupervisor.getSupStaffNo();
        this.employeeProfileResources = new EmployeeProfileResource(employeeSupervisor.getEmployeeProfiles());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupFirstname() {
        return supFirstname;
    }

    public void setSupFirstname(String supFirstname) {
        this.supFirstname = supFirstname;
    }

    public String getSupLastname() {
        return supLastname;
    }

    public void setSupLastname(String supLastname) {
        this.supLastname = supLastname;
    }

    public String getSupStaffNo() {
        return supStaffNo;
    }

    public void setSupStaffNo(String supStaffNo) {
        this.supStaffNo = supStaffNo;
    }

    public Collection<EmployeeProfileResource> getEmployeeProfileResources() {
        return employeeProfileResources;
    }

    public void setEmployeeProfileResources(Collection<EmployeeProfileResource> employeeProfileResources) {
        this.employeeProfileResources = employeeProfileResources;
    }

    public EmployeeSupervisor toEmployeeSupervisor() {
        EmployeeSupervisor employeeSupervisor = new EmployeeSupervisor();
        employeeSupervisor.setId(id);
        employeeSupervisor.setSupFirstname(supFirstname);
        employeeSupervisor.setSupLastname(supLastname);
        employeeSupervisor.setSupStaffNo(supStaffNo);
        employeeSupervisor.setEmployeeProfiles(employeeProfileResources);

        return  employeeSupervisor;
    }
}
