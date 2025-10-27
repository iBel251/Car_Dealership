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
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            double price = v.getPrice();
            if(price >= min && price <= max){
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            String vehicleMake = v.getMake();
            String vehicleModel = v.getModel();
            if(make.equalsIgnoreCase(vehicleMake) && model.equalsIgnoreCase(vehicleModel)){
                result.add(v);
            }

        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            int year = v.getYear();
            if(year >= min && year <= max){
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            String vehicleColor = v.getColor();
            if(color.equalsIgnoreCase(vehicleColor)){
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            int mileage = v.getOdometer();
            if(mileage >= min && mileage <= max){
                result.add(v);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            String type = v.getVehicleType();
            if(type.equalsIgnoreCase(vehicleType)){
                result.add(v);
            }
        }
        return result;
    }

    public Vehicle getVehicleByVin(int vin){
        Vehicle result = null;

            for(Vehicle v : inventory){
                if(vin == v.getVin()){
                    result = v;
                }
            }
        return result;
    }

    public void removeVehicle(Vehicle v){
            inventory.remove(v);
        System.out.println("✅Vehicle successfully removed.");
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return  name +
                "|" + address +
                "|" + phone + "\n" +
                inventory;
    }
}
