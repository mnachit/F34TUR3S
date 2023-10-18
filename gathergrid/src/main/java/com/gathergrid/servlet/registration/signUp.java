package com.gathergrid.servlet.registration;

import java.io.IOException;
import java.util.List;

import com.gathergrid.entities.User;
import com.gathergrid.exceptions.factories.ExceptionHandlerFactory;
import com.gathergrid.exceptions.implementation.ExceptionHandler;
import com.gathergrid.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class signUp extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(firstName, lastName, userName, email, password);

        try {

            userService.registerUser(user);

            response.sendRedirect("successRegistration.jsp");

        } catch (Exception e) {

            ExceptionHandler exceptionHandler = ExceptionHandlerFactory.getExceptionHandler(e);

            exceptionHandler.handleException(e, request);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/failedRegistration.jsp");

            dispatcher.forward(request, response);

        }
    }
}
