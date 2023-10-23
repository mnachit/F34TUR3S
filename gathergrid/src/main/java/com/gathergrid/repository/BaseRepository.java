package com.gathergrid.repository;

import java.util.List;

import com.gathergrid.entities.Ticket;
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

    public List<E> fetchAll(Class<E> entityClass) {

        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";

        TypedQuery<E> query = entityManager.createQuery(jpql, entityClass);

        return query.getResultList();
    }

    public E findBy(Class<E> entityClass, String fieldName, Object value) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value";
        TypedQuery<E> query = entityManager.createQuery(jpql, entityClass);
        query.setParameter("value", value);
        return query.getSingleResult();
    }

    protected boolean existsByField(Class<E> entityClass, String fieldName, Object value) {

        String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value";

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        query.setParameter("value", value);

        return query.getSingleResult() > 0;
    }

}
