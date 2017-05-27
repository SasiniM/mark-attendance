package org.dialog.hack.model;

import javax.persistence.*;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "User_Role")
    private String userRole;

    @OneToOne
    @JoinColumn(name = "Emp_id", referencedColumnName = "ID")
    EmployeeProfile employeeProfile;

    /*@OneToOne
    @JoinColumn(name = "sup_ID", referencedColumnName = "sup_ID")
    Employee_Supervisor employee_supervisor;
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }

    /*
    public void setEmployee_supervisor(Employee_Supervisor employee_supervisor) {
        this.employee_supervisor = employee_supervisor;
    }*/
}
