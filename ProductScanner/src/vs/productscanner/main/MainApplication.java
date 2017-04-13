package vs.productscanner.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import vs.productscanner.fridge.Fridge;
import vs.productscanner.sensor.BeerSensor;
import vs.productscanner.sensor.ButterSensor;
import vs.productscanner.sensor.EggsSensor;
import vs.productscanner.sensor.MilkSensor;
import vs.productscanner.sensor.scanoption.ScanOption;
import vs.productscanner.sensor.scanoption.xmlscann.XMLScan;
import vs.productscanner.transmitter.ScannedProductTransmitter;
import vs.productscanner.transmitter.transmitoption.udp.UDPTransmit;

public class MainApplication {

	private final static String PRODUCTSCANNER_PROJECT_NAME = "ProductScanner";
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private final static String PRODUCTSCANNER_SENSOR_XMLSCAN_XMLSOURCE = "ProductScanner.sensor.XMLScan.XMLSource";
	private final static String PRODUCTSCANNER_TRANSMITTER_UDPTRANSMIT_DESTINATION_IP = "ProductScanner.transmitter.UDPTransmit.destination.ip";
	private final static String PRODUCTSCANNER_TRANSMITTER_UDPTRANSMIT_DESTINATION_PORT = "ProductScanner.transmitter.UDPTransmit.destination.port";
	
	/**
	 * MAINAPPLICATION
	 * 
	 * @param args
	 */
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
			System.err.println("ERROR : IO");
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

	private static void initialize(Fridge fridge, Properties properties) throws NumberFormatException, UnknownHostException {
		initializeSensors(fridge, properties);
		initializeTransmitter(fridge, properties);
	}

	private static void initializeTransmitter(Fridge fridge, Properties properties) throws NumberFormatException, UnknownHostException {
		System.out.println("INFO : Initialize Transmitter");
		String destinationIP = properties.getProperty(PRODUCTSCANNER_TRANSMITTER_UDPTRANSMIT_DESTINATION_IP);
		String destinationPort = properties.getProperty(PRODUCTSCANNER_TRANSMITTER_UDPTRANSMIT_DESTINATION_PORT);
		
		System.out.println(String.format("INFO : Create UDPTransmitter (%s:%s)", destinationIP, destinationPort));
		ScannedProductTransmitter transmitter = new ScannedProductTransmitter();
		transmitter.addTransmitOption(new UDPTransmit(InetAddress.getByName(destinationIP), Integer.parseInt(destinationPort)));
		fridge.setTransmitter(transmitter);
	}

	private static void initializeSensors(Fridge fridge, Properties properties) {
		System.out.println("INFO : Initialize Sensors");
		ScanOption scanOption = new XMLScan(properties.getProperty(PRODUCTSCANNER_SENSOR_XMLSCAN_XMLSOURCE));
		fridge.addSensor(new MilkSensor(scanOption));
		fridge.addSensor(new BeerSensor(scanOption));
		fridge.addSensor(new EggsSensor(scanOption));
		fridge.addSensor(new ButterSensor(scanOption));
	}

	private static String getPathSeperator() {
		if(OS.indexOf("win") >= 0) {
			return "\\";
		} 
		return "/";
	}

}
