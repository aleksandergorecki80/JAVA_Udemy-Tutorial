import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
    private int linesOfCode = 0;
    private int yearsOfExperience = 0;
    private int iq = 0;

    private final String programmerRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
    private final Pattern programmerPat = Pattern.compile(programmerRegex);

    public Programmer(String personText) {
        super(personText);
        Matcher programmerMatcher = programmerPat.matcher(this.peopleMatcher.group("details"));

        if(programmerMatcher.find()){
            this.linesOfCode = Integer.parseInt(programmerMatcher.group("locpd"));
            this.yearsOfExperience = Integer.parseInt(programmerMatcher.group("yoe"));
            this.iq = Integer.parseInt(programmerMatcher.group("iq"));
        }
    }
    public int getSalary() {
        return 30 + this.linesOfCode * this.yearsOfExperience * this.iq;
    }

}
