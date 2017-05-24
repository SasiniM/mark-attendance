package org.dialog.hack.rest.controllers;

import org.dialog.hack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
