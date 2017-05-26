/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.*;

import java.util.Collection;
import java.util.Date;

/**
 * Created by sasini on 5/24/17.
 *
 */
public class EmployeeProfileResource {

    private Long id;
    //private String emp_profilepic;
    private String empStaffNo;
    private String empFirstname;
    private String empLastname;
    private String email;
    private String empMobile;
    private String empDesignation;
    private Date createdDate;

    private UserResource userResource;
    private CompanyResource companyResource; // Company Resource
    private EmployeeSupervisorResource employeeSupervisorResource; //supervisor resource
    private Collection<EmployeeAttendanceResource> employeeAttendanceResources;


    public EmployeeProfileResource(EmployeeProfile employeeProfile) {
        this.id = employeeProfile.getId();
        this.empStaffNo = employeeProfile.getEmpStaffNo();
        this.empFirstname = employeeProfile.getEmpFirstname();
        this.empLastname = employeeProfile.getEmpLastname();
        this.email = employeeProfile.getEmail();
        this.empMobile = employeeProfile.getEmpMobile();
        this.empDesignation = employeeProfile.getEmpDesignation();
        this.createdDate = employeeProfile.getCreatedDate();
        this.userResource = new UserResource(employeeProfile.getUser());
        this.companyResource = new CompanyResource(employeeProfile.getCompany());
        this.employeeSupervisorResource = new EmployeeSupervisorResource(employeeProfile.getEmployeeSupervisor());
        this.employeeAttendanceResources = new EmployeeAttendanceResource(employeeProfile.getEmployeeAttendances());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpStaffNo() {
        return empStaffNo;
    }

    public void setEmpStaffNo(String empStaffNo) {
        this.empStaffNo = empStaffNo;
    }

    public String getEmpFirstname() {
        return empFirstname;
    }

    public void setEmpFirstname(String empFirstname) {
        this.empFirstname = empFirstname;
    }

    public String getEmpLastname() {
        return empLastname;
    }

    public void setEmpLastname(String empLastname) {
        this.empLastname = empLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserResource getUserResource() {
        return userResource;
    }

    public void setUserResource(UserResource userResource) {
        this.userResource = userResource;
    }

    public CompanyResource getCompanyResource() {
        return companyResource;
    }

    public void setCompanyResource(CompanyResource companyResource) {
        this.companyResource = companyResource;
    }

    public EmployeeSupervisorResource getEmployeeSupervisorResource() {
        return employeeSupervisorResource;
    }

    public void setEmployeeSupervisorResource(EmployeeSupervisorResource employeeSupervisorResource) {
        this.employeeSupervisorResource = employeeSupervisorResource;
    }

    public Collection<EmployeeAttendanceResource> getEmployeeAttendanceResources() {
        return employeeAttendanceResources;
    }

    public void setEmployeeAttendanceResources(Collection<EmployeeAttendanceResource> employeeAttendanceResources) {
        this.employeeAttendanceResources = employeeAttendanceResources;
    }

    public EmployeeProfile toEmployeeProfile() {
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setId(id);
        employeeProfile.setEmpStaffNo(empStaffNo);
        employeeProfile.setEmpFirstname(empFirstname);
        employeeProfile.setEmpLastname(empLastname);
        employeeProfile.setEmail(email);
        employeeProfile.setEmpMobile(empMobile);
        employeeProfile.setEmpDesignation(empDesignation);

        return  employeeProfile;
    }
}