import java.util.Scanner;
import java.util.ArrayList;

public class Company {
    public static final int max_employees = 5;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        char user_input;

        int i;

        ArrayList<Employee> crew = new ArrayList<Employee>();
        ArrayList<AdministrativeAssistant> hourly = new ArrayList<AdministrativeAssistant>();

        do {
            user_input = menu();

            if (user_input == 'a') {
                if (crew.size() >= max_employees) {
                    // print error
                }
                else {
                    String name;
                    double salary;
                    int hours;

                    boolean works_hourly;

                    System.out.println("What is their name?");
                    name = scnr.next();

                    System.out.println("What is their salary (yearly or hourly)?");
                    salary = scnr.nextDouble();

                    System.out.println("Are they an hourly worker? (Y/N)");
                    works_hourly = scnr.next().equalsIgnoreCase("Y");

                    if (works_hourly) {
                        System.out.println("How many hours per week do they work?");
                        hours = scnr.nextInt();

                        AdministrativeAssistant obj = new AdministrativeAssistant(name, salary, hours);
                        crew.add(obj);
                        hourly.add(obj);
                    }
                    else {
                        Employee obj = new SoftwareEngineer(name, salary);
                        crew.add(obj);
                    }
                }
            }
            else if (user_input == 'b') {
                for (i = 0; i < crew.size(); ++i) {
                    System.out.println(crew.get(i).toString());
                }
            }
            else if (user_input == 'c') {
                String name;
                double amount;

                boolean match = false;

                System.out.println("Name?");
                name = scnr.next();

                for (i = 0; i < crew.size(); ++i) {
                    if (crew.get(i).getName().equals(name)) {
                        match = true;

                        System.out.println("How much?");
                        amount = scnr.nextDouble();

                        crew.get(i).giveRaise(amount);
                    }
                }

                if (!match) {
                    System.out.println("Error");
                }
            }
            else if (user_input == 'd') {
                if (crew.isEmpty()) {
                    System.out.print("Error");
                }
                else {
                    for (i = 0; i < crew.size(); ++i) {
                        crew.get(i).getPaid();
                    }
                }
            }
            else if (user_input == 'e') {
                String name;
                double amount;

                boolean match = false;

                System.out.println("Name?");
                name = scnr.next();

                for (i = 0; i < hourly.size(); ++i) {
                    if (hourly.get(i).getName().equals(name)) {
                        match = true;

                        System.out.println("Hours: "+hourly.get(i).getHours());
                        System.out.println("New hours?");
                        amount = scnr.nextDouble();

                        crew.get(i).giveRaise(amount);
                    }
                }

                if (!match) {
                    System.out.println("Error");
                }
            }

        } while (user_input != 'f');
    }

    public static char menu() {
        Scanner scnr = new Scanner(System.in);

        char input;

        System.out.println("a. Add an Employee");
        System.out.println("b. List all Employees");
        System.out.println("c. Give an Employee a raise");
        System.out.println("d. Give Paychecks");
        System.out.println("e. Change someone’s hours");
        System.out.println("f. Quit");
        System.out.println();

        do {
            input = scnr.next().charAt(0);
        } while (input < 'a' || input > 'f');

        return input;
    }
}