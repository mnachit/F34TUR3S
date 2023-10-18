package com.gathergrid.servlet;

import com.gathergrid.entities.Event;
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
import java.util.List;
import java.util.Objects;

@WebServlet(name = "home", urlPatterns = "/")
public class HomeServlet extends HttpServlet{
    EventServiceImp eventServiceImp ;
    public void init()
    {
        eventServiceImp = new EventServiceImp(new EventRespository());
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pageNumber = 1;
        if (request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Response res = eventServiceImp.SearchEvents(pageNumber,request.getParameter("search"));
        List<Object> data = (List<Object>) res.getData();
        request.setAttribute("events",(List<Event>) data.get(0));
        request.setAttribute("totalPages",data.get(1));
        request.setAttribute("pageNumber", pageNumber);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}