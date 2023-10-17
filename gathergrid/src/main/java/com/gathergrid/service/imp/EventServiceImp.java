package com.gathergrid.service.imp;

import com.gathergrid.entities.Response;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.EventService;

public class EventServiceImp implements EventService {
    public EventRespository eventRespository ;
    public EventServiceImp(EventRespository eventRespository) {
        this.eventRespository = eventRespository;
    }
    @Override
    public  Response getEvents() {
         return  null;
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
