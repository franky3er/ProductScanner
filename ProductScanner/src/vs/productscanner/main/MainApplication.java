package vs.productscanner.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import vs.productscanner.fridge.Fridge;
import vs.productscanner.product.Milk;
import vs.productscanner.product.Product;
import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.EggsSensor;
import vs.productscanner.sensor.MilkSensor;
import vs.productscanner.sensor.Sensor;
import vs.productscanner.sensor.scanoption.xmlscann.XMLScan;

public class MainApplication {

	private final static String PRODUCTSCANNER_PROJECT_NAME = "ProductScanner";
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private final static String PRODUCTSCANNER_SENSOR_XMLSCAN_XMLSOURCE = "ProductScanner.sensor.XMLScan.XMLSource";
	private final static String PRODUCTSCANNER_TRANSMITTER_UDPTRANSMIT_DESTINATION_IP = "ProductScanner.transmitter.UDPTransmit.destination.ip";
	private final static String PRODUCTSCANNER_TRANSMITTER_UDPTRANSMIT_DESTINATION_PORT = "ProductScanner.transmitter.UDPTransmit.destination.port";
	
	
	public static void main(String[] args) {
		Fridge fridge = new Fridge();
		try {
			Properties properties = loadProperties();
			initialize(fridge, properties);
			fridge.scan();
			fridge.transmit();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR : ProductScanner.properties not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR : Parsing ProductScanner.properties failed");
			e.printStackTrace();
		}
	}

	private static Properties loadProperties() throws FileNotFoundException, IOException {
		System.out.println("INFO : Load config");
		String sourceProperties = System.getProperty("user.dir") + getPathSeperator() + "config" 
				+ getPathSeperator() + PRODUCTSCANNER_PROJECT_NAME + ".properties";
		Properties properties = new Properties();
		properties.load(new FileReader(sourceProperties));
		return properties;
	}

	private static void initialize(Fridge fridge, Properties properties) {
			
	}

	private static String getPathSeperator() {
		if(OS.indexOf("win") >= 0) {
			return "\\";
		} 
		return "/";
	}

}
