package org.dialog.hack.rest.resources;

import org.dialog.hack.model.Company;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sasini on 5/24/17.
 */
public class CompanyResource {
    private Long id;
    private String companyName;

    List<EmployeeProfileResource> employeeProfileResources;

    public CompanyResource(Company company){
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.employeeProfileResources =
                company.getEmployeeProfiles().
                        stream().map(EmployeeProfileResource::new).collect(Collectors.toList());
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

    public List<EmployeeProfileResource> getEmployeeProfileResources() {
        return employeeProfileResources;
    }

    public void setEmployeeProfileResources(List<EmployeeProfileResource> employeeProfileResources) {
        this.employeeProfileResources = employeeProfileResources;
    }

    public Company toCompany() {
        Company company = new Company();
        company.setId(id);
        company.setCompanyName(companyName);
        company.setEmployeeProfiles(employeeProfileResources.stream().
                map(EmployeeProfileResource::toEmployeeProfile).
                collect(Collectors.toList()));
        return  company;
    }
}
