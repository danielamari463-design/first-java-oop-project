import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public static ArrayList<Car> carlist = new ArrayList<>();
    public static ArrayList<Truck> trucklist = new ArrayList<>();
    public static ArrayList<Bikes> bikelist = new ArrayList<>();
    public static ArrayList<Individual> indivuallist = new ArrayList<>();
    public static ArrayList<Company> companyList = new ArrayList<>();
    public static ArrayList<Contracts> contractList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static {

        // Cars : ( brand, model, year, daily price, purchase price, color,
        // availability, card number, id, fuel type, air conditioning, seating capacity)
        carlist.add(new Car("Toyota", "Camry", 2020, 50, 20000, "Red", true, 1111, 0, "Gasoline", true, 5));// 1
        carlist.add(new Car("Honda", "Civic", 2019, 40, 18000, "Blue", true, 2222, 1, "Diesel", true, 5));// 2
        carlist.add(new Car("Ford", "Mustang", 2021, 70, 30000, "Black", true, 3333, 2, "Gasoline", true, 5));// 3
        carlist.add(new Car("Chevrolet", "Impala", 2018, 45, 22000, "White", true, 4444, 3, "Diesel", true, 5));// 4
        carlist.add(new Car("Nissan", "Altima", 2020, 55, 25000, "Silver", true, 5555, 4, "Gasoline", true, 5));// 5
        carlist.add(new Car("BMW", "3 Series", 2021, 80, 35000, "Gray", true, 6666, 5, "Diesel", true, 5));// 6
        carlist.add(new Car("Mercedes-Benz", "C-Class", 2020, 90, 40000, "Black", true, 7777, 6, "electric", true, 5));// 7
        carlist.add(new Car("Audi", "A4", 2019, 75, 32000, "Blue", true, 8888, 7, "electric", true, 5));// 8
        carlist.add(new Car("Volkswagen", "Jetta", 2021, 65, 28000, "Red", true, 9999, 8, "Gasoline", true, 5));// 9
        carlist.add(new Car("Subaru", "Outback", 2020, 60, 26000, "White", true, 1010, 9, "Diesel", true, 5));// 10
        carlist.add(new Car("Mazda", "CX-5", 2019, 55, 24000, "Silver", true, 111111, 10, "Gasoline", true, 5));// 11
        carlist.add(new Car("Hyundai", "Elantra", 2021, 45, 20000, "Gray", true, 1212, 11, "Diesel", true, 5));// 12

        // Trucks : ( brand, model, year, daily price, purchase price,
        // color,availability, card number, id , load capacity, air conditioning)
        trucklist.add(new Truck("Ford", "F-150", 2020, 80, 30000, "Red", true, 1111, 12, 1000, true));// 1
        trucklist.add(new Truck("Chevrolet", "Silverado", 2019, 75, 28000, "Blue", true, 2222, 13, 1200, true));// 2
        trucklist.add(new Truck("Ram", "1500", 2021, 85, 32000, "Black", true, 3333, 14, 1400, true));// 3
        trucklist.add(new Truck("Toyota", "Tundra", 2020, 70, 25000, "White", true, 4444, 15, 1600, true));// 4
        trucklist.add(new Truck("Nissan", "Titan", 2019, 65, 24000, "Silver", true, 5555, 16, 1800, true));// 5
        trucklist.add(new Truck("GMC", "Sierra", 2021, 90, 35000, "Gray", true, 6666, 17, 2000, true));// 6
        trucklist.add(new Truck("Honda", "Ridgeline", 2020, 75, 28000, "Red", true, 7777, 18, 1400, true));// 7
        trucklist.add(new Truck("Volkswagen", "Amarok", 2019, 70, 26000, "Blue", true, 8888, 19, 1600, true));// 8
        trucklist.add(new Truck("Subaru", "Outback", 2021, 65, 24000, "White", true, 9999, 20, 1800, true));// 9
        trucklist.add(new Truck("Mazda", "BT-50", 2020, 60, 22000, "Silver", true, 1010, 21, 1200, true));// 10
        trucklist.add(new Truck("Hyundai", "Santa Cruz", 2019, 55, 20000, "Gray", true, 111111, 22, 1400, true));// 11
        trucklist.add(new Truck("Isuzu", "D-Max", 2021, 50, 18000, "Red", true, 1212, 23, 1600, true));// 12

        // Bikes : ( brand, model, year, daily price, purchase price,
        // color,availability, card number, id , engine capacity, has carrier)
        bikelist.add(new Bikes("Yamaha", "YZF-R3", 2020, 30, 5000, "Red", true, 1111, 23, 4, true));// 1
        bikelist.add(new Bikes("Kawasaki", "Ninja 400", 2019, 25, 4500, "Blue", true, 2222, 24, 4, true));// 2
        bikelist.add(new Bikes("Honda", "CBR500R", 2021, 35, 5500, "Black", true, 3333, 25, 5, true));// 3
        bikelist.add(new Bikes("Suzuki", "GSX250R", 2020, 20, 4000, "White", true, 4444, 26, 2.5, false));// 4
        bikelist.add(new Bikes("Ducati", "Monster 821", 2019, 40, 9000, "Red", true, 5555, 27, 8, true));// 5
        bikelist.add(new Bikes("BMW", "G 310 R", 2021, 30, 6000, "Gray", true, 6666, 28, 5, true));// 6
        bikelist.add(new Bikes("KTM", "RC 390", 2020, 25, 4500, "Red", true, 7777, 29, 5, true));// 7
        bikelist.add(new Bikes("Triumph", "Street Triple", 2019, 35, 7000, "Blue", true, 8888, 30, 6.6, true));// 8
        bikelist.add(new Bikes("Harley-Davidson", "Street 750", 2021, 40, 8000, "Black", true, 9999, 31, 7.5, true));// 9
        bikelist.add(new Bikes("Aprilia", "RS 660", 2020, 30, 6500, "White", true, 1010, 32, 6.6, true));// 10
        bikelist.add(new Bikes("Moto Guzzi", "V85 TT", 2019, 25, 5500, "Silver", true, 111111, 33, 8.5, true));// 11
        bikelist.add(new Bikes("Indian", "Scout Bobber", 2021, 35, 7500, "Gray", true, 1212, 34, 7.5, true));// 12

        // Individuals : ( first name, last name, address, phone number, email,
        // role, age, driver license number, id, account type, birthdate, balance)
        indivuallist.add(new Individual("Daniel", "Amari", "123 Main St", "123-456-7890", "Daniel.doe@example.com",
                "customer", 25, 123456789, 1, "standard", "1998-01-01", 100000.0));// 1
        indivuallist.add(new Individual("Jane", "Smith", "456 Elm St", "987-654-3210", "jane.smith@example.com",
                "customer", 30, 987654321, 2, "standard", "1993-05-15", 50000.0));// 2
        indivuallist.add(new Individual("Bob", "Johnson", "789 Oak St", "555-555-5555", "bob.johnson@example.com",
                "customer", 35, 456789123, 3, "standard", "1988-08-08", 150000.0));// 3
        indivuallist.add(new Individual("Alice", "Williams", "321 Pine St", "111-222-3333",
                "alice.williams@example.com", "customer", 40, 321654987, 4, "standard", "1983-03-03", 75000.0));// 4
        indivuallist.add(new Individual("Charlie", "Brown", "654 Cedar St", "444-444-4444", "charlie.brown@example.com",
                "customer", 45, 654987321, 5, "standard", "1978-07-07", 200000.0));// 5
        indivuallist.add(new Individual("David", "Miller", "987 Maple St", "777-888-9999", "david.miller@example.com",
                "customer", 50, 987321654, 6, "standard", "1973-01-01", 100000.0));// 6
        indivuallist.add(new Individual("Eve", "Davis", "246 Birch St", "222-333-4444", "eve.davis@example.com",
                "customer", 55, 123654987, 7, "standard", "1968-06-06", 250000.0));// 7
        indivuallist.add(new Individual("Frank", "Garcia", "135 Spruce St", "888-999-0000", "frank.garcia@example.com",
                "customer", 60, 456321789, 8, "standard", "1963-01-01", 125000.0));// 8
        indivuallist.add(new Individual("Grace", "Martinez", "864 Willow St", "333-444-5555",
                "grace.martinez@example.com", "customer", 65, 789456123, 9, "standard", "1958-06-06", 175000.0));// 9
        indivuallist.add(new Individual("Hank", "Rodriguez", "753 Aspen St", "666-777-8888",
                "hank.rodriguez@example.com", "customer", 70, 321654987, 10, "standard", "1953-01-01", 100000.0));// 10
        indivuallist.add(new Individual("Ivy", "Wilson", "159 Chestnut St", "999-000-1111", "ivy.wilson@example.com",
                "customer", 75, 654987321, 11, "standard", "1948-06-06", 225000.0));// 11
        indivuallist.add(new Individual("Jack", "Anderson", "357 Redwood St", "444-555-6666",
                "jack.anderson@example.com", "customer", 80, 987321654, 12, "standard", "1943-01-01", 150000.0));// 12

        // Company : ( company name, address, email, company number, commercial number,
        // origin, company balance)
        companyList.add(new Company("Tesla", "123 Tech Street", "L5n8o@example.com", 123456789, 1,
                "New York", 100000.0));// 1
        companyList.add(new Company("Finance Corp.", "456 Finance Avenue", "2WYdI@example.com", 987654321, 2,
                "Los Angeles", 150000.0));// 2
        companyList.add(new Company("Healthcare Inc.", "789 Healthcare Blvd", "2Z4B2@example.com", 555555555, 3,
                "Chicago", 200000.0));// 3
        companyList.add(new Company("Education Foundation", "321 Education Court", "L5n8o@example.com", 111111111, 4,
                "Houston", 250000.0));// 4
        companyList.add(new Company("Entertainment Co.", "654 Entertainment Lane", "2WYdI@example.com", 222222222, 5,
                "Phoenix", 300000.0));// 5
        companyList.add(new Company("Retail Group", "987 Retail Road", "2Z4B2@example.com", 333333333, 6,
                "Dallas", 350000.0));// 6
        companyList.add(new Company("Travel Agency", "246 Travel Circle", "L5n8o@example.com", 444444444, 7,
                "Miami", 400000.0));// 7
        companyList.add(new Company("Media House", "135 Media Place", "2WYdI@example.com", 555555555, 8,
                "Seattle", 450000.0));// 8
        companyList.add(new Company("Real Estate Co.", "864 Real Estate Drive", "2Z4B2@example.com", 666666666, 9,
                "Denver", 500000.0));// 9
        companyList.add(new Company("Tech Startup", "753 Tech Lane", "L5n8o@example.com", 777777777, 10,
                "Austin", 550000.0));// 10

        // Contracts : ( status, start date, end date, total cost, vehicle type, vehicle
        // model, customer name, late fee, company name)
        contractList.add(new Contracts(true, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10), 500.0, "Car",
                "Toyota Camry", "John Doe", 0.0, ""));// 1
        contractList.add(new Contracts(false, LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 10), 600.0, "Car",
                "Honda Civic", "", 0.0, "Finance Corp."));// 2
        contractList.add(new Contracts(true, LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 10), 700.0, "Bike",
                "Suzuki GSX250R", "John Doe", 0.0, ""));// 3
        contractList.add(new Contracts(false, LocalDate.of(2023, 4, 1), LocalDate.of(2023, 4, 10), 800.0, "Bike",
                "Kawasaki Ninja 400", "", 0.0, "Education Foundation"));// 4
        contractList.add(new Contracts(true, LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 10), 900.0, "Truck",
                "Ford F-150", "John Doe", 0.0, ""));// 5
        contractList.add(new Contracts(false, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 10), 1000.0, "Truck",
                "Chevrolet Silverado", "", 0.0, "Retail Group"));// 6
        contractList.add(new Contracts(true, LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 10), 1100.0, "Car",
                "Nissan Altima", "John Doe", 0.0, ""));// 7
        contractList.add(new Contracts(false, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 10), 1200.0, "Car",
                "Ford Mustang", "", 120.0, "Retail Group"));// 8
        contractList.add(new Contracts(true, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10), 1300.0, "Bike",
                "Yamaha YZF-R3", "John Doe", 60.0, ""));// 9
        contractList.add(new Contracts(false, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 10), 1400.0, "Bike",
                "Honda CBR500R", "", 140.0, "Education Foundation"));// 10
        contractList.add(new Contracts(true, LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 10), 1500.0, "Truck",
                "Ram 1500", "John Doe", 120.0, ""));// 11
        contractList.add(new Contracts(false, LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 10), 1600.0, "Truck",
                "GMC Sierra", "", 160.0, "Travel Agency"));// 12
        contractList.add(new Contracts(false, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 1700.0, "Car",
                "Ford Mustang", "James Hernandez", 130.0, ""));// 13
        contractList.add(new Contracts(false, LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 10), 1800.0, "Car",
                "Ford Mustang", "", 180.0, "Finance Corp."));// 14
        contractList.add(new Contracts(false, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 10), 1900.0, "Bike",
                "Honda CBR500R", "James Hernandez", 150.0, ""));// 15
        contractList.add(new Contracts(false, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 10), 2000.0, "Bike",
                "Yamaha YZF-R3", "James Hernandez", 200.0, ""));// 16
        contractList.add(new Contracts(false, LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 10), 2100.0, "Truck",
                "Ram 1500", "James Hernandez", 150.0, ""));// 17
        contractList.add(new Contracts(false, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 10), 2200.0, "Truck",
                "GMC Sierra", "James Hernandez", 220.0, ""));// 18

    }

    public static void displayCarList() {
        for (Car car : carlist) {
            System.out.println(car.brand + " " + car.model + " (" + car.year + ") - $" + car.dailyPrice + " per day"
                    + " - Available: " + car.available + " - ID: " + car.id + " - Card Number: " + car.cardNumber
                    + " - Purchase Price: " + car.purchasePrice + " - Color: " + car.color + " - Fuel Type: "
                    + car.fuelType + " - Air Conditioning: " + car.airConditioning + " - Seating Capacity: "
                    + car.seatingCapacity);
            System.out.println();
        }
    }

    public static void displayBikeList() {
        for (Bikes bike : bikelist) {
            System.out.println(bike.brand + " " + bike.model + " (" + bike.year + ") - $" + bike.dailyPrice + " per day"
                    + " - Available: " + bike.available + " - ID: " + bike.id + " - Card Number: " + bike.cardNumber
                    + " - Purchase Price: " + bike.purchasePrice + " - Color: " + bike.color + " - Engine Size: "
                    + bike.engineCapacity + "l - Has Carrier: " + bike.hasCarrier);
            System.out.println();
        }
    }

    public static void displayTruckList() {
        for (Truck truck : trucklist) {
            System.out.println(truck.brand + " " + truck.model + " (" + truck.year + ") - $" + truck.dailyPrice
                    + " per day" + " - Available: " + truck.available + " - ID: " + truck.id + " - Card Number: "
                    + truck.cardNumber + " - Purchase Price: " + truck.purchasePrice + " - Color: " + truck.color
                    + " - Load Capacity: " + truck.loadCapacity + "kg - Air Conditioning: " + truck.airConditioning);
            System.out.println();
        }
    }

    public static void displayIndividualList() {
        for (Individual individual : indivuallist) {
            System.out.println(individual.firstname + " " + individual.lastname + " - Address: " + individual.address
                    + " - Phone Number: " + individual.phoneNumber + " - Email: " + individual.email
                    + " - Account Type: "
                    + individual.accountType + " - Age: " + individual.age + " - ID: " + individual.id +
                    " - Driver License Number: " + individual.driverLicenseNumber + " - Birthdate: "
                    + individual.Birthedate + " - Balance: " + individual.balance);
            System.out.println();
        }
    }

    public static Car findCarById(int id) {
        for (Car car : carlist) {
            if (car.id == id) {
                return car;
            }
        }
        return null; // Car not found
    }

    public static Bikes findBikeById(int id) {
        for (Bikes bike : bikelist) {
            if (bike.id == id) {
                return bike;
            }
        }
        return null; // Bike not found
    }

    public static Truck findTruckById(int id) {
        for (Truck truck : trucklist) {
            if (truck.id == id) {
                return truck;
            }
        }
        return null; // Truck not found
    }

    public static Car removeCarById(int id) {
        for (Car car : carlist) {
            if (car.id == id) {
                carlist.remove(car);
                return car;
            }
        }
        return null; // Car not found
    }

    public static Bikes removeBikeById(int id) {
        for (Bikes bike : bikelist) {
            if (bike.id == id) {
                bikelist.remove(bike);
                return bike;
            }
        }
        return null; // Bike not found
    }

    public static Truck removeTruckById(int id) {
        for (Truck truck : trucklist) {
            if (truck.id == id) {
                trucklist.remove(truck);
                return truck;
            }
        }
        return null; // Truck not found
    }

    public static void addCar(Car car) {
        carlist.add(car);
    }

    public static void addBike(Bikes bike) {
        bikelist.add(bike);
    }

    public static void addTruck(Truck truck) {
        trucklist.add(truck);
    }

    public static void addIndividual(Individual individual) {
        indivuallist.add(individual);
    }

    public static Car findCarByCardNumber(int cardNumber) {
        for (Car car : carlist) {
            if (car.cardNumber == cardNumber) {
                return car;
            }
        }
        return null; // Car not found
    }

    public static Bikes findBikeByCardNumber(int cardNumber) {
        for (Bikes bike : bikelist) {
            if (bike.cardNumber == cardNumber) {
                return bike;
            }
        }
        return null; // Bike not found
    }

    public static Truck findTruckByCardNumber(int cardNumber) {
        for (Truck truck : trucklist) {
            if (truck.cardNumber == cardNumber) {
                return truck;
            }
        }
        return null; // Truck not found
    }

    public static Individual findIndividualById(int id) {
        for (Individual individual : indivuallist) {
            if (individual.id == id) {
                return individual;
            }
        }
        return null; // Individual not found
    }

    public static double RentalAgreement(int id, int days, int choice) {
        Individual individual = new Individual(null, null, null, null, null, null, 0, 0, 0, null, null, 0);
        Company company = new Company(null, null, null, 0, 0, null, 0);
        LocalDate Date = LocalDate.now();
        System.out.println("--------------------------------- Rental Agreement ---------------------------------");
        System.out.println("Date of rental: " + Date);
        Date = Date.plusDays(days);
        System.out.println("Days of rental: " + days);
        System.out.println("Date of return the vehicle: " + Date);
        System.out.println("------------------------------------------------------------------------------------");
        if (choice == 1) {
            for (Company comp : companyList) {
                if (comp.companyNumber == id) {
                    company = comp;
                    break;
                }
            }
            System.out.println("Company Name: " + company.companyName);
            System.out.println("Commercial Number: " + company.commercialNumber);
            System.out.println("Origin: " + company.origin);
            System.out.println("Your vehicle has been rented successfully! Thank you for choosing our service.");
            System.out.println("------------------------------------------------------------------------------------");
        } else if (choice == 2) {
            for (Individual ind : indivuallist) {
                if (ind.id == id) {
                    individual = ind;
                    break;
                }
            }
            System.out.println("Customer Name: " + individual.firstname + " " + individual.lastname);
            System.out.println("Customer Address: " + individual.address);
            System.out.println("Customer Phone Number: " + individual.phoneNumber);
            System.out.println("Customer Account Type: " + individual.accountType);
            System.out.println("Customer ID: " + individual.id);
            System.out.println("Customer Driver License Number: " + individual.driverLicenseNumber);
            System.out.println("Your vehicle has been rented successfully! Thank you for choosing our service.");
            System.out.println("------------------------------------------------------------------------------------");
        }
        System.out.println("The date of actual return of the vehicle : ");
        System.out.print("The days : ");
        int dd = sc.nextInt();
        System.out.print("The month : ");
        int MM = sc.nextInt();
        System.out.print("The year : ");
        int YYYY = sc.nextInt();
        LocalDate actualReturnDate = LocalDate.of(YYYY, MM, dd);
        double fine = actualReturnDate.compareTo(Date);
        System.out.println("The fine is : " + fine + " $");
        System.out.println("------------------------------------------------------------------------------------");
        return fine;
    }

    public static void displayCompanyList() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        for (Company company : companyList) {
            System.out.println("Company Name: " + company.companyName + " - Company Address: " + company.address
                    + " - Company Email: " + company.email
                    + " - Company Number: " + company.companyNumber + " - Commercial Number: "
                    + company.commercialNumber + " - Origin: " + company.origin + " - Company Balance: "
                    + company.companyBalance );
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
        }
    }

    public static void addCompany() {
        System.out.println("Enter the company name: ");
        String companyName = sc.next();
        System.out.println("Enter the company address: ");
        String address = sc.next();
        System.out.println("Enter the company email: ");
        String email = sc.next();
        System.out.println("Enter the company number: ");
        int companyNumber = sc.nextInt();
        System.out.println("Enter the commercial number: ");
        int commercialNumber = sc.nextInt();
        System.out.println("Enter the origin: ");
        String origin = sc.next();
        System.out.println("Enter the company balance: ");
        double companyBalance = sc.nextDouble();
        Company company = new Company(companyName, address, email, companyNumber, commercialNumber, origin,
                companyBalance);
        companyList.add(company);
    }

    public static void findCompanyByCommercialNumber(int commercialNumber) {
        for (Company company : companyList) {
            if (company.commercialNumber == commercialNumber) {
                System.out.println("Company found: " + company.companyName + " - Address: " + company.address
                        + " - Email: " + company.email + " - Company Number: " + company.companyNumber + " - Commercial Number: "
                        + company.commercialNumber + " - Origin: " + company.origin + " - Company Balance: " + company.companyBalance);
                return;
            }
        }
        System.out.println("Company not found with this commercial number: " + commercialNumber);
    }

    public static void editCompany(int companyNumber) {
        for (Company company : companyList) {
            if (company.companyNumber == companyNumber) {
                System.out.println("Editing company: " + company.companyName);
                System.out.println("Enter new company name: ");
                String newCompanyName = sc.next();
                System.out.println("Enter new company address: ");
                String newAddress = sc.next();
                System.out.println("Enter new company email: ");
                String newEmail = sc.next();
                System.out.println("Enter new company number: ");
                int newCompanyNumber = sc.nextInt();
                System.out.println("Enter new commercial number: ");
                int newCommercialNumber = sc.nextInt();
                System.out.println("Enter new origin: ");
                String newOrigin = sc.next();
                System.out.println("Enter new company balance: ");
                double newCompanyBalance = sc.nextDouble();

                company.companyName = newCompanyName;
                company.address = newAddress;
                company.email = newEmail;
                company.companyNumber = newCompanyNumber;
                company.commercialNumber = newCommercialNumber;
                company.origin = newOrigin;
                company.companyBalance = newCompanyBalance;

                System.out.println("Company updated successfully!");
                return;
            }
        }
        System.out.println("Company not found with number: " + companyNumber);
    }

    public void displayContracts() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        for (Contracts contract : contractList) {
            System.out.println("Contract Status: " + (contract.status ? "Active" : "Inactive") + " - Start Date: "
                    + contract.startDate + " - End Date: " + contract.endDate + " - Total Cost: $" + contract.totalCost
                    + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                    + " - Customer Name: " + contract.customer + " - Late Fee: $" + contract.lateFee
                    + " - Company Name: " + contract.companyName);
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
        }
    }

    public void add_contract(boolean status, String vehicleType, String vehicleModel, double totalCost, String customer,
            double lateFee, String companyName) {

        LocalDate startDate = LocalDate.now();
        System.out.println("ENTER THE END DATE :");
        System.out.print("THE DAYS :");
        int dd = sc.nextInt();
        System.out.print("THE MONTH :");
        int MM = sc.nextInt();
        System.out.print("THE YEAR :");
        int YYYY = sc.nextInt();
        LocalDate endDate = LocalDate.of(YYYY, MM, dd);
        contractList.add(new Contracts(status, startDate, endDate, totalCost, vehicleType, vehicleModel, customer,
                lateFee, companyName));
        displayContracts();
    }

    public static void find_company_by_name(String companyName) {
        for (Company company : companyList) {
            if (company.companyName.equalsIgnoreCase(companyName)) {
                System.out.println("Company found: " + company.companyName + " - Address: " + company.address
                        + " - Email: " + company.email + " - Company Number: " + company.companyNumber
                        + " - Commercial Number: " + company.commercialNumber + " - Origin: " + company.origin
                        + " - Company Balance: " + company.companyBalance);
                return;
            }
        }
        System.out.println("Company not found with name: " + companyName);
    }

    public static void find_individual_by_first_and_last_name(String firstName, String lastName) {
        for (Individual individual : indivuallist) {
            if (individual.firstname.equalsIgnoreCase(firstName) && individual.lastname.equalsIgnoreCase(lastName)) {
                System.out.println("Individual found: " + individual.firstname + " " + individual.lastname
                        + " - Address: " + individual.address + " - Email: " + individual.email + " - ID: "
                        + individual.id + " - Phone Number: " + individual.phoneNumber + " - Balance: "
                        + individual.balance + " - Driver License Number: " + individual.driverLicenseNumber
                        + " - Age: "
                        + individual.age + " - Birthdate: " + individual.Birthedate + " - Account Type: "
                        + individual.accountType + " - Role: " + individual.role);
                return;
            }
        }
        System.out.println("Individual not found with first name: " + firstName + " and last name: " + lastName);
    }

}
