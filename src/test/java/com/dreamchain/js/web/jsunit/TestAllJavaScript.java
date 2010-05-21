package com.dreamchain.js.web.jsunit;

import org.junit.Test;

public class TestAllJavaScript extends SeleniumTest {
	
	@Test
	public void rowSelector() throws Exception {
		assertScriptacuolusTestPasses("rowSelectorTest.html");
	}
	
}
