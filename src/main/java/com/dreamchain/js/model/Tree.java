package com.dreamchain.js.model;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	public String value;
	public List<Tree> children = new ArrayList<Tree>();

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	
}
