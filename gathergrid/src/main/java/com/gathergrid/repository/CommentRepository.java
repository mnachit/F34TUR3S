package com.gathergrid.repository;

import com.gathergrid.entities.Comment;
import com.gathergrid.entities.Response;
import com.gathergrid.factory.DbEntityManagerFactory;
import jakarta.persistence.EntityManager;

public class CommentRepository {
    public Response save(Comment comment) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.persist(comment);
        em.getTransaction().commit();
        em.close();
        return new Response("Comment Created ",comment,201);
    }
    public Response update(Comment comment) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.merge(comment);
        em.getTransaction().commit();
        em.close();
        return new Response("Comment Updated ",comment,200);
    }
    public Response delete(Comment comment) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.remove(comment);
        em.getTransaction().commit();
        em.close();
        return new Response("Comment Deleted ",comment,200);
    }
    public Response findById(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        Comment comment = em.find(Comment.class,id);
        em.getTransaction().commit();
        em.close();
        if (comment == null) return new Response("No Comment Found ",comment,404);
        else return new Response("Comment Found ",comment,200);
    }
    public Response findAll() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        java.util.List<Comment> comments = em.createQuery("select c from Comment c",Comment.class).getResultList();
        em.getTransaction().commit();
        em.close();
        if (comments.isEmpty()) return new Response("No Comments Found ",comments,404);
        else return new Response("Comments Found ",comments,200);
    }
    public Response findAllByEvent(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        java.util.List<Comment> comments = em.createQuery("select c from Comment c where c.event.id = :id",Comment.class).setParameter("id",id).getResultList();
        em.getTransaction().commit();
        em.close();
        if(comments.isEmpty()) return new Response("No Comments Found ",comments,404);
        else return new Response("Comments Found ",comments,200);
    }
}
