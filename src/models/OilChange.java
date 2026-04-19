package models;

public class OilChange extends MaintenanceRecord {

    public OilChange(String vehicleId, String serviceType, double cost) {
        super(vehicleId, serviceType, cost);
    }

    @Override
    public void display() {
        System.out.println("[Oil Change] " + serviceType + " - $" + cost);
    }
}