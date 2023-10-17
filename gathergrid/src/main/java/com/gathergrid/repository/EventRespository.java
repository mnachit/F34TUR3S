package com.gathergrid.repository;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;

import java.util.List;


public class EventRespository {
   public void save(Event event) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
   }
   public void update(Event event) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.merge(event);
        em.getTransaction().commit();
   }
    public void delete(Event event) {
          EntityManager em = DbEntityManagerFactory.getEntityManager();
          em.getTransaction().begin();
          em.remove(em.contains(event) ? event : em.merge(event));
          em.getTransaction().commit();
    }
    public Event findById(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        Event event = em.find(Event.class,id);
        em.getTransaction().commit();
        return event;
    }
    public List<Event> findAll() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e",Event.class).getResultList();
        em.getTransaction().commit();
        return events;
    }
    public List<Event> findAllByCategorie(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e where e.categorie.id = :id",Event.class).setParameter("id",id).getResultList();
        em.getTransaction().commit();
        return events;
    }
    public List<Event> searchEvents(String term){
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e where e.name like :term or e.description like :term",Event.class).setParameter("term","%"+term+"%").getResultList();
        em.getTransaction().commit();
        return events;
    }
}
