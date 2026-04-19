package models;

public class Vehicle {
    private String id;
    private String brand;
    private String model;

    public Vehicle(String id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
}