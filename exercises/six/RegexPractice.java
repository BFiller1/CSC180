package exercises.six;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	String input;
	Pattern p;
	Matcher m;
	
	public void extractNumber(String input){
		
		String numRegex = "(\\d+(\\.\\d*)?)";
//		String numInput = ("3 + 2 / 4.0 * 1 ^ 17.34");
//		Matcher p = Pattern.compile(numRegex).matcher(numInput);
		p = Pattern.compile(numRegex);
		m = p.matcher(input);
		
		//extractNumbers("3 + 2 / 4.0 * 1 ^ 17.34") = [3, 2, 4.0, 1, 17.34]
		ArrayList<String> al = new ArrayList<String>();

		while(m.find()){
			al.add(m.group());
		}
		System.out.println("Returned Numbers");
		System.out.println(al.toString());
	}
	
	public void extractOperators(String input){
		String operatorRegex = "[+//*^-]";
//		String numInput = ("3 + 2 / 4.0 * 1 ^ 17.34");
		//[+//*^-]\
		//extracts all operators in math equation
		//extractOperators("3 + 2 / 4.0 * 1 ^ 17.34") = ["+", "/", "*", "^"]
		p = Pattern.compile(operatorRegex);
		m = p.matcher(input);
		
		ArrayList<String> al = new ArrayList<String>();

		while(m.find()){
			al.add(m.group());
		}
		System.out.println("Returned Operators");
		System.out.println(al.toString());
	}
	
	public void extractEmails(String input){
		String emailRegex = "[A-z0-9_.]+@[A-z0-9_.]+([.com]|[.net]|[.edu])";
//		String emails = "someone@this.com, that one guy, realEmail@k.edu";
		//extracts email addresses from email message
//		[A-z0-9_.]+@[A-z0-9_.]+([.com]|[.net]|[.edu])
		
		p = Pattern.compile(emailRegex);
		m = p.matcher(input);
		
		ArrayList<String> al = new ArrayList<String>();

		while(m.find()){
			al.add(m.group());
		}
		System.out.println("Returned Emails");
		System.out.println(al.toString());
	}
	
	public void extractListBody(String input){
		String bodyRegex = "<li>(.+?)</li>";
//		String input = "<li>somewhere over the rainbow</li>";
		//extracts all the content inside of any <li> element in an HTML payload and returns them as a List of Strings.
		p = Pattern.compile(bodyRegex);
		m = p.matcher(input);
		
		ArrayList<String> al = new ArrayList<String>();

		while(m.find()){
			al.add(m.group(1));

		}
		System.out.println("Returned Emails");
		System.out.println(al.toString());
	}

}
