package com.gathergrid.service.imp;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.EventService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;

public class EventServiceImp implements EventService {
    public EventRespository eventRespository ;
    public EventServiceImp(EventRespository eventRespository) {
        this.eventRespository = eventRespository;
    }
    @Override
    public  Response getEvents() {
        List<Event> events = eventRespository.findAll();
        if(events.isEmpty()){
            return new Response("No Events Found",404);
        }else{
            return new Response("Events Found",events,200);
        }
    }
    @Override
    public  Response getEvent(Long id) {
        return null;
    }
    @Override
    public  Response SearchEvents(int page,String searchTerm) {
        int eventsPerPage = 1;
        int offset = (page - 1) * eventsPerPage;
        List<Event> events ;
        Long totalEvents;
        if(searchTerm !=null){
            events = eventRespository.searchEvents(offset, eventsPerPage,searchTerm);
            totalEvents = (Long) eventRespository.searchEventsCount(searchTerm);
        }else{
            events = eventRespository.findByPagination(offset, eventsPerPage);
            totalEvents = (Long) eventRespository.findTotalEvents();
        }
        Integer totalPages = (int) Math.ceil((double) totalEvents / eventsPerPage);

        if(events.isEmpty()){
            return new Response("No Events Found",404);
        }else{
            return new Response("Events Found",List.of(events,totalPages),200);
        }
    }


}
