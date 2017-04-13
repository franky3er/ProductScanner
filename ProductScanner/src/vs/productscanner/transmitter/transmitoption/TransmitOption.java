package vs.productscanner.transmitter.transmitoption;

import vs.products.ScannedProduct;

public interface TransmitOption {
	/**
	 * This method transmit the state of a scanned product depending on the implementation.
	 * 
	 * @author franky3er
	 * @param scannedProduct
	 */
	void transmit(ScannedProduct scannedProduct);
}
