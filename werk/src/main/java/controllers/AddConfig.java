package controllers;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AddConfig {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Configuration conf = new Configuration();
        Configuration conf1 = new Configuration();
        Configuration conf2 = new Configuration();
        Configuration conf3 = new Configuration();

        Application app = new Application();
        Application app1 = new Application();
        Application app2 = new Application();

        Device dev = new Device();
        Device dev1 = new Device();
        Device dev2 = new Device();

        User user = new User();

        Platform pf = new Platform();
        Platform pf1 = new Platform();

        QRCode qr = new QRCode();
        QRCode qr1 = new QRCode();
        QRCode qr2 = new QRCode();
        QRCode qr3 = new QRCode();

        List<Application> apps= new ArrayList<>();
        List<Application> apps1= new ArrayList<>();
        List<Configuration> configs = new ArrayList<>();
        List<Configuration> configs1 = new ArrayList<>();
        List<Device> devices = new ArrayList<>();
        List<Platform> platforms = new ArrayList<>();
        List<User> users = new ArrayList<>();

        apps.add(app);
        apps1.add(app1);
        apps1.add(app2);

        configs.add(conf);
        configs.add(conf1);
        configs1.add(conf2);
        configs1.add(conf3);

        devices.add(dev);
        devices.add(dev1);
        devices.add(dev2);


        platforms.add(pf);
        platforms.add(pf1);
        users.add(user);

        user.setPlatforms(platforms);
        user.setPassword("password");
        user.setUserName("bernd");

        qr.setSecretKey(273930);
        qr.setConfiguration(conf);
        qr.setUrl("www.github.com");

        qr1.setSecretKey(192233);
        qr1.setConfiguration(conf1);
        qr1.setUrl("www.facebook.com");

        qr2.setSecretKey(187534);
        qr2.setConfiguration(conf2);
        qr2.setUrl("www.youtube.com");

        qr3.setSecretKey(123273);
        qr3.setConfiguration(conf3);
        qr3.setUrl("www.twitter.com");


        pf.setName("EVA");
        pf.setApplications(apps);
        pf.setUsers(users);

        pf1.setName("PXL");
        pf1.setApplications(apps1);
        pf1.setUsers(users);

      //  conf.setPlatform(pf);
        conf.setAmtDevicesPermitted(3);
        conf.setApplication(app);
        conf.setDevices(devices);
        conf.setQrCode(qr);

        // conf 1

        //conf1.setPlatform(pf1);
        conf1.setAmtDevicesPermitted(3);
        conf1.setApplication(app1);
        conf1.setDevices(devices);
        conf1.setQrCode(qr1);

        // conf 2

      //  conf2.setPlatform(pf1);
        conf2.setAmtDevicesPermitted(3);
        conf2.setApplication(app2);
        conf2.setDevices(devices);
        conf2.setQrCode(qr2);

        // conf 3

      //  conf3.setPlatform(pf1);
        conf3.setAmtDevicesPermitted(4);
        conf3.setApplication(app2);
        conf3.setDevices(devices);
        conf3.setQrCode(qr3);

        dev.setBrand("Android");
        dev.setConfigurations(configs);
        dev.setModel("S8");

        dev1.setBrand("Apple");
        dev1.setConfigurations(configs1);
        dev1.setModel("iPhone 8");

        dev2.setBrand("Android");
        dev2.setConfigurations(configs1);
        dev2.setModel("Galaxy s2");

        app.setApplicationName("Waterberkeningsapplicatie");
        app.setConfigurations(configs);
        app.setPlatform(pf);

        app1.setApplicationName("Lessenrooster applicatie");
        app1.setConfigurations(configs);
        app1.setPlatform(pf1);

        app2.setApplicationName("Studie applicatie");
        app2.setConfigurations(configs);
        app2.setPlatform(pf1);


        em.persist(app);
        em.persist(app1);
        em.persist(app2);
        em.persist(dev);
        em.persist(dev1);
        em.persist(dev2);
        em.persist(user);
        em.persist(pf);
        em.persist(pf1);
        em.persist(conf);
        em.persist(conf1);
        em.persist(conf2);
        em.persist(conf3);
        em.persist(qr);
        em.persist(qr1);
        em.persist(qr2);
        em.persist(qr3);
        tx.commit();
        em.close();
        emf.close();

    }

}
