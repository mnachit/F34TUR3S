package com.gathergrid.servlet.profile;

import java.io.IOException;

import com.gathergrid.entities.User;
import com.gathergrid.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class profile extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("LoggedUser");

        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/profile/profile.jsp");

        dispatcher.forward(request, response);

    }
}
