import datoPersona.Coach;
import datoPersona.Person;
import datoPersona.Player;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> market = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        loadPersonDate(market);
        inputMenuOptions(sc, market);
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

    public static void showTeamMenu() {
        System.out.println("Team Manager:\n" +
                "1- Deregister team\n" +
                "2- Modify president\n" +
                "3- Dismiss coach\n" +
                "4- Register player or coach\n" +
                " 0- Exit");
    }

    public static void inputTeamMenu(Scanner sc) {
        int option = 1;
        do {
            showTeamMenu();
            try {
                option = sc.nextInt();
                if (option < 0 || option > 4) {
                    System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option!");
                sc.nextLine();
            }
            teamMenuOptionSwitch(option, sc);
        } while (option != 0);
    }

    public static void teamMenuOptionSwitch(int option, Scanner sc) {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public static void inputMenuOptions(Scanner sc, ArrayList<Person> market) {
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
            menuOptionsSwitch(option, sc, market);
        } while (option != 0);
    }

    public static void menuOptionsSwitch(int option, Scanner sc, ArrayList<Person> market) {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                addPersonToMarket(sc, market);
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

    public static void addPersonToMarket(Scanner sc, ArrayList<Person> market) {
        boolean exit = false;
        System.out.println("Register player or coach: \n" +
                "1. Player\n" +
                "2. Coach\n" +
                "3. Exit");
        do {
            int option = sc.nextInt();
            if (option == 1) {
                Person.addPersonToMarket(market, Player.createPlayer(sc));
                exit = true;
            }
            if (option == 2) {
                Person.addPersonToMarket(market, Coach.createCoach(sc));
                exit = true;
            } else if (option == 3) {
                exit = true;
            } else if (option < 1 || option > 3) {
                System.out.println("Invalid option. Try again.");
            }
        } while (!exit);
    }

    public static void addPlayerOrCoachToTeam (Scanner sc, ArrayList<Person> market, ArrayList<Team> teams) {
        boolean exit = false;
        Team team = Team.searchTeamInTeamList(sc, teams);
        System.out.println("Register player or coach: \n" +
                "1. Player\n" +
                "2. Coach\n" +
                "3. Exit");
        do {
            int option = sc.nextInt();
            if (option == 1) {
                team.addPlayerToTeam(sc, market);
                exit = true;
            }
            if (option == 2) {
                team.setCoach();
                exit = true;
            } else if (option == 3) {
                exit = true;
            } else if (option < 1 || option > 3) {
                System.out.println("Invalid option. Try again.");
            }
        } while (!exit);
    }

}