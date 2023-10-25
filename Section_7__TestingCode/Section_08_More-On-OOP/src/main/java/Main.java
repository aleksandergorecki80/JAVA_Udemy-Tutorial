import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
                     Flinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}
                     Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=130,yoe=14,iq=100}
                     Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=230,yoe=8,iq=105}
                     Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=163,yoe=3,iq=115}
                     Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=104}
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

        int totalSalaries = 0;
        Employee employee = null;
        while (peopleMatcher.find()) {
            employee = switch (peopleMatcher.group("role")) {
                case "Programmer" -> new Programmer(peopleMatcher.group());
                case "Manager" -> new Manager(peopleMatcher.group()); // if there is group() empty without any input it refers to a single line
                case "CEO" -> new CEO(peopleMatcher.group()); // if there is group() empty without any input it refers to a single line
                case "Analyst" -> new Analyst(peopleMatcher.group()); // if there is group() empty without any input it refers to a single line
                default -> new Nobody("Nobody");
            };
            System.out.println(employee.toString());
            totalSalaries+= employee.getSalary();

            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
//            System.out.printf("%s %s %s%n", peopleMatcher.group("firstName"), peopleMatcher.group("lastName"), peopleMatcher.group("role"));
//            System.out.printf("Total is %s%n", currencyInstance.format(totalSalaries));
        }
        System.out.println(totalSalaries);

    }
}

