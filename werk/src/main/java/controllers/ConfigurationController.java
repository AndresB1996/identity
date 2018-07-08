package controllers;


import entities.Configuration;
import repositories.ConfigurationRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/configuration")
public class ConfigurationController {


    private ConfigurationRepository configurationRepository;

    public ConfigurationController() {
        configurationRepository = new ConfigurationRepository();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Configuration> getAllConfigurations(){
        return configurationRepository.getAllConfigurations(); }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Configuration getConfigurationById(@PathParam("id") int id){
        return configurationRepository.getConfigurationById(id); }

    @GET
    @Path("/applications/{id}")
    @Produces("application/json")
    public List<Configuration> getConfigurationsFromAplication(@PathParam("id") int id){
        return configurationRepository.getConfigurationsFromApplication(id); }

}
