package vs.productscanner.sensor.scanoption;

import vs.products.Product;
import vs.products.ScannedProduct;

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
