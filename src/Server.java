import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serSocket = new ServerSocket(9999); 
			/* listens to 9999 port and when a clients wants to connect 
			 * it creates another port for communication so that 9999 is not blocked 
			 * and other clients can connect
			 */
			System.out.println("Server running on port 9999");
			
			Socket sock = serSocket.accept(); //.accept() waits for client to connect
			
			System.out.println("Client connected, new port created at: "+sock.getPort());
			// sock is the new port created
			
			//each socket has its own inputStream and outputStream
			
			/*Server has inputStream which is connected to outputStream of client
			 * Server has outputStream which is connected to inputStream of Server
			 */
			
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			
			byte[] buffer = new byte[1023];
			in.read(buffer);
			System.out.println("Recived from client:"+new String(buffer));
			
			sock.close();
			serSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
