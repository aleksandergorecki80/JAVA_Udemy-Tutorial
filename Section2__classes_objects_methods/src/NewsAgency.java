import business.Company;

public class NewsAgency {
    Company company;

    public void accessMethod(){
        Person person = new Person();
        // No access to Person private fields;
        person.lastName = "Smith";
    }
 }
