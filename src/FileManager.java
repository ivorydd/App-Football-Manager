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
}

