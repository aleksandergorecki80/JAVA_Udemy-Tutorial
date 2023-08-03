import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section_04_Lesson_53__FindingMultipleMatches {
    public static void main(String[] args) {

        String people = """
                John, Doe, 15/6/1895
                Jan, Kowalski, 22/1/1975
                Jack, Nowak, 1/12/2002
                """;
        String regex = "(?<firstName>\\w+),\\s*(?<lastName>\\w+),\\s*(?<dob>(\\d{1,2}/){2}\\d{4})\\n";

        Pattern pat = Pattern.compile(regex);
        Matcher match = pat.matcher(people);

        ;
        while (match.find()) {
            System.out.println(match.group("firstName"));
            System.out.println(match.group("lastName"));
            System.out.println(match.group("dob"));
            System.out.println("---------------------------");
        }

    }
}
