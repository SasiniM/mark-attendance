package org.dialog.hack.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sasini on 5/20/17.
 */
@Path("/test")
public class testController {
    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmployee(){
        return Response.status(200).entity("hello").build();
    }

    @GET
    @Path("/remove")
    @Produces(MediaType.TEXT_PLAIN)
    public  Response removeEmployee(){
        return Response.status(200).entity("Remove Employee").build();
    }
}
