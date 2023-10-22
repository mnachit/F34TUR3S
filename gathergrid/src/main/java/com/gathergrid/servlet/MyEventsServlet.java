package com.gathergrid.servlet;

import com.gathergrid.embeddables.AddressEmail;
import com.gathergrid.entities.Event;
import com.gathergrid.entities.Response;
import com.gathergrid.entities.User;
import com.gathergrid.repository.CategorieRepository;
import com.gathergrid.repository.EventRespository;
import com.gathergrid.repository.UserRepository;
import com.gathergrid.service.CategoryService;
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

@WebServlet(name = "myEvents", urlPatterns = "/myEvents")
public class MyEventsServlet extends HttpServlet {
    EventService eventService;
    CategoryService categoryService;
    private Integer vip_price;

    @Override
    public void init() {
        CategorieRepository categorieRepository = new CategorieRepository();
        eventService = new EventServiceImp(new EventRespository(), categorieRepository, new UserRepository());
        categoryService = new CategoryService(categorieRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loggedUser = (User) req.getSession().getAttribute("LoggedUser");
        int pageNumber = 1;
        if (req.getParameter("page") != null) {
            pageNumber = Integer.parseInt(req.getParameter("page"));
        }
        Response res = eventService.searchMyEvents(pageNumber, loggedUser.getId(), req.getParameter("search"));
        Response categories = categoryService.getCategories();
        List<Event> events = null;
        Integer totalPages = 0;
        if (res.getStatus() == 200) {
            List<Object> data = (List<Object>) res.getData();
            events = (List<Event>) data.get(0);
            totalPages = (Integer) data.get(1);
        }
        req.setAttribute("categories", categories.getData());
        req.setAttribute("events", events);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("pageNumber", pageNumber);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/event/myEvents.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loggedUser = (User) req.getSession().getAttribute("LoggedUser");


        Long deleteId = Long.valueOf(req.getParameter("delete_id"));
        if (deleteId != null) {
            Response res = eventService.deleteEvent(deleteId, loggedUser.getId());
            if (res.getStatus() == 200) {
                req.getSession().setAttribute("success", res.getMessage());
                resp.sendRedirect(req.getContextPath() + "/myEvents");
            }
            else {
                req.getSession().setAttribute("error", res.getMessage());
                resp.sendRedirect(req.getContextPath() + "/myEvents");
            }
            return;
        }

        req.getParameterNames().asIterator().forEachRemaining(System.out::println);
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String dateTime = req.getParameter("datetime");
        String location = req.getParameter("location");
        Long categoryId = Long.valueOf(req.getParameter("category"));
        Integer vip_price = Integer.valueOf(req.getParameter("vip_price"));
        Integer regular_price = Integer.valueOf(req.getParameter("regular_price"));
        Integer basic_price = Integer.valueOf(req.getParameter("basic_price"));
        Response res = eventService.createEvent(name, description, location,dateTime, vip_price, regular_price, basic_price, categoryId, loggedUser.getId());
        if (res.getStatus() == 200) {
            req.getSession().setAttribute("success", res.getMessage());
            resp.sendRedirect(req.getContextPath() + "/myEvents");
        }
        else {
            req.getSession().setAttribute("error", res.getMessage());
            resp.sendRedirect(req.getContextPath() + "/myEvents");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
