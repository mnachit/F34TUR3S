package com.gathergrid.repository;

import com.gathergrid.entities.Categorie;
import com.gathergrid.entities.Response;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;

public class CategorieRepository {
    public Response save(Categorie categorie) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(categorie);
        em.getTransaction().commit();
        em.close();
        return new Response("Categorie Created ",categorie,201);
    }
    public Response update(Categorie categorie) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.merge(categorie);
        em.getTransaction().commit();
        em.close();
        return new Response("Categorie Updated ",categorie,200);
    }
    public Response delete(Categorie categorie) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(categorie) ? categorie : em.merge(categorie));
        em.getTransaction().commit();
        em.close();
        return new Response("Categorie Deleted ",categorie,200);
    }
    public Response findById(Long id) {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        Categorie categorie = em.find(Categorie.class,id);
        em.getTransaction().commit();
        em.close();
        if (categorie == null) return new Response("No Categorie Found ",categorie,404);
        else return new Response("Categorie Found ",categorie,200);
    }
    public Response findAll() {
        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        java.util.List<Categorie> categories = em.createQuery("select c from Categorie c",Categorie.class).getResultList();
        em.getTransaction().commit();
        em.close();
        if (categories.isEmpty()) return new Response("No Categories Found ",categories,404);
        else return new Response("Categories Found ",categories,200);
    }


}
