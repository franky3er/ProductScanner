package vs.productscanner.sensor;

import vs.productscanner.product.Milk;
import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.scanoption.ScanOption;

public class MilkSensor extends Sensor {

	public MilkSensor(ScanOption scanOption) {
		super(scanOption);
	}

	@Override
	public ScannedProduct scan() {
		System.out.println("INFO : MilkSensor.scan()");
		return super.getScanOption().scan(new Milk());
	}
	
}
