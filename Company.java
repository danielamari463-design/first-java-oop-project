import java.util.Scanner;

public class Company extends Customer {
    static Scanner sc = new Scanner(System.in);

    Database db = new Database();

    String companyName;
    String email;
    int companyNumber;

    int commercialNumber;
    String origin;

    double companyBalance = 0;

    public Company(String companyName, String address, String email, int companyNumber, int commercialNumber,
            String origin, double companyBalance) {
        this.companyName = companyName;
        this.address = address;
        this.email = email;
        this.companyNumber = companyNumber;
        this.commercialNumber = commercialNumber;
        this.origin = origin;
        this.companyBalance = companyBalance;
    }

    public static void discountPercentage() {
    }

    @Override
    public void displayAll() {

        System.out.println("Displaying all companies");
        db.displayCompanyList();
    }

    @Override
    public void add() {

        System.out.println("Adding a new company");
        db.addCompany();
        db.displayCompanyList();

    }

    @Override
    public void search() {

        db.displayCompanyList();
        System.out.println("Enter the company commercial number to search for: ");
        int commercialNumber = sc.nextInt();
        db.findCompanyByCommercialNumber(commercialNumber);
    }

    @Override
    public void edit() {

        db.displayCompanyList();
        System.out.println("Enter the company number to edit: ");
        int companyNumber = sc.nextInt();
        db.editCompany(companyNumber);
        db.displayCompanyList();
    }

}
