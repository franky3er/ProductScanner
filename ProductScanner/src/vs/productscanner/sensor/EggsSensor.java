package vs.productscanner.sensor;

import vs.productscanner.product.Eggs;
import vs.productscanner.product.ScannedProduct;
import vs.productscanner.sensor.scanoption.ScanOption;

public class EggsSensor extends Sensor {

	public EggsSensor(ScanOption scanOption) {
		super(scanOption);
	}

	@Override
	public ScannedProduct scan() {
		System.out.println("INFO : ButterSensor.scan()");
		return super.getScanOption().scan(new Eggs());
	}

}
