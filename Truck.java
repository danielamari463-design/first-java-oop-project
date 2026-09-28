import java.util.Scanner;
import java.util.Random;

public class Truck extends Vehicle {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Database db = new Database();
    Individual individual = new Individual("", "", "", "", "", "", 0, 0, 0, "", "", 0);
    Company company = new Company("", "", "", 0, 0, "", 0);

    double balanceTruck = 0;
    double loadCapacity;
    boolean airConditioning;

    public Truck(String brand, String model, int year, double dailyPrice, double purchasePrice, String color,
            boolean available, int cardNumber, int id, double loadCapacity, boolean airConditioning) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.purchasePrice = purchasePrice;
        this.color = color;
        this.available = available;
        this.cardNumber = (int) cardNumber;
        this.id = rand.nextInt(10000);
        this.loadCapacity = loadCapacity;
        this.airConditioning = airConditioning;

    }

    @Override
    public void displayAllVehicles() {
        // Implementation for displaying all trucks
    }

    @Override
    public void rentVehicle(int choice) {
        // Implementation for renting a truck
        System.out.println("Enter the ID of the truck you want to rent: ");
        int truckId = sc.nextInt();
        sc.nextLine();
        Truck truckToRent = db.findTruckById(truckId);
        if (truckToRent != null) {
            if (truckToRent.available) {
                System.out.println("Truck details:");
                System.out.println("Brand: " + truckToRent.brand);
                System.out.println("Model: " + truckToRent.model);
                System.out.println("Year: " + truckToRent.year);
                System.out.println("Color: " + truckToRent.color);
                System.out.println("Load Capacity: " + truckToRent.loadCapacity);
                System.out.println("Air conditioning: " + truckToRent.airConditioning);
                System.out.println("Daily rental Price: $" + truckToRent.dailyPrice);
                System.out.print("Enter the number of days you want to rent the truck: ");
                int days = sc.nextInt();
                sc.nextLine();
                balanceTruck += (truckToRent.dailyPrice * days);
                System.out.print("Enter the truck card number to confirm the rental: ");
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
                    company.companyBalance -= balanceTruck; // Deduct the purchase price from the company's balance
                    if (cardNumber == truckToRent.cardNumber && company.companyBalance >= 0) {
                        truckToRent.available = false; // Mark the truck as rented
                        System.out.println("Truck rented successfully!");
                        System.out.println("Total rental cost: $" + balanceTruck);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Brand: " + truckToRent.brand);
                        System.out.println("Model: " + truckToRent.model);
                        System.out.println("Year: " + truckToRent.year);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        double fine = Database.RentalAgreement(companyCommercialNumber, days, 1)
                                * (truckToRent.dailyPrice * 10 / 100);
                        System.out.println("Fine for late return: $" + fine);
                        company.companyBalance -= fine; // Deduct the fine from the company's balance
                        System.out.println("Remaining balance after fine: $" + company.companyBalance);
                        db.add_contract(truckToRent.available, "truck", truckToRent.model, truckToRent.purchasePrice,
                                "", fine, company.companyName);
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
                    individual.balance -= balanceTruck; // Deduct the rental cost from the individual's balance
                    if (cardNumber == truckToRent.cardNumber && individual.balance >= 0) {
                        truckToRent.available = false; // Mark the truck as unavailable after renting
                        System.out.println("Truck rented successfully!");
                        System.out.println("Total rental cost: $" + balanceTruck);
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------");
                        System.out.println("Brand: " + truckToRent.brand);
                        System.out.println("Model: " + truckToRent.model);
                        System.out.println("Year: " + truckToRent.year);
                        System.out.println(
                                "---------------------------------------------------------------------------------------------------------------");
                        double fine = Database.RentalAgreement(userId, days, 2) * (truckToRent.dailyPrice * 10 / 100);
                        System.out.println("Fine for late return: $" + fine);
                        individual.balance -= fine; // Deduct the fine from the customer's balance
                        System.out.println("Remaining balance after fine: $" + individual.balance);
                        db.add_contract(truckToRent.available, "truck", truckToRent.model, truckToRent.purchasePrice,
                                individual.firstname, fine, "");
                    } else if (individual.balance < 0) {
                        System.out.println("Insufficient balance to rent the truck.");
                    } else {
                        System.out.println("Invalid card number. Rental failed.");
                    }
                } else {
                    System.out.println("Truck is not available for rent.");
                }
            } else {
                System.out.println("Truck not found.");
            }
        }
    }

    @Override
    public void buyVehicle(int choice) {
        // Implementation for buying a truck
        System.out.println("Enter the ID of the truck you want to buy: ");
        int truckId = sc.nextInt();
        sc.nextLine();
        Truck truckToBuy = db.findTruckById(truckId);
        if (truckToBuy != null) {
            System.out.println("Truck details:");
            System.out.println("Brand: " + truckToBuy.brand);
            System.out.println("Model: " + truckToBuy.model);
            System.out.println("Year: " + truckToBuy.year);
            System.out.println("Color: " + truckToBuy.color);
            System.out.println("Air Conditioning: " + truckToBuy.airConditioning);
            System.out.println("Load Capacity: " + truckToBuy.loadCapacity);
            System.out.println("Purchase Price: $" + truckToBuy.purchasePrice);
            balanceTruck += truckToBuy.purchasePrice; // Add the purchase price to the customer's balance
            System.out.print("Enter the truck card number to confirm the purchase: ");
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
                company.companyBalance = company.companyBalance - (balanceTruck - balanceTruck * 12 / 100);
                if (cardNumber == truckToBuy.cardNumber && company.companyBalance >= 0) {
                    truckToBuy.available = false; // Mark the truck as sold
                    System.out.println("--------------------------------------------");
                    System.out.println("Truck purchased successfully!");
                    System.out.println("you will get 12% discount on the purchase price");
                    System.out.println("Total purchase cost: $" + (balanceTruck - balanceTruck * 12 / 100));
                    System.out.println("Remaining company balance: $" + company.companyBalance);
                    System.out.println("--------------------------------------------");
                    db.removeTruckById(truckId);
                    db.displayTruckList();
                    db.add_contract(truckToBuy.available, "truck", truckToBuy.model, truckToBuy.purchasePrice, "", 0,
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
                individual.balance = individual.balance - (balanceTruck + balanceTruck * 12 / 100);
                if (cardNumber == truckToBuy.cardNumber && individual.balance >= 0) {
                    System.out.println("--------------------------------------------");
                    System.out.println("Truck purchased successfully!");
                    System.out.println("Total purchase cost: $" + (balanceTruck + balanceTruck * 12 / 100));
                    System.out.println("Remaining balance: $" + individual.balance);
                    System.out.println("--------------------------------------------");
                    db.removeTruckById(truckId);
                    db.displayTruckList();
                    db.add_contract(truckToBuy.available, "truck", truckToBuy.model, truckToBuy.purchasePrice,
                            individual.firstname, 0, "");
                } else if (individual.balance < 0) {
                    System.out.println("Insufficient balance. Purchase failed.");
                } else {
                    System.out.println("Invalid card number. Purchase failed.");
                }
            }
        } else {
            System.out.println("Truck not found.");
        }

    }

    @Override
    public void addVehicle() {
        // Implementation for adding a truck to the truck list
        System.out.print("Enter the brand of the truck: ");
        String brand = sc.nextLine();
        System.out.print("Enter the model of the truck: ");
        String model = sc.nextLine();
        System.out.print("Enter the year of the truck: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the daily price of the truck: ");
        double dailyPrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the purchase price of the truck: ");
        double purchasePrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the color of the truck: ");
        String color = sc.nextLine();
        System.out.print("Enter the card number associated with the truck: ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the load capacity of the truck: ");
        double loadCapacity = sc.nextDouble();
        sc.nextLine();
        System.out.print("Does the truck have air conditioning? (true/false): ");
        boolean airConditioning = sc.nextBoolean();
        sc.nextLine();
        Truck newTruck = new Truck(brand, model, year, dailyPrice, purchasePrice, color, true, cardNumber,
                rand.nextInt(10000), loadCapacity, airConditioning);
        db.addTruck(newTruck);
        System.out.println("Truck added successfully!");
        db.displayTruckList();
    }

    @Override
    public void removeVehicle() {
        // Implementation for removing a truck from the truck list
        System.out.print("Enter the ID of the truck you want to remove: ");
        int truckId = sc.nextInt();
        sc.nextLine();
        Truck removedTruck = db.removeTruckById(truckId);
        if (removedTruck != null) {
            System.out.println("Truck removed successfully!");
        } else {
            System.out.println("Truck not found.");
        }
    }

    @Override
    public void searchVehicleByCardNumber() {
        // Implementation for searching a truck in the truck list
        System.out.print("Enter the card number to search for: ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        Truck foundTruck = db.findTruckByCardNumber(cardNumber);
        if (foundTruck != null) {
            System.out.println("Truck found:");
            System.out.println("Brand: " + foundTruck.brand);
            System.out.println("Model: " + foundTruck.model);
            System.out.println("Year: " + foundTruck.year);
            System.out.println("Color: " + foundTruck.color);
            System.out.println("Purchase Price: $" + foundTruck.purchasePrice);
            System.out.println("Daily Price: $" + foundTruck.dailyPrice);
            System.out.println("Load Capacity: " + foundTruck.loadCapacity);
            System.out.println("Air Conditioning: " + foundTruck.airConditioning);
            System.out.println("ID: " + foundTruck.id);
            System.out.println();
        } else {
            System.out.println("Truck not found.");
        }
    }
}
