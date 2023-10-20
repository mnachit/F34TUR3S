package com.gathergrid.servlet;

import com.gathergrid.repository.EventRespository;
import com.gathergrid.repository.TicketRepository;
import com.gathergrid.repository.UserRepository;
import com.gathergrid.service.imp.TicketServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Edit_Profile", urlPatterns = "/Edit_Profile")
public class Edit_Profile extends HttpServlet {

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/profile/edit_profile.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
