package interfaces;

import entities.Application;
import entities.Platform;

import java.util.Collection;
import java.util.List;

public interface PlatformInterface  {

    List<Platform> getAllPlatforms();
    List<Application> getAllApplicationsFromPlatform(int id);
    Platform getPlatformById(int id);

}
