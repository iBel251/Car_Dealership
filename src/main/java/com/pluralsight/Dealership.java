package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership() {
        this.name = "";
        this.address = "";
        this.phone = "";
    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }

    public void removeVehicle(Vehicle vehicle){}

    @Override
    public String toString() {
        return  name +
                "|" + address +
                "|" + phone + "\n" +
                inventory;
    }
}
