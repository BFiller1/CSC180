package labs.five;

import java.text.ParseException;

public interface Converter<T> {

    T parse(String fromString) throws ParseException; // turn a string into a T
    String format(T fromObject); // turn a T into a string

}
