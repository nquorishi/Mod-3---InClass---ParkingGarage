/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parkingcharges;

/**
 *
 * @author Naweed
 */

import java.util.Scanner;

public class ParkingCharges {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalCharge = 0.0;
        
        System.out.print("Enter total hours parked (or -1 to exit): ");
        double hours = input.nextDouble();
        
        while (hours != -1) {
            double charge = calculateCharges(hours);
            System.out.printf("The charge for this customer is $%.2f%n", charge);
            
            totalCharge += charge;
            System.out.printf("Running total of yesterday’s receipts: $%.2f%n", totalCharge);
            
            System.out.print("Enter hours parked (or -1 to exit): ");
            hours = input.nextDouble();
        }
    }
    
    public static double calculateCharges(double hours) {
        double minCharge = 2.0;
        double maxCharge = 10.0;
        double additionalCharge = 0.5;
        double maxHours = 24.0;
        
        if (hours <= 3.0) {
            return minCharge;
        } else if (hours <= maxHours) {
            double additionalHours = hours - 3.0;
            double additionalCost = Math.ceil(additionalHours) * additionalCharge;
            double totalCharge = minCharge + additionalCost;
            return Math.min(totalCharge, maxCharge);
        } else {
            return maxCharge;
        }
    }
}
