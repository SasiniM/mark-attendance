package org.dialog.hack.rest.controllers;

import org.dialog.hack.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sasini on 5/27/17.
 */
@Path("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GET
    @Path("/{year}/{month}/{firstname}/{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeAttendances(@PathParam("year") String year, @PathParam("month") String month, @PathParam("firstname") String firstName, @PathParam("lastname") String lastName) {
        return Response.status(200).entity(attendanceService.getEmployeeAttendances(year, month, firstName, lastName)).build();
    }

    @GET
    @Path("/mark/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployeeAttendance(@PathParam("username") String username) {
        boolean isSuccess = attendanceService.saveEmployeeAttendance(username);

        if (isSuccess == true) {
            return Response.status(200).entity("Transaction successful").build();
        }
        else {
            return Response.status(200).entity("Transaction faild").build();
        }

    }
}
