package utils;

import models.*;
import services.*;

import java.io.*;
import java.util.*;

public class FileHandler {

    public static void exportData(List<Vehicle> vehicles, List<MaintenanceRecord> records) {
        try (PrintWriter writer = new PrintWriter("data.txt")) {

            for (Vehicle v : vehicles) {
                writer.println("V," + v.getId() + "," + v.getBrand() + "," + v.getModel());
            }

            for (MaintenanceRecord r : records) {
                writer.println("R," + r.getVehicleId() + "," + r.getServiceType() + "," + r.getCost());
            }

            System.out.println("Data exported!");

        } catch (Exception e) {
            System.out.println("Error exporting data!");
        }
    }

    public static void importData(VehicleService vs, RecordService rs) {
        try (Scanner sc = new Scanner(new File("data.txt"))) {

            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");

                if (parts[0].equals("Vehicle:")) {
                    vs.addVehicle(new Car(parts[1], parts[2], parts[3], 0));
                } else if (parts[0].equals("Record:")) {
                    rs.addRecord(new OilChange(parts[1], parts[2], Double.parseDouble(parts[3])));
                }
            }

            System.out.println("Data imported!");

        } catch (Exception e) {
            System.out.println("Error importing data!");
        }
    }
}