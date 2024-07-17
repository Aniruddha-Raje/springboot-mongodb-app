package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class CustomerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("doFilter called");
        System.out.println("Starting a transaction for req : {}" + req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Committing a transaction for req : {}" + req.getRequestURI());
    }
}
