import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section_04_Lesson_048_CommentsInRegularExpressions {
    public static void main(String[] args) {
        String regex = """
                        
        # This is my regex to parse code
                        # This is my regex to parse the phone number 
                        (?:(?<countryCode>\\d{1,2})[-.,\\s]?)? # Gets country code
                        (?:\\(?(?<areaCode>\\d{3})\\)?[-.\\s]?) # Gets area code 
                        (?:(?<exchange>\\d{3})[-.\\s]?) # Gets exchange
                        (?<lineNumber>\\d{4}) # Gets line number
                        """;  // ?: do not capture
        String phoneNumber = "12 (188) 334-6465";
//        System.out.println(phoneNumber.matches(regex));

        Pattern phoneNumberPattern = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);

        if(phoneNumberMatcher.matches()){
            System.out.println(phoneNumberMatcher.group(0));
            System.out.println("Country code = " + phoneNumberMatcher.group("countryCode"));
            System.out.println(phoneNumberMatcher.group(2));
            System.out.println(phoneNumberMatcher.group(3));
            System.out.println(phoneNumberMatcher.group(4));
        }
    }
}
