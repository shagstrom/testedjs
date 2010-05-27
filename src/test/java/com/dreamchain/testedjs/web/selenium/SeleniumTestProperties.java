package com.dreamchain.testedjs.web.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SeleniumTestProperties {
	
	private static final String PROPERTIES_FILE_LOCATION = "src/test/resources/selenium.properties";

	public static final String BUILD_MACHINE;
	public static final String MACHINE_BROWSERS;
	public static final int SELENIUM_SERVER_PORT;
	public static final int JETTY_PORT;
	public static final int DEFAULT_TIME_FOR_JAVASCRIPT_TO_FINISH;
	public static final String[] JETTY_SERVER_WEB_ROOTs;
	
	private static final String DEFAULT_BUILD_MACHINE = "localhost";
	private static final String DEFAULT_MACHINE_BROWSERS = "";
	private static final String DEFAULT_SELENIUM_SERVER_PORT = "4444";
	private static final String DEFAULT_JETTY_PORT = "8088";
	private static final String DEFAULT_DEFAULT_TIME_FOR_JAVASCRIPT_TO_FINISH = "1000";
	private static final String DEFAULT_JETTY_SERVER_WEB_ROOTS = "src/main/webapp;";
	
	static {
		Properties properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(PROPERTIES_FILE_LOCATION);
			properties.load(inputStream);
		} catch(IOException e) {
			Log log = LogFactory.getLog(SeleniumTestProperties.class);
			log.warn("Could not read properties file from '" + PROPERTIES_FILE_LOCATION + "'. Using default values.");
		}

		BUILD_MACHINE = properties.getProperty("build-machine", DEFAULT_BUILD_MACHINE);
		MACHINE_BROWSERS = properties.getProperty("machine-browsers", DEFAULT_MACHINE_BROWSERS);
		SELENIUM_SERVER_PORT = Integer.parseInt(properties.getProperty("selenium-server-port", DEFAULT_SELENIUM_SERVER_PORT));
		JETTY_PORT = Integer.parseInt(properties.getProperty("jetty-port", DEFAULT_JETTY_PORT));
		DEFAULT_TIME_FOR_JAVASCRIPT_TO_FINISH = 
			Integer.parseInt(properties.getProperty("default-time-for-javascript-test-to-finish", DEFAULT_DEFAULT_TIME_FOR_JAVASCRIPT_TO_FINISH));
		JETTY_SERVER_WEB_ROOTs = properties.getProperty("javascript-test-webroots", DEFAULT_JETTY_SERVER_WEB_ROOTS).split("\\s*;\\s*");
		
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// Java drives me mad! How am I supposed to recover from this?
			}
		}
		
	}

}
