import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        Flyer flyer = new CEO("Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}");
        flyer.fyl();
        System.out.println(flyer.getHoursFlown());

        Chef programmerThatCooks = new Programmer("Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}");
        System.out.println(programmerThatCooks.yellAtPeople());


        String people = """
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Flinstone, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}
                     Flinstone, Fred2, 1/1/1900, Programmer, {locpd=130,yoe=14,iq=100}
                     Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=230,yoe=8,iq=105}
                     Alinstone4, Fred4, 1/1/1900, Programmer, {locpd=163,yoe=3,iq=115}
                     Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=104}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
                     Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
                     Aubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
                     Wubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
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
        IEmployee employee = null;

        List<IEmployee> employees  = new LinkedList<>();

        while (peopleMatcher.find()) {
            employee = Employee.createEmployee(peopleMatcher.group());


            employees.add(employee);
            System.out.println(employees + " === employees");



//            System.out.println(employee.getClass());

            if(employee.getClass().equals(Programmer.class)){
                System.out.println("=====PROGRAMMER=====");
            }

            if(employee instanceof Programmer){
                System.out.println("-------- instance of PROGRAMMER -----");
                System.out.println(((Programmer) employee).getIq());
            }

            if(employee instanceof Programmer coder){
                System.out.println("-------- instance of PROGRAMMER with pattern matching-----");
                System.out.println(coder.getIq());
            }
        }

        employees.remove(4);

        IEmployee employee1 = employees.get(0);
        IEmployee employee2 = employees.get(1);
        IEmployee employee3 = employees.get(2);

//        employees.remove(employee1);
//        employees.remove(employee2);
//        employees.remove(employee3);

        IEmployee randomEmployee = employees.get(5);
        System.out.println(randomEmployee + " ====== random employee");
        System.out.println(employees.contains(randomEmployee) + " contains random employee");

        IEmployee employee5 = Employee.createEmployee("Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=104}");
        System.out.println(employees.contains(employee5));
        System.out.println(randomEmployee.equals(employee5) + " are equal?");

//        employees.set(0, Employee.createEmployee());

        Object[] genericArray = employees.toArray();
        IEmployee[] otherArray = employees.toArray(new IEmployee[0]);

        List<IEmployee> sublist = employees.subList(0,3);

        List<String> undesirables = new ArrayList<>(List.of("Wilma5", "Barney4", "Fred2"));
        undesirables.sort(Comparator.naturalOrder());

        System.out.println(undesirables + " ====== undesirables");



//        List<String> undesirablesNames = new ArrayList<>();
//
//        undesirablesNames.add("Wilma5");
//        undesirablesNames.add("Barney4");
//        undesirablesNames.add("Fred2");

        Programmer programmer1 = new Programmer("Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=141}");
        Programmer programmer2 = new Programmer("Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}");

        System.out.println(programmer1.equals(programmer2) + " == programmer1 equals programmer2");


        List<String> newStrings = new ArrayList<>();
        System.out.println(newStrings);

        newStrings.addAll(undesirables);
        System.out.println(newStrings);

        removeUndesirables(employees, undesirables);

//        employees.sort((o1, o2) -> {
//            // if there is an "o1" that is an instance of Employee make the variable "emp1" of type Employee
//            if( o1 instanceof Employee emp1 && o2 instanceof Employee emp2 ){
////                    Employee emp1 = (Employee) o1;
////                    Employee emp2 = (Employee) o2;
//                int lastNameResult = emp1.lastName.compareTo(emp2.lastName);
//                return lastNameResult != 0 ? lastNameResult : Integer.compare(emp1.getSalary(), emp2.getSalary());
//            }
//            return 0;
//        });

        Collections.sort(employees, (o1, o2) -> {
            // if there is an "o1" that is an instance of Employee make the variable "emp1" of type Employee
            if( o1 instanceof Employee emp1 && o2 instanceof Employee emp2 ){
//                    Employee emp1 = (Employee) o1;
//                    Employee emp2 = (Employee) o2;
                int lastNameResult = emp1.lastName.compareTo(emp2.lastName);
                return lastNameResult != 0 ? lastNameResult : Integer.compare(emp1.getSalary(), emp2.getSalary());
            }
            return 0;
        });

        for (IEmployee worker : employees){
            System.out.println("=======  " + worker.toString());
            totalSalaries+= worker.getSalary();
        }

        System.out.println(totalSalaries);
        System.out.println(employees);

        Weirdo larry = new Weirdo("Larry", "Moore", LocalDate.of(1925, 1, 12));
        System.out.println(larry.firstName());
        System.out.println(larry.doSomething());

        Weirdo snake = new Weirdo("Jack", "Snake");
        System.out.println(snake.sayHello());


    }



    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames) {
        for(Iterator<IEmployee> iterator = employees.iterator(); iterator.hasNext(); ){
            IEmployee worker = iterator.next();
            if(worker instanceof Employee tempWorker){
//                Employee tempWorker = (Employee) worker;
                if(removalNames.contains(tempWorker.firstName)){
                    iterator.remove();
                }
            }
        }
    }
}

