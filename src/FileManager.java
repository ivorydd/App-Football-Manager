import java.io.*;
import java.util.*;
import datoPersona.Coach;
import datoPersona.Player;
import java.util.ArrayList;
import datoPersona.Person;

public class FileManager {
    public static void loadMarket(String filePath, ArrayList<Person> people) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;
                String[] parts = line.split(";");
                String type = parts[0].trim();
                String name = parts[1].trim();
                String surname = parts[2].trim();
                String birthday = parts[3].trim();
                int motivationLevel = Integer.parseInt(parts[4].trim());
                double annualSalary = Double.parseDouble(parts[5].trim());

                if (type.equalsIgnoreCase("J")) {
                    int playerNumber = Integer.parseInt(parts[6].trim());
                    String position = parts[7].trim();
                    int quality = Integer.parseInt(parts[8].trim());

                    people.add(new Player(name, surname, birthday, motivationLevel, annualSalary, playerNumber, position,quality));

                } else if (type.equalsIgnoreCase("E")) {
                    int numberOfWon = Integer.parseInt(parts[6].trim());
                    boolean isNationalTeamCoach = Boolean.parseBoolean(parts[7].trim());

                    people.add(new Coach(name, surname, birthday, motivationLevel, annualSalary, isNationalTeamCoach, numberOfWon));
                }
            }
        } catch (IOException e) {
            System.out.println("Fail to load file: " + filePath);
        }
    }

    public static void loadTeam(String filePath, ArrayList<Team> teams) {

    }





    public static void savePersonOfMarketToFile(ArrayList<Person> market, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person p : market) {
                if (p instanceof Player) {
                    Player player = (Player) p;
                    writer.write("J;" + player.getName() + ";" + player.getSurname() + ";" + player.getBirthDate() + ";" +
                            player.getMotivationLevel() + ";" + player.getAnnualSalary()+ ";" + player.getPlayerNumber() + ";" +
                            player.getPosition() + ";" + player.getQuality());
                } else if (p instanceof Coach){
                    Coach coach = (Coach) p;
                    writer.write("E;" + coach.getName() + ";" + coach.getSurname() + ";" + coach.getBirthDate() + ";" +
                            coach.getMotivationLevel() + ";" + coach.getAnnualSalary() + ";" + coach.getNumberOfWon() + ";" + coach.getIsNationalTeamCoach());
                }writer.newLine();
            }
            System.out.println("Save data to " + filePath);
        } catch (IOException e) {
            System.out.println("Fail to save date to：" + e.getMessage());
        }
    }
}

