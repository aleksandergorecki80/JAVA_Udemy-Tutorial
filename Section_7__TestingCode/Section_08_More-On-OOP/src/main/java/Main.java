import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String people = """
                     Flinstone, Fred, 1/1/1900, Programmerdddddd, {locpd=900,yoe=10,iq=140}
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
                     Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

        Matcher peopleMatcher = Employee.PEOPLE_MATCHER.matcher(people);

        int totalSalaries = 0;
        Employee employee = null;
        while (peopleMatcher.find()) {
            employee = Employee.createEmployee(peopleMatcher.group());
            System.out.println(employee.toString());
            totalSalaries+= employee.getSalary();
        }
        System.out.println(totalSalaries);
    }
}

