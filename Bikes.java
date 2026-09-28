import java.util.Scanner;
import java.util.Random;

public class Bikes extends Vehicle {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Database db = new Database();
    Individual individual = new Individual("", "", "", "", "", "", 0, 0, 0, "", "", 0);
    Company company = new Company("", "", "", 0, 0, "", 0);

    double balanceBike = 0;
    double engineCapacity;
    boolean hasCarrier;

    public Bikes(String brand, String model, int year, double dailyPrice, double purchasePrice, String color,
            boolean available, int cardNumber, int id, double engineCapacity, boolean hasCarrier) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.purchasePrice = purchasePrice;
        this.color = color;
        this.available = available;
        this.cardNumber = (int) cardNumber;
        this.id = rand.nextInt(10000);
        this.engineCapacity = engineCapacity;
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayAllVehicles() {
        // Implementation for displaying all bikes
    }

    @Override
    public void rentVehicle(int choice) {
        // Implementation for renting a bike
        System.out.print("Enter the ID of the bike you want to rent: ");
        int bikeId = sc.nextInt(); // Get the bike ID from the user
        sc.nextLine();
        Bikes bikeToRent = db.findBikeById(bikeId); // Find the bike in the database using the ID
        if (bikeToRent != null) { // Check if the bike exists
            if (bikeToRent.available) { // Check if the bike is available for rent
                System.out.println("Bike details:");
                System.out.println("Brand: " + bikeToRent.brand);
                System.out.println("Model: " + bikeToRent.model);
                System.out.println("Year: " + bikeToRent.year);
                System.out.println("Color: " + bikeToRent.color);
                System.out.println("Engine Capacity: " + bikeToRent.engineCapacity);
                System.out.println("Has Carrier: " + bikeToRent.hasCarrier);
                System.out.println("Daily rental Price: $" + bikeToRent.dailyPrice);
                System.out.print("Enter the number of days you want to rent the bike: ");
                int days = sc.nextInt();
                sc.nextLine();
                balanceBike += (bikeToRent.dailyPrice * days); // Calculate the total rental cost
                System.out.print("Enter the bike card number to confirm the rental: ");
                int cardNumber = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    db.displayCompanyList();
                    System.out.println("enter your company commercial number :");
                    int companyCommercialNumber = sc.nextInt();
                    sc.nextLine();
                    for (Company com : db.companyList) {
                        if (com.commercialNumber == companyCommercialNumber) {
                            company = com;
                            break;
                        }
                    }
                    company.companyBalance = company.companyBalance - balanceBike; // Deduct the total rental cost from
                                                                                   // the company's balance
                    if (cardNumber == bikeToRent.cardNumber && company.companyBalance >= 0) {
                        bikeToRent.available = false; // Mark the bike as rented
                        System.out.println("Bike rented successfully!");
                        System.out.println("Total rental cost: $" + balanceBike);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Brand: " + bikeToRent.brand);
                        System.out.println("Model: " + bikeToRent.model);
                        System.out.println("Year: " + bikeToRent.year);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        double fine = Database.RentalAgreement(companyCommercialNumber, days, 1)
                                * (bikeToRent.dailyPrice * 10 / 100);
                        System.out.println("Fine for late return: $" + fine);
                        company.companyBalance -= fine; // Deduct the fine from the company's balance
                        System.out.println("Remaining balance after fine: $" + company.companyBalance);
                        db.add_contract(bikeToRent.available, "bike", bikeToRent.model, bikeToRent.purchasePrice, "",
                                fine, company.companyName);
                    } else if (company.companyBalance < 0) {
                        System.out.println("Insufficient balance. Rental failed.");
                    } else {
                        System.out.println("Invalid card number. Rental failed.");
                    }
                } else if (choice == 2) {

                    db.displayIndividualList();
                    System.out.println("enter your id :");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    for (Individual ind : db.indivuallist) {
                        if (ind.id == userId) {
                            individual = ind;
                            break;
                        }
                    }
                    individual.balance -= balanceBike;
                    if (cardNumber == bikeToRent.cardNumber && individual.balance >= 0) {
                        bikeToRent.available = false; // Mark the bike as rented
                        System.out.println("Bike rented successfully!");
                        System.out.println("Total rental cost: $" + balanceBike);
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------");
                        System.out.println("Brand: " + bikeToRent.brand);
                        System.out.println("Model: " + bikeToRent.model);
                        System.out.println("Year: " + bikeToRent.year);
                        System.out.println(
                                "---------------------------------------------------------------------------------------------------------------");
                        double fine = Database.RentalAgreement(userId, days, 2) * (bikeToRent.dailyPrice * 10 / 100);
                        System.out.println("Fine for late return: $" + fine);
                        individual.balance -= fine; // Deduct the fine from the customer's balance
                        System.out.println("Remaining balance after fine: $" + individual.balance);
                        db.add_contract(bikeToRent.available, "bike", bikeToRent.model, bikeToRent.purchasePrice,
                                individual.firstname, fine, "");
                    } else if (individual.balance < 0) {
                        System.out.println("Insufficient balance. Rental failed.");
                    } else {
                        System.out.println("Invalid card number. Rental failed.");
                    }
                } else {
                    System.out.println("Bike is not available for rent.");
                }
            } else {
                System.out.println("Bike not found.");
            }
        }
    }

    @Override
    public void buyVehicle(int choice) {
        // Implementation for buying a bike
        System.out.println("Enter the ID of the bike you want to buy: ");
        int bikeId = sc.nextInt();
        sc.nextLine();
        Bikes bikeToBuy = db.findBikeById(bikeId);
        if (bikeToBuy != null) {
            System.out.println("Bike details:");
            System.out.println("Brand: " + bikeToBuy.brand);
            System.out.println("Model: " + bikeToBuy.model);
            System.out.println("Year: " + bikeToBuy.year);
            System.out.println("Color: " + bikeToBuy.color);
            System.out.println("Engine Capacity: " + bikeToBuy.engineCapacity);
            System.out.println("Has Carrier: " + bikeToBuy.hasCarrier);
            System.out.println("Purchase Price: $" + bikeToBuy.purchasePrice);
            balanceBike += bikeToBuy.purchasePrice;
            System.out.print("Enter the bike card number to confirm the purchase: ");
            int cardNumber = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                db.displayCompanyList();
                System.out.println("enter your company commercial number :");
                int companyCommercialNumber = sc.nextInt();
                sc.nextLine();
                for (Company com : db.companyList) {
                    if (com.commercialNumber == companyCommercialNumber) {
                        company = com;
                        break;
                    }
                }
                company.companyBalance = company.companyBalance - (balanceBike - balanceBike * 5 / 100);
                if (cardNumber == bikeToBuy.cardNumber && company.companyBalance >= 0) {
                    bikeToBuy.available = false; // Mark the bike as sold
                    System.out.println("--------------------------------------------");
                    System.out.println("Bike purchased successfully!");
                    System.out.println("you will get 5% discount on the purchase price");
                    System.out.println("Total purchase cost: $" + (balanceBike - balanceBike * 5 / 100));
                    System.out.println("Remaining company balance: $" + company.companyBalance);
                    System.out.println("--------------------------------------------");
                    db.removeBikeById(bikeId);
                    db.displayBikeList();
                    db.add_contract(bikeToBuy.available, "bike", bikeToBuy.model, bikeToBuy.purchasePrice, "", 0,
                            company.companyName);
                } else if (company.companyBalance < 0) {
                    System.out.println("Insufficient balance. Purchase failed.");
                } else {
                    System.out.println("Invalid card number. Purchase failed.");
                }
            } else if (choice == 2) {
                db.displayIndividualList();
                System.out.println("enter your id :");
                int userId = sc.nextInt();
                sc.nextLine();
                for (Individual ind : db.indivuallist) {
                    if (ind.id == userId) {
                        individual = ind;
                        break;
                    }
                }
                individual.balance = individual.balance - (balanceBike + balanceBike * 5 / 100);
                if (cardNumber == bikeToBuy.cardNumber && individual.balance >= 0) {
                    System.out.println("--------------------------------------------");
                    System.out.println("Bike purchased successfully!");
                    System.out.println("Total purchase cost: $" + (balanceBike + balanceBike * 5 / 100));
                    System.out.println("Remaining balance: $" + individual.balance);
                    System.out.println("--------------------------------------------");
                    db.removeBikeById(bikeId);
                    db.displayBikeList();
                    db.add_contract(bikeToBuy.available, "bike", bikeToBuy.model, bikeToBuy.purchasePrice,
                            individual.firstname, 0, "");
                } else if (individual.balance < 0) {
                    System.out.println("Insufficient balance. Purchase failed.");
                } else {
                    System.out.println("Invalid card number. Purchase failed.");
                }
            }
        } else {
            System.out.println("Bike not found.");
        }

    }

    @Override
    public void addVehicle() {
        // Implementation for adding a bike to the bike list
        System.out.print("Enter the brand of the bike: ");
        String brand = sc.nextLine();
        System.out.print("Enter the model of the bike: ");
        String model = sc.nextLine();
        System.out.print("Enter the year of the bike: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the daily price of the bike: ");
        double dailyPrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the purchase price of the bike: ");
        double purchasePrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the color of the bike: ");
        String color = sc.nextLine();
        System.out.print("Enter the card number associated with the bike: ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the engine capacity of the bike: ");
        double engineCapacity = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter whether the bike has a carrier (true/false): ");
        boolean hasCarrier = sc.nextBoolean();
        sc.nextLine();
        Bikes newBike = new Bikes(brand, model, year, dailyPrice, purchasePrice, color, true, cardNumber,
                rand.nextInt(10000), engineCapacity, hasCarrier);
        db.addBike(newBike);
        System.out.println("Bike added successfully!");
        db.displayBikeList();
    }

    @Override
    public void removeVehicle() {
        // Implementation for removing a bike from the bike list
        System.out.print("Enter the ID of the bike you want to remove: ");
        int bikeId = sc.nextInt();
        sc.nextLine();
        Bikes removedBike = db.removeBikeById(bikeId);
        if (removedBike != null) {
            System.out.println("Bike removed successfully!");
        } else {
            System.out.println("Bike not found.");
        }
    }

    @Override
    public void searchVehicleByCardNumber() {
        // Implementation for searching a bike in the bike list
        System.out.print("Enter the card number to search for: ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        Bikes foundBike = db.findBikeByCardNumber(cardNumber);
        if (foundBike != null) {
            System.out.println("Bike found:");
            System.out.println("Brand: " + foundBike.brand);
            System.out.println("Model: " + foundBike.model);
            System.out.println("Year: " + foundBike.year);
            System.out.println("Color: " + foundBike.color);
            System.out.println("Purchase Price: $" + foundBike.purchasePrice);
            System.out.println("Daily Price: $" + foundBike.dailyPrice);
            System.out.println("Engine Capacity: " + foundBike.engineCapacity);
            System.out.println("Has Carrier: " + foundBike.hasCarrier);
            System.out.println("ID: " + foundBike.id);
            System.out.println();
        } else {
            System.out.println("Bike not found.");
        }
    }

}
