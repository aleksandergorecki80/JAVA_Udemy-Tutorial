import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section_04_Lesson_047__Named_Capture_Groups {
    public static void main(String[] args) {
        String regex = "(?:(?<countryCode>\\d{1,2})[-.,\\s]?)?(?:(\\d{3})[-.\\s]?)(?:(\\d{3})[-.\\s]?)(\\d{4})";  // ?: do not capture
        String phoneNumber = "1.334.568.6465";
//        System.out.println(phoneNumber.matches(regex));

        Pattern phoneNumberPattern = Pattern.compile(regex);
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
