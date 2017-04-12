package vs.productscanner.transmitter.transmitoption.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import vs.productscanner.product.ScannedProduct;
import vs.productscanner.transmitter.transmitoption.TransmitOption;

/**
 * This class implements a transmit via a datagram socket (UDP)
 * 
 * @author franky3er
 *
 */
public class UDPTransmit implements TransmitOption {
	
	private DatagramSocket clientSocket;	
	private InetAddress destinationIP;
	private int destinationPort;
	
	public UDPTransmit(InetAddress destinationIP, int destinationPort) {
		this.destinationIP = destinationIP;
		this.destinationPort = destinationPort;
		try {
			this.clientSocket = new DatagramSocket();
		} catch (SocketException e) {
			System.err.println("ERROR : Could not create Datagram Socket");
			e.printStackTrace();
		}
	}
	
	@Override
	public void transmit(ScannedProduct scannedProduct) {
		String sendData = scannedProduct.getStateAsString();
		System.out.println(String.format("INFO : UDPTransmit.transmit() : %s", sendData));
		try {
			clientSocket.send(new DatagramPacket(sendData.getBytes(), sendData.getBytes().length, destinationIP, destinationPort));
		} catch (IOException e) {
			System.err.println("ERROR : Failed to send data: " + sendData);
			e.printStackTrace();
		}
		
	}

	public InetAddress getDestinationIP() {
		return destinationIP;
	}

	public void setDestinationIP(InetAddress destinationIP) {
		this.destinationIP = destinationIP;
	}

	public int getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}

}
