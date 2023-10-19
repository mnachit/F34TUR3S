package com.gathergrid.servlet;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.EventService;
import com.gathergrid.service.imp.EventServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="myEvents", urlPatterns = "/myEvents")
public class MyEventsServlet extends HttpServlet {
    EventService eventService;

    @Override
    public void init()
    {
        eventService = new EventServiceImp(new EventRespository());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = 1;
        if (req.getParameter("page") != null) {
            pageNumber = Integer.parseInt(req.getParameter("page"));
        }
        Response res = eventService.SearchEvents(pageNumber,req.getParameter("search"));
        List<Event> events =  null;
        Integer totalPages = 0;
        if(res.getStatus() == 200){
            List<Object> data = (List<Object>) res.getData();
            events = (List<Event>) data.get(0);
            totalPages = (Integer) data.get(1);
        }
        req.setAttribute("events",events);
        req.setAttribute("totalPages",totalPages);
        req.setAttribute("pageNumber", pageNumber);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
