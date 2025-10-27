package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);

    private Dealership dealership;

    public UserInterface(){}

    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }
    public void display(){
        init();
        boolean keepGoing = true;

        while (keepGoing){
            System.out.println("Search Menu");
            System.out.println("1 - By price");
            System.out.println("2 - By make/model");
            System.out.println("3 - By year");
            System.out.println("4 - By color");
            System.out.println("5 - By mileage");
            System.out.println("6 - By Vehicle type");
            System.out.println("7 - Display all");
            System.out.println("8 - Add vehicle");
            System.out.println("9 - Remove vehicle");
            System.out.println("99 - Exit");

            int input = 0;

            while(true){
                System.out.print("Enter the number assigned : ");
                if(sc.hasNextInt()){
                    input = sc.nextInt();
                    sc.nextLine();
                    if((input > 0 && input <= 9) || input == 99){
                        keepGoing = false;
                        executeSelection(input);
                        break;
                    }else{
                        System.out.println("Selection out of range. Please try again.");
                    }
                }else{
                    System.out.println("Invalid selection. Please enter only the number assigned to the options.");
                    sc.nextLine();
                }
            }
        }
    }

    private void executeSelection(int input){
        switch (input){
            case 1 : {
                System.out.print("Price starting from - : ");
                double min = sc.nextDouble();
                sc.nextLine();
                System.out.print("Up to : ");
                double max = sc.nextDouble();
                sc.nextLine();
                processGetByPriceRequest(min, max);
                break;
            }
            case 2 : {
                System.out.print("Make : ");
                String make = sc.nextLine();
                System.out.print("Model : ");
                String model = sc.nextLine();

                processGetByMakeModelRequest(make, model);
                break;
                }
            case 3 : {
                System.out.print("Enter starting year: ");
                int min = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter ending year: ");
                int max = sc.nextInt();
                sc.nextLine();

                processGetByYearRequest(min, max);
                break;
                }
            case 4 : {
                System.out.print("Enter color: ");
                String color = sc.nextLine();

                processGetByColorRequest(color);
                break;
                }
            case 5 : {
                System.out.print("Mileage starting from - : ");
                int min = sc.nextInt();
                sc.nextLine();
                System.out.print("Up to : ");
                int max = sc.nextInt();
                sc.nextLine();
                processGetByMileageRequest(min, max);
                break;
                }
            case 6 : {
                System.out.print("Enter vehicle type: ");
                String type = sc.nextLine();

                processGetByVehicleTypeRequest(type);
                break;
            }
            case 7 : {
                processGetAllVehiclesRequest();
                break;
                }
            case 8 : {
                System.out.println(8);
                break;
                }
            case 9 : {
                while(true){

                    System.out.print("Enter vin number of the vehicle : ");
                    int vin = sc.nextInt();
                    sc.nextLine();

                    Vehicle v = dealership.getVehicleByVin(vin);
                    if(v != null){
                        System.out.println("========== Vehicle found ==========");
                        System.out.println(v.toString());
                        System.out.println("\n\n Enter Y to proceed, X to cancel.");
                        String choice = sc.nextLine();

                        if(choice.toLowerCase().charAt(0) == 'y'){
                            processRemoveVehicleRequest(v);
                            break;
                        }else{
                            System.out.println("Process canceled.");
                            continue;
                        }
                    }else{
                        System.out.println("No vehicle found, please check the vin number and try again.");
                    }
                }
            }
            case 99 : {
                System.out.println("========== Bye :( ==========");
                break;
            }
        }
    }

    public void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle v : vehicles){
            System.out.println(v);
        }
        System.out.println("===== Press Enter to continue =====");
        sc.nextLine();
        display();
    }
    public void processGetByPriceRequest(double min, double max){
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }
    public void processGetByMakeModelRequest(String make, String model){
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    public void processGetByYearRequest(int min, int max){
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }
    public void processGetByColorRequest(String color){
        displayVehicles(dealership.getVehiclesByColor(color));
    }
    public void processGetByMileageRequest(int min, int max){
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest(String type){
        displayVehicles(dealership.getVehiclesByType(type));
    }
    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){}
    public void processRemoveVehicleRequest(Vehicle v){
        dealership.removeVehicle(v);
        DealershipFileManager.saveDealership(dealership);

        System.out.println("===== Press Enter to continue. =====");
        sc.nextLine();
        display();
    }
}
