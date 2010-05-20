package com.dreamchain.js.web.jsunit;

import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.Test;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

public class RowSelectorTest {
	
	private final String LOCAL_IP = getLocalIP();
	private final int JETTY_PORT = 8089;
	
	@Test
	public void something() throws Exception {
		
		Server jettyServer = createJettyServer();
		jettyServer.start();
		Selenium selenium = new DefaultSelenium("192.168.1.64", 4444, "*firefox", "http://" + LOCAL_IP + ":" + JETTY_PORT +"/jsunit/" );
		selenium.start();
		try {
			selenium.open("rowSelectorTest.html");
		} catch (SeleniumException e) {
			System.out.println(e);
		}
		Thread.sleep(5000);
		Assert.assertTrue(!selenium.isTextPresent("Failure:"));
		Assert.assertTrue(!selenium.isTextPresent("Error:"));
		selenium.stop();
		jettyServer.stop();

	}
	
	private Server createJettyServer() {

		Server jettyServer = new Server(JETTY_PORT);
		
		ResourceHandler mainHandler = new ResourceHandler();
		mainHandler.setResourceBase("src/main/webapp");
		
		ResourceHandler testHandler = new ResourceHandler();
		testHandler.setResourceBase("src/test/webapp");
		
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { mainHandler, testHandler});
		
		jettyServer.setHandler(handlers);

		return jettyServer;

	}
	
	private String getLocalIP() {
		try {
			return java.net.InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new AssertionError();
		}
	}

}
