/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

import org.dialog.hack.model.Role;

/**
 * Created by sasini on 5/24/17.
 */
public class RoleResource {

    private Long id;
    private String name;

    public RoleResource() {
    }

    public RoleResource(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role toRole(){
        Role role = new Role();
        role.setId(id);
        role.setName(name);

        return role;
    }
}
