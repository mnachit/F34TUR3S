package com.gathergrid.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String Firstname;
    @Setter
    @Getter
    private String Lastname;

}
