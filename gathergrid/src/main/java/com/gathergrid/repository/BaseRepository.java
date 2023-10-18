package com.gathergrid.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class BaseRepository {

    public static boolean existsByField(EntityManager entityManager, Class<?> entityClass, String fieldName,
            Object value) {

        String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value";

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        query.setParameter("value", value);

        return query.getSingleResult() > 0;
    }

}
