package org.dialog.hack.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer company_ID;
    private String getCompany_name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "company", fetch = FetchType.EAGER)
    Collection<Employee_Profile> employee_profiles;

    public Integer getCompany_ID() {
        return company_ID;
    }

    public void setCompany_ID(Integer company_ID) {
        this.company_ID = company_ID;
    }

    public String getGetCompany_name() {
        return getCompany_name;
    }

    public void setGetCompany_name(String getCompany_name) {
        this.getCompany_name = getCompany_name;
    }

    public Collection<Employee_Profile> getEmployee_profiles() {
        return employee_profiles;
    }

    public void setEmployee_profiles(Collection<Employee_Profile> employee_profiles) {
        this.employee_profiles = employee_profiles;
    }
}
