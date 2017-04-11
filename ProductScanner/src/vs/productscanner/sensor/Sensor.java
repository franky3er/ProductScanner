package vs.productscanner.sensor;

import vs.productscanner.sensor.scanoption.ScanOption;

public class Sensor {
	private ScanOption scanOption;
	
	public Sensor(ScanOption scanOption){
		this.setScanOption(scanOption);
	}
	
	public ScanOption getScanOption() {
		return scanOption;
	}
	public void setScanOption(ScanOption scanOption) {
		this.scanOption = scanOption;
	}
}
