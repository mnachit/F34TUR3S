package com.gathergrid.exceptions.handlers;

import com.gathergrid.exceptions.costums.AlreadyExistsException;
import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.exceptions.implementation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

public class AlreadyExistsExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, HttpServletRequest request) {

        AlreadyExistsException alreadyExistsExceptionHandler = (AlreadyExistsException) exception;

        request.setAttribute("errors", alreadyExistsExceptionHandler.getError());

    }

    @Override
    public String getMessage() {
        return "This Record Already Exists";
    }

}
