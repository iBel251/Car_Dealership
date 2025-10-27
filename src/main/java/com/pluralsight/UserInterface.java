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

            int input = 0;

            while(true){
                System.out.print("Enter the number assigned : ");
                if(sc.hasNextInt()){
                    input = sc.nextInt();
                    sc.nextLine();
                    if(input > 0 && input <= 9){
                        keepGoing = false;
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


}
