package exercises.five;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class ParseAndFormatTest {

	@Test
	public void DateTest() {
		Converter<Date> dates = new SimpleDateFormatConverter();


		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 22);
		Date d = cal.getTime();
		String formatted = dates.format(d);
		System.out.println(formatted);
		Assert.assertEquals("22 October 2014", formatted);
	}
	@Test
	public void DateTest1(){
		
		Converter<Date> dates1 = new SimpleDateFormatConverter(new SimpleDateFormat("MM dd yyyy"));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 22);
		Date d = cal.getTime();
		String formatted = dates1.format(d);
		System.out.println(formatted);
		Assert.assertEquals("10 22 2014", formatted);
		formatted = dates1.format(d);
		System.out.println(formatted);
	}
	
	@Test
	public void DateTest2(){
		Converter<Date> dates2 = new SimpleDateFormatConverter(new SimpleDateFormat("MMMM dd yyyy"), new SimpleDateFormat("MM dd yy"));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 22);
		Date d = cal.getTime();
		String formatted = dates2.format(d);
		System.out.println(formatted);
		Assert.assertEquals("22 October 2014", formatted);
		formatted = dates2.format(d);
		System.out.println(formatted);
		
	}
	
	@Test
	public void FormatTest(){
		Converter<Auction> auction = new TableRowAuctionConverter();
		Auction a = new Auction(5, "Something", "Something Else", 7);
		String s = ("something:Description of something:7");
		String form = auction.format(a);
//		Auction auction = trac.parse(auctionItem);
		System.out.println(form);
		
	}
}
