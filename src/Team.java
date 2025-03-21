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
    private Coach coach;
    private ArrayList<Person> players;

    public Team (String teamName, int foundationYear, String city, String stadiumName) {
        this.teamName = teamName;
        this.foundationYear = foundationYear;
        this.city = city;
        this.stadiumName = stadiumName;
    }

    public Team(String teamName, int foundationYear, String city, String stadiumName, Coach coach, ArrayList<Person> players) {
        this.teamName = teamName;
        this.foundationYear = foundationYear;
        this.city = city;
        this.stadiumName = stadiumName;
        this.coach = coach;
        this.players = players;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public ArrayList<Person> getPlayers() {
        return players;
    }

    public void AskForHowManyPlayers(ArrayList<Person> players, Scanner sc, ArrayList<Person> market) {
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
        boolean find = Person.searchPersonInMarket(playerName);
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
}
