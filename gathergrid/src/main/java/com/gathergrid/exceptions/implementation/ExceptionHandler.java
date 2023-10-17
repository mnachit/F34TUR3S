package com.gathergrid.exceptions.implementation;

import jakarta.servlet.http.HttpServletRequest;

public interface ExceptionHandler {

    void handleException(Exception exception, HttpServletRequest request);

    String getMessage();
}
