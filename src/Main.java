import models.*;
import services.*;
import utils.*;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static VehicleService vehicleService = new VehicleService();
    private static RecordService recordService = new RecordService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Vehicle Maintenance Log ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Add Record");
            System.out.println("4. View Records");
            System.out.println("5. Delete Vehicle");
            System.out.println("6. Export Data");
            System.out.println("7. Import Data");
            System.out.println("8. Exit");

            int choice = getInt();

            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> vehicleService.viewVehicles();
                case 3 -> addRecord();
                case 4 -> recordService.viewRecords();
                case 5 -> deleteVehicle();
                case 6 -> FileHandler.exportData(vehicleService.getVehicles(), recordService.getRecords());
                case 7 -> FileHandler.importData(vehicleService, recordService);
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addVehicle() {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Mileage: ");
        int mileage = getInt();

        if (brand.isEmpty() || model.isEmpty()) {
            System.out.println("Invalid input!");
            return;
        }

        Car car = new Car(UUID.randomUUID().toString(), brand, model, mileage);
        vehicleService.addVehicle(car);
    }

    private static void addRecord() {
        System.out.print("Vehicle ID: ");
        String id = scanner.nextLine();

        System.out.print("Service Type: ");
        String type = scanner.nextLine();

        System.out.print("Cost: ");
        double cost = getDouble();

        if (cost < 0) {
            System.out.println("Invalid cost!");
            return;
        }

        MaintenanceRecord record = new OilChange(id, type, cost);
        recordService.addRecord(record);
    }

    private static void deleteVehicle() {
        System.out.print("Enter Vehicle ID: ");
        String id = scanner.nextLine();
        vehicleService.deleteVehicle(id);
    }

    private static int getInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private static double getDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}