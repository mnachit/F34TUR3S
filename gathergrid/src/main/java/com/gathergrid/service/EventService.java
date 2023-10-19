package com.gathergrid.service;

import com.gathergrid.entities.Response;

public interface EventService {

    public  Response getEvents();
    public  Response getEvent(Long id);
    public  Response SearchEvents(int page,String searchTerm);
    public Response searchMyEvents(int page, Long userId, String searchTerm);
    public Response createEvent(String title, String description, String location, String date, String time, int vip_price, int regular_price, int basic_price, Long category, Long user);
    public Response deleteEvent(Long id);

}
