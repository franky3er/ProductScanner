package vs.productscanner.sensor.scanoption;

import vs.productscanner.product.Product;
import vs.productscanner.product.ScannedProduct;

public interface ScanOption {
	ScannedProduct scan(Product product);
}
