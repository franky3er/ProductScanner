package vs.productscanner.sensor.scanoption;

import vs.productscanner.product.Product;
import vs.productscanner.product.ScannedProduct;

public interface ScanOption {
	/**
	 * This method scans a product depending on the implementation.
	 * 
	 * @author franky3er
	 * @param product
	 * @return ScannedProduct
	 */
	ScannedProduct scan(Product product);
}
