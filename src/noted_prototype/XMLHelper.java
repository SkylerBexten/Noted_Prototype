
package noted_prototype;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XMLHelper {
   
    private void addChild(Category cat, Node node){
        //Get child node's name and create Category or Note.
        Node currentNode = node;
        Element elm = (Element) currentNode;
        if(currentNode.getNodeName().equals("Category")){
            Category newCat = new Category(elm.getAttribute("name"));
            cat.addChild(newCat);
            
            //Get children of the node
            if(currentNode.hasChildNodes()){
                NodeList childNodes = currentNode.getChildNodes();
                for(int j = 0; j < childNodes.getLength(); j++){
                    currentNode = childNodes.item(j);
                    if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                        addChild(newCat,currentNode);
                    }
                }
            }
            
        }else if(currentNode.getNodeName().equals("Note")){
            Note newNote = new Note(currentNode.getTextContent());
            cat.addNote(newNote);
        }
    }
    
    public void getFileHierarchy(File inputFile){
        
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            
            //Go through the document's children.
            Element main = doc.getDocumentElement();
            NodeList nodes = main.getChildNodes();
            for(int j = 0; j < nodes.getLength(); j++){
                Node currentNode = nodes.item(j);
                
                //Only examine element nodes.
                if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                   String nodeName = currentNode.getNodeName();
                   
                   //If the node is a category node, add a category
                   //to the top categories in the program.
                   if(nodeName.equals("Category")){
                       Element elm = (Element) currentNode;
                       Category cat = new Category(elm.getAttribute("name"));
                       
                       //Add the category's children to the node.
                       if(currentNode.hasChildNodes()){
                           NodeList childNodes = currentNode.getChildNodes();
                           for(int k = 0; k < childNodes.getLength();k++){
                                currentNode = childNodes.item(k);
                                if(currentNode.getNodeType() == Node.ELEMENT_NODE){
                                    addChild(cat, currentNode);
                                }
                           }
                         Noted_Prototype.TopCategories.add(cat);  
                       }
                   }
                   
                   //Add a note object to the top notes in the program.
                   if(nodeName.equals("Note")){
                       Note note = new Note(currentNode.getTextContent());
                       Noted_Prototype.TopNotes.add(note);
                   }
                   
                   //Get all the tags in the file hierarchy
                   if(nodeName.equals("Tag")){
                       String tagName = currentNode.getTextContent();
                       Element elm = (Element) currentNode;
                       int tagCount = Integer.valueOf(elm.getAttribute("count"));
                       Tag tag = new Tag(tagName,tagCount);
                       Noted_Prototype.TagList.add(tag);
                   }
                }
            }
            
        }catch(Exception e){
            System.out.println("Error reading in file.");
        }
        
    }
    
}
