package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private String emp_profilepic;
    @Column(name = "emp_StaffNO")
    private String empStaffNo;
    @Column(name = "emp_firstname")
    private String empFirstname;
    @Column(name = "emp_lastname")
    private String empLastname;
    @Column(name = "email")
    private String email;
    @Column(name = "emp_mobile")
    private String empMobile;
    @Column(name = "emp_designation")
    private String empDesignation;
    @Column(name = "create_time")
    private Date createdDate;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "employeeProfile", fetch = FetchType.EAGER)
    User user;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    Company company;

    @ManyToOne
    @JoinColumn(name = "employeeSupervisor_id", referencedColumnName = "id")
    EmployeeSupervisor employeeSupervisor;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employeeProfile", fetch = FetchType.EAGER)
    Collection<EmployeeAttendance> employeeAttendances;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public EmployeeSupervisor getEmployeeSupervisor() {
        return employeeSupervisor;
    }

    public void setEmployeeSupervisor(EmployeeSupervisor employeeSupervisor) {
        this.employeeSupervisor = employeeSupervisor;
    }

    public Collection<EmployeeAttendance> getEmployeeAttendances() {
        return employeeAttendances;
    }

    public void setEmployeeAttendances(Collection<EmployeeAttendance> employeeAttendances) {
        this.employeeAttendances = employeeAttendances;
    }
}
