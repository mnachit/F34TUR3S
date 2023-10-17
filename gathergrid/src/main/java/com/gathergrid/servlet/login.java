package com.gathergrid.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = "/login")
public class login extends HttpServlet {

    String message;
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jspPath = "/WEB-INF/auth/login.jsp";  // Path to your JSP file
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspPath);

        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Handle any exceptions that may occur
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
