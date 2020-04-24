package com.descartes.fasttwig2stack.runable;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.descartes.fasttwig2stack.helpers.MyXMLHandler;

public class FastTwig2Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         parser.parse("book.xml", new MyXMLHandler());

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
