package com.redhat.samples.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

/**
 * Servlet implementation class DataSourceServlet
 */
@WebServlet("/DataSourceServlet")
public class DataSourceServlet extends HttpServlet {

    private static final long serialVersionUID = 6618728190618097169L;

    private static final Logger LOGGER = Logger.getLogger(DataSourceServlet.class);

    /** Context */
    private Context ctx = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSourceServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            // Loading Initial Context
            this.ctx = new InitialContext();
        } catch (NamingException e) {
            throw new ServletException("Unable to get Initial Context", e);
        }
    }

    @Override
    public void destroy() {
        try {
            if (null != this.ctx) {
                this.ctx.close();
            }
        } catch (NamingException e) {
            LOGGER.warn("Exception closing the context.", e);
        }

        super.destroy();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("resource")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting DataSource properties
        // DataSource name
        String ds = "jboss/datasources/ExampleDS";
        if (null != request.getParameter("ds")) {
            ds = request.getParameter("ds");
        }
        // User credentials
        String user = null;
        if (null != request.getParameter("user") && !"".equals(request.getParameter("user"))) {
            user = request.getParameter("user");
        }
        String pwd = null;
        if (null != request.getParameter("pwd") && !"".equals(request.getParameter("pwd"))) {
            pwd = request.getParameter("pwd");
        }

        // We want to close the connection
        boolean closeConnection = true;
        if (null == request.getParameter("close")) {
            closeConnection = false;
        }

        Connection con = null;
        Statement stmt = null;
        try {
            DataSource datasource = (DataSource) this.ctx.lookup("java:/" + ds);

            if (null != user) {
                con = datasource.getConnection(user, pwd);
            } else {
                con = datasource.getConnection();
            }
            stmt = con.createStatement();
        } catch (NamingException e) {
            throw new ServletException("Unable to find DataSource in context", e);
        } catch (SQLException e) {
            throw new ServletException("Unable to manage SQL connection", e);
        } finally {
            try {
                if (null != stmt) {
                    stmt.close();
                }
                if (closeConnection && (null != con)) {
                    con.close();
                }
            } catch (SQLException e) {
                LOGGER.warn("Exception closing DB resources.", e);
            }
        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>Testing JBoss DataSources</title></head>");
        out.println("<body><h2>DataSource Testing works!!!</h2>");
        if (closeConnection) {
            out.println("<h4>Connection closed</h4>");
        } else {
            out.println("<h4>Connection not closed</h4>");
        }
        out.println("</html>");
    }
}
