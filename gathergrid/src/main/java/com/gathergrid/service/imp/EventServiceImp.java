package com.gathergrid.service.imp;

import com.gathergrid.entities.Categorie;
import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.entities.User;
import com.gathergrid.repository.CategorieRepository;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.EventService;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EventServiceImp implements EventService {
    private final CategorieRepository categorieRepository;
    private final UserServiceImp userServiceImp;
    public EventRespository eventRespository;

    public EventServiceImp(EventRespository eventRespository) {
        this.eventRespository = eventRespository;
        this.categorieRepository = new CategorieRepository();
        this.userServiceImp = new UserServiceImp();
    }

    @Override
    public Response getEvents() {
        List<Event> events = eventRespository.findAll();
        if (events.isEmpty()) {
            return new Response("No Events Found", 404);
        } else {
            return new Response("Events Found", events, 200);
        }
    }

    @Override
    public Response getEvent(Long id) {
        Event event = eventRespository.findById(id);
        if (event == null) {
            return new Response("No Event Found", 404);
        } else {
            return new Response("Event Found", event, 200);
        }
    }

    @Override
    public Response SearchEvents(int page, String searchTerm) {
        int eventsPerPage = 1;
        int offset = (page - 1) * eventsPerPage;
        List<Event> events;
        Long totalEvents;
        if (searchTerm != null) {
            events = eventRespository.searchEvents(offset, eventsPerPage, searchTerm);
            totalEvents = (Long) eventRespository.searchEventsCount(searchTerm);
        } else {
            events = eventRespository.findByPagination(offset, eventsPerPage);
            totalEvents = (Long) eventRespository.findTotalEvents();
        }
        Integer totalPages = (int) Math.ceil((double) totalEvents / eventsPerPage);

        if (events.isEmpty()) {
            return new Response("No Events Found", 404);
        } else {
            return new Response("Events Found", List.of(events, totalPages), 200);
        }
    }

    public Response searchMyEvents(int page, Long userId, String searchTerm) {
//        User user = userServiceImp.getUser(userId);
        int eventsPerPage = 1;
        int offset = (page - 1) * eventsPerPage;
        List<Event> events;
        Long totalEvents;
        if (searchTerm != null) {
            events = eventRespository.searchMyEvents(offset, eventsPerPage, searchTerm, user);
            totalEvents = eventRespository.searchEventsCount(searchTerm);
        } else {
            events = eventRespository.findByPagination(offset, eventsPerPage);
            totalEvents = eventRespository.findTotalEvents();
        }
        Integer totalPages = (int) Math.ceil((double) totalEvents / eventsPerPage);

        if (events.isEmpty()) {
            return new Response("No Events Found", 404);
        } else {
            return new Response("Events Found", List.of(events, totalPages), 200);
        }
    }

    @Override
    public Response createEvent(String title, String description, String location, String date, String time, int vip_price, int regular_price, int basic_price, Long category, Long user) {
        Categorie eventCategory = categorieRepository.findById(category);
        User defaultUser = new User();
//        User user1 = userServiceImp.getUser(user);
        if (eventCategory == null) {
            return new Response("Category Not Found", 404);
        }


        Date formattedDate;
        Time formattedTime;
        try {
            formattedDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(date);
            formattedTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        eventRespository.save(new Event(title, description, location, formattedDate, formattedTime, eventCategory, defaultUser, vip_price, regular_price, basic_price));

        return new Response("Event Created", 200);
    }

    @Override
    public Response deleteEvent(Long id) {
        return null;
    }

}
