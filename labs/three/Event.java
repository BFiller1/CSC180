package labs.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public interface Event {

	//Scanner scan = new Scanner(System.in);

	final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	void show();
	Event next();
}
