package com.redhat.samples.fwk.sl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jLogger.class);
	
	/**
	 * Print a debug message in log.
	 * 
	 * @param message
	 */
	public void logDebugMessage(String message) {
		LOGGER.debug("[DEBUG] {}", message);
	}
	
	/**
	 * Print a trace message in log.
	 * 
	 * @param message
	 */
	public void logTraceMessage(String message) {
		LOGGER.trace("[TRACE]: {}", message);
	}
	
	/**
	 * Print a info message in log.
	 * 
	 * @param message
	 */
	public void logInfoMessage(String message) {
		LOGGER.info("[INFO]: {}", message);
	}

	/**
	 * Print a warning message in log.
	 * 
	 * @param message
	 */
	public void logWarnMessage(String message) {
		LOGGER.warn("[WARN]: {}", message);
	}

	/**
	 * Print a error message in log.
	 * 
	 * @param message
	 */
	public void logErrorMessage(String message) {
		LOGGER.error("[ERROR]: {}", message);
	}
	
}
