package exercises.six;


import org.junit.Test;

public class RegexTest {

	RegexPractice rp = new RegexPractice();
	@Test
	public void numRegexTest() {
		String nums = "5 + 77 / 3 batman and robin";
		rp.extractNumber(nums);
		
	}
	
	@Test
	public void operatorRegexTest() {
		String operators = ("3 + 2 / 4.0 * 1 ^ 17.34");
		rp.extractOperators(operators);
	}
	@Test
	public void emailRegexTest() {
		String emails = "someone@this.com, that one guy, realEmail@k.edu";
		rp.extractEmails(emails);
	}
	
	@Test
	public void bodyListRegexTest() {
		String bodyList = "<li>somewhere over the rainbow</li>";
		rp.extractListBody(bodyList);
	}

}
