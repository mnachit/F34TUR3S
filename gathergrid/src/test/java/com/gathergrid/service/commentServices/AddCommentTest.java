package com.gathergrid.service.commentServices;

import com.gathergrid.entities.Comment;
import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.entities.User;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.CommentService;
import com.gathergrid.service.CommentServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommentTest {
    EventRespository eventRespository;
    CommentService commentService;
    @BeforeEach
    public void setUp() {
        eventRespository = Mockito.mock(EventRespository.class);
        commentService = new CommentServiceImp(eventRespository);
    }
    @Test
    public void shouldVerifyCommentTextIsNotBlank() {

        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).update(new Event());
        // Assert
        assertEquals("Comment Text is Empty", commentService.addComment(null, null, null).getMessage(), "Comment Text is Empty not handled properly");
    }
    @Test
    public void shouldVerifyCommentEventId(){
        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).update(new Event());
        // Assert
        assertEquals("Event Id is Empty", commentService.addComment("test", null, null).getMessage(), "Event Id is Empty not handled properly");

    }
    @Test
    public void shouldVerifyCommentUser(){
        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).update(new Event());
        // Assert
        assertEquals("User is Empty or Id is Empty", commentService.addComment("test", 1L, null).getMessage(), "User is not Existing  not handled properly");
    }
    @Test
    public void shouldUpdateEventAndInsertComment(){
        Mockito.when(eventRespository.findById(1L)).thenReturn(new Event());
        Mockito.doNothing().when(eventRespository).update(new Event());
        User user = new User();
        user.setId(1L);
        // Assert
        assertEquals("Comment Added", commentService.addComment("test", 1L, user).getMessage(), "Comment Added not handled properly");
    }
}