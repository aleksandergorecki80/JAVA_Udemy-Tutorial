import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int orgSize = 0;
    private int directorReports = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);
    private final String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mgrPat = Pattern.compile(mgrRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public Manager(String personText) {
        Matcher peopleMatcher = peoplePattern.matcher(personText);

        if(peopleMatcher.find()){
            this.lastName =  peopleMatcher.group("lastName");
            this.firstName =  peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMatcher.group("dob")));
            Matcher managerMatcher = mgrPat.matcher(peopleMatcher.group("details"));

            if(managerMatcher.find()){
                this.orgSize = Integer.parseInt(managerMatcher.group("orgSize"));
                this.directorReports = Integer.parseInt(managerMatcher.group("dr"));
            }
        }
    }

    public int getSalary() {
        return 35 + this.orgSize * this.directorReports;
    }

    @Override
    public String toString() {
        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
    }
}
