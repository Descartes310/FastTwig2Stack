package com.descartes.fasttwig2stack.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author descartes
 *
 */
public class Sequence {
	
	private List<XMLNode> data = new ArrayList<XMLNode>();

	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<XMLNode> getData() {
		return data;
	}

	public void setData(List<XMLNode> data) {
		this.data = data;
	}
	
	public void addNode(XMLNode node) {
		List<XMLNode> nodes = this.getData();
		nodes.add(node);
		this.setData(nodes);
	}

	@Override
	public String toString() {
		return "Sequence [data=" + data + "]";
	}

}
