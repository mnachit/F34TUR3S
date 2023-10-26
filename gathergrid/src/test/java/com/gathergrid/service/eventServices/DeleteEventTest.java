package com.gathergrid.service.eventServices;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.User;
import com.gathergrid.repository.CategorieRepository;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.repository.UserRepository;
import com.gathergrid.service.EventService;
import com.gathergrid.service.EventServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteEventTest {
    EventRespository eventRespository;
    UserRepository userRepository;
    EventService eventService;
    CategorieRepository categorieRepository;
    @BeforeEach
    public void setUp() {
        eventRespository = Mockito.mock(EventRespository.class);
        userRepository = Mockito.mock(UserRepository.class);
        categorieRepository = Mockito.mock(CategorieRepository.class);
        eventService = new EventServiceImp(eventRespository, categorieRepository, userRepository);
    }
    @Test
    public void shouldVerifyEventIdIsNotNull() {
        Mockito.when(eventRespository.findById(1L)).thenReturn(null);
        Mockito.doNothing().when(eventRespository).delete(new Event());
        Mockito.when(userRepository.findById(1L)).thenReturn(new User());
        // Assert
        assertEquals("Event Id is Empty", eventService.deleteEvent(null, 1L).getMessage(), "Event Id is Empty not handled properly");

    }
    @Test
    public void shouldVerifyUserIsNotNull() {
        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).delete(new Event());
        Mockito.when(userRepository.findById(1L)).thenReturn(null);
        // Assert
        assertEquals("User Id is Empty", eventService.deleteEvent(1L, null).getMessage(), "User Id is Empty  not handled properly");

    }
    @Test
    public void shouldVerifyEventIsNotExisting() {
        Mockito.when(eventRespository.findById(1L)).thenReturn(null);
        Mockito.doNothing().when(eventRespository).delete(new Event());
        Mockito.when(userRepository.findById(1L)).thenReturn(new User());
        // Assert
        assertEquals("Event Not Found", eventService.deleteEvent(1L, 1L).getMessage(), "Event is not Existing  not handled properly");
    }
    @Test
    public void shouldVerfiyUserIsNotExisting() {
        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).delete(new Event());
        Mockito.when(userRepository.findById(1L)).thenReturn(null);
        // Assert
        assertEquals("User Not Found", eventService.deleteEvent(1L, 1L).getMessage(), "User is not Existing  not handled properly");
    }

    @Test
    public void shouldVerifytheUserIsTheOwnerOfEvent(){
        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).delete(new Event());
        User user = new User();
        user.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(user);
        // Assert
        assertEquals("You are not allowed to delete this event", eventService.deleteEvent(1L, 1L).getMessage(), "User Is Not the Owner of the Event  not handled properly");
    }
    @Test
    public void shouldDeleteEvent(){

        Mockito.doNothing().when(eventRespository).delete(new Event());
        User user = new User();
        user.setId(1L);
        Event event = new Event();
        event.setUser(user);
        Mockito.when(userRepository.findById(1L)).thenReturn(user);
        Mockito.when(eventRespository.findById(1L)).thenReturn(event);
        // Assert
        assertEquals("Event Deleted", eventService.deleteEvent(1L, 1L).getMessage(), "Event Deleted not handled properly");
    }

}
