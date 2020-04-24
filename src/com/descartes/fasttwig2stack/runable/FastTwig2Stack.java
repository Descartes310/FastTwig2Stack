package com.descartes.fasttwig2stack.runable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.descartes.fasttwig2stack.helpers.MyXMLHandler;
import com.descartes.fasttwig2stack.models.Sequence;
import com.descartes.fasttwig2stack.models.XMLDoc;
import com.descartes.fasttwig2stack.models.XMLNode;

public class FastTwig2Stack {
	
	public static int leftPos = 1;
	public static int rightPos;
	public static Long startTime;
	public static Long endTime;
	public static List<XMLNode> stack = new ArrayList<XMLNode>();
	public static XMLDoc xmldoc = new XMLDoc();
	public static Map<String, Sequence> xmlnodes = new HashMap<String, Sequence>();
	public static String[] queries = {"annotation", "open_auction", "bidder", "interval"};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 
			 for(String query: queries) {
				 xmlnodes.put(query, new Sequence());
			 }
			 
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         parser.parse("pretty_output_xml_file.xml", new MyXMLHandler());

	      } catch (DOMException e) {
	         e.printStackTrace();
	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (TransformerFactoryConfigurationError e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	}

}
