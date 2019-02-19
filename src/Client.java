import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		try {
			Socket socket = new Socket("127.0.0.1",9999);
			System.out.println("Client Side: " + "Connected to Server");
			
			// client port 
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			System.out.println("Enter data to be sent to Server..");
			out.write(read.nextLine().getBytes());
			
			byte buffer[] = new byte[1024];
			in.read(buffer);
			
			System.out.println("Response Received: "+new String(buffer));
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
