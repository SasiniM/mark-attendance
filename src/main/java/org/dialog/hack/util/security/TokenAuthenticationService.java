/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.util.security;

import org.dialog.hack.model.User;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "Authorization";

    private final TokenHandler tokenHandler;

    public TokenAuthenticationService(String secret, UserService userService) {
        this.tokenHandler = new TokenHandler(secret, userService);
    }

    public String addAuthentication(HttpServletResponse response, String username) throws IOException {
        String token = tokenHandler.createTokenForUser(username);
        response.setHeader(AUTH_HEADER_NAME, token);
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            final UserDetail user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                return  new UserAuthentication(user);
            }
        }
        return null;
    }
}
