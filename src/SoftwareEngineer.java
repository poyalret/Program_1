public class SoftwareEngineer extends Employee {
    // Parameterized Constructor
    public SoftwareEngineer(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.cash = 0;
    }

    // Methods
    public void giveRaise(double percentage) {
        salary += salary * percentage;
    }
}
