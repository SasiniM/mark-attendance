package org.dialog.hack.rest.controllers;

import org.dialog.hack.model.EmployeeSupervisor;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.dialog.hack.rest.resources.EmployeeSupervisorResource;
import org.dialog.hack.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sasini on 5/27/17.
 */
@Path("/supervisor")
public class SupervisorController {
    @Autowired
    SupervisorService supervisorService;

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployeeSupervisor(EmployeeSupervisorResource supervisorResource) {
        boolean isSuccess = supervisorService.saveEmployeeSupervisor(supervisorResource);

        if (isSuccess == true)
            return Response.status(200).entity("Transaction successful").build();
        else
            return Response.status(200).entity("Transaction faild").build();

    }
}
