package com.gathergrid.service;

import com.gathergrid.entities.Response;

public interface EventService {

    public  Response getEvents();
    public  Response getEvent(Long id);
    public  Response SearchEvents(String searchTerm);
}
