package com.gathergrid.repository;

import com.gathergrid.embeddables.AddressEmail;
import com.gathergrid.entities.User;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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

    public boolean existsByEmail(String email) {
        return BaseRepository.existsByField(entityManager, User.class, "email.addressEmail", email);
    }

    public boolean existsByUsername(String username) {
        return BaseRepository.existsByField(entityManager, User.class, "name.userName", username);
    }

}
