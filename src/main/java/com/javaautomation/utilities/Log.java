package com.javaautomation.utilities;

import org.apache.logging.log4j.*;

public class Log {

	// Initialize Log4j logs
	private static Logger log = LogManager.getLogger(Log.class.getName());

	public static void startTestCase(String testCaseName) {
		log.info("=====================================" + testCaseName
				+ " TEST START=========================================");
	}

	public static void endTestCase(String testCaseName) {
		log.info("=====================================" + testCaseName
				+ " TEST END=========================================");
	}

	// Methods to call from tests for logging
	
	public static void info(String message) {

		log.info(message);

	}

	public static void warn(String message) {

		log.warn(message);

	}

	public static void error(String message) {

		log.error(message);

	}

	public static void fatal(String message) {

		log.fatal(message);

	}

	public static void debug(String message) {

		log.debug(message);

	}

}
