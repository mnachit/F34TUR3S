package com.gathergrid.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.Currency;
import java.util.List;

@Entity
@Setter@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;
    private Date date;
    private Time time;
    @ManyToOne
    private Categorie categorie;
    private int vip_price;
    private int regular_price;
    private int basic_price;
    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

    public Event(String name, String description, String location, Date date, Time time, Categorie categorie, int vip_price, int regular_price, int basic_price, List<Comment> comments) {
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

    public Event(String name, String description, String location, Date date, Time time, Categorie categorie, int vip_price, int regular_price, int basic_price) {
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

    public Event(String name, String description, String location, Date date, Time time, int vip_price, int regular_price, int basic_price) {
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
