package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {
    public static void main(String[] args) {
        Vehicle v = new Vehicle(1,2009,"toyota","rav4","car","white",10000,12350);
        Dealership d = new Dealership("abc","address","1231231234");
        d.addVehicle(v);
        System.out.println(d);

        System.out.println(DealershipFileManager.getDealership());
    }
}