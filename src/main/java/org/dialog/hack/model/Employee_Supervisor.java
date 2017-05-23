package org.dialog.hack.model;

import javax.persistence.Entity;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Employee_Supervisor {
    private String sup_ID;
    private String sup_firstname;
    private  String sup_lastname;
    private  String sup_staffNo;

    public String getSup_ID() {
        return sup_ID;
    }

    public void setSup_ID(String sup_ID) {
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
}
