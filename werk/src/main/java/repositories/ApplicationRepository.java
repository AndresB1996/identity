package repositories;

import entities.Application;
import entities.Platform;
import interfaces.ApplicationInterface;

import javax.persistence.*;
import java.util.List;

public class ApplicationRepository implements ApplicationInterface {


    @Override
    public List<Application> getAllApplications() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        TypedQuery<Application> query = em.createQuery("select p from Application as p", Application.class);
        List<Application> results = query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return results;
    }

    @Override
    public Platform getApplicationPlatform(int id) {
        Platform platform;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select p.platform from Application  as p WHERE p.id =  ?1",Platform.class);
        query.setParameter(1,id);
        platform =(Platform) query.getSingleResult();
        tx.commit();
        em.close();
        emf.close();
        return platform;
    }
}
