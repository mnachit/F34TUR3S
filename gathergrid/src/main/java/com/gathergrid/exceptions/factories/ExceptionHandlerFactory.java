package com.gathergrid.exceptions.factories;

import com.gathergrid.exceptions.costums.AlreadyExistsException;
import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.exceptions.handlers.AlreadyExistsExceptionHandler;
import com.gathergrid.exceptions.handlers.ValidationExceptionHandler;
import com.gathergrid.exceptions.implementation.ExceptionHandler;

public class ExceptionHandlerFactory {

    public static ExceptionHandler getExceptionHandler(Exception exception) {

        if (exception instanceof ValidationException) {
            return new ValidationExceptionHandler();
        }

        if (exception instanceof AlreadyExistsException) {
            return new AlreadyExistsExceptionHandler();
        }

        return null;
    }
}
