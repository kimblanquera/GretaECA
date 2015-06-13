/*
 *
 * Description: This module modifies existing XML files.
 * 
 * Used to edit parameter values of XML files for Greta
 * to execute depending on the question and answer(s) of
 * the patient.
 * 
 * Called before Greta.
 * 
 * Requires: name of xml file, attributes/values/elements 
 * to be changed, values to replace existing ones
 *
 */
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLmod {

	public void modifyXML () {
		
		/*
		 * 
		 * filename: path/to/nameOfFile.xml
		 * tagName: name of element enclosed in "<" and ">" 
		 * attrName: name of attribute
		 * value: value to replace existing data of attributes
		 * 
		 */
		

		
	} // --- END PUBLIC VOID modifyXML
	
	
	// --- START XML HELPER METHODS
	
	protected Node getNode(String tagName, NodeList nodes) {
		
		/*
		 * 	Function: searches for tagName (element name)
		 * 	and returns the node from the tree
		 * 
		 */
		
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                return node;
            }
        }

        return null;
    }

    protected String getNodeValue( Node node ) {
    	
    	/*
    	 * 	Function: returns the value of a node
    	 * 
    	 * 	ex. if <node>value</node>, returns value
    	 * 
    	 */
    	
        NodeList childNodes = node.getChildNodes();
        for (int x = 0; x < childNodes.getLength(); x++ ) {
            Node data = childNodes.item(x);
            if ( data.getNodeType() == Node.TEXT_NODE )
                return data.getNodeValue();
        }
        return "";
    }

    protected String getNodeValue(String tagName, NodeList nodes ) {
    	
    	/*
    	 * 	Function: returns the value of a node from
    	 *	list of nodes
    	 *
    	 * 	ex. if <node>value</node>, returns value
    	 * 
    	 */
    	
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE )
                        return data.getNodeValue();
                }
            }
        }
        return "";
    }

    protected String getNodeAttr(String attrName, Node node ) {
    	NamedNodeMap attrs = node.getAttributes();
        for (int y = 0; y < attrs.getLength(); y++ ) {
            Node attr = attrs.item(y);
            if (attr.getNodeName().equalsIgnoreCase(attrName)) {
                return attr.getNodeValue();
            }
        }
        return "";
    }

    protected String getNodeAttr(String tagName, String attrName, NodeList nodes ) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
                        if ( data.getNodeName().equalsIgnoreCase(attrName) )
                            return data.getNodeValue();
                    }
                }
            }
        }

        return "";
    }
    
    protected void setNodeValue(String tagName, String value, NodeList nodes) {
        Node node = getNode(tagName, nodes);
        if ( node == null )
            return;

        // Locate the child text node and change its value
        NodeList childNodes = node.getChildNodes();
        for (int y = 0; y < childNodes.getLength(); y++ ) {
            Node data = childNodes.item(y);
            if ( data.getNodeType() == Node.TEXT_NODE ) {
                data.setNodeValue(value);
                return;
            }
        }
    }
    
    protected void setLastValue(String tagName, String value, NodeList nodes) {
    	
    	Node node = getNode(tagName, nodes);
    	if (node == null)
    		return;
    	
    	NodeList childNodes = node.getChildNodes();
    	int x = childNodes.getLength();
    	Node data = childNodes.item(x-1);
    	if ( data.getNodeType() == Node.TEXT_NODE ) {
            data.setNodeValue(value);
            return;
        }
    	
    }
    
    /*
     *  CRED HERE
     */
    protected void setAttrValue (Node node, String attrName, String value) {
    	
    	// CHANGE VALUE OF ATTRIBUTE FOR A TAG
    	NamedNodeMap attr = node.getAttributes();
    	Node nodeAttr = attr.getNamedItem(attrName);
    	nodeAttr.setTextContent(value);
    	
    }
    
    
    // --- END XML HELPER METHODS
	
} // --- END PUBLIC CLASS XMLmod