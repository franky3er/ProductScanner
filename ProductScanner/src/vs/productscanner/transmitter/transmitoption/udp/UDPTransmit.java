package vs.productscanner.transmitter.transmitoption.udp;

import vs.productscanner.product.ScannedProduct;
import vs.productscanner.transmitter.transmitoption.TransmitOption;

public class UDPTransmit implements TransmitOption {
	
	private String destinationIP;
	private int destinationPort;
	
	public UDPTransmit(String destinationIP, int destinationPort) {
		this.destinationIP = destinationIP;
		this.destinationPort = destinationPort;
	}
	
	@Override
	public void transmit(ScannedProduct scannedProduct) {
		// TODO Auto-generated method stub
		
	}

	public String getDestinationIP() {
		return destinationIP;
	}

	public void setDestinationIP(String destinationIP) {
		this.destinationIP = destinationIP;
	}

	public int getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}

}
