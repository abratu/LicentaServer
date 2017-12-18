package com.abratu.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.addHeader("WWW-Authenticate", "Basic realm=\"\" + getRealmName() + \"\"");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String params = httpServletRequest.getHeader("parameters");
        PrintWriter writer = httpServletResponse.getWriter();
        httpServletResponse.setStatus(401);
        writer.println("HTTP Status 401 - " + e.getMessage());
    }


}
