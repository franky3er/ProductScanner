package vs.productscanner.sensor;

import vs.productscanner.product.Beer;
import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.scanoption.ScanOption;

public class BeerSensor extends Sensor {

	public BeerSensor(ScanOption scanOption) {
		super(scanOption);
	}

	@Override
	public ScannedProduct scan() {
		System.out.println("INFO : BeerSensor.scan()");
		return super.getScanOption().scan(new Beer());
	}
	
	

}
