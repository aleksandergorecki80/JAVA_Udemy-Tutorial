import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static void main(String[] args) {
        String regex = "(\\d[-.\\s])?(\\d{3}[-.\\s]){1,2}\\d{4}"; // {1,2} between one or two times
        String phoneNumber = "1.334 646.6564";
        System.out.println(phoneNumber.matches(regex));

        Pattern pattern = Pattern.compile(regex);

        Matcher match = pattern.matcher(phoneNumber);
        System.out.println(match);

        if (match.matches()) {
            System.out.println("It matches");
            System.out.println(match.group(1));
            System.out.println(match.group("2"));
        }
    }
}
