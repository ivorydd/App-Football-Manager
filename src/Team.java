import datoPersona.Coach;
import datoPersona.Player;
import datoPersona.Person;

import java.util.ArrayList;


public class Team {
    private String TeamName;
    private int foundationYear;
    private String city;
    private String stadiumName;
    private Coach coach;
    private ArrayList<Person> players;

    public Team(String teamName, int foundationYear, String city, String stadiumName, Coach coach, ArrayList<Person> players) {
        this.TeamName = teamName;
        this.foundationYear = foundationYear;
        this.city = city;
        this.stadiumName = stadiumName;
        this.coach = coach;
        this.players = players;
    }

    public void calcularTeamQuality() {
        int qualityTotal = 0;
        for (Person player : this.players) {
            qualityTotal += player.getQuality();
        }
        qualityTotal = qualityTotal / this.players.size();
        System.out.println("quality: "+ qualityTotal);
    }

   public void addPlayer() {
        Person.searchPersonInMarket(this.players);

    }
}
