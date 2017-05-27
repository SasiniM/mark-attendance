package org.dialog.hack.rest.controllers;

import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.dialog.hack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sasini on 5/24/17.
 */
@Path("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GET
    @Path("/{firstname}/{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeProfiles(@PathParam("firstname") String firstName, @PathParam("lastname") String lastName){
        return Response.status(200).entity(employeeService.getemployeeProfiles(firstName, lastName)).build();
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployeeProfile(EmployeeProfileResource profileResource) {
        return Response.status(200).entity("").build();
    }

}
