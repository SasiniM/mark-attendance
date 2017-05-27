package org.dialog.hack.rest.controllers;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.rest.resources.EmployeeAttendanceResource;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.dialog.hack.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sasini on 5/27/17.
 */
@Path("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

@PUT
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createEmployeeAttendance(EmployeeAttendanceResource attendanceResource) {
    boolean isSuccess = attendanceService.saveEmployeeAttendance(attendanceResource);

    if (isSuccess == true)
        return Response.status(200).entity("Transaction successful").build();
    else
        return Response.status(200).entity("Transaction faild").build();

}
}