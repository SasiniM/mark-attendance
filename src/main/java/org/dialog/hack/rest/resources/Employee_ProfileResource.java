/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.*;

import java.util.Collection;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class Employee_ProfileResource {

    private Integer emp_ID;
    //String emp_profilepic;
    private String emp_staff_no;
    private String emp_firstname;
    private String emp_lastname;
    private String email;
    private String emp_mobile;
    private String emp_designation;
    private String createTime;
    private UserResource userResource;
    private Company company; // Company Resource
    private Employee_Supervisor employee_supervisor; //supervisor resource
    private Collection<Employee_Attendance> employee_attendances;


    public Employee_ProfileResource(Employee_Profile employee_profile) {
        this.emp_ID = employee_profile.getEmp_ID();
        this.emp_staff_no = employee_profile.getEmp_staff_no();
        this.emp_firstname = employee_profile.getEmp_firstname();
        this.emp_lastname = employee_profile.getEmp_lastname();
        this.email = employee_profile.getEmail();
        this.emp_mobile = employee_profile.getEmp_mobile();
        this.emp_designation = employee_profile.getEmp_designation();
        this.createTime = employee_profile.getCreateTime();
        this.userResource = new UserResource(employee_profile.getUser());
        this.company = employee_profile.getCompany();
        this. employee_supervisor = employee_profile.getEmployee_supervisor();
        this.employee_attendances = employee_profile.getEmployee_attendances();
    }


    public Integer getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(Integer emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getEmp_staff_no() {
        return emp_staff_no;
    }

    public void setEmp_staff_no(String emp_staff_no) {
        this.emp_staff_no = emp_staff_no;
    }

    public String getEmp_firstname() {
        return emp_firstname;
    }

    public void setEmp_firstname(String emp_firstname) {
        this.emp_firstname = emp_firstname;
    }

    public String getEmp_lastname() {
        return emp_lastname;
    }

    public void setEmp_lastname(String emp_lastname) {
        this.emp_lastname = emp_lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmp_mobile() {
        return emp_mobile;
    }

    public void setEmp_mobile(String emp_mobile) {
        this.emp_mobile = emp_mobile;
    }

    public String getEmp_designation() {
        return emp_designation;
    }

    public void setEmp_designation(String emp_designation) {
        this.emp_designation = emp_designation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public UserResource getUser() {
        return userResource;
    }

    public void setUser(UserResource userResource) {
        this.userResource = userResource;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee_Supervisor getEmployee_supervisor() {
        return employee_supervisor;
    }

    public void setEmployee_supervisor(Employee_Supervisor employee_supervisor) {
        this.employee_supervisor = employee_supervisor;
    }

    public Collection<Employee_Attendance> getEmployee_attendances() {
        return employee_attendances;
    }

    public void setEmployee_attendances(Collection<Employee_Attendance> employee_attendances) {
        this.employee_attendances = employee_attendances;
    }

    public Employee_Profile toEmployee_profile() {
        Employee_Profile employee_profile = new Employee_Profile();
        employee_profile.setEmp_ID(emp_ID);
        employee_profile.setEmp_staff_no(emp_staff_no);
        employee_profile.setEmp_firstname(emp_firstname);
        employee_profile.setEmp_lastname(emp_lastname);
        employee_profile.setEmail(email);
        employee_profile.setEmp_mobile(emp_mobile);
        employee_profile.setEmp_designation(emp_designation);

        return  employee_profile;
    }
}
