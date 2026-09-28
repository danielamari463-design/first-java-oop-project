import java.time.LocalDate;
import java.util.Scanner;

public class Contracts {

    Scanner sc = new Scanner(System.in);
    Database db = new Database();

    boolean status;
    LocalDate startDate;
    LocalDate endDate;
    double totalCost;
    String vehicleType;
    String vehicleModel;
    String customer;
    double lateFee;
    String companyName;

    public Contracts(boolean status, LocalDate startDate, LocalDate endDate, double totalCost, String vehicleType,
            String vehicleModel, String customer, double lateFee, String companyName) {
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.customer = customer;
        this.lateFee = lateFee;
        this.companyName = companyName;
    }

    public void displayContracts() {
        db.displayContracts();
    }

    public void find_active_expired_contracts() {
        System.out.println("Active Contracts: ");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------");
        for (Contracts contract : db.contractList) {
            if (contract.status == true) {
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        System.out.println();
        System.out.println("Expired Contracts: ");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------");
        for (Contracts contract : db.contractList) {
            if (contract.status == false) {
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee
                        + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }

    }

    public void findContractsByCustomer() {
        db.displayContracts();
        System.out.println("Enter the name of the customer to find their contracts: ");
        String customerName = db.sc.nextLine();
        boolean found = false;
        System.out.println("Contracts for customer: " + customerName);
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------");
        for (Contracts contract : db.contractList) {
            if (contract.customer.equalsIgnoreCase(customerName)) {
                found = true;
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        if (!found) {
            System.out.println("No contracts found for customer: " + customerName);
        }

    }

    public void findContractsByVehicle() {
        db.displayContracts();
        System.out.println("Enter the model of the vehicle to find its contracts: ");
        String vehicleModel = sc.nextLine();
        boolean found = false;
        System.out.println("Contracts for vehicle model: " + vehicleModel);
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------");
        for (Contracts contract : db.contractList) {
            if (contract.vehicleModel.equalsIgnoreCase(vehicleModel)) {
                found = true;
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        if (!found) {
            System.out.println("No contracts found for vehicle model: " + vehicleModel);
        }
    }

    public void findMostContractedVehicle() {
        if (db.contractList.isEmpty()) {
            System.out.println("No contracts available to determine the most contracted vehicle.");
            return;
        }

        String mostContractedVehicle = null;
        int maxContracts = 0;

        for (Contracts contract : db.contractList) {
            int count = 0;
            for (Contracts c : db.contractList) {
                if (c.vehicleModel.equalsIgnoreCase(contract.vehicleModel)) {
                    count++;
                }
            }
            if (count > maxContracts) {
                maxContracts = count;
                mostContractedVehicle = contract.vehicleModel;
            }
        }

        System.out
                .println("Most Contracted Vehicle: " + mostContractedVehicle + " with " + maxContracts + " contracts.");
    }

    public void find_Contracts_with_Late_Fees() {
        System.out.println("Contracts with Late Fees:");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------");
        boolean found = false;
        for (Contracts contract : db.contractList) {
            if (contract.lateFee > 0) {
                found = true;
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        if (!found) {
            System.out.println("No contracts with late fees found.");
        }
    }

    public void display_contracts_by_company() {
        for (Contracts contract : Database.contractList) {
            if (contract.companyName.equalsIgnoreCase("")) {

            } else {
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void find_active_expired_contracts_by_company() {
        System.out.println("Active Contracts by Company:");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------");
        for (Contracts contract : db.contractList) {
            if (contract.status == true && !contract.companyName.equals("")) {
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        System.out.println("Expired Contracts by Company:");
        for (Contracts contract : db.contractList) {
            if (contract.status == false && !contract.companyName.equals("")) {
                System.out.println();
                System.out.println(" - Start Date: " + contract.startDate
                        + " - End Date: " + contract.endDate + " - Total Cost: " + contract.totalCost
                        + " - Vehicle Type: " + contract.vehicleType + " - Vehicle Model: " + contract.vehicleModel
                        + " - Customer: " + contract.customer + " - Late Fee: " + contract.lateFee + " - Company Name: "
                        + contract.companyName);
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------");
            }
        }

    }

    public void total_revenues() {
        double total_revenues = 0;
        for (Contracts contract : db.contractList) {
            total_revenues += contract.totalCost;
        }
        System.out.println("Total Revenues: " + total_revenues);

    }

    public void find_VIP_customers() { // vip customer if he has more than or equal to 5 contracts
        System.out.println("VIP Customers:");
        if (db.contractList.isEmpty()) {
            System.out.println("No contracts available to determine the most contracted customer.");
            return;
        }

        String vip_customers = null;
        int minimum_contracts_level = 5;

        for (Contracts contract : db.contractList) {
            int count = 0;

            for (Contracts c : db.contractList) {
                if (contract.customer.equalsIgnoreCase(c.customer)) {
                    count++;
                }
            }

            if (count >= minimum_contracts_level && contract.customer != "" && vip_customers != contract.customer) {
                vip_customers = contract.customer;
                System.out.println(vip_customers + " has " + count + " contracts.");

            }
        }
    }

}
