/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.model.EmployeeProfile;
import org.dialog.hack.model.User;

import javax.persistence.*;

/**
 * Created by sasini on 5/24/17.
 *
 */
public class UserResource {

    private Long id;
    private String username;
    private String password;
    private String userRole;
    EmployeeProfileResource employeeProfileResource;

    public UserResource(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.userRole = user.getUserRole();
        this.employeeProfileResource = new EmployeeProfileResource(user.getEmployeeProfile());
    }

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

    public EmployeeProfileResource getEmployeeProfileResource() {
        return employeeProfileResource;
    }

    public void setEmployeeProfileResource(EmployeeProfileResource employeeProfileResource) {
        this.employeeProfileResource = employeeProfileResource;
    }
    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserRole(userRole);
        user.;

        return  user;
}
