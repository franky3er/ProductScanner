package vs.productscanner.sensor;

import vs.products.Butter;
import vs.products.ScannedProduct;
import vs.productscanner.sensor.scanoption.ScanOption;

public class ButterSensor extends Sensor {

	public ButterSensor(ScanOption scanOption) {
		super(scanOption);
	}

	@Override
	public ScannedProduct scan() {
		System.out.println("INFO : ButterSensor.scan()");
		return super.getScanOption().scan(new Butter());
	}

}
