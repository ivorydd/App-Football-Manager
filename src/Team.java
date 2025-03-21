import datoPersona.Coach;
import datoPersona.Player;
import datoPersona.Person;
import java.util.ArrayList;
import java.util.Scanner;


public class Team {
    private String teamName;
    private int foundationYear;
    private String city;
    private String stadiumName;
    private Person president;
    private Coach coach;
    private ArrayList<Person> players;

    public Team (String teamName, int foundationYear, String city, String stadiumName) {
        this.teamName = teamName;
        this.foundationYear = foundationYear;
        this.city = city;
        this.stadiumName = stadiumName;
    }

    public static Team createTeam(Scanner sc, ArrayList<Person> market) {
        System.out.print("Team's name: ");
        String teamName = sc.nextLine();
        System.out.print("Year of foundation: ");
        int foundationYear = Integer.parseInt(sc.nextLine());
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("Stadium: ");
        String stadiumName = sc.nextLine();
        ArrayList<Person> players = new ArrayList<>();
        Team team = new Team(teamName, foundationYear, city, stadiumName);
        team.changePresident(market, sc);
        team.changeCoach(market, sc);
        team.askForHowManyPlayers(players, sc, market);
        return team;
    }

    public void askForHowManyPlayers(ArrayList<Person> players, Scanner sc, ArrayList<Person> market) {
        System.out.println("How many player do you want to add to " + this.teamName + "?");
        int numberOfPlayers = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i + 1));
            addPlayerToTeam(sc, market);
        }
    }

    public void calcularTeamQuality() {
        int qualityTotal = 0;
        int count = 0;

        for (Person person : this.players) {
            if (person instanceof Player) {
                qualityTotal += ((Player) person).getQuality();
                count++;
            }
        }
        if (count > 0) {
            qualityTotal = qualityTotal / count;
        }
        System.out.println("quality: " + qualityTotal);
    }

    public void addPlayerToTeam(Scanner sc, ArrayList<Person> market) {
        System.out.println("Input the player's name: ");
        String playerName = sc.nextLine();
        boolean find = Person.searchPersonInMarket(market, playerName);
        if (find) {
               System.out.println("Add " + playerName + " to the team: " + this.teamName + "!");
               this.players.add(Player.loadSinglePersonData(market, playerName));
               Player.removePersonFromMarket(market, playerName);
        } else {
               System.out.println("Person not found in market!");
        }
    }

    public static Team searchTeamInTeamList(Scanner sc, ArrayList<Team> teams) {
        System.out.println("Input the team's name: ");
        String teamName = sc.nextLine();
        for (Team team : teams) {
            if (team.teamName.equalsIgnoreCase(teamName)) {
                return team;
            } else {
                System.out.println("Team not found in team list!");
            }
        }
        return null;
    }

    public void changeCoach(ArrayList<Person> market, Scanner sc) {
        boolean exit = false;
        do {
            System.out.println("Input the coach's name: ");
            String coachName = sc.nextLine().trim();
            System.out.println("Searching in the market....");
            boolean found = Person.searchPersonInMarket(market, coachName);
            if (found) {
                Coach newCoach = (Coach) Person.loadSinglePersonData(market, coachName);
                System.out.println("Found " + newCoach.getName() + ". Adding to team: " + this.teamName);
                if (this.coach != null) {
                    System.out.println("Moving current coach " + this.coach.getName() + " to the market.");
                    Person.addPersonToMarket(market, this.coach);
                }
                this.coach = newCoach;
                exit = true;
            } else {
                System.out.println("Coach not found in market! Do you want to create a new coach? (Y/N)");
                String response = sc.nextLine().trim();
                if (response.equalsIgnoreCase("y")) {
                    if (this.coach != null) {
                        System.out.println("Moving current coach " + this.coach.getName() + " to the market.");
                        Person.addPersonToMarket(market, this.coach);
                    }
                    this.coach = Coach.createCoach(sc);
                    System.out.println("New coach added to the team: " + this.coach.getName());
                    exit = true;
                } else if (response.equalsIgnoreCase("n")) {
                    System.out.println("Okay, let's try again.");
                } else {
                    System.out.println("Invalid input! Please enter Y or N.");
                }
            }
        } while (!exit);
    }


    public void changePresident(ArrayList<Person> market, Scanner sc) {
        boolean exit = false;

        do {
            System.out.println("Input the president's name: ");
            String presidentName = sc.nextLine().trim();
            System.out.println("Searching in the market....");
            boolean found = Person.searchPersonInMarket(market, presidentName);
            if (found) {
                Person newPresident = Person.loadSinglePersonData(market, presidentName);
                System.out.println("Found " + newPresident.getName() + ". Adding as president to team: " + this.teamName);
                if (this.president != null) {
                    System.out.println("Moving current president " + this.president.getName() + " to the market.");
                    Person.addPersonToMarket(market, this.president);
                }
                this.president = newPresident;
                exit = true;
            } else {
                System.out.println("President not found in market! Do you want to create a new one? (Y/N)");
                String response = sc.nextLine().trim();
                if (response.equalsIgnoreCase("y")) {
                    if (this.president != null) {
                        System.out.println("↩Moving current president " + this.president.getName() + " to the market.");
                        Person.addPersonToMarket(market, this.president);
                    }
                    this.president = Person.createPerson(sc); // ⛳ 你需要有 createPerson 方法！
                    System.out.println("New president added to the team: " + this.president.getName());
                    exit = true;
                } else if (response.equalsIgnoreCase("n")) {
                    System.out.println("Okay, try again.");
                } else {
                    System.out.println("Invalid input! Please enter Y or N.");
                }
            }
        } while (!exit);
    }



    //Setter
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setPresident(Person president) {
        this.president = president;
    }

    public void setPlayers(ArrayList<Person> players) {
        this.players = players;
    }

    //Getter
    public Coach getCoach() {
        return coach;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public String getCity() {
        return city;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public Person getPresident() {
        return president;
    }

    public ArrayList<Person> getPlayers() {
        return players;
    }
}
