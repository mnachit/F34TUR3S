package com.gathergrid.service;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;

import java.util.List;

public interface EventService {

    public  Response getEvents();
    public  Response getEvent(Long id);
    public  Response SearchEvents(int page,String searchTerm);
}
