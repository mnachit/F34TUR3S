package com.gathergrid.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DbEntityManagerFactory {
    
   private static EntityManagerFactory emf;

    private DbEntityManagerFactory() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = jakarta.persistence.Persistence.createEntityManagerFactory("gathergrid_unit");
            return emf;
        }
        return emf;
    }

    public static void closeEntityManagerFactory(){
        if(emf!=null){
            emf.close();
            emf = null;
        }
    }
    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }


}
