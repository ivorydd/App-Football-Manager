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

    public Team(String teamName, int foundationYear, String city, String stadiumName, Coach coach, ArrayList<Person> players) {
        this.teamName = teamName;
        this.foundationYear = foundationYear;
        this.city = city;
        this.stadiumName = stadiumName;
        this.coach = coach;
        this.players = players;
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

   public void addPlayer() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Input the person's name: ");
       String playerName = sc.nextLine();
       boolean find = Person.searchPersonInMarket(playerName);
       if (find) {
           System.out.println("Add " + playerName + " to the team: " + this.teamName + "!");
       } else {
           System.out.println("Person not found in market!");
       }
    }
}
