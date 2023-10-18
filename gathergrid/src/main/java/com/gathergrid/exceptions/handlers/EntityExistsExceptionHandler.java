package com.gathergrid.exceptions.handlers;

import com.gathergrid.exceptions.implementation.ExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.servlet.http.HttpServletRequest;

public class EntityExistsExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, HttpServletRequest request) {

        EntityExistsException entityExistsException = (EntityExistsException) exception;

        request.setAttribute("errors", entityExistsException.getMessage());

    }

    @Override
    public String getMessage() {
        return "Record Do Not Exist";
    }
}
