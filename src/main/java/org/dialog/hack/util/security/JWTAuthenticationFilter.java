/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.util.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.dialog.hack.util.ServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    private final TokenAuthenticationService authenticationService;

    public JWTAuthenticationFilter(TokenAuthenticationService authenticationService) {
        if (authenticationService == null) {
            throw new NullPointerException("Token Authentication Services is null");
        }
        this.authenticationService = authenticationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

   /*     Authentication authentication =
                authenticationService.getAuthentication(HttpServletRequest.class.cast(servletRequest));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(servletRequest, servletResponse);
        SecurityContextHolder.getContext().setAuthentication(null);*/

        /*HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String authToken = authenticationService.getTokenFromRequest(httpRequest);*/

        try {
            /*if (authToken != null) {
                String username = tokenAuthenticationService.getUsernameFromToken(authToken);
                JwtUser user = new JwtUser(username, tokenAuthenticationService.getAuthorities(authToken), true, true, true, true, "null");
                PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, null, user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);*/
            Authentication authentication =
                    authenticationService.getAuthentication(HttpServletRequest.class.cast(servletRequest));
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(servletRequest, servletResponse);
            }

            System.out.println(((HttpServletRequest)servletRequest).getRequestURI());
            if (((HttpServletRequest)servletRequest).getRequestURI().contains("attendance/mark")) {
                filterChain.doFilter(servletRequest, servletResponse);
            }

            servletResponse.getWriter().write("Unauthorized. Jwt Token not provided");
            ((HttpServletResponse) servletResponse).setStatus(401);

        } catch (ExpiredJwtException e1) {
            servletResponse.getWriter().write("Unauthorized. Jwt Token Expired");
            ((HttpServletResponse) servletResponse).setStatus(401);

        } catch (ServiceException e2) {
            servletResponse.getWriter().write("Unauthorized.");
            ((HttpServletResponse) servletResponse).setStatus(403);
        }

    }
}
