package labs.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

	//handles all the information from different states
	public static void main(String[] args) {
		
		try(
				ServerSocket server = new ServerSocket(10000);
				Socket clientsocket = server.accept();
					PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
					ObjectOutputStream oos = new ObjectOutputStream(clientsocket.getOutputStream())
				){
					String command = in.readLine();
					out.println(command);
				
				Pattern DELETE = Pattern.compile("(d\\()(\\d+)(\\))");
				Pattern UPDATE = Pattern.compile("");
				Pattern SEARCH = Pattern.compile("(findById\\()(\\d+)(\\))");
				
				Matcher delete_match = DELETE.matcher(command);
				Matcher update_match = UPDATE.matcher(command);
				Matcher search_match = SEARCH.matcher(command);
				
				if(delete_match.find()){
					long id = Long.parseLong(delete_match.group(1));
					AuctionService as = new InMemoryAuctionService();
					as.delete(id);
				}
				else if(update_match.find()){
					//find a way to update byte stream
//					AuctionService as = new InMemoryAuctionService();
//					as.update(id, a);
				}
				else if(search_match.find()){
					long id = Long.parseLong(search_match.group(1));
					AuctionService as = new InMemoryAuctionService();
					
				}
					
				try {
					clientsocket.close();
					oos.flush();
				}
					catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
}
