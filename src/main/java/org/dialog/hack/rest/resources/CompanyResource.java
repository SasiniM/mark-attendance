package org.dialog.hack.rest.resources;

import org.dialog.hack.model.Company;
import java.util.Collection;

/**
 * Created by sasini on 5/24/17.
 */
public class CompanyResource {
    private Long id;
    private String companyName;

    Collection<EmployeeProfileResource> employeeProfileResources;

    public CompanyResource(Company company){
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.employeeProfileResources = new EmployeeProfileResource(company.getEmployeeProfiles());
    }

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

    public Collection<EmployeeProfileResource> getEmployeeProfileResources() {
        return employeeProfileResources;
    }

    public void setEmployeeProfileResources(Collection<EmployeeProfileResource> employeeProfileResources) {
        this.employeeProfileResources = employeeProfileResources;
    }

    public Company toCompany() {
        Company company = new Company();
        company.setId(id);
        company.setCompanyName(companyName);
        company.setEmployeeProfiles(employeeProfileResources);

        return  company;
    }
}
