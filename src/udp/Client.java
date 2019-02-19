package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		
		try {
			
			DatagramSocket datagramSocket = new DatagramSocket();
			
			String msg = "hello there";
			
			byte data[] = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8989);
			
			datagramSocket.send(packet);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
