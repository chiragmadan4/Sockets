package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		
		try {
			DatagramSocket datagramSocket = new DatagramSocket(8989);
			
			DatagramPacket packet = new DatagramPacket(new byte[1000],1000); // data will be received in this packet
			
			System.out.println("Waiting for packet");
			datagramSocket.receive(packet);
			
			System.out.println("packet received from IP: "+packet.getAddress()+" Port: "+packet.getPort());
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
