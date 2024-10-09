//CSC 205: 26063
//Program: 1
//Author(s): Jacob Meacham (id: 37025281)
//Description: Defines the class AdministrativeAssistant which inherits from the abstract class Employee and the interface Hourly

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
        return name + " Hourly Wage: " + salary + " Cash: " + cash + " Administrative Assistant";
    }
}
