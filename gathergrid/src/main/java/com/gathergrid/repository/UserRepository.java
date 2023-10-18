package com.gathergrid.repository;

import com.gathergrid.entities.User;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public UserRepository() {

        entityManager = DbEntityManagerFactory.getEntityManager();

        transaction = entityManager.getTransaction();
    }

    public void saveUser(User user) {

        transaction.begin();

        entityManager.persist(user);

        transaction.commit();

    }
}
