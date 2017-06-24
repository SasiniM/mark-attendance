/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.controllers;

import org.dialog.hack.rest.resources.CustomMessageResource;
import org.dialog.hack.util.ServiceException;

import javax.ws.rs.core.Response;

/**
 * @author Amila Karunathilaka
 */
public abstract class AbstractRestController {



    public Response handleServiceException(ServiceException se) {
        return Response.status(500).entity(new CustomMessageResource(se.getMessage())).build();
    }

    public Response handleServiceException(String customMessage, ServiceException ex){
        return Response.status(500).entity(new CustomMessageResource(customMessage)).build();
    }


}
