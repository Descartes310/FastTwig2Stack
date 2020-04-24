package com.descartes.fasttwig2stack.helpers;

import java.util.Arrays;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.descartes.fasttwig2stack.models.Sequence;
import com.descartes.fasttwig2stack.models.XMLNode;
import com.descartes.fasttwig2stack.runable.FastTwig2Stack;

/**
 * 
 * @author descartes
 *
 */
public class MyXMLHandler extends DefaultHandler{
   //Nous nous servirons de cette variable plus tard
   private String node = null;
   //début du parsing
   public void startDocument() throws SAXException {
	   //String start = new Date(System.currentTimeMillis()).toString();
	   FastTwig2Stack.startTime = System.currentTimeMillis();
	   System.out.println("Start time   ====>   "+FastTwig2Stack.startTime);
   }
   
   //fin du parsing
   public void endDocument() throws SAXException {
	   
	   FastTwig2Stack.xmldoc.setRoot(FastTwig2Stack.xmldoc.getNodes().get(FastTwig2Stack.xmldoc.getNodes().size()-1));
//	   System.out.println("*************** Début du document ***************");
//	   System.out.println("La valeur du document XML est " + FastTwig2Stack.xmldoc.toString());
//	   System.out.println("*************** Fin du document ***************\n\n\n");

	   for(XMLNode node: FastTwig2Stack.xmldoc.getNodes()) {
		  if(Arrays.asList(FastTwig2Stack.queries).contains(node.getLabel())){
			  Sequence sequence = FastTwig2Stack.xmlnodes.get(node.getLabel());
			  sequence.addNode(node);
			  FastTwig2Stack.xmlnodes.put(node.getLabel(), sequence);
			  
		  }
	   }
	   
	   FastTwig2Stack.endTime = System.currentTimeMillis();
	   System.out.println("End time   ====>   "+FastTwig2Stack.endTime);
	   System.out.println("Processing time   ====>   "+ (FastTwig2Stack.endTime - FastTwig2Stack.startTime)/1000+" secondes");
   }   
   
   /**
    * Redéfinition de la méthode pour intercepter les événements
    */
   public void startElement(String namespaceURI, String lname,
         String qname, Attributes attrs) throws SAXException {
	   

	   	  XMLNode xmlnode = new XMLNode();
	   	  
	   	  if(FastTwig2Stack.stack.size() == 0)
	   		  xmlnode.setLevel(0);
	   	  else
	   		  xmlnode.setLevel(FastTwig2Stack.stack.get(FastTwig2Stack.stack.size()-1).getLevel()+1);
	   
		  xmlnode.setLabel(qname);
		  xmlnode.setLeftPos(FastTwig2Stack.leftPos);
		  //System.out.println("Le leftPos est: "+ FastTwig2Stack.leftPos);
		  FastTwig2Stack.leftPos += 1;
		  FastTwig2Stack.stack.add(xmlnode);
   }   

   public void endElement(String uri, String localName, String qName)
         throws SAXException{
     //System.out.println("Fin de l'élément " + qName); 
	   
	   FastTwig2Stack.stack.get(FastTwig2Stack.stack.size()-1).setRightPos(FastTwig2Stack.leftPos);

	   FastTwig2Stack.leftPos += 1;
	   FastTwig2Stack.xmldoc.addNode(FastTwig2Stack.stack.get(FastTwig2Stack.stack.size()-1));
	   FastTwig2Stack.stack.remove(FastTwig2Stack.stack.size()-1);
	   
	  //System.out.println("Delete taille de la pile " + FastTwig2Stack.stack.size());

     //System.out.println("Fin de  local l'élément ================================" + localName);  
   }
   
   /**
    * permet de récupérer la valeur d'un nœud
    */  
   public void characters(char[] data, int start, int end){   
      //System.out.println("***********************************************");
	   
      //La variable data contient tout notre fichier.
      //Pour récupérer la valeur, nous devons nous servir des limites en paramètre
      //"start" correspond à l'indice où commence la valeur recherchée
      //"end" correspond à la longueur de la chaîne
      String str = new String(data, start, end);
      
      FastTwig2Stack.stack.get(FastTwig2Stack.stack.size()-1).setValue(str);
      //System.out.println("Donnée du nœud " + node + " : " + str);
      
   }
}