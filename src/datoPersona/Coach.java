package datoPersona;

public class Coach extends Person {
    private boolean isNationalTeamCoach;
    private int numberOfWon;

    public Coach(String name, String surname, String birthDate, int motivationLevel, double annualSalary, boolean isNationalTeamCoach, int numberOfWon) {
        super(name, surname, birthDate, motivationLevel, annualSalary);
        this.isNationalTeamCoach = isNationalTeamCoach;
        this.numberOfWon = numberOfWon;
    }

    public void salaryIncrease() {
        this.annualSalary += 0.05 * this.annualSalary;
    }

    public void training() {
        super.training();
        salaryIncrease();
    }


    @Override
    public String toString() {
        return  super.toString() +
                "\nIs National Team Coach: " + this.isNationalTeamCoach+
                "\nMatch had won: " + this.numberOfWon +
                "\n------------------------------------------------";
    }
}
