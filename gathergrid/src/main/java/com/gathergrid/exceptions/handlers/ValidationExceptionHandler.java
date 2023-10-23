package com.gathergrid.exceptions.handlers;

import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.exceptions.interfaces.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

public class ValidationExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, HttpServletRequest request) {

        ValidationException validationException = (ValidationException) exception;

        request.setAttribute("errors", validationException.getErrors());

    }

    @Override
    public String getMessage() {
        return "Some Thing Went Wrong With The Validation";
    }

}
