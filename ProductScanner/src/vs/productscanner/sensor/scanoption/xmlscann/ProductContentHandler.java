package vs.productscanner.sensor.scanoption.xmlscann;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import vs.productscanner.product.Product;

public class ProductContentHandler implements ContentHandler{

	private Product product;
	private boolean productFound;
	private String currentValue;
	private String currentProductName;
	private String currentAmmount;
	
	public ProductContentHandler(Product product){
		this.product = product;
		this.productFound = false;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.currentValue = new String(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.equals("name")){
			this.currentProductName = this.currentValue;
		}
		
		if(localName.equals("ammount")){
			this.currentAmmount = this.currentValue;
		}
		
		if(localName.equals("product") && this.product.getName().equals(this.currentProductName)){
			this.product.setAmmount(this.currentAmmount);
		}
	}

	public void endDocument() throws SAXException {}
	public void endPrefixMapping(String prefix) throws SAXException {}
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {}
	public void processingInstruction(String target, String data) throws SAXException {}
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {}
	public void setDocumentLocator(Locator locator) {  }
	public void skippedEntity(String name) throws SAXException {}
	public void startDocument() throws SAXException {}
	public void startPrefixMapping(String prefix, String uri) throws SAXException {}
}
