package com.gathergrid.repository;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
        Event event = em.find(Event.class, id);
        em.getTransaction().commit();
        return event;
    }

    public List<Event> findAll() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        List<Event> events = em.createQuery("select e from Event e", Event.class).getResultList();
        return events;
    }

    public List<Event> findByPagination(int offset, int eventsPerPage) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        List<Event> events = em.createQuery("select e from Event e", Event.class).setFirstResult(offset)
                .setMaxResults(eventsPerPage).getResultList();
        t.commit();
        return events;
    }

    public Long findTotalEvents() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        Long count = em.createQuery("select count(e) from Event e", Long.class).getSingleResult();
        return count;
    }

    public List<Event> findAllByCategorie(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        List<Event> events = em.createQuery("select e from Event e where e.categorie.id = :id", Event.class)
                .setParameter("id", id).getResultList();
        em.getTransaction().commit();
        return events;
    }

    public List<Event> searchEvents(int offset, int eventsPerPage, String term) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        List<Event> events = em.createQuery(
                "select e from Event e where e.name like :term or e.description like :term or e.categorie.name like :term",
                Event.class).setParameter("term", "%" + term + "%").setFirstResult(offset).setMaxResults(eventsPerPage)
                .getResultList();
        return events;
    }

    public Long searchEventsCount(String term) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        Long count = em.createQuery(
                "select count(e) from Event e where e.name like :term or e.description like :term or e.categorie.name like :term",
                Long.class).setParameter("term", "%" + term + "%").getSingleResult();
        return count;
    }
}
