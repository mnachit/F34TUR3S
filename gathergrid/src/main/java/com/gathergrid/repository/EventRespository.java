package com.gathergrid.repository;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;

import java.util.List;


public class EventRespository {
   public Response save(Event event) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        em.close();
        return new Response("Event Created ",event,201);
   }
   public Response update(Event event) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.merge(event);
        em.getTransaction().commit();
        em.close();
        return new Response("Event Updated ",event,200);
   }
    public Response delete(Event event) {
          EntityManager em = DbEntityManagerFactory.getEntityManager();
            em.getTransaction().begin();
          em.remove(event);
          em.getTransaction().commit();
          em.close();
          return new Response("Event Deleted ",event,200);
    }
    public Response findById(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        Event event = em.find(Event.class,id);
        em.getTransaction().commit();
        em.close();
        if (event == null) return new Response("No Event Found ",event,404);
        else return new Response("Event Found ",event,200);
    }
    public Response findAll() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e",Event.class).getResultList();
        em.getTransaction().commit();
        em.close();
        if (events.isEmpty()) return new Response("No Events Found ",events,404);
        else return new Response("Events Found ",events,200);
    }
    public Response findAllByCategorie(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e where e.categorie.id = :id",Event.class).setParameter("id",id).getResultList();
        em.getTransaction().commit();
        em.close();
        if(events.isEmpty()) return new Response("No Events Found ",events,404);
        else return new Response("Events Found ",events,200);
    }
    public Response searchEvents(String term){
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e where e.name like :term or e.description like :term",Event.class).setParameter("term","%"+term+"%").getResultList();
        em.getTransaction().commit();
        em.close();
        if(events.isEmpty()) return new Response("No Events Found ",events,404);
        else return new Response("Events Found ",events,200);
    }
}
