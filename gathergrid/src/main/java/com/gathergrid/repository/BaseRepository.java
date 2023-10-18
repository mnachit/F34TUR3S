package com.gathergrid.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class BaseRepository {

    public static boolean existsByField(EntityManager entityManager, Class<?> entityClass, String fieldName,
            String value) {
                
        String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :"
                + fieldName;

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        query.setParameter(fieldName, value);

        return query.getSingleResult() > 0;
    }
}
