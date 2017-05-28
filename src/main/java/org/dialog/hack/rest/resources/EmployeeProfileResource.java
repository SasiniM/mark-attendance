/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    private UserResource user;
    private CompanyResource company; // Company Resource
    private EmployeeSupervisorResource employeeSupervisor; //supervisor resource
    private List<EmployeeAttendanceResource> employeeAttendance;


    public EmployeeProfileResource() {
    }

    public EmployeeProfileResource(EmployeeProfile employeeProfile) {
        this.id = employeeProfile.getId();
        this.empStaffNo = employeeProfile.getEmpStaffNo();
        this.empFirstname = employeeProfile.getEmpFirstname();
        this.empLastname = employeeProfile.getEmpLastname();
        this.email = employeeProfile.getEmail();
        this.empMobile = employeeProfile.getEmpMobile();
        this.empDesignation = employeeProfile.getEmpDesignation();
        this.createdDate = employeeProfile.getCreatedDate();
        if (employeeProfile.getUser() != null) {
            this.user = new UserResource(employeeProfile.getUser());
        }
        if (employeeProfile.getCompany() != null) {
            this.company = new CompanyResource(employeeProfile.getCompany());
        }

        if (employeeProfile.getEmployeeSupervisor() != null) {
            this.employeeSupervisor = new EmployeeSupervisorResource(employeeProfile.getEmployeeSupervisor());
        }

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

    public UserResource getUser() {
        return user;
    }

    public void setUser(UserResource user) {
        this.user = user;
    }

    public CompanyResource getCompany() {
        return company;
    }

    public void setCompany(CompanyResource company) {
        this.company = company;
    }

    public EmployeeSupervisorResource getEmployeeSupervisor() {
        return employeeSupervisor;
    }

    public void setEmployeeSupervisor(EmployeeSupervisorResource employeeSupervisor) {
        this.employeeSupervisor = employeeSupervisor;
    }

    public List<EmployeeAttendanceResource> getEmployeeAttendance() {
        return employeeAttendance;
    }

    public void setEmployeeAttendance(List<EmployeeAttendanceResource> employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
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
        employeeProfile.setCreatedDate(createdDate);

        if (user != null) {
            employeeProfile.setUser(user.toUser());
        }
        if (company != null) {
            employeeProfile.setCompany(company.toCompany());
        }
        if (employeeSupervisor != null) {
            employeeProfile.setEmployeeSupervisor(employeeSupervisor.toEmployeeSupervisor());
        }

        return  employeeProfile;
    }
}
