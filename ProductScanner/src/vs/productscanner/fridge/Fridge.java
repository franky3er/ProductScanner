package vs.productscanner.fridge;

import java.util.ArrayList;
import java.util.List;

import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.Sensor;
import vs.productscanner.transmitter.ScannedProductTransmitter;

public class Fridge {
	private List<ScannedProduct> scannedProducts;
	private List<Sensor> sensors;
	private ScannedProductTransmitter transmitter;
	
	public Fridge(){
		this.scannedProducts = new ArrayList<ScannedProduct>();
		this.sensors = new ArrayList<Sensor>();
		this.transmitter = new ScannedProductTransmitter();
	}
	
	public List<ScannedProduct> getScannedProducts() {
		return scannedProducts;
	}
	private void setScannedProducts(List<ScannedProduct> scannedProducts) {
		this.scannedProducts = scannedProducts;
	}
	private void addScannedProducts(List<ScannedProduct> scannedProducts) {
		this.scannedProducts.addAll(scannedProducts);
	}
	private void addScannedProduct(ScannedProduct scannedProduct) {
		this.scannedProducts.add(scannedProduct);
	}
	public List<Sensor> getSensors() {
		return sensors;
	}
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}
	public void removeSensor(Sensor sensor) {
		this.sensors.remove(sensor);
	}
	public ScannedProductTransmitter getTransmitter() {
		return transmitter;
	}
	public void setTransmitter(ScannedProductTransmitter transmitter) {
		this.transmitter = transmitter;
	}
	
	/**
	 * Scanns all Sensors and add the outcoming scanned product to the scanned products list.
	 * 
	 * @author franky3er
	 */
	public void scan() {
		System.out.println("INFO : All sensors scan()");
		for(Sensor sensor : this.sensors) {
			this.scannedProducts.add(sensor.scan());
		}
	}
	
	/**
	 * Transmit all the saved scanned products via the TransmitOption implementation.
	 * 
	 * @author franky3er
	 */
	public void transmit() {
		System.out.println("INFO : Transmit all scanned products");
		this.transmitter.transmit(this.scannedProducts);
	}
}
