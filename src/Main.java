import datoPersona.Coach;
import datoPersona.Person;
import datoPersona.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    }

    public static void showMenu() {
        System.out.println("Welcome to HerGame Manager: \n" +
                "1 - View current league standings \n" +
                "2 - Manage team \n" +
                "3 - Register team \n" +
                "4 - Register player or coach \n" +
                "5 - Check team data \n" +
                "6 - Check team player data \n" +
                "7 - Play new league \n" +
                "8 - Perform training session \n" +
                "9 - Transfer player \n" +
                "10 - Save team data \n" +
                "0 - Exit \n" +
                "You option: ");
    }

    public static void inputMenuOptions() {
        Scanner sc = new Scanner(System.in);
        int option = 1;
        do {
            showMenu();
            try {
                option = sc.nextInt();
                if (option < 0 || option > 10) {
                    System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option!");
                sc.nextLine();
            }
            menuOptionsSwitch(option);
        } while (option != 0);
        sc.close();
    }

    public static void menuOptionsSwitch(int option) {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
    }

    public static void loadPersonDate(ArrayList<Person> people) {
        FileManager.loadMarket("src/resource/mercat_fitxatges.txt", people);
    }

    public void addPerson() {
        System.out.println("Register player or coach: \n" +
                "1. Player\n" +
                "2. Coach");
        Scanner sc = new Scanner(System.in);
        int option = 1;
        if (option == 1) {
            Player.createPlayer();
        } if (option == 2) {
            Coach.createCoach();
        }

    }

}