import java.util.Scanner;
import java.util.Random;

public class Car extends Vehicle {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Database db = new Database();
    Individual individual = new Individual("", "", "", "", "", "", 0, 0, 0, "", "", 0);
    Company company = new Company("", "", "", 0, 0, "", 0);

    double balanceCar = 0;

    String fuelType;
    boolean airConditioning;
    int seatingCapacity;

    public Car(String brand, String model, int year, double dailyPrice, double purchasePrice, String color,
            boolean available, long cardNumber, int id, String fuelType, boolean airConditioning, int seatingCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.purchasePrice = purchasePrice;
        this.color = color;
        this.available = available;
        this.cardNumber = (int) cardNumber;
        this.id = rand.nextInt(10000);
        this.fuelType = fuelType;
        this.airConditioning = airConditioning;
        this.seatingCapacity = seatingCapacity;

    }

    @Override
    public void displayAllVehicles() {
        // Implementation for displaying all cars
        db.displayCarList();
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void rentVehicle(int choice) {
        // Implementation for renting a car

        System.out.print("Enter the ID of the car you want to rent: ");
        int carId = sc.nextInt();
        sc.nextLine();
        Car carToRent = db.findCarById(carId);
        if (carToRent != null) {
            if (carToRent.available) {
                System.out.println("Car details:");
                System.out.println("Brand: " + carToRent.brand);
                System.out.println("Model: " + carToRent.model);
                System.out.println("Year: " + carToRent.year);
                System.out.println("Color: " + carToRent.color);
                System.out.println("Fuel Type: " + carToRent.fuelType);
                System.out.println("Air Conditioning: " + carToRent.airConditioning);
                System.out.println("Seating Capacity: " + carToRent.seatingCapacity);
                System.out.println("Daily rental Price: $" + carToRent.dailyPrice);
                System.out.println("enter the number of days you want to rent the car: ");
                int days = sc.nextInt();
                sc.nextLine();
                balanceCar += (carToRent.dailyPrice * days);
                System.out.print("Enter the car card number to confirm the rental: ");
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
                    company.companyBalance -= balanceCar; // Deduct the purchase price from the company's balance
                    if (cardNumber == carToRent.cardNumber && company.companyBalance >= 0) {
                        carToRent.available = false; // Mark the car as rented
                        System.out.println("Car rented successfully!");
                        System.out.println("Total rental cost: $" + balanceCar);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Brand: " + carToRent.brand);
                        System.out.println("Model: " + carToRent.model);
                        System.out.println("Year: " + carToRent.year);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        double fine = Database.RentalAgreement(companyCommercialNumber, days, 1)
                                * (carToRent.dailyPrice * 10 / 100);
                        System.out.println("Fine for late return: $" + fine);
                        company.companyBalance -= fine; // Deduct the fine from the company's balance
                        System.out.println("Remaining balance after fine: $" + company.companyBalance);
                        db.add_contract(carToRent.available, "car", carToRent.model, carToRent.purchasePrice, "", fine,
                                company.companyName);
                    } else if (company.companyBalance < 0) {
                        System.out.println("Insufficient balance. Rental failed.");
                    } else {
                        System.out.println("Invalid card number. Rental failed.");
                    }
                } else if (choice == 2) {
                    db.displayIndividualList();
                    System.out.println("enter your id :");
                    int userId = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    for (Individual ind : db.indivuallist) {
                        if (ind.id == userId) {
                            individual = ind;
                            break;
                        }
                    }
                    individual.balance -= balanceCar; // Deduct the rental cost from the customer's balance
                    if (cardNumber == carToRent.cardNumber && individual.balance >= 0) {
                        carToRent.available = false; // Mark the car as rented
                        System.out.println("Car rented successfully!");
                        System.out.println("Total rental cost: $" + balanceCar);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Brand: " + carToRent.brand);
                        System.out.println("Model: " + carToRent.model);
                        System.out.println("Year: " + carToRent.year);
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------");
                        double fine = Database.RentalAgreement(userId, days, 2) * (carToRent.dailyPrice * 10 / 100);
                        System.out.println("Fine for late return: $" + fine);
                        individual.balance -= fine; // Deduct the fine from the customer's balance
                        System.out.println("Remaining balance after fine: $" + individual.balance);
                        db.add_contract(carToRent.available, "car", carToRent.model, carToRent.purchasePrice,
                                individual.firstname, fine, "");
                    } else if (individual.balance < 0) {
                        System.out.println("Insufficient balance. Rental failed.");
                    } else {
                        System.out.println("Invalid card number. Rental failed.");
                    }
                }
            } else {
                System.out.println("Car is not available for rent.");
            }

        } else {
            System.out.println("Car not found.");
        }
    }

