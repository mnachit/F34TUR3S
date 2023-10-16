package com.gathergrid.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Setter@Getter
    private Long id;
    @Setter@Getter
    private Date date_of_reservation;
    @ManyToOne
    @Setter@Getter
    private User user;
    @ManyToOne
    @Setter@Getter
    private Event event;

    public Ticket(Date date_of_reservation, User user, Event event) {
        this.date_of_reservation = date_of_reservation;
        this.user = user;
        this.event = event;
    }
    public Ticket() {
    }
}
