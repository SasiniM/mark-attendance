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
        return Response.status(200).entity(employeeService.getEmployeeProfiles(firstName, lastName)).build();
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployeeProfile(EmployeeProfileResource profileResource) {
        boolean isSuccess = employeeService.saveEmployeeProfile(profileResource);

        if (isSuccess == true)
            return Response.status(200).entity("Transaction successful").build();
        else
            return Response.status(200).entity("Transaction failed").build();

    }

    @DELETE
    @Path("/remove/{empStaffNo}")
    public Response removeEmployeeProfile(@PathParam("empStaffNo") String empStaffNo){
        Boolean isSuccess = employeeService.removeEmployeeProfile(empStaffNo);

        if(isSuccess == true){
            return Response.status(200).entity("Employee deleted successfully").build();
        }
        else
            return Response.status(200).entity("Unable to delete employee").build();
    }

}
