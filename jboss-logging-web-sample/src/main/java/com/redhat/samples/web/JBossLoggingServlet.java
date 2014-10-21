package com.redhat.samples.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

/**
 * Servlet implementation class JBossLoggingServlet
 */
public class JBossLoggingServlet extends HttpServlet {

	/** JBoss Logger */
	private static final long serialVersionUID = 2518824528761300162L;

	private static final Logger LOGGER = Logger
			.getLogger(JBossLoggingServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JBossLoggingServlet() {
		super();

		LOGGER.info("JBoss Logging Servlet created");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOGGER.info("JBoss Logging Servlet initiated successfully");
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		LOGGER.info("JBoss Logging Servlet destroyed");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Level
		String level = request.getParameter("level");
		if (null == level) {
			level = "INFO";
		}
		// Message
		String message = request.getParameter("message");
		if (null == message) {
			message = "This is a default message";
		}

		// Evaluate level to log the message
		switch (level) {
		case "DEBUG":
			LOGGER.debug(message);
			break;

		case "TRACE":
			LOGGER.trace(message);
			break;

		case "WARN":
			LOGGER.warn(message);
			break;

		case "ERROR":
			LOGGER.error(message);
			break;

		case "FATAL":
			LOGGER.fatal(message);
			break;

		case "EXCEPTION":
			LOGGER.error(message, new RuntimeException(
					"This is a new RuntimeException"));
			break;

		case "EXCEPTION-BY":
			LOGGER.error(message, new RuntimeException(
					"This is a new RuntimeException",
					new NullPointerException()));
			break;

		default:
			LOGGER.info(message);
		}

		response.getWriter().write(
				"Message logged with '" + level
						+ "' level in JBoss EAP log file");
	}

}
