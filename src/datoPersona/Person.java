package datoPersona;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    protected final String name;
    protected final String surname;
    protected final String birthDate;
    protected int motivationLevel;
    protected double annualSalary;

    public Person(String name,String surname, String birthDate, int motivationLevel, double annualSalary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.motivationLevel = setMotivationLevel(motivationLevel);
        this.annualSalary = annualSalary;
    }

    public void training() {
        System.out.println(this.name + " is having training!");
    }

    public int setMotivationLevel(int motivationLevel) {
        if(motivationLevel < 1 || motivationLevel > 10) {
            throw new IllegalArgumentException("Invalid motivation level!");
        } else {
            return this.motivationLevel = motivationLevel;
        }
    }

    public static boolean searchPersonInMarket(ArrayList<Person> market, String playerName) {
        for (Person Person : market) {
            if(Person.getName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    public static Person createPerson(Scanner sc) {
        System.out.println("Input the person's name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Input the person's surname: ");
        String surname = sc.nextLine();
        System.out.println("Input the person's birthday: ");
        String birthday = sc.nextLine();
        System.out.println("Input the person's motivation level(1-10): ");
        int motivation = sc.nextInt();
        System.out.println("Input the person's annual salary: ");
        double annualSalary = sc.nextDouble();
        sc.nextLine();
        return new Person(name, surname, birthday, motivation, annualSalary) {};
    }

    public static void addPersonToMarket(ArrayList<Person> market, Person person) {
        market.add(person);
    }

    public static Person loadSinglePersonData(ArrayList<Person> market, String personName) {
        for (Person person : market) {
            if (person.getName().equalsIgnoreCase(personName)) {
                return person;
            }
        }
        return null;
    }

    public static void removePersonFromMarket(ArrayList<Person> market, String personName) {
        for (Person person : market) {
            if (person instanceof Player && person.getName().equalsIgnoreCase(personName)) {
                market.remove(person);
            } else if (person instanceof Coach && person.getName().equalsIgnoreCase(personName)) {
                market.remove(person);
            } else if (person instanceof Person && person.getName().equalsIgnoreCase(personName)) {
                market.remove(person);
            }
        }
    }

    @Override
    public String toString() {
        return "\n------------------------------------------------\n"+
                this.name + " " + this.surname + ":"
                + " \nBirthday: " + this.birthDate
                + "\nMotivation Level: " + this.motivationLevel
                + "\nAnnual Salary: " + this.annualSalary;
    }

    //Getter

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getMotivationLevel() {
        return motivationLevel;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }
}
