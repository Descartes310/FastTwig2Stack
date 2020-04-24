package com.descartes.fasttwig2stack.models;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author descartes
 *
 */

public class XMLNode {
	
	private int leftPos;
    private int rightPos;
    private int level;
    private String label;
    private String value;
    private XMLNode parent;
    private List<XMLNode> childs;
    private XMLNode[] partialSolutions;
    
    public XMLNode(String tag) {
        this.leftPos = 0;
        this.rightPos = 0;
        this.level = 0;
        this.label = tag;
        this.value = "";
        this.childs = null;
        this.parent = null;
    }

    public XMLNode() {
        this.leftPos = 0;
        this.rightPos = 0;
        this.level = 0;
        this.label = "";
        this.value = "";
        this.childs = null;
        this.parent = null;
    }
    
    public static XMLNode newDocElement(XMLNode elt, XMLNode[] partialSolutions) {
    	XMLNode newDocElement = new XMLNode();
    	newDocElement.leftPos = elt.leftPos;
    	newDocElement.rightPos = elt.rightPos;
    	newDocElement.level = elt.leftPos;
    	newDocElement.label = elt.label;
    	newDocElement.value = elt.value;
    	newDocElement.partialSolutions = partialSolutions;
    	newDocElement.childs = elt.childs;
    	newDocElement.parent = elt.parent;
    	
    	return newDocElement;
    }

	public int getLeftPos() {
		return leftPos;
	}

	public void setLeftPos(int leftPos) {
		this.leftPos = leftPos;
	}

	public int getRigthPos() {
		return rightPos;
	}

	public void setRightPos(int rightPos) {
		this.rightPos = rightPos;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public XMLNode[] getPartialSolutions() {
		return partialSolutions;
	}

	public void setPartialSolutions(XMLNode[] partialSolutions) {
		this.partialSolutions = partialSolutions;
	}

	public List<XMLNode> getChilds() {
		return childs;
	}

	public void setChilds(List<XMLNode> childs) {
		this.childs = childs;
	}
	
	
	
	public XMLNode getParent() {
		return parent;
	}

	public void setParent(XMLNode parent) {
		this.parent = parent;
	}

	public XMLNode addChild(XMLNode xmlnode) {
		List<XMLNode> childs = this.childs;
		childs.add(xmlnode);
		this.setChilds(childs);
		return xmlnode;
	}

//	@Override
//	public String toString() {
//		return "XMLNode: \n parent=" + parent +" \n leftPos=" + leftPos + " \n rigthPos=" + rigthPos + " \n level=" + level + " \n label=" + label + ", value=" + value ;
//	}

	@Override
	public String toString() {
		return "\n label: " + label + ", level: " + level + ", left: " + leftPos + ", right:, " + rightPos + " \n";
	}
	

}
