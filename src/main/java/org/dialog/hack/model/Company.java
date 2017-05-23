package org.dialog.hack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer company_ID;
    private String getCompany_name;

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
