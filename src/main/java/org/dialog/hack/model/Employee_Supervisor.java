package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Employee_Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sup_ID;
    private String sup_firstname;
    private String sup_lastname;
    private String sup_staffNo;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "employee_supervisor", fetch = FetchType.EAGER)
    Employee_Profile employee_profile;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "employee_supervisor", fetch = FetchType.EAGER)
    User user;

    public Integer getSup_ID() {
        return sup_ID;
    }

    public void setSup_ID(Integer sup_ID) {
        this.sup_ID = sup_ID;
    }

    public String getSup_firstname() {
        return sup_firstname;
    }

    public void setSup_firstname(String sup_firstname) {
        this.sup_firstname = sup_firstname;
    }

    public String getSup_lastname() {
        return sup_lastname;
    }

    public void setSup_lastname(String sup_lastname) {
        this.sup_lastname = sup_lastname;
    }

    public String getSup_staffNo() {
        return sup_staffNo;
    }

    public void setSup_staffNo(String sup_staffNo) {
        this.sup_staffNo = sup_staffNo;
    }

    public Employee_Profile getEmployee_profile() {
        return employee_profile;
    }

    public void setEmployee_profile(Employee_Profile employee_profile) {
        this.employee_profile = employee_profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
