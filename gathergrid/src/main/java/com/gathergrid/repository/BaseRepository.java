package com.gathergrid.repository;

import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public abstract class BaseRepository<E> {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    protected BaseRepository() {
        entityManager = DbEntityManagerFactory.getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void save(E entity) {

        transaction.begin();

        entityManager.persist(entity);

        transaction.commit();

    }

    protected boolean existsByField(Class<?> entityClass, String fieldName, Object value) {

        String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value";

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        query.setParameter("value", value);

        return query.getSingleResult() > 0;
    }

}
