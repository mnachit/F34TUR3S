package com.gathergrid.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Name name;

    private AdressEmail email;

    private Password password;

    public User() {
    }

    public User(Long id, Name name, AdressEmail email, Password password) {
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
    @Pattern(regexp = "^[^\\s]*$", message = "No Space Allowed")
    private String firstName;

    @NotEmpty(message = "Please enter your Last Name")
    @Pattern(regexp = "^[^\\s]*$", message = "No Space Allowed")

    private String lastName;

    @NotEmpty(message = "Please enter your User Name")
    @Pattern(regexp = "^[^\\s]*$", message = "No Space Allowed")
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
class AdressEmail {

    @NotEmpty(message = "Please enter your Email")
    @Email(message = "Invalid email format")
    private String adressEmail;

    public AdressEmail() {
    }

    public AdressEmail(String adressEmail) {
        this.adressEmail = adressEmail;
    }

    public String getAdressEmail() {
        return adressEmail;
    }

    public void setAdressEmail(String adressEmail) {
        this.adressEmail = adressEmail;
    }
}

@Embeddable
class Password {

    @NotEmpty(message = "Please enter your Password")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Pattern(regexp = "^[^\\s]*$", message = "No Space Allowed")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character")
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
