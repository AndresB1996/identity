package interfaces;

import entities.Configuration;

import java.util.List;

public interface ConfigurationInterface {
    List<Configuration> getAllConfigurations();

    Configuration getConfigurationById(int id);

    List<Configuration> getConfigurationsFromApplication(int id);
}
