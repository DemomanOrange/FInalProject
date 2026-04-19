package models;

public class Car extends Vehicle {
    private int mileage;

    public Car(String id, String brand, String model, int mileage) {
        super(id, brand, model);
        this.mileage = mileage;
    }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }
}