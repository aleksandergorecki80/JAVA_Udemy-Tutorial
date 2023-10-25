import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int linesOfCode = 0;
    private int yearsOfExperience = 0;
    private int iq = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);

    private final String programmerRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
    private final Pattern programmerPat = Pattern.compile(programmerRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public Programmer(String personText) {
        Matcher peopleMatcher = peoplePattern.matcher(personText);

        if(peopleMatcher.find()){
            this.lastName =  peopleMatcher.group("lastName");
            this.firstName =  peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMatcher.group("dob")));
            Matcher programmerMatcher = programmerPat.matcher(peopleMatcher.group("details"));

            if(programmerMatcher.find()){
                this.linesOfCode = Integer.parseInt(programmerMatcher.group("locpd"));
                this.yearsOfExperience = Integer.parseInt(programmerMatcher.group("yoe"));
                this.iq = Integer.parseInt(programmerMatcher.group("iq"));
            }
        }
    }
    public int getSalary() {
        return 30 + this.linesOfCode * this.yearsOfExperience * this.iq;
    }

    @Override
    public String toString() {
        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
    }
}
