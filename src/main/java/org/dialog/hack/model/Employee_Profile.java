package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
public class Employee_Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer emp_ID;
    //String emp_profilepic;
    private String emp_staff_no;
    private String emp_firstname;
    private String emp_lastname;
    private String email;
    private Integer company_ID;
    private String emp_mobile;
    private Integer sup_ID;
    private String emp_designation;
    private String createTime;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employee_profile", fetch = FetchType.EAGER)
    User user;

    @ManyToOne
    @JoinColumn(name = "company_ID", referencedColumnName = "company_ID")
    Company company;

    @OneToOne
    @JoinColumn(name = "sup_ID", referencedColumnName = "sup_ID")
    Employee_Supervisor employee_supervisor;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "emp_profile", fetch = FetchType.EAGER)
    Collection<Employee_Attendance> employee_attendances;

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

    public Integer getCompany_ID() {
        return company_ID;
    }

    public void setCompany_ID(Integer company_ID) {
        this.company_ID = company_ID;
    }

    public String getEmp_mobile() {
        return emp_mobile;
    }

    public void setEmp_mobile(String emp_mobile) {
        this.emp_mobile = emp_mobile;
    }

    public Integer getSup_ID() {
        return sup_ID;
    }

    public void setSup_ID(Integer sup_ID) {
        this.sup_ID = sup_ID;
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
}
