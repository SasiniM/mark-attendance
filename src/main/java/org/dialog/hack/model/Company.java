package org.dialog.hack.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "company_name")
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
