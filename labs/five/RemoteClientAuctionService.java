package labs.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteClientAuctionService {

	/*Calls server
	 *This lab has the functionality as the last, just with a
	 *client(multiple) and server
	 * methodName(simplemethodparams){serialized body}
	 * 
	 * If the method has no Auction parameters, there is no need for the
	 *body (likewise, if there are no simple method parameters, there is no
	 *need for the parameter section.
	 */

	/*
	 * On the server side, there will be a new class that is listening for
socket connections. When a socket connection comes in, this class
will read the message, pull out the method name and parameters, and
call the appropriate method on the original auction service. Then,
it will send a response back through the Socket.
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
//		AuctionService as = new AuctionService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try(
		Socket client = new Socket("localhost", 10000);
		BufferedReader file = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()))){
			String userInput = br.readLine();
			pw.write(userInput);
			client.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}