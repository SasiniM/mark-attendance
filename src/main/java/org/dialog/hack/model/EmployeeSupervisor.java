package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
@Table(name = "Employee_Supervisor")
public class EmployeeSupervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Sup_Firstname", nullable = false)
    private String supFirstname;

    @Column(name = "Sup_Lastname")
    private String supLastname;

    @Column(name = "Sup_StaffNo", nullable = false)
    private String supStaffNo;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employeeSupervisor", fetch = FetchType.EAGER)
    List<EmployeeProfile> employeeProfiles;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "User_Id", referencedColumnName = "ID")
    User user1;
/*
    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "employeeProfile", fetch = FetchType.EAGER)
    @JoinColumn(name = "uID_fk", referencedColumnName = "uID")
    User user;
*/
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

    public List<EmployeeProfile> getEmployeeProfiles() {
        return employeeProfiles;
    }

    public void setEmployeeProfiles(List<EmployeeProfile> employeeProfiles) {
        this.employeeProfiles = employeeProfiles;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
}
