package org.dialog.hack.rest.resources;

import org.dialog.hack.model.Company;

/**
 * Created by sasini on 5/24/17.
 */
public class CompanyResource {
    private Integer company_ID;
    private String getCompany_name;

    public CompanyResource(Company company){
        this.company_ID = company.getCompany_ID();
        this.getCompany_name = company.getGetCompany_name();
    }

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
}
