package datoPersona;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Player extends Person {
    private int playerNumber;
    private String position;
    private int quality;

    public Player(String name,String surname, String birthDate, int motivationLevel, double annualSalary, int playerNumber, String position, int quality) {
        super(name,surname, birthDate, motivationLevel, annualSalary);
        this.playerNumber = playerNumber;
        this.position = setPosition(position);
        this.quality = setQuality(quality);
    }

    public String setPosition(String position) {
        if (!position.matches("POR|DEF|MIG|DAV")) {
            throw new IllegalArgumentException("Invalid position!");
        } else {
            return this.position = position;
        }
    }

    public int setQuality(int quality) {
        if(quality < 30 || quality > 100) {
            throw new IllegalArgumentException("Invalid quality!");
        } else {
            return this.quality = quality;
        }
    }

    public String positionChange(String position) {
        Random rand = new Random();
        int even = rand.nextInt(3);
        if (Objects.equals(position, "POR")) {
            switch (even) {
                case 0:
                    this.position = "DEF";
                    break;
                case 1:
                    this.position = "DAV";
                    break;
                case 2:
                    this.position = "MIG";
                    break;
            }
        } else if (Objects.equals(position, "DEF")) {
            switch (even) {
                case 0:
                    this.position = "MIG";
                    break;
                case 1:
                    this.position = "DAV";
                    break;
                case 2:
                    this.position = "POR";
                    break;
                default:
            }
        } else if (Objects.equals(position, "DAV")) {
            switch (even) {
                case 0:
                    this.position = "MIG";
                    break;
                case 1:
                    this.position = "DEF";
                    break;
                case 2:
                    this.position = "POR";
                    break;
                default:
            }
        } else {
            switch (even) {
                case 0:
                    this.position = "DAV";
                    break;
                case 1:
                    this.position = "DEF";
                    break;
                case 2:
                    this.position = "POR";
                    break;
                default:
            }
        }
        return this.position;
    }

    public void training() {
        super.training();
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        if (randomNumber < 5) {
            this.position = positionChange(position);
            if (this.quality < 100) {
                this.quality = quality + 1;
                System.out.println(this.name + "'s quality + 1! \n" + this.name + "'s new quality: " + this.quality);
            }
            System.out.println(this.name + " have change the position to " + position + "!");
        }
    }

    public int getQuality() {
        return quality;
    }

    public static Player createPlayer(Scanner sc) {
        Person person = Person.createPerson(sc);
        System.out.println("Input the person's player number: ");
        int playerNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Input the person's position(POR|DEF|MIG|DAV): ");
        String position = sc.nextLine().toUpperCase();
        System.out.println("Input the person's quality(30 - 100): ");
        int quality = sc.nextInt();
        return new Player(person.name, person.surname, person.birthDate, person.motivationLevel, person.annualSalary,
                playerNumber, position, quality);
    }


    @Override
    public String toString() {
        return  super.toString() +
                "\nPlayer Number: " + this.playerNumber +
                "\nPosition: " + this.position +
                "\nQuality: " + this.quality +
                "\n------------------------------------------------";
    }

    //Getter
    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getPosition() {
        return position;
    }
}