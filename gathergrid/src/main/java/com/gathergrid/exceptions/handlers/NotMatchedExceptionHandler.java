package com.gathergrid.exceptions.handlers;

import java.util.List;

import com.gathergrid.exceptions.costums.NotMatchedException;
import com.gathergrid.exceptions.implementation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

public class NotMatchedExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, HttpServletRequest request) {

        NotMatchedException notMatchedException = (NotMatchedException) exception;

        request.setAttribute("errors", List.of(notMatchedException.getError()));

    }

    @Override
    public String getMessage() {
        return "This Record Already Exists";
    }
}
