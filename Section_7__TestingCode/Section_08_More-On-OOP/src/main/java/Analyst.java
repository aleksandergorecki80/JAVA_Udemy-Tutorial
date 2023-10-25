import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int projectCount = 0;


    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);
    String analystRegex = "\\w+=(?<projectCount>\\w+)";
    private final Pattern analystPat = Pattern.compile(analystRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public Analyst(String personText) {
        Matcher peopleMatcher = peoplePattern.matcher(personText);

        if(peopleMatcher.find()){
            this.lastName =  peopleMatcher.group("lastName");
            this.firstName =  peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMatcher.group("dob")));
            Matcher analystMatcher = analystPat.matcher(peopleMatcher.group("details"));

            if(analystMatcher.find()){
                this.projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
            }
        }
    }

    public int getSalary() {
        return 35  * this.projectCount;
    }

    @Override
    public String toString() {
        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
    }
}
