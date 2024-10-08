abstract class Employee {
    // Data
    protected String name;

    protected double salary;
    protected double cash;

    // Methods
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getCash() {
        return cash;
    }

    public void getPaid() {
        cash += salary/26;
    }

    public String toString() {
        return name + " Salary: " + salary + " Cash: " + cash + " " + getClass().getName();
    }

    public abstract void giveRaise(double percentage);
}
