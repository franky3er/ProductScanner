package vs.productscanner.transmitter;

import java.util.ArrayList;
import java.util.List;

import vs.productscanner.product.ScannedProduct;
import vs.productscanner.transmitter.transmitoption.TransmitOption;

public class ScannedProductTransmitter {
	private List<TransmitOption> transmitOptions;
	
	public ScannedProductTransmitter() {
		transmitOptions = new ArrayList<TransmitOption>();
	}
	
	public ScannedProductTransmitter(List<TransmitOption> transmitOptions) {
		this.transmitOptions = transmitOptions;
	}
	
	public void transmit(List<ScannedProduct> scannedProducts){
		for(ScannedProduct scannedProduct : scannedProducts) {
			this.transmit(scannedProduct);
		}
	}
	
	public void transmit(ScannedProduct scannedProduct) {
		for(TransmitOption transmitOption : this.transmitOptions) {
			transmitOption.transmit(scannedProduct);
		}
	}
	
	public void addTransmitOption(TransmitOption transmitOption) {
		this.transmitOptions.add(transmitOption);
	}
	
	public void removeTransmitOption(TransmitOption transmitOption) {
		this.transmitOptions.remove(transmitOption);
	}
}
