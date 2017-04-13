package vs.productscanner.sensor;

import vs.products.Beer;
import vs.products.ScannedProduct;
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
