//CSC 205: 26063
//Program: 1
//Author(s): Jacob Meacham (id: 37025281)
//Description: Defines the class SoftwareEngineer which inherits from the abstract class Employee

public class SoftwareEngineer extends Employee {
    // Parameterized Constructor
    public SoftwareEngineer(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.cash = 0;
    }

    // Methods
    public void giveRaise(double percentage) {
        salary += salary / percentage;
    }

    public String toString() {
        return super.toString() + " Software Engineer";
    }
}
