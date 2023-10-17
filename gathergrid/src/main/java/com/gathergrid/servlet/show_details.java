package com.gathergrid.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "show_details", urlPatterns = "/show_details/1")
public class show_details {
    String message;
    public void init()
    {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jspPath = "/WEB-INF/event/show_details.jsp";
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(jspPath);

        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
