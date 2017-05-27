package org.dialog.hack.rest.resources;

import org.dialog.hack.model.EmployeeSupervisor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sasini on 5/24/17.
 */
public class EmployeeSupervisorResource {

    private Long id;
    private String supFirstname;
    private String supLastname;
    private String supStaffNo;

    List<EmployeeProfileResource> employeeProfileResources;

    public  EmployeeSupervisorResource(){}
    public EmployeeSupervisorResource(EmployeeSupervisor employeeSupervisor){
        this.id = employeeSupervisor.getId();
        this.supFirstname = employeeSupervisor.getSupFirstname();
        this.supLastname = employeeSupervisor.getSupLastname();
        this.supStaffNo = employeeSupervisor.getSupStaffNo();
        if(employeeSupervisor.getEmployeeProfiles() != null) {
            this.employeeProfileResources =
                    employeeSupervisor.getEmployeeProfiles().
                            stream().map(EmployeeProfileResource::new).collect(Collectors.toList());
        }

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

    public List<EmployeeProfileResource> getEmployeeProfileResources() {
        return employeeProfileResources;
    }

    public void setEmployeeProfileResources(List<EmployeeProfileResource> employeeProfileResources) {
        this.employeeProfileResources = employeeProfileResources;
    }

    public EmployeeSupervisor toEmployeeSupervisor() {
        EmployeeSupervisor employeeSupervisor = new EmployeeSupervisor();
        employeeSupervisor.setId(id);
        employeeSupervisor.setSupFirstname(supFirstname);
        employeeSupervisor.setSupLastname(supLastname);
        employeeSupervisor.setSupStaffNo(supStaffNo);
        if (employeeProfileResources != null) {
            employeeSupervisor.setEmployeeProfiles(employeeProfileResources.stream().
                    map(EmployeeProfileResource::toEmployeeProfile).
                    collect(Collectors.toList()));
        }

        return  employeeSupervisor;
    }
}
