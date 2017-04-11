package vs.productscanner.sensor.scanoption.xmlscann;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import vs.productscanner.product.Product;
import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.scanoption.ScanOption;

public class XMLScan implements ScanOption{
	private String productsFileSource;
	private XMLReader xmlReader;
	
	public XMLScan(String productsFileSource){
		this.setProductsFileSource(productsFileSource);
		try {
			this.xmlReader = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			System.out.println("ERROR : Could not create XMLReader");
			e.printStackTrace();
		}
	}
	
	@Override
	public ScannedProduct scan(Product product) {
		ScannedProduct scannedProduct = null;
		this.xmlReader.setContentHandler(new ProductContentHandler(product));
		try {
			
			this.xmlReader.parse(new InputSource(new FileReader(this.productsFileSource)));
			
			scannedProduct = new ScannedProduct(product);
			scannedProduct.setTimeStamp(new Date());
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : File not found: " + this.productsFileSource);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR : IOError");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("ERROR : SaxParseError");
			e.printStackTrace();
		}
		
		return scannedProduct;
	}

	public String getProductsFileSource() {
		return productsFileSource;
	}

	public void setProductsFileSource(String productsFileSource) {
		this.productsFileSource = productsFileSource;
	}
}
