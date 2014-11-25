package labs.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TheServer {

	public static void main(String[] args) throws IOException {

		try(
			ServerSocket server = new ServerSocket(10000);
			Socket clientsocket = server.accept();
				PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))
			){
				String command = in.readLine();
				out.println(command);
				int id = 0;
				System.out.println("The item with the id " + id + " has been deleted.");
				clientsocket.close();
				server.close();

			}
//			System.out.println("Waiting for connection");
//				server.wait();
	}
}
