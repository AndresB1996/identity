package controllers;

import entities.Application;
import entities.Platform;
import repositories.ApplicationRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/application")
public class ApplicationController {

    ApplicationRepository applicationRepository;

   public ApplicationController() {
       applicationRepository = new ApplicationRepository();
   }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Application> getAllApplications(){
       return applicationRepository.getAllApplications(); }

    @GET
    @Path("/{id}/platform")
    @Produces("application/json")
    public Platform getPlatformFomApplication(@PathParam("id") int id){
        return applicationRepository.getApplicationPlatform(id); }
}
