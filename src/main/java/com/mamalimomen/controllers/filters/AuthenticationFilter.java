package com.mamalimomen.controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authentication", urlPatterns = {"/filter/*"})
public final class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        Cookie[] cookies = req.getCookies();
        if (session != null && cookies.length == 3) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/OnlineBusReservation/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
