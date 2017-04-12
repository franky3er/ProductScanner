package vs.productscanner.transmitter.transmitoption;

import vs.productscanner.product.ScannedProduct;

public interface TransmitOption {
	void transmit(ScannedProduct scannedProduct);
}
