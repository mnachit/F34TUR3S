package com.gathergrid.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DbEntityManagerFactory {
    
   private static EntityManagerFactory emf;

   private static EntityManager em;

    private DbEntityManagerFactory() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = jakarta.persistence.Persistence.createEntityManagerFactory("gathergrid_unit");
            return emf;
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        if(em==null){
            em = getEntityManagerFactory().createEntityManager();
            return em;
        }
        return em;
    }
    public static void closeEntityManagerFactory(){
        if(emf!=null){
            emf.close();
        }
    }

    public  static void closeEntityManager(){
        if(em!=null){
            em.close();
        }
    }
}
