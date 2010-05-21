package com.dreamchain.js.web.jsunit;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public abstract class SeleniumTest {

	private final static String BUILD_MACHINE = "localhost";
	private final static String MACHINE_BROWSERS = "localhost:*safari";

	private final static int SELENIUM_SERVER_PORT = 4444;
	private final static int JETTY_PORT = 8089;
	private final int DEFAULT_TIME_FOR_JS_TEST = 5000;
	private final static String JS_TEST_URL = "http://" + BUILD_MACHINE + ":" + JETTY_PORT +"/jsunit/";
	private static Server jettyServer;
	private static List<Selenium> selenia;

	protected void assertScriptacuolusTestPasses(String url) throws InterruptedException {
		assertScriptacuolusTestPasses(url, DEFAULT_TIME_FOR_JS_TEST);
	}

	protected void assertScriptacuolusTestPasses(String url, int timeForJSTest) throws InterruptedException {
		for (Selenium selenium : selenia)
			selenium.open(url);
		Thread.sleep(timeForJSTest);
		for (Selenium selenium : selenia) {
			Assert.assertTrue(selenium.isTextPresent("0 failures"));
			Assert.assertFalse(selenium.isTextPresent("Failure:"));
			Assert.assertFalse(selenium.isTextPresent("Error:"));
		}
	}
	
	@BeforeClass
	public static void before() throws Exception {
		if (jettyServer == null) {
			jettyServer = createJettyServer();
		}
		jettyServer.start();
		if (selenia == null) {
			selenia = createSelenia();
		}
		for (Selenium selenium : selenia)
			selenium.start();
	}
	
	@AfterClass
	public static void after() throws Exception {
		for (Selenium selenium : selenia)
			selenium.stop();
		jettyServer.stop();
	}
	
	private static List<Selenium> createSelenia() {
		List<Selenium> selenia = new ArrayList<Selenium>();
		List<Machine> machines = Machine.valuesOf(MACHINE_BROWSERS);
		for (Machine machine : machines)
			for (String browser : machine.getBrowsers())
				selenia.add(new DefaultSelenium(machine.getName(), SELENIUM_SERVER_PORT, browser, JS_TEST_URL));
		return selenia;
	}
	
	private static Server createJettyServer() {

		Server jettyServer = new Server(JETTY_PORT);
		
		HandlerList handlers = new HandlerList();
		
		ResourceHandler mainHandler = new ResourceHandler();
		mainHandler.setResourceBase("src/main/webapp");
		handlers.addHandler(mainHandler);
		
		
		ResourceHandler testHandler = new ResourceHandler();
		testHandler.setResourceBase("src/test/webapp");
		handlers.addHandler(testHandler);
		
		jettyServer.setHandler(handlers);

		return jettyServer;

	}
	
	protected List<Selenium> getSelenia() {
		return selenia;
	}
	
}
