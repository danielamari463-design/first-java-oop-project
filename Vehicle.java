public abstract class Vehicle {
    public abstract void displayAllVehicles();

    public abstract void rentVehicle(int choice);

    public abstract void buyVehicle(int choice);

    public abstract void addVehicle();

    public abstract void removeVehicle();

    public abstract void searchVehicleByCardNumber();

    String brand;
    String model;
    int year;
    double dailyPrice;
    double purchasePrice;
    String color;
    boolean available;
    int cardNumber;
    int id;

}
