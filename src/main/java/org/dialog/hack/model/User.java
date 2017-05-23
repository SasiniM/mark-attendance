package org.dialog.hack.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
public class User {
    private int emp_ID;
    private String username;
    private String password;
    private String user_role;

    @OneToOne
    Employee_Profile employee_profile;
    @OneToOne
    Employee_Supervisor employee_supervisor;

    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public Employee_Supervisor getEmployee_supervisor() {
        return employee_supervisor;
    }

    public void setEmployee_supervisor(Employee_Supervisor employee_supervisor) {
        this.employee_supervisor = employee_supervisor;
    }

    public Employee_Profile getEmployee_profile() {
        return employee_profile;
    }

    public void setEmployee_profile(Employee_Profile employee_profile) {
        this.employee_profile = employee_profile;
    }
}
