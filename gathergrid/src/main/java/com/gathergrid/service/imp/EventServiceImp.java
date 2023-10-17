package com.gathergrid.service.imp;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.EventService;

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
    public  Response SearchEvents(String searchTerm) {
        return null;
    }


}
