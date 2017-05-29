/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.util.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class UserAuthentication implements Authentication {

    private final UserDetail user;
    private boolean authenticated = true;

    public UserAuthentication(UserDetail user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getCredentials() {
        return user.getPassword();
    }

    @Override
    public UserDetail getDetails() {
        return user;
    }

    @Override
    public String getPrincipal() {
        return user.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated =authenticated;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
