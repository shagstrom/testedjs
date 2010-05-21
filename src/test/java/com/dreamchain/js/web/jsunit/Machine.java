package com.dreamchain.js.web.jsunit;

import java.util.ArrayList;
import java.util.List;

public class Machine {
	
	private String name;
	private List<String> browsers = new ArrayList<String>();
	
	public Machine(String machineString) {
		String[] split = machineString.split("\\s*:\\s*");
		setName(split[0]);
		for (String browser : split[1].split("\\s*,\\s*"))
			browsers.add(browser);
	}

	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	List<String> getBrowsers() {
		return browsers;
	}
	void setBrowsers(List<String> browsers) {
		this.browsers = browsers;
	}
	
	static List<Machine> valuesOf(String s) {
		List<Machine> machines = new ArrayList<Machine>();
		String[] machineStrings = s.split("\\s*;\\s*");
		for (String machineString : machineStrings)
			machines.add(new Machine(machineString));
		return machines;
	}

}
