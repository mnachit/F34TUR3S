package com.gathergrid.Tests;

import com.gathergrid.entities.Categorie;
import com.gathergrid.entities.Event;
import com.gathergrid.entities.Ticket;
import com.gathergrid.entities.User;
import com.gathergrid.factory.DbEntityManagerFactory;
import com.gathergrid.repository.CategorieRepository;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.repository.TicketRepository;
import com.gathergrid.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.sql.Date;

public class TestingRepositories {
    public static void main(String[] args) {
        EventRespository eventRespository = new EventRespository();
        CategorieRepository categorieRepository = new CategorieRepository();
        testCategorieRepository(categorieRepository);










    }
    public static void testEventRespository(EventRespository eventRespository){
        Event event = new Event("Event1","Event1 Description","Event1 Location",new Date(2021,10,10),new java.sql.Time(10,10,10),100,200,300);
        eventRespository.save(event);
        eventRespository.update(event);
        eventRespository.delete(event);
        eventRespository.findById(1L);
        eventRespository.findAll();
    }
    public static void testCategorieRepository(CategorieRepository categorieRepository){
        Categorie categorie = new Categorie("Categorie1","Categorie1 Description");
        categorieRepository.save(categorie);
        categorie = (Categorie) categorieRepository.findById(6L).getData();
        categorie.setName("Categorie1 Updated");
        categorieRepository.update(categorie);
        categorieRepository.findAll();
        categorieRepository.delete(categorie);

    }
    public static void testTicketRepository(TicketRepository ticketRepository){
        UserRepository userRepository = new UserRepository();
        EventRespository eventRespository = new EventRespository();

//        User newUser = new User("Saad", "Meddiche", "Saadoun", "saadmeddiche2004201@gmail.com", "22");
//        EntityManager entityManager = DbEntityManagerFactory.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(newUser);
//        entityManager.getTransaction().commit();
//        entityManager.close();

        EntityManager em = DbEntityManagerFactory.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class,1L);
        em.getTransaction().commit();
        em.close();
        Event event =(Event) eventRespository.findById(1L).getData();

        Ticket ticket = new Ticket(new Date(2021,10,10),user,event);
        ticketRepository.save(ticket);
//        ticket.setDate_of_reservation(new Date(2021,10,11));
//        ticketRepository.update(ticket);
//        ticketRepository.findById(1L);
//        ticketRepository.findAll();
//        ticketRepository.findByEvent(4L);
        ticket.setId(11L);
        ticketRepository.delete(ticket);

    }

}
