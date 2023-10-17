package com.gathergrid.servlet;

import com.gathergrid.entities.Response;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.EventService;
import com.gathergrid.service.imp.EventServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet{
    EventServiceImp eventServiceImp ;
    public void init()
    {
        eventServiceImp = new EventServiceImp(new EventRespository());
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Response responsee = eventServiceImp.getEvents();
        String jspPath = "/WEB-INF/event/home.jsp";
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(jspPath);
        try {
            request.setAttribute("events",responsee.getData());
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
