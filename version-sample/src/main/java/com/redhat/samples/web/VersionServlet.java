package com.redhat.samples.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VersionServlet
 */
@WebServlet(displayName = "VersionServlet", urlPatterns = "/version")
public class VersionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String VERSION = "2.0";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VersionServlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Version " + VERSION);
    }

}
