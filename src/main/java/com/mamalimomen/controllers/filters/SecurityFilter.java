package com.mamalimomen.controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "security", urlPatterns = "/filter/security/*")
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (cookies.length == 3) {
            for(Cookie cookie : cookies){
                if (cookie.getValue().equals("Manager")){
                    chain.doFilter(request, response);
                }
            }
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    public void destroy() {

    }
}
