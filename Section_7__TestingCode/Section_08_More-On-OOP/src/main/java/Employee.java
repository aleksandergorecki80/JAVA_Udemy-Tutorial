import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {
    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    protected static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    protected final Matcher peopleMatcher;
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;

    public static final Pattern PEOPLE_MATCHER = Pattern.compile(PEOPLE_REGEX);

    protected Employee() {
        this.peopleMatcher = null;
        this.firstName = "No name";
        this.lastName = "No name";
        this.dob = null;
    }

    protected Employee(String personText) {
        this.peopleMatcher = Employee.PEOPLE_MATCHER.matcher(personText);

        if (peopleMatcher.find()) {
            this.lastName = peopleMatcher.group("lastName");
            this.firstName = peopleMatcher.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMatcher.group("dob")));
        }
    }

    public static final IEmployee createEmployee(String employeeText){
        Matcher peopleMatcher = Employee.PEOPLE_MATCHER.matcher(employeeText);
        if (peopleMatcher.find()) {
            return switch (peopleMatcher.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText); // if there is group() empty without any input it refers to a single line
                case "CEO" -> new CEO(employeeText); // if there is group() empty without any input it refers to a single line
                case "Analyst" -> new Analyst(employeeText); // if there is group() empty without any input it refers to a single line
//                default -> new Employee() {
//                    @Override
//                    public int getSalary() {
//                        return 0;
//                    }
//                };
                default -> () -> 0;
            };
        } else {
            return new DummyEmployee();
        }
    }

    public abstract int getSalary();

    @Override
    public String toString() {
        return String.format("%s, : %s salary: %s, bonus: %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()), this.moneyFormat.format(getBonus()));
    }

    public double getBonus(){
        return this.getSalary() * 1.10;
    }

//    private static void MyMethod(){           ****** STATIC methods can't access the class fields
//        this.lastName = "";
//    }


    private static final class DummyEmployee extends Employee implements IEmployee {
        @Override
        public int getSalary() {
            return 0;
        }
    }

    private final class MyInnerClass {
        public int getStuff() {
            System.out.println(firstName);
            return 0;
        }
    }
}
