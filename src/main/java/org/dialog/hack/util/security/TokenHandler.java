/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.util.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class TokenHandler {

    private final String secret;
    private final UserService userService;

    public TokenHandler(String secret, UserService userService) {
        if (secret == null || secret.trim().isEmpty()) {
            throw new IllegalArgumentException("Authentication secrete key is illegal");
        }
        if (userService == null) {
            throw new NullPointerException("UserService is null");
        }
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.userService = userService;
    }

    public  UserDetail parseUserFromToken(String token) {
        String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();

        return userService.loadUserByUsername(username);
    }

    public String createTokenForUser(String username){
        Date now  = new Date();
        Date expiration = new Date(now.getTime() + TimeUnit.HOURS.toMillis(1l));
        return Jwts.builder().setId(UUID.randomUUID().toString()).
                setSubject(username).setIssuedAt(now).
                setExpiration(expiration).signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}
