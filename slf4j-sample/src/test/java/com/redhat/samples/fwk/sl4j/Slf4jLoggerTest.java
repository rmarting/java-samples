/**
 * 
 */
package com.redhat.samples.fwk.sl4j;

import junit.framework.TestCase;

/**
 * @author rmarting
 */
public class Slf4jLoggerTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.redhat.samples.fwk.sl4j.Slf4jLogger#logDebugMessage(java.lang.String)}
	 * .
	 */
	public void testLogDebugMessage() {
		(new Slf4jLogger()).logDebugMessage("Log debug message from Test Case");
	}

	/**
	 * Test method for
	 * {@link com.redhat.samples.fwk.sl4j.Slf4jLogger#logTraceMessage(java.lang.String)}
	 * .
	 */
	public void testLogTraceMessage() {
		(new Slf4jLogger()).logDebugMessage("Log trace message from Test Case");
	}

	/**
	 * Test method for
	 * {@link com.redhat.samples.fwk.sl4j.Slf4jLogger#logInfoMessage(java.lang.String)}
	 * .
	 */
	public void testLogInfoMessage() {
		(new Slf4jLogger()).logDebugMessage("Log info message from Test Case");
	}

	/**
	 * Test method for
	 * {@link com.redhat.samples.fwk.sl4j.Slf4jLogger#logWarnMessage(java.lang.String)}
	 * .
	 */
	public void testLogWarnMessage() {
		(new Slf4jLogger()).logDebugMessage("Log debug message from Test Case");
	}

	/**
	 * Test method for
	 * {@link com.redhat.samples.fwk.sl4j.Slf4jLogger#logErrorMessage(java.lang.String)}
	 * .
	 */
	public void testLogErrorMessage() {
		(new Slf4jLogger()).logDebugMessage("Log error message from Test Case");
	}

}
