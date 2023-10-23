package com.gathergrid.repository;

import java.util.List;

import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public abstract class BaseRepository<E> {

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    protected BaseRepository() {
        entityManager = DbEntityManagerFactory.getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void save(E entity) {
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public void update(E entity) {

        transaction.begin();

        entityManager.merge(entity);

        transaction.commit();

    }

    public List<E> fetchAll(Class<E> entityClass) {

        transaction.begin();

        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";

        TypedQuery<E> query = entityManager.createQuery(jpql, entityClass);

        List<E> entities = query.getResultList();

        transaction.commit();

        return entities;
    }

    public E findBy(Class<E> entityClass, String fieldName, Object value) {

        transaction.begin();

        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value";
        TypedQuery<E> query = entityManager.createQuery(jpql, entityClass);
        query.setParameter("value", value);

        E entity = query.getSingleResult();

        transaction.commit();

        return entity;
    }

    protected boolean existsByField(Class<E> entityClass, String fieldName, Object value) {

        transaction.begin();

        String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value";

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        query.setParameter("value", value);

        Boolean result = query.getSingleResult() > 0;

        transaction.commit();

        return result;
    }

}
