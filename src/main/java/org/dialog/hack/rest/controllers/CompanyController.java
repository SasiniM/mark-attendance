package org.dialog.hack.rest.controllers;

import org.dialog.hack.rest.resources.CompanyResource;
import org.dialog.hack.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sasini on 5/27/17.
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

        if (isSuccess == true) {
            return Response.status(200).entity("Transaction successful").build();
        }
        else {
            return Response.status(200).entity("Transaction failed").build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCompany(@PathParam("id") Long id) {
        boolean isSuccess = companyService.deleteCompany(id);

        if (isSuccess == true){
            return Response.status(200).entity("Transaction successful").build();
        }
        else {
            return Response.status(200).entity("Transaction failed").build();
        }
    }

    @GET
    @Path("/list/{pageNo}/{pageSize}/{sortDir}/{sortCol}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEmployeeSupervisor(@PathParam("pageNo") int pageNo,@PathParam("pageSize") int pageSize,
                                           @PathParam("sortDir") String sortDir,@PathParam("sortCol") String sortCol) {
        return Response.status(200).entity(companyService.listCompanies(pageNo, pageSize, sortDir,
                sortCol)).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSupervisor(){

        return Response.status(200).entity(companyService.getCompanies()).build();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEmployeeByCompany(@PathParam("id") Long id){
        return  Response.status(200).entity(companyService.listEmployeeByCompany(id)).build();
    }
}
