package com.gathergrid.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.Currency;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Setter@Getter
    private Long id;
    @Setter@Getter
    private String name;
    @Setter@Getter
    private String description;
    @Setter@Getter
    private String location;
    @Setter@Getter
    private Date date;
    @Setter@Getter
    private Time time;
    @ManyToOne
    @Setter@Getter
    private Categorie categorie;
    @Setter@Getter
    private Currency vip_price;
    @Setter@Getter
    private Currency regular_price;
    @Setter@Getter
    private Currency basic_price;
    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

    public Event(String name, String description, String location, Date date, Time time, Categorie categorie, Currency vip_price, Currency regular_price, Currency basic_price, List<Comment> comments) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.categorie = categorie;
        this.vip_price = vip_price;
        this.regular_price = regular_price;
        this.basic_price = basic_price;
        this.comments = comments;
    }

    public Event(String name, String description, String location, Date date, Time time, Categorie categorie, Currency vip_price, Currency regular_price, Currency basic_price) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.categorie = categorie;
        this.vip_price = vip_price;
        this.regular_price = regular_price;
        this.basic_price = basic_price;
    }

    public Event(String name, String description, String location, Date date, Time time, Currency vip_price, Currency regular_price, Currency basic_price) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.vip_price = vip_price;
        this.regular_price = regular_price;
        this.basic_price = basic_price;
    }

    public Event() {
    }
}
