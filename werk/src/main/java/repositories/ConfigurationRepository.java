package repositories;

import entities.Application;
import entities.Configuration;
import interfaces.ConfigurationInterface;

import javax.persistence.*;
import java.util.List;

public class ConfigurationRepository implements ConfigurationInterface {


    @Override
    public List<Configuration> getAllConfigurations() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        TypedQuery<Configuration> query = em.createQuery("select p from Configuration as p", Configuration.class);
        List<Configuration> results = query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return results;
    }

    @Override
    public Configuration getConfigurationById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        TypedQuery<Configuration> query = em.createQuery("select p from Configuration as p where p.id = ?1", Configuration.class);
        query.setParameter(1,id);
        Configuration result = query.getSingleResult();
        tx.commit();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public List<Configuration> getConfigurationsFromApplication(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        TypedQuery<Configuration> query = em.createQuery("SELECT t0.id, t0.amtDevicesPermitted, t1.id, t1.applicationName, t2.id, t2.name, t3.configuration.id, t3.secretKey, t3.url " +
                "FROM Configuration t0 LEFT OUTER JOIN Application t1 ON " +
                "t0.application.id = t1.id LEFT OUTER JOIN QRCode t3 ON t0.id = t3.configuration.id LEFT OUTER JOIN Platform t2 ON t1.platform.id = t2.id WHERE (t0.id = ?1)", Configuration.class);
        query.setParameter(1,id);
        List<Configuration> results = query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return results;
    }
}
