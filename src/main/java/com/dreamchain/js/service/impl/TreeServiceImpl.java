package com.dreamchain.js.service.impl;

import org.springframework.stereotype.Service;

import com.dreamchain.js.model.Tree;
import com.dreamchain.js.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService {
	
	public Tree getRandomTree() {
		return getRandomTree(4);
	}

	Tree getRandomTree(double n) {
		Tree tree = new Tree();
		char symbol = (char) (Math.random() * ('Z' - 'A' + 1) + 'A');
		tree.setValue(String.valueOf(symbol));
		double numberOfChildren = Math.random() * n;
		for (double i = 1; i < numberOfChildren; i++)
			tree.getChildren().add(getRandomTree(n-1));
		return tree;
	}

}
