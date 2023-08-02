package model;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


    public Person() {

    }

    public String getFirstName(){
        return this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
    }
}
