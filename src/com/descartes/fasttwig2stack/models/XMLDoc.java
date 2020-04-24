package com.descartes.fasttwig2stack.models;

import java.util.ArrayList;
import java.util.List;

public class XMLDoc {
	
	private XMLNode root = new XMLNode();
	private List<XMLNode> nodes = new ArrayList<XMLNode>();
	
	public XMLDoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XMLDoc(XMLNode root, List<XMLNode> nodes) {
		super();
		this.root = root;
		this.nodes = nodes;
	}

	public XMLNode getRoot() {
		return root;
	}

	public void setRoot(XMLNode root) {
		this.root = root;
	}

	public List<XMLNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<XMLNode> nodes) {
		this.nodes = nodes;
	}
	
	public XMLNode addNode(XMLNode xmlnode) {
		List<XMLNode> nodes = this.nodes;
		nodes.add(xmlnode);
		this.setNodes(nodes);
		return xmlnode;
	}

	@Override
	public String toString() {
		return "XMLDoc [root=" + root + ", nodes=" + nodes + "]";
	}

}
