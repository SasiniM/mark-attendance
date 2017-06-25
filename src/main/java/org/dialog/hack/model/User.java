package org.dialog.hack.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sasini on 5/22/17.
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user", fetch = FetchType.EAGER)
    EmployeeProfile employeeProfile;

    @OneToOne
    @JoinColumn(name = "Sup_Id", referencedColumnName = "ID")
    EmployeeSupervisor employeeSupervisor;

    @ManyToMany
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "Role_Id"))
    private List<Role> roles;

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


    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }

    public EmployeeSupervisor getEmployeeSupervisor() {
        return employeeSupervisor;
    }

    public void setEmployeeSupervisor(EmployeeSupervisor employeeSupervisor) {
        this.employeeSupervisor = employeeSupervisor;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    /*
    public void setEmployee_supervisor(Employee_Supervisor employee_supervisor) {
        this.employee_supervisor = employee_supervisor;
    }*/
}
