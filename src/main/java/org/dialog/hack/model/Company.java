package org.dialog.hack.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Company_Name")
    private String companyName;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "company", fetch = FetchType.EAGER)
    List<EmployeeProfile> employeeProfiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<EmployeeProfile> getEmployeeProfiles() {
        return employeeProfiles;
    }

    public void setEmployeeProfiles(List<EmployeeProfile> employeeProfiles) {
        this.employeeProfiles = employeeProfiles;
    }
}
