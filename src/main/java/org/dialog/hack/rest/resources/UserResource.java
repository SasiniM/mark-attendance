/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.User;

/**
 * Created by sasini on 5/24/17.
 *
 */
public class UserResource {

    private Integer u_ID;
    private String username;
    private String password;
    private String user_role;

    public UserResource(User user) {
        this.u_ID = user.getU_ID();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.user_role = user.getUser_role();
    }
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

}
