package org.dialog.hack.model;

import javax.persistence.*;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer u_ID;
    private String username;
    private String password;
    private String user_role;

    @OneToOne
    @JoinColumn(name = "emp_ID", referencedColumnName = "emp_ID")
    Employee_Profile employee_profile;


    /*@OneToOne
    @JoinColumn(name = "sup_ID", referencedColumnName = "sup_ID")
    Employee_Supervisor employee_supervisor;
*/
    public Integer getU_ID() {
        return u_ID;
    }

    public void setU_ID(Integer u_ID) {
        this.u_ID = u_ID;
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

    public Employee_Profile getEmployee_profile() {
        return employee_profile;
    }

    public void setEmployee_profile(Employee_Profile employee_profile) {
        this.employee_profile = employee_profile;
    }

    /*public Employee_Supervisor getEmployee_supervisor() {
        return employee_supervisor;
    }

    public void setEmployee_supervisor(Employee_Supervisor employee_supervisor) {
        this.employee_supervisor = employee_supervisor;
    }*/
}
