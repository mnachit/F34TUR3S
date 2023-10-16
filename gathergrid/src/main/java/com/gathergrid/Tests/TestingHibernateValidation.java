package com.gathergrid.Tests;

import com.gathergrid.entities.User;
import com.gathergrid.factory.DbEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TestingHibernateValidation {

    public static void main(String[] args) {

        EntityManager entityManager = DbEntityManagerFactory.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        User newUser = new User("Saad", "Meddiche", "Saadoun", "saadmeddiche2004201@gmail.com", "22");

        System.out.println("User Name: " + newUser.getName().getFirstName() + " " + newUser.getName().getLastName());
        System.out.println("User Email: " + newUser.getEmail().getAddressEmail());
        System.out.println("User Password: " + newUser.getPassword().getPassword());

        entityManager.persist(newUser);

        transaction.commit();

        entityManager.close();
    }
}
