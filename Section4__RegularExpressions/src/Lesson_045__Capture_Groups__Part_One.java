import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson_045__Capture_Groups__Part_One {
    public static void main(String[] args) {
        String regex = "((\\d{1,2})[-.,\\s]?)?((\\d{3})[-.\\s]?)((\\d{3})[-.\\s]?)(\\d{4})";
        String phoneNumber = "1.334.568.6465";
//        System.out.println(phoneNumber.matches(regex));
        
        Pattern phoneNumberPattern = Pattern.compile(regex);
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);

        if(phoneNumberMatcher.matches()){
            System.out.println(phoneNumberMatcher.group(0));
            System.out.println(phoneNumberMatcher.group(1));
            System.out.println(phoneNumberMatcher.group(2));
            System.out.println(phoneNumberMatcher.group(3));
            System.out.println(phoneNumberMatcher.group(4));
            System.out.println(phoneNumberMatcher.group(5));
            System.out.println(phoneNumberMatcher.group(6));
        }


    }
}
