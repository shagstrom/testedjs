package com.dreamchain.testedjs.web.javascript;

import org.junit.Test;

import com.dreamchain.testedjs.web.selenium.SeleniumTest;

public class TestAllJavaScript extends SeleniumTest {
	
	@Test
	public void rowSelector() throws Exception {
		assertScriptacuolusTestPasses("jsunit/rowSelectorTest.html");
	}
	
	@Test
	public void dynamicTree() throws Exception {
		assertScriptacuolusTestPasses("jsunit/dynamicTreeTest.html");
	}
	
}
