package com.pluralsight;

import com.sun.source.tree.BreakTree;

import java.io.*;

public class DealershipFileManager {

    public static Dealership getDealership(){
        Dealership dealership = null;
        try(BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))){

            //Skip 1st line
            String firstLine = reader.readLine();
            if(firstLine == null){
                System.out.println("File is empty.");
            }else{
                String[] sections = firstLine.split("\\|");
                dealership = new Dealership(sections[0],sections[1],sections[2]);
            }
            String line;
            while((line = reader.readLine()) != null){
                String[] sections = line.split("\\|");

                Vehicle v = new Vehicle(Integer.parseInt(sections[0]),Integer.parseInt(sections[1]),sections[2],sections[3],sections[4],sections[5],Integer.parseInt(sections[6]),Double.parseDouble(sections[7]));

                if(dealership != null){
                    dealership.addVehicle(v);
                }
            }
        }catch (IOException e){
            System.out.println("Error! " + e.getMessage());
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership){
        try(PrintWriter writer = new PrintWriter(new FileWriter("inventory.csv"))){
            writer.println(dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getPhone());

            for(Vehicle v : dealership.getInventory()){
                writer.println(v.toString());
            }
            System.out.println("✅ Dealership data successfully saved to inventory.csv");
        }catch (IOException e){
            System.out.println("Error reading from file. " + e.getMessage());
        }
    }
}
