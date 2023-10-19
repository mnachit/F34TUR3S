package com.gathergrid.filters;

import java.io.IOException;
import java.util.function.Predicate;

import com.gathergrid.entities.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthentificationFilter implements Filter {

    private HttpServletRequest httpRequest;

    private HttpServletResponse httpResponse;

    private String[] reachablePathsWithoutAuthentification = { "/authentification", "/signUpServlet",
            "/signInServlet" };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;

        HttpSession httpSession = httpRequest.getSession();

        User loggedUser = (User) httpSession.getAttribute("LoggedUser");

        if (noAccessToThisRoute.test(loggedUser)) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        chain.doFilter(request, response);

    }

    public boolean reachablePathWithoutLoggin() {

        String url = httpRequest.getRequestURL().toString();

        for (String path : reachablePathsWithoutAuthentification) {
            if (url.contains(path)) {
                return true;
            }
        }
        return false;
    }

    Predicate<User> noAccessToThisRoute = loggedUser -> loggedUser == null && !reachablePathWithoutLoggin();

}
