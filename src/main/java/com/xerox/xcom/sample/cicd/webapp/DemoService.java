package com.xerox.xcom.sample.cicd.webapp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/demo")
public class DemoService  {

	
    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("pong").build();
    }

}
