package com.pluralsight;

import java.util.ArrayList;

public class Search {

    public void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle v : vehicles){
            System.out.println(v);
        }
    }
    public void processGetByPriceRequest(){}
    public void processGetByMakeModelRequest(){}
    public void processGetByYearRequest(){}
    public void processGetByColorRequest(){}
    public void processGetByMileageRequest(){}
    public void processGetByVehicleTypeRequest(){}
    public void processGetAllVehiclesRequest(){
       displayVehicles(DealershipFileManager.getDealership().getAllVehicles());
    }
    public void processAddVehicleRequest(){}
    public void processRemoveVehicleRequest(){}


}
