package com.gathergrid.factory;

import jakarta.persistence.EntityManagerFactory;

public class DbEntityManagerFactory {
   private static EntityManagerFactory emf;

    private DbEntityManagerFactory() {
    }
    public static EntityManagerFactory getManagerFactory() {
        if(emf == null) {
            emf = jakarta.persistence.Persistence.createEntityManagerFactory("gathergrid_unit");
            return emf;
        }
        return emf;
    }
}
