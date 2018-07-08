package interfaces;

import entities.Application;
import entities.Platform;

import java.util.List;

public interface ApplicationInterface {

    List<Application> getAllApplications();
    Platform getApplicationPlatform(int id);
}
