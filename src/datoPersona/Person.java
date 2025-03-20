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

    public static boolean searchPersonInMarket(String playerName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/resource/mercat_fitxatges.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[1].toLowerCase().contains(playerName.toLowerCase())) {
                    return true;
                }
                }
        } catch (IOException e) {
            System.out.println("Fail to load file!");
        }
        return false;
    }

    public static Person createPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the person's name: ");
        String name = sc.nextLine();
        System.out.println("Input the person's surname: ");
        String surname = sc.nextLine();
        System.out.println("Input the person's birthday: ");
        String birthday = sc.nextLine();
        System.out.println("Input the person's motivation level: ");
        int motivation = sc.nextInt();
        System.out.println("Input the person's annual salary: ");
        double annualSalary = sc.nextDouble();
        sc.close();
        return new Person(name, surname, birthday, motivation, annualSalary) {};
    }

    @Override
    public String toString() {
        return "\n------------------------------------------------\n"+
                this.name + " " + this.surname + ":"
                + " \nBirthday: " + this.birthDate
                + "\nMotivation Level: " + this.motivationLevel
                + "\nAnnual Salary: " + this.annualSalary;
    }
}
