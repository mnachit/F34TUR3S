package com.gathergrid.Tests;

import com.gathergrid.entities.Categorie;
import com.gathergrid.entities.Event;
import com.gathergrid.repository.CategorieRepository;
import com.gathergrid.repository.EventRespository;

import java.sql.Date;

public class TestingRepositories {
    public static void main(String[] args) {
        EventRespository eventRespository = new EventRespository();
        CategorieRepository categorieRepository = new CategorieRepository();
//        inserting the categorie
        Categorie categorie = new Categorie("Music","Music Events");
        categorieRepository.save(categorie);
//        inserting the event
        Event event = new Event("Music Event","Music Event","Tunis",new Date(2021,10,10),new java.sql.Time(10,10,10),categorie,10,10,10);
        eventRespository.save(event);
//        find all events
        System.out.println(eventRespository.findAll());



    }
}
