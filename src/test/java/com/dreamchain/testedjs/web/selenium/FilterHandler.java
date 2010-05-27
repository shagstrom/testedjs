package com.dreamchain.testedjs.web.selenium;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.handler.AbstractHandler;

public class FilterHandler extends AbstractHandler {
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, int dispatch) throws IOException,
			ServletException {
		if (target.matches(".*(WEB-INF|META-INF).*")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
