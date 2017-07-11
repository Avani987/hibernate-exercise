package main.java;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Author implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authorId")
    private int aId;
    @Column(name = "authorAge")
    private int age;
    @Column(name = "authorFirstName")
    String firstName;
    @Column(name = "authorLastName")
    String lastName;
    @Temporal(TemporalType.DATE)@Column(name = "DateOfBirth") //using @Temporal to store only date value
    Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public Author(int age, String firstName, String lastName, Date dob) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob=dob;
    }

    public Author() {
        firstName=null;
        lastName=null;
        age=0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Age=" + age + ", First Name=" + firstName + ", Last Name=" + lastName + ", Date Of Birth=" + dob;
    }

}

