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
    private int rigthPos;
    private int level;
    private String tag;
    private String value;
    private List<XMLNode> childs;
    private XMLNode[] partialSolutions;
    
    public XMLNode(String tag) {
        this.leftPos = 0;
        this.rigthPos = 0;
        this.level = 0;
        this.tag = tag;
        this.value = "";
        this.childs = null;
    }

    public XMLNode() {
        this.leftPos = 0;
        this.rigthPos = 0;
        this.level = 0;
        this.tag = "";
        this.value = "";
        this.childs = null;
    }
    
    public static XMLNode newDocElement(XMLNode elt, XMLNode[] partialSolutions) {
    	XMLNode newDocElement = new XMLNode();
    	newDocElement.leftPos = elt.leftPos;
    	newDocElement.rigthPos = elt.rigthPos;
    	newDocElement.level = elt.leftPos;
    	newDocElement.tag = elt.tag;
    	newDocElement.value = elt.value;
    	newDocElement.partialSolutions = partialSolutions;
    	newDocElement.childs = elt.childs;
    	
    	return newDocElement;
    }

	public int getLeftPos() {
		return leftPos;
	}

	public void setLeftPos(int leftPos) {
		this.leftPos = leftPos;
	}

	public int getRigthPos() {
		return rigthPos;
	}

	public void setRigthPos(int rigthPos) {
		this.rigthPos = rigthPos;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	@Override
	public String toString() {
		return "XMLNode [leftPos=" + leftPos + ", rigthPos=" + rigthPos + ", level=" + level + ", tag=" + tag
				+ ", value=" + value + ", childs=" + childs + ", partialSolutions=" + Arrays.toString(partialSolutions)
				+ "]";
	}

	

}
