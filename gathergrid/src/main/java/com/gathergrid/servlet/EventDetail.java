package com.gathergrid.servlet;

import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.service.imp.EventServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "event_detail", urlPatterns = "/event_detail")
public class EventDetail extends HttpServlet {

    EventServiceImp eventServiceImp;
    public void init() {
        eventServiceImp = new EventServiceImp(new EventRespository());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("event") == null){
           response.sendRedirect("home");
        }else{
            Long id = Long.parseLong(request.getParameter("event"));
            Event event = null;
            Response res = eventServiceImp.getEvent(id);
            if(res.getStatus() == 200){
                event = (Event) eventServiceImp.getEvent(id).getData();
            }
            request.setAttribute("event",event);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/event/event.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Error: " + e.getMessage());
            }

        }

    }
}
