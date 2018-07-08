package controllers;

import entities.Application;
import entities.Configuration;
import entities.Platform;
import repositories.PlatformRepository;

;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;

@Path("/platform")
public class PlatformController {

    private PlatformRepository platformRepository;

    public PlatformController( ){
        platformRepository = new PlatformRepository();
    }

    @Path("/hello")
    @GET
    public String sayHello() {
        return "HELLO";
    }


    @Path("/all")
    @GET
    @Produces("application/json")
    public List<Platform> getAllPlatforms(){
        return platformRepository.getAllPlatforms();
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public Platform getPlatformById(@PathParam("id") int id){
        return platformRepository.getPlatformById(id);
    }


    @Path("/{id}/applications")
    @GET
    @Produces("application/json")
    public Collection<Application> getAllApplicationsFromPlatform(@PathParam("id") int id){
       return platformRepository.getAllApplicationsFromPlatform(id);
    }
}
