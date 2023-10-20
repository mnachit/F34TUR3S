package com.gathergrid.service;

import com.gathergrid.entities.Response;
import com.gathergrid.entities.User;

public interface CommentService {

    public Response addComment(String text, Long event_id, User user);
}
