import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerHandlingMultipleRequests {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serSocket  = new ServerSocket(9999);
			System.out.println("Server listening on port: 9999");
			while(true) {
				System.out.println("Waiting for client..");
				Socket sock = serSocket.accept();
				new Service(sock).start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Service extends Thread{
	Socket sock;
	public Service(Socket s) {
		this.sock = s;
	}
	public void run() {
		System.out.println("Client connected on new port: "+sock.getPort());
		InputStream inputStream;
		OutputStream outputStream;
		try {
			inputStream = sock.getInputStream();
			outputStream = sock.getOutputStream();
			byte[] buffer = new byte[1024];
			System.out.println("Waiting for Client input..");
			inputStream.read(buffer);
			outputStream.write("Data received".getBytes());
			System.out.println("Response sent");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
