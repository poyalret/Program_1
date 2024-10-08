public class AdministrativeAssistant extends Employee implements Hourly {
    // Data
    protected int hours;

    // Parameterized Constructor
    public AdministrativeAssistant(String name, double salary, int hours) {
        this.name = name;
        this.salary = salary;
        this.hours = hours;
    }

    // Methods
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void giveRaise(double amount) {
        salary += amount;
    }

    public void getPaid() {
        cash += hours * salary;
    }

    public String toString() {
        return name + " Hourly Wage: " + salary + " Cash: " + cash + " " + getClass().getName();
    }
}
