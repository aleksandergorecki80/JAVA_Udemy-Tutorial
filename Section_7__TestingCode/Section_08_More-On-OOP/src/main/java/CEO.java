import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee {
    private int avgStockPrice = 0;

    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public CEO(String personText) {
        super(personText);
        Matcher managerMatcher = ceoPat.matcher(peopleMatcher.group("details"));

        if(managerMatcher.find()){
            this.avgStockPrice = Integer.parseInt(managerMatcher.group("avgStockPrice"));
        }
    }

    public int getSalary() {
        return 35 * this.avgStockPrice;
    }

//    @Override
//    public String toString() {
//        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
//    }
}
