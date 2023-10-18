package com.gathergrid.exceptions.factories;

import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.exceptions.handlers.EntityExistsExceptionHandler;
import com.gathergrid.exceptions.handlers.ValidationExceptionHandler;
import com.gathergrid.exceptions.implementation.ExceptionHandler;

import jakarta.persistence.EntityExistsException;

public class ExceptionHandlerFactory {

    public static ExceptionHandler getExceptionHandler(Exception exception) {

        if (exception instanceof ValidationException) {
            return new ValidationExceptionHandler();
        }

        if (exception instanceof EntityExistsException) {
            return new EntityExistsExceptionHandler();
        }

        return null;
    }
}
