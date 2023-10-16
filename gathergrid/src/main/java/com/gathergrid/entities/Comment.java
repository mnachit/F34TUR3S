package com.gathergrid.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Setter @Getter
    private Long id;
    @Setter@Getter
    private String text;

    @ManyToOne
    @Setter@Getter
    private User user;
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @Getter@Setter
    private Event event;
    @Setter@Getter
    private Date date;

    public Comment(String text, User user, Event event, Date date) {
        this.text = text;
        this.user = user;
        this.event = event;
        this.date = date;
    }
    public Comment() {
    }
}
