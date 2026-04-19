package models;

public class MaintenanceRecord {
    protected String vehicleId;
    protected String serviceType;
    protected double cost;

    public MaintenanceRecord(String vehicleId, String serviceType, double cost) {
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.cost = cost;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void display() {
        System.out.println(serviceType + " - $" + cost);
    }
}