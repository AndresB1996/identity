package repositories;

import entities.Application;
import entities.Platform;
import interfaces.PlatformInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class PlatformRepository  implements PlatformInterface {


    @Override
    public List<Platform> getAllPlatforms() {
        List<Platform> platforms;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select p from  Platform as p ",Platform.class);
        platforms =(List<Platform>) query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return platforms;
    }

    @Override
    public List<Application> getAllApplicationsFromPlatform(int id) {
        List<Application> applications;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select a from  Application a WHERE a.platform.id = ?1");
        query.setParameter(1,id);
        applications =(List<Application>) query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return applications;
    }

    @Override
    public Platform getPlatformById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Platform p = em.find(Platform.class,id);
        tx.commit();
        em.close();
        emf.close();
        return p;
    }
}
