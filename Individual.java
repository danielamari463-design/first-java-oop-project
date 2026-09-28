import java.util.Scanner;
import java.util.Random;

public class Individual extends Customer {

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Database db = new Database();

    String firstname;
    String lastname;
    int age;
    String role;
    double driverLicenseNumber;
    String accountType;
    String Birthedate;

    double balance = 0;

    public Individual(String firstname, String lastname, String address, String phoneNumber, String email,
            String role, int age, double driverLicenseNumber, int id, String accountType, String Birthedate,
            double balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        this.role = role;
        this.age = age;
        this.driverLicenseNumber = driverLicenseNumber;
        this.accountType = accountType;
        this.id = rand.nextInt(10000);
        this.Birthedate = Birthedate;
    }

    @Override
    public void add() {

        System.out.print("Enter the first name of the customer: ");
        String firstname = sc.nextLine();
        System.out.print("Enter the last name of the customer: ");
        String lastname = sc.nextLine();
        System.out.print("Enter the address of the customer: ");
        String address = sc.nextLine();
        System.out.print("Enter the phone number of the customer: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter the email of the customer: ");
        String email = sc.nextLine();
        System.out.print("Enter the role of the customer (e.g., Individual, Corporate): ");
        String role = sc.nextLine();
        System.out.print("Enter the age of the customer: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline character
        System.out.print("Enter the driver license number of the customer: ");
        double driverLicenseNumber = sc.nextDouble();
        sc.nextLine(); // Consume newline character
        System.out.print("Enter the account type of the customer (e.g., Regular, Premium): ");
        String accountType = sc.nextLine();
        System.out.print("Enter the birthdate of the customer (YYYY-MM-DD): ");
        String birthdate = sc.nextLine();
        System.out.print("Enter the initial balance for the customer: ");
        double balance = sc.nextDouble();
        Individual newIndividual = new Individual(firstname, lastname, address, phoneNumber, email,
                role, age, driverLicenseNumber, rand.nextInt(10000), accountType, birthdate, balance);
        db.addIndividual(newIndividual);
        System.out.println("Customer added successfully!");
        System.out.println();
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------");
        db.displayIndividualList();
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void search() {
        // Implementation for searching a customer in the customer list
        db.displayIndividualList();
        System.out.print("Enter the ID of the customer you want to search for: ");
        int customerId = sc.nextInt();
        sc.nextLine();
        Individual foundCustomer = db.findIndividualById(customerId);
        if (foundCustomer != null) {
            System.out.println("Customer found:");
            System.out.println(foundCustomer.firstname + " " + foundCustomer.lastname + " - Address: "
                    + foundCustomer.address + " - Phone Number: " + foundCustomer.phoneNumber + " - Email: "
                    + foundCustomer.email + " - Account Type: " + foundCustomer.accountType + " - Age: "
                    + foundCustomer.age + " - ID: " + foundCustomer.id + " - Balance: " + foundCustomer.balance);
        } else {
            System.out.println("Customer not found.");
        }
    }

    @Override
    public void displayAll() {
        // Implementation for displaying all customers
        db.displayIndividualList();
    }

    @Override
    public void edit() {
        // Implementation for editing a customer's information
        db.displayIndividualList();
        System.out.print("Enter the ID of the customer you want to edit: ");
        int customerId = sc.nextInt();
        sc.nextLine(); // Consume newline character
        Individual foundCustomer = db.findIndividualById(customerId);
        if (foundCustomer != null) {
            System.out.println("Customer found. Enter new information:");
            System.out.print("Enter the first name of the customer: ");
            foundCustomer.firstname = sc.nextLine();
            System.out.print("Enter the last name of the customer: ");
            foundCustomer.lastname = sc.nextLine();
            System.out.print("Enter the address of the customer: ");
            foundCustomer.address = sc.nextLine();
            System.out.print("Enter the phone number of the customer: ");
            foundCustomer.phoneNumber = sc.nextLine();
            System.out.print("Enter the email of the customer: ");
            foundCustomer.email = sc.nextLine();
            System.out.print("Enter the role of the customer (e.g., Individual, Corporate): ");
            foundCustomer.role = sc.nextLine();
            System.out.print("Enter the age of the customer: ");
            foundCustomer.age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the driver license number of the customer: ");
            foundCustomer.driverLicenseNumber = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter the account type of the customer (e.g., Regular, Premium): ");
            foundCustomer.accountType = sc.nextLine();
            System.out.print("Enter the birthdate of the customer (YYYY-MM-DD): ");
            foundCustomer.Birthedate = sc.nextLine();
            System.out.print("Enter the updated balance for the customer: ");
            foundCustomer.balance = sc.nextDouble();
            sc.nextLine();
            System.out.println("Customer information updated successfully!");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------");
            db.displayIndividualList();
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Customer not found.");
        }
    }

}