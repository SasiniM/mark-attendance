package org.dialog.hack.rest.controllers;

import org.dialog.hack.rest.resources.CompanyResource;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.dialog.hack.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author amila karunathilaka.
 */
@Path("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCompany(CompanyResource companyResource) {
        boolean isSuccess = companyService.saveCompany(companyResource);

        if (isSuccess == true)
            return Response.status(200).entity("Transaction successful").build();
        else
            return Response.status(200).entity("Transaction failed").build();

    }
}
