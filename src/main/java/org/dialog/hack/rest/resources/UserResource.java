/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.Role;
import org.dialog.hack.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sasini on 5/24/17.
 *
 */
public class UserResource {

    private Long id;
    private String username;
    private String password;
    private List<RoleResource> roles;

    public UserResource() {
    }

    public UserResource(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
       // this.roles = user.getRoles().stream().map(RoleResource::new).collect(Collectors.toList());
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

    public List<RoleResource> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleResource> roles) {
        this.roles = roles;
    }

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
       // user.setRoles(roles.stream().map(RoleResource::toRole).collect(Collectors.toList()));

        return user;
    }
}
