package com.redhat.samples.fwk.sl4j;

import java.util.Random;

/**
 * @author rmarting
 */
public class Main {

	private static final char[] LEVELS = new char[] { 'd', 't', 'i', 'e', 'w' };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Arguments
		// Maximum Timeout between each log message. Default 1000 (1sg)
		int timeout = (null != args[0] ? Integer.parseInt(args[0]) : 1000);
		// Number of messages to log. Default -1 (infinitum)
		int loops = (null != args[1] ? Integer.parseInt(args[1]) : -1);
		
		// Random
		Random random = new Random();

		// Logger
		Slf4jLogger logger = new Slf4jLogger();

		do {
			switch (LEVELS[random.nextInt(LEVELS.length)]) {
			case 'd':
				logger.logDebugMessage("Debug message");
				break;

			case 't':
				logger.logTraceMessage("Trace message");
				break;

			case 'i':
				logger.logInfoMessage("Info message");
				break;

			case 'e':
				logger.logErrorMessage("Error message");
				break;

			case 'w':
				logger.logWarnMessage("Warn message");
				break;

			default:
				break;
			}

			try {
				Thread.sleep(random.nextInt(timeout));
			} catch (InterruptedException e) {
				logger.logErrorMessage("Thread interrupted");
			}
		} while ((loops-- != 1)); // Continue until no more messages
	}

}
