package services;

import models.*;
import java.util.*;

public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        System.out.println("Vehicle added!");
    }

    public void viewVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.getId() + " | " + v.getBrand() + " " + v.getModel());
        }
    }

    public void deleteVehicle(String id) {
        vehicles.removeIf(v -> v.getId().equals(id));
        System.out.println("Vehicle deleted!");
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}