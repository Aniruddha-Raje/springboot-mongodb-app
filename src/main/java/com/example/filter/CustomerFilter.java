package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@Order(1)
public class CustomerFilter implements Filter {

    //Filters operate at the Servlet level

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        log.info("doFilter called");
        log.info("doFilter start {}" + req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
        log.info("doFilter committing transaction {}" + req.getRequestURI());
    }

    @Override public void destroy() {
        log.info("Filter destroy called");
    }
}
