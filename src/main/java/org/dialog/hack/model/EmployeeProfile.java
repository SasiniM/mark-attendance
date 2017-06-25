package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
@Table(name = "Employee_Profile")
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    //private String emp_profilepic;
    @Column(name = "Emp_StaffNO")
    private String empStaffNo;
    @Column(name = "Emp_Firstname")
    private String empFirstname;
    @Column(name = "Emp_Lastname")
    private String empLastname;
    @Column(name = "Email")
    private String email;
    @Column(name = "Emp_Mobile")
    private String empMobile;
    @Column(name = "Emp_Designation")
    private String empDesignation;
    @Column(name = "Create_Time")
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "ID")
    User user;

    @ManyToOne
    @JoinColumn(name = "Company_ID", referencedColumnName = "ID")
    Company company;

    @ManyToOne
    @JoinColumn(name = "Emp_Sup_ID", referencedColumnName = "ID")
    EmployeeSupervisor employeeSupervisor;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employeeProfile", fetch = FetchType.EAGER)
    List<EmployeeAttendance> employeeAttendances;

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

    public List<EmployeeAttendance> getEmployeeAttendances() {
        return employeeAttendances;
    }

    public void setEmployeeAttendances(List<EmployeeAttendance> employeeAttendances) {
        this.employeeAttendances = employeeAttendances;
    }
}
