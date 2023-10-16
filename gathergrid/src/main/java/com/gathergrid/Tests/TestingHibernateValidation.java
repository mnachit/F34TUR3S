package com.gathergrid.Tests;

import com.gathergrid.entities.User;

public class TestingHibernateValidation {

    public static void main(String[] args) {

        User newUser = new User("Saad", "Meddiche", "Saadoun", "saadmeddiche2004201@gmail.com", "");

        System.out.println("User Name: " + newUser.getName().getFirstName() + " " + newUser.getName().getLastName());
        System.out.println("User Email: " + newUser.getEmail().getAdressEmail());
        System.out.println("User Password: " + newUser.getPassword().getPassword());
    }
}
