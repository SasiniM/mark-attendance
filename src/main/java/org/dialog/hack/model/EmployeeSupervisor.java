package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
@Table(name = "Employee_Supervisor")
public class EmployeeSupervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supID;

    @Column(name = "sup_firstname", nullable = false)
    private String supFirstname;

    @Column(name = "sup_lastname")
    private String supLastname;

    @Column(name = "sup_staffNo", nullable = false)
    private String supStaffNo;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employeeSupervisor", fetch = FetchType.EAGER)
    Collection<EmployeeProfile> employeeProfiles;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "employeeProfile", fetch = FetchType.EAGER)
    User user;

    public Long getSupID() {
        return supID;
    }

    public void setSupID(Long supID) {
        this.supID = supID;
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

    public Collection<EmployeeProfile> getEmployeeProfiles() {
        return employeeProfiles;
    }

    public void setEmployeeProfiles(Collection<EmployeeProfile> employeeProfiles) {
        this.employeeProfiles = employeeProfiles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
