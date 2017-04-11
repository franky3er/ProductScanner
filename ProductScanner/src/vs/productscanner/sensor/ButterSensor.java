package vs.productscanner.sensor;

import vs.productscanner.product.Butter;
import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.scanoption.ScanOption;

public class ButterSensor extends Sensor {

	public ButterSensor(ScanOption scanOption) {
		super(scanOption);
	}

	@Override
	public ScannedProduct scan() {
		return super.getScanOption().scan(new Butter());
	}

}