    @Override
    public void buyVehicle(int choice) {
        // Implementation for buying a car
        System.out.println("Enter the ID of the car you want to buy: ");
        int carId = sc.nextInt();
        sc.nextLine();
        Car carToBuy = db.findCarById(carId);
        if (carToBuy != null) {
            System.out.println("Car details:");
            System.out.println("Brand: " + carToBuy.brand);
            System.out.println("Model: " + carToBuy.model);
            System.out.println("Year: " + carToBuy.year);
            System.out.println("Color: " + carToBuy.color);
            System.out.println("Fuel Type: " + carToBuy.fuelType);
            System.out.println("Air Conditioning: " + carToBuy.airConditioning);
            System.out.println("Seating Capacity: " + carToBuy.seatingCapacity);
            System.out.println("Purchase Price: $" + carToBuy.purchasePrice);
            balanceCar += carToBuy.purchasePrice;
            System.out.print("Enter the car card number to confirm the purchase: ");
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
                company.companyBalance = company.companyBalance - (balanceCar - balanceCar * 10 / 100);
                if (cardNumber == carToBuy.cardNumber && company.companyBalance >= 0) {
                    carToBuy.available = false; // Mark the car as sold
                    System.out.println("--------------------------------------------");
                    System.out.println("Car purchased successfully!");
                    System.out.println("you will get 10% discount on the price");
                    System.out.println("Total purchase cost: $" + (balanceCar - balanceCar * 10 / 100));
                    System.out.println("Remaining company balance: $" + company.companyBalance);
                    System.out.println("--------------------------------------------");
                    db.removeCarById(carId);
                    db.displayCarList();
                    db.add_contract(carToBuy.available, "car", carToBuy.model, carToBuy.purchasePrice, "", 0,
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
                individual.balance = individual.balance - (balanceCar + balanceCar * 10 / 100);
                if (cardNumber == carToBuy.cardNumber && individual.balance >= 0) {
                    carToBuy.available = false; // Mark the car as sold
                    System.out.println("--------------------------------------------");
                    System.out.println("Car purchased successfully!");
                    System.out.println("Total purchase cost: $" + (balanceCar + balanceCar * 10 / 100));
                    System.out.println("Remaining balance: $" + individual.balance);
                    System.out.println("--------------------------------------------");
                    db.removeCarById(carId);
                    db.displayCarList();
                    db.add_contract(carToBuy.available, "car", carToBuy.model, carToBuy.purchasePrice,
                            individual.firstname, 0, "");

                } else if (individual.balance < 0) {
                    System.out.println("Insufficient balance. Purchase failed.");
                } else {
                    System.out.println("Invalid card number. Purchase failed.");
                }
            }
        } else {
            System.out.println("Car not found.");
        }

    }

    @Override
    public void addVehicle() {
        // Implementation for adding a car to the car list
        System.out.print("Enter the brand of the car: ");
        String brand = sc.nextLine();
        System.out.print("Enter the model of the car: ");
        String model = sc.nextLine();
        System.out.print("Enter the year of the car: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the daily price of the car: ");
        double dailyPrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the purchase price of the car: ");
        double purchasePrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the color of the car: ");
        String color = sc.nextLine();
        System.out.print("Enter the card number associated with the car: ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the fuel type of the car: ");
        String fuelType = sc.nextLine();
        System.out.print("Does the car have air conditioning? (true/false): ");
        boolean airConditioning = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Enter the seating capacity of the car: ");
        int seatingCapacity = sc.nextInt();
        sc.nextLine();
        Car newCar = new Car(brand, model, year, dailyPrice, purchasePrice, color, true, cardNumber,
                rand.nextInt(10000), fuelType, airConditioning, seatingCapacity);
        db.addCar(newCar);
        System.out.println("Car added successfully!");
        db.displayCarList();
    }

    @Override
    public void removeVehicle() {
        // Implementation for removing a car from the car list
        System.out.print("Enter the ID of the car you want to remove: ");
        int carId = sc.nextInt();
        sc.nextLine();
        Car removedCar = db.removeCarById(carId);
        if (removedCar != null) {
            System.out.println("Car removed successfully!");
        } else {
            System.out.println("Car not found.");
        }

    }

    @Override
    public void searchVehicleByCardNumber() {
        // Implementation for searching a car in the car list
        System.out.print("Enter the card number to search for: ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        Car foundCar = db.findCarByCardNumber(cardNumber);
        if (foundCar != null) {
            System.out.println("Car found:");
            System.out.println("Brand: " + foundCar.brand);
            System.out.println("Model: " + foundCar.model);
            System.out.println("Year: " + foundCar.year);
            System.out.println("Color: " + foundCar.color);
            System.out.println("Purchase Price: $" + foundCar.purchasePrice);
            System.out.println("Daily Price: $" + foundCar.dailyPrice);
            System.out.println("Fuel Type: " + foundCar.fuelType);
            System.out.println("Air Conditioning: " + foundCar.airConditioning);
            System.out.println("Seating Capacity: " + foundCar.seatingCapacity);
            System.out.println("ID: " + foundCar.id);
            System.out.println();
        } else {
            System.out.println("Car not found.");
        }
    }
}
