package com.gathergrid.entities;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Name name;

    private Email email;

    private Password password;

    public User() {
    }

    public User(Long id, Name name, Email email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

@Embeddable
class Name {

    @NotEmpty(message = "Please enter your First Name")
    private String firstName;

    @NotEmpty(message = "Please enter your Last Name")
    private String lastName;

    @NotEmpty(message = "Please enter your User Name")
    private String userName;

    public Name() {
    }

    public Name(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

@Embeddable
class Email {

    @NotEmpty(message = "Please enter your Email")
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

@Embeddable
class Password {

    @NotEmpty(message = "Please enter your Password")
    private String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}