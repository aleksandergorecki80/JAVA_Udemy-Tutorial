import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=2500,yoe=10,iq=140}
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=4000,yoe=10,iq=140}
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=5000,yoe=10,iq=140}
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=6000,yoe=10,iq=140}
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=7000,yoe=10,iq=140}
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=9000,yoe=10,iq=140}
                     Flinstone, Fred, 1/1/1900, Programmerzzzzz, {locpd=10000,yoe=10,iq=140}
                     Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
                     Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
                     Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
                     Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
                     Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
                     Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
                     Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
                     Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
                     Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
                     Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
                     Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
                     Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
                     Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
        Pattern peoplePattern = Pattern.compile(peopleRegex);
        Matcher peopleMatcher = peoplePattern.matcher(people);

        String progRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
        Pattern progPat = Pattern.compile(progRegex);

        int totalSalaries = 0;
        while (peopleMatcher.find()) {
            totalSalaries += switch (peopleMatcher.group("role")) {
                case "Programmer" -> {
                    Matcher progMat = progPat.matcher(peopleMatcher.group("details"));
                    if (progMat.find()) {
                        String locpd = progMat.group("locpd");
                        String yoe = progMat.group("yoe");
                        String iq = progMat.group("iq");
                        System.out.printf("Programmer loc: %s yoe: %s iq: %s%n", locpd, yoe, iq);
                    }
                    yield 3500;
                }
                case "CEO" -> {
                    yield 5500;
                }
                case "Analyst" -> {
                    yield 2500;
                }
                case "Manager" -> {
                    yield 4000;
                }
                default -> {
                    yield 0;
                }
            };
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
//            System.out.printf("%s %s %s%n", peopleMatcher.group("firstName"), peopleMatcher.group("lastName"), peopleMatcher.group("role"));
//            System.out.printf("Total is %s%n", currencyInstance.format(totalSalaries));
        }


    }
}

