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
		Converter<Date> dates1 = new SimpleDateFormatConverter(new SimpleDateFormat("MM dd yyyy"));
		Converter<Date> dates2 = new SimpleDateFormatConverter(new SimpleDateFormat("MM dd yyyy"), new SimpleDateFormat("MMMM dd yy"));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		String formatted = dates.format(d);
		System.out.println(formatted);
		
		Assert.assertEquals("21 October 2014", formatted);
		
		cal.set(Calendar.DATE, 21);
		d = cal.getTime();
		
		Assert.assertEquals("Oct 21 2014", formatted);
		formatted = dates1.format(d);
		System.out.println(formatted);
		
		Assert.assertEquals("October 21 14", formatted);
		formatted = dates2.format(d);
		System.out.println(formatted);
		
	}
	
	@Test
	public void FormatTest(){
		TableRowAuctionConverter trac = new TableRowAuctionConverter();
		
		String auctionItem = "1:Toy:fun:5";
		Auction auction = trac.parse(auctionItem);
		System.out.println(auction);
		
	}

}
