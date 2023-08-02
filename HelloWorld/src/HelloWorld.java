import model.Person;

import java.time.LocalDate;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world from Hello World");

        Person johny = new Person("johny", "smith", LocalDate.of(2000, 11, 21));

        System.out.println(johny);

//        Person amy = new Person();

        System.out.format("The person's first name is: %s", johny.getFirstName());

        johny.setLastName("doe");
        System.out.format("The person's last name is: %s", johny.getLastName());
    }
}
