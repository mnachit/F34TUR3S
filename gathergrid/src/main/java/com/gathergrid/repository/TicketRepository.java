package com.gathergrid.repository;

import com.gathergrid.entities.Response;
import com.gathergrid.entities.Ticket;
import com.gathergrid.factory.DbEntityManagerFactory;
import jakarta.persistence.EntityManager;

public class TicketRepository {
    public Response save(Ticket ticket) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
        em.close();
        return new Response("Ticket Created ",ticket,201);
    }
    public Response update(Ticket ticket) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.merge(ticket);
        em.getTransaction().commit();
        em.close();
        return new Response("Ticket Updated ",ticket,200);
    }
    public Response delete(Ticket ticket) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(ticket) ? ticket : em.merge(ticket));
        em.getTransaction().commit();
        em.close();
        return new Response("Ticket Deleted ",ticket,200);
    }
    public Response findById(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        Ticket ticket = em.find(Ticket.class,id);
        em.getTransaction().commit();
        em.close();
        if (ticket == null) return new Response("No Ticket Found ",ticket,404);
        else return new Response("Ticket Found ",ticket,200);
    }
    public Response findAll() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        java.util.List<Ticket> tickets = em.createQuery("select t from Ticket t",Ticket.class).getResultList();
        em.getTransaction().commit();
        em.close();
        if (tickets.isEmpty()) return new Response("No Tickets Found ",tickets,404);
        else return new Response("Tickets Found ",tickets,200);
    }
    public Response findByEvent(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        java.util.List<Ticket> tickets = em.createQuery("select t from Ticket t where t.event.id = :id",Ticket.class).setParameter("id",id).getResultList();
        em.getTransaction().commit();
        em.close();
        if (tickets.isEmpty()) return new Response("No Tickets Found ",tickets,404);
        else return new Response("Tickets Found ",tickets,200);
    }

}
