import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int avgStockPrice = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);
    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public CEO(String personText) {
        Matcher peopleMatcher = peoplePattern.matcher(personText);

        if(peopleMatcher.find()){
            this.lastName =  peopleMatcher.group("lastName");
            this.firstName =  peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMatcher.group("dob")));
            Matcher managerMatcher = ceoPat.matcher(peopleMatcher.group("details"));

            if(managerMatcher.find()){
                this.avgStockPrice = Integer.parseInt(managerMatcher.group("avgStockPrice"));
            }
        }
    }

    public int getSalary() {
        return 35 * this.avgStockPrice;
    }

    @Override
    public String toString() {
        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
    }
}
