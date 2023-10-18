import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer
            Rubble, Barney, 2/2/1905, CEO
            Flinstone, Wilma, 3/3/1910, Analyst
            Rubble, Betty, 4/4/1915, Manager
            """;

        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        int totalSalaries = 0;
        while (mat.find()) {
           totalSalaries+= switch (mat.group("role")){
                case "Programmer" -> 3000;
               default -> 0;
            };
            System.out.printf("%s %s %s%n", mat.group("firstName"), mat.group("lastName"), mat.group("role"));
        }


    }
}

