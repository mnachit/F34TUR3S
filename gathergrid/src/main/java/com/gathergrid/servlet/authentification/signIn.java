package com.gathergrid.servlet.authentification;

import java.io.IOException;
import java.io.PrintWriter;

import com.gathergrid.embeddables.AddressEmail;
import com.gathergrid.embeddables.Password;
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

@WebServlet(name = "signInServlet", urlPatterns = "/signInServlet")
public class signIn extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(new AddressEmail(email));
        user.setPassword(new Password(password));

        try {

            userService.loginUser(user, request);

            request.setAttribute("successLoggingAccount", true);

        } catch (Exception e) {

            ExceptionHandler exceptionHandler = ExceptionHandlerFactory.getExceptionHandler(e);

            exceptionHandler.handleException(e, request);

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/authentification");

        dispatcher.forward(request, response);
    }
}
