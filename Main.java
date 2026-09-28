import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Vehicle car = new Car("", "", 0, 0, 0, "", false, 0, 0, "", false, 0);
        Vehicle bikes = new Bikes("", "", 0, 0, 0, "", false, 0, 0, 0, false);
        Vehicle truck = new Truck("", "", 0, 0, 0, "", false, 0, 0, 0, false);
        Customer individual = new Individual("", "", "", "", "", "", 0, 0, 0, "", "", 0);
        Company company = new Company("", "", "", 0, 0, "", 0);
        Contracts contract = new Contracts(false, null, null, 0, "", "", "", 0.0, "");

        // SMART VEHICLE RENTAL AND SELLER SYSTEM
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to the Smart Vehicle Rental and Seller System!");
        int roleChoice = 0;
        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("enter your acount type (Enter 1 for company, 2 for personal)");
        int acount_Type = 0;
        acount_Type = sc.nextInt();
        if (acount_Type == 1) {
            System.out.println("Enter 1 for signing in and 2 for signing up : ");
            int company_acount_choice = 0;
            company_acount_choice = sc.nextInt();
            if (company_acount_choice == 1) {
                System.out.println("Enter your company name : ");
                String company_name = sc.next();
                Database.find_company_by_name(company_name);
            } else {
                company.add();
            }
            System.out.println();
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        } else if (acount_Type == 2) {
            System.out.println("Enter 1 for signing in and 2 for signing up : ");
            int personal_acount_choice = 0;
            personal_acount_choice = sc.nextInt();
            if (personal_acount_choice == 1) {
                System.out.println("Enter your first name : ");
                String perssonal_first_name = sc.next();
                System.out.println("Enter your last name : ");
                String perssonal_last_name = sc.next();
                Database.find_individual_by_first_and_last_name(perssonal_first_name, perssonal_last_name);
            } else {
                individual.add();
            }
            System.out.println();
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println();

        }

        boolean running = true;
        while (running) {
            System.out.println(
                    "----------------------------------------------------------------------------------------------");
            System.out.println("Please select your role:");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Customer management");
            System.out.println("4. Company management");
            System.out.println("5. Exit");
            try {
                roleChoice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, 3, or 4).");
                sc.next();
                continue;
            }
            if (roleChoice == 1) {
                System.out.println(
                        "Do you present a company account or a personal account? (Enter 1 for company, 2 for personal)");
                System.out.println("1. Company Account");
                System.out.println("2. Personal Account");
                int accountTypeChoice = 0;
                try {
                    accountTypeChoice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (1 or 2).");
                    sc.next();
                    continue;
                }
                if (accountTypeChoice == 1) {
                    System.out.println("Company account selected.");

                    System.out.println(
                            "do you want to see the cars or the trucks or the bikes? (Enter 1 for cars, 2 for trucks, 3 for bikes)");
                    System.out.println("1. Cars");
                    System.out.println("2. Trucks");
                    System.out.println("3. Bikes");
                    int vehicleTypeChoice = 0;
                    try {
                        vehicleTypeChoice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        sc.next();
                        continue;
                    }
                    if (vehicleTypeChoice == 1) {
                        System.out.println("Cars selected.");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        Database.displayCarList();
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "Do you want to rent or buy a car or search for a car? (Enter 1 for rent, 2 for buy, 3 for search)");
                        System.out.println("1. Rent a car");
                        System.out.println("2. Buy a car");
                        System.out.println("3. Search for a car");
                        int rentOrBuyChoice = 0;
                        try {
                            rentOrBuyChoice = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            sc.next();
                            continue;
                        }
                        if (rentOrBuyChoice == 1) {
                            System.out.println("Rent a car selected.");
                            car.rentVehicle(1);
                        } else if (rentOrBuyChoice == 2) {
                            System.out.println("Buy a car selected.");
                            car.buyVehicle(1);
                        } else if (rentOrBuyChoice == 3) {
                            System.out.println("Search for a car selected.");
                            car.searchVehicleByCardNumber();
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        }
                    } else if (vehicleTypeChoice == 2) {
                        System.out.println("Trucks selected.");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        Database.displayTruckList();
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "Do you want to rent or buy a truck or search for a truck? (Enter 1 for rent, 2 for buy, 3 for search)");
                        System.out.println("1. Rent a truck");
                        System.out.println("2. Buy a truck");
                        System.out.println("3. Search for a truck");
                        int rentOrBuyChoice = 0;
                        try {
                            rentOrBuyChoice = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            sc.next();
                            continue;
                        }
                        if (rentOrBuyChoice == 1) {
                            System.out.println("Rent a truck selected.");
                            truck.rentVehicle(1);
                        } else if (rentOrBuyChoice == 2) {
                            System.out.println("Buy a truck selected.");
                            truck.buyVehicle(1);
                        } else if (rentOrBuyChoice == 3) {
                            System.out.println("Search for a truck selected.");
                            truck.searchVehicleByCardNumber();
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        }
                    } else if (vehicleTypeChoice == 3) {
                        System.out.println("Bikes selected.");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        Database.displayBikeList();
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "Do you want to rent or buy a bike or search for a bike? (Enter 1 for rent, 2 for buy, 3 for search)");
                        System.out.println("1. Rent a bike");
                        System.out.println("2. Buy a bike");
                        System.out.println("3. Search for a bike");
                        int rentOrBuyChoice = 0;
                        try {
                            rentOrBuyChoice = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            sc.next();
                            continue;
                        }
                        if (rentOrBuyChoice == 1) {
                            System.out.println("Rent a bike selected.");
                            bikes.rentVehicle(1);
                        } else if (rentOrBuyChoice == 2) {
                            System.out.println("Buy a bike selected.");
                            bikes.buyVehicle(1);
                        } else if (rentOrBuyChoice == 3) {
                            System.out.println("Search for a bike selected.");
                            bikes.searchVehicleByCardNumber();
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                    }
                } else if (accountTypeChoice == 2) {
                    System.out.println("Personal account selected.");

                    System.out.println(
                            "do you want to see the cars or the trucks or the bikes? (Enter 1 for cars, 2 for trucks, 3 for bikes)");
                    System.out.println("1. Cars");
                    System.out.println("2. Trucks");
                    System.out.println("3. Bikes");
                    int vehicleTypeChoice = 0;
                    try {
                        vehicleTypeChoice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        sc.next();
                        continue;
                    }
                    if (vehicleTypeChoice == 1) {
                        System.out.println("Cars selected.");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        Database.displayCarList();
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "Do you want to rent or buy a car or search for a car? (Enter 1 for rent, 2 for buy, 3 for search)");
                        System.out.println("1. Rent a car");
                        System.out.println("2. Buy a car");
                        System.out.println("3. Search for a car");
                        int rentOrBuyChoice = 0;
                        try {
                            rentOrBuyChoice = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            sc.next();
                            continue;
                        }
                        if (rentOrBuyChoice == 1) {
                            System.out.println("Rent a car selected.");
                            car.rentVehicle(2);
                        } else if (rentOrBuyChoice == 2) {
                            System.out.println("Buy a car selected.");
                            car.buyVehicle(2);
                            Database.displayCarList();
                        } else if (rentOrBuyChoice == 3) {
                            System.out.println("Search for a car selected.");
                            car.searchVehicleByCardNumber();
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        }
                    } else if (vehicleTypeChoice == 2) {
                        System.out.println("Trucks selected.");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        Database.displayTruckList();
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "Do you want to rent or buy a truck or search for a truck? (Enter 1 for rent, 2 for buy, 3 for search)");
                        System.out.println("1. Rent a truck");
                        System.out.println("2. Buy a truck");
                        System.out.println("3. Search for a truck");
                        int rentOrBuyChoice = 0;
                        try {
                            rentOrBuyChoice = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            sc.next();
                            continue;
                        }
                        if (rentOrBuyChoice == 1) {
                            System.out.println("Rent a truck selected.");
                            truck.rentVehicle(2);
                        } else if (rentOrBuyChoice == 2) {
                            System.out.println("Buy a truck selected.");
                            truck.buyVehicle(2);
                        } else if (rentOrBuyChoice == 3) {
                            System.out.println("Search for a truck selected.");
                            truck.searchVehicleByCardNumber();
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        }
                    } else if (vehicleTypeChoice == 3) {
                        System.out.println("Bikes selected.");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        Database.displayBikeList();
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "Do you want to rent or buy a bike or search for a bike? (Enter 1 for rent, 2 for buy, 3 for search)");
                        System.out.println("1. Rent a bike");
                        System.out.println("2. Buy a bike");
                        System.out.println("3. Search for a bike");
                        int rentOrBuyChoice = 0;
                        try {
                            rentOrBuyChoice = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            sc.next();
                            continue;
                        }
                        if (rentOrBuyChoice == 1) {
                            System.out.println("Rent a bike selected.");
                            bikes.rentVehicle(2);
                        } else if (rentOrBuyChoice == 2) {
                            System.out.println("Buy a bike selected.");
                            bikes.buyVehicle(2);
                        } else if (rentOrBuyChoice == 3) {
                            System.out.println("Search for a bike selected.");
                            bikes.searchVehicleByCardNumber();
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number (1 or 2).");
                }
            } else if (roleChoice == 2) {
                System.out.println("Admin account selected.");
                System.out.println("1. Add a new vehicle");
                System.out.println("2. Remove an existing vehicle");
                System.out.println("3. Display all contracts");
                System.out.println("4. find active and expired contracts");
                System.out.println("5. Search for a contract by customer name");
                System.out.println("6. Search for a contract by vehicle name");
                System.out.println("7. Find the most contracted vehicle");
                System.out.println("8. Find VIP customer");
                System.out.println("9. Find contract with late fee");
                System.out.println("10. Display all contracts with company");
                System.out.println("11. Find active and expired contracts by company");
                System.out.println("12. Total revenue ");
                int adminActionChoice = 0;
                try {
                    adminActionChoice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (1 or 2).");
                    sc.next();
                    continue;
                }
                if (adminActionChoice == 1) {
                    System.out.println("Add a new vehicle selected.");
                    System.out.println(
                            "what kind of vehicle do you want to add? (Enter 1 for car, 2 for truck, 3 for bike)");
                    System.out.println("1. Car");
                    System.out.println("2. Truck");
                    System.out.println("3. Bike");
                    int vehicleTypeChoice = 0;
                    try {
                        vehicleTypeChoice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        sc.next();
                        continue;
                    }
                    if (vehicleTypeChoice == 1) {
                        System.out.println("Car selected.");
                        car.addVehicle();
                        Database.displayCarList();
                    } else if (vehicleTypeChoice == 2) {
                        System.out.println("Truck selected.");
                        truck.addVehicle();
                        Database.displayTruckList();
                    } else if (vehicleTypeChoice == 3) {
                        System.out.println("Bike selected.");
                        bikes.addVehicle();
                        Database.displayBikeList();
                    } else {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                    }
                } else if (adminActionChoice == 2) {
                    System.out.println("Remove an existing vehicle selected.");
                    System.out.println(
                            "what kind of vehicle do you want to remove? (Enter 1 for car, 2 for truck, 3 for bike)");
                    System.out.println("1. Car");
                    System.out.println("2. Truck");
                    System.out.println("3. Bike");
                    int vehicleTypeChoice = 0;
                    try {
                        vehicleTypeChoice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        sc.next();
                        continue;
                    }
                    if (vehicleTypeChoice == 1) {
                        System.out.println("Car selected.");
                        Database.displayCarList();
                        car.removeVehicle();
                        Database.displayCarList();
                    } else if (vehicleTypeChoice == 2) {
                        System.out.println("Truck selected.");
                        Database.displayTruckList();
                        truck.removeVehicle();
                        Database.displayTruckList();
                    } else if (vehicleTypeChoice == 3) {
                        System.out.println("Bike selected.");
                        Database.displayBikeList();
                        bikes.removeVehicle();
                        Database.displayBikeList();
                    } else {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                    }
                } else if (adminActionChoice == 3) {
                    System.out.println("Display all contracts selected.");
                    contract.displayContracts();
                } else if (adminActionChoice == 4) {
                    System.out.println("find active and expired contracts selected.");
                    contract.find_active_expired_contracts();
                } else if (adminActionChoice == 5) {
                    System.out.println("Search for a contract by customer name selected.");
                    contract.findContractsByCustomer();
                } else if (adminActionChoice == 6) {
                    System.out.println("Search for a contract by vehicle name selected.");
                    contract.findContractsByVehicle();
                } else if (adminActionChoice == 7) {
                    System.out.println("Find the most contracted vehicle selected.");
                    contract.findMostContractedVehicle();
                } else if (adminActionChoice == 8) {
                    System.out.println("Find  vip customer .");
                    contract.find_VIP_customers();
                } else if (adminActionChoice == 9) {
                    System.out.println("Find contract with late fee selected.");
                    contract.find_Contracts_with_Late_Fees();
                } else if (adminActionChoice == 10) {
                    System.out.println("Find active contracts by company selected.");
                    contract.find_active_expired_contracts();
                } else if (adminActionChoice == 11) {
                    System.out.println("Find active and expired contracts by company selected.");
                    contract.find_active_expired_contracts_by_company();
                } else if (adminActionChoice == 12) {
                    contract.total_revenues();
                } else {
                    System.out.println("Invalid input. Please enter a number (1 to 11).");
                }
            } else if (roleChoice == 3) {
                System.out.println("Customer menu selected.");
                System.out.println("choose what do you want :");
                System.out.println("1. Search for a customer");
                System.out.println("2. Edit a customer");
                System.out.println("3. Display all customers");
                System.out.println("4. Add a new customer");
                int customerMenuChoice = 0;
                try {
                    customerMenuChoice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (1, 2, 3, or 4).");
                    sc.next();
                    continue;
                }
                if (customerMenuChoice == 1) {
                    System.out.println("Search for a customer selected.");
                    individual.search();
                    individual.search();
                } else if (customerMenuChoice == 2) {
                    System.out.println("Edit a customer selected.");
                    individual.edit();
                } else if (customerMenuChoice == 3) {
                    System.out.println("Display all customers selected.");
                    individual.displayAll();
                } else if (customerMenuChoice == 4) {
                    System.out.println("Add a new customer selected.");
                    individual.add();
                } else {
                    System.out.println("Invalid input. Please enter a number (1, 2, 3, or 4).");
                }
            } else if (roleChoice == 4) {
                System.out.println("Company management selected.");
                System.out.println("choose what do you want :");
                System.out.println("1. Search for a company");
                System.out.println("2. Edit a company");
                System.out.println("3. Display all companies");
                System.out.println("4. Add a new company");
                int companyMenuChoice = 0;
                try {
                    companyMenuChoice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (1, 2, 3, or 4).");
                    sc.next();
                    continue;
                }
                if (companyMenuChoice == 1) {
                    System.out.println("Search for a company selected.");
                    company.search();
                } else if (companyMenuChoice == 2) {
                    System.out.println("Edit a company selected.");
                    company.edit();
                } else if (companyMenuChoice == 3) {
                    System.out.println("Display all companies selected.");
                    company.displayAll();
                } else if (companyMenuChoice == 4) {
                    System.out.println("Add a new company selected.");
                    company.add();
                } else {
                    System.out.println("Invalid input. Please enter a number (1, 2, 3, or 4).");
                }
            } else if (roleChoice == 5) {
                running = false;
            } else {
                System.out.println("Invalid input. Please enter a number (1, 2, 3, or 4).");
            }
        }

    }
}