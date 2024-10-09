//CSC 205: 26063
//Program: 1
//Author(s): Jacob Meacham (id: 37025281)
//Description: Presents the user a menu and allows them to manage employees in a company.

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

            if (user_input == 'a') { // Add an Employee
                if (crew.size() >= max_employees) {
                    System.out.println("Already at maximum number of employees!");
                }
                else {
                    String name;
                    double salary;
                    int hours;

                    boolean works_hourly;

                    System.out.println("What is their name?");
                    name = scnr.nextLine();

                    System.out.println("What is their salary (yearly or hourly)?");
                    salary = scnr.nextDouble();
                    scnr.nextLine();

                    System.out.println("Are they an hourly worker? (Y/N)");
                    works_hourly = scnr.nextLine().equalsIgnoreCase("Y");

                    if (works_hourly) {
                        System.out.println("How many hours per week do they work?");
                        hours = scnr.nextInt();
                        scnr.nextLine();

                        AdministrativeAssistant obj = new AdministrativeAssistant(name, salary, hours);
                        crew.add(obj);
                        hourly.add(obj);
                    }
                    else {
                        Employee obj = new SoftwareEngineer(name, salary);
                        crew.add(obj);
                    }

                    System.out.println(name+" was hired!");
                }
            }
            else if (user_input == 'b') { // List all Employees
                if (crew.isEmpty()) {
                    System.out.println("Nobody works here!");
                }
                else {
                    for (i = 0; i < crew.size(); ++i) {
                        System.out.println(crew.get(i).toString());
                    }
                }
            }
            else if (user_input == 'c') { // Give an Employee a Raise
                String name;
                double amount;

                boolean match = false;

                System.out.println("Who do you want to give a raise to?");
                name = scnr.nextLine();

                for (i = 0; i < crew.size(); ++i) {
                    if (crew.get(i).getName().equals(name)) {
                        match = true;

                        System.out.println("What raise do you want to give them?");
                        amount = scnr.nextDouble();
                        scnr.nextLine();

                        crew.get(i).giveRaise(amount);

                        System.out.println(crew.get(i).getName() + " is happy!");
                    }
                }

                if (!match) {
                    System.out.println("Nobody under that name works here!");
                }
            }
            else if (user_input == 'd') { // Give Paychecks
                if (crew.isEmpty()) {
                    System.out.print("Error");
                }
                else {
                    for (i = 0; i < crew.size(); ++i) {
                        crew.get(i).getPaid();
                    }
                    System.out.println("Hooray for money!");
                }
            }
            else if (user_input == 'e') { // Change someone's hours
                String name;
                int hours;

                boolean match = false;

                System.out.println("Change hours for who?");
                name = scnr.nextLine();

                for (i = 0; i < hourly.size(); ++i) {
                    if (hourly.get(i).getName().equals(name)) {
                        match = true;

                        System.out.println(hourly.get(i).getName()+" currently works "+hourly.get(i).getHours()+" hours per week. What would you like to change it to?");
                        hours = scnr.nextInt();
                        scnr.nextLine();

                        hourly.get(i).setHours(hours);
                        System.out.println(hourly.get(i).getName()+" will now work 40 hours per week");
                    }
                }

                if (!match) {
                    System.out.println("Nobody under that name is paid hourly!");
                }
            }
        } while (user_input != 'f');

        System.out.println("Bye!");
    }

    public static char menu() { // Prints menu and returns user input as a char
        Scanner scnr = new Scanner(System.in);

        char input;

        System.out.println("What do you want to do?");
        System.out.println("A. Add an Employee");
        System.out.println("B. List all Employees");
        System.out.println("C. Give an Employee a Raise");
        System.out.println("D. Give Paychecks");
        System.out.println("E. Change someones hours");
        System.out.println("F. Quit");

        input = scnr.nextLine().charAt(0);
        while (input < 'a' || input > 'f') {
            System.out.println("Invalid option");
            input = scnr.nextLine().charAt(0);
        }

        return input;
    }
}