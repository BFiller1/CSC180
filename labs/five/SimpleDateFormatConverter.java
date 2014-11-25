package labs.five;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatConverter implements Converter<Date> {
	
	private SimpleDateFormat forParsing = new SimpleDateFormat("M-dd-yyyy");
	private SimpleDateFormat forFormatting = new SimpleDateFormat("M-dd-yyyy");
	
	SimpleDateFormatConverter() {
		
	}
	
	SimpleDateFormatConverter(SimpleDateFormat sdf) {
		//use the given sdf for both parsing and formatting; if given a null value, defaults to the class's default sdf
		if(sdf != null){
			//sdf = default sdf
			this.forParsing = sdf;
			this.forFormatting = sdf;
		}
	}
	
	SimpleDateFormatConverter(SimpleDateFormat forParsing, SimpleDateFormat forFormatting){
		// class will use the given sdfs for parsing and formatting, respectively; for each null value, defaults to the class's default sdf
		if(forParsing != null){
			//sdf = default sdf
			this.forParsing = forParsing;
		}
		else if(!forFormatting.equals(null)){
			this.forFormatting = forFormatting;
		}
	}
	
	@Override
	public Date parse(String fromString) throws ParseException {
		

			return forParsing.parse(fromString);

	}

	@Override
	public String format(Date fromObject) {
		try{
			return forFormatting.format(fromObject);
		}
		catch(Exception e){
			
		}
		return null;
	}
}
