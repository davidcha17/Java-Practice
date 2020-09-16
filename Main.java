package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Let's calculate your mortgage payments");

        int principal = 0;
        int years = 0;
        float actualRate = 0;
        int monthly = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if(principal >= 1_000 && principal <= 1_000_000)
                break;
            else
                System.out.println("Please print a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float rate = scanner.nextFloat();
            if(rate > 0 && rate <= 30) {
                actualRate = (rate / 100) / 12;
                System.out.println("Annual Rate: " + actualRate);
                break;
            }
            else
                System.out.println("Please enter an annual interest rate between 0 and 30.");
        }



        while(true) {
            System.out.print("Period (years): ");
            int year = scanner.nextInt();
            if(year >= 1 && year <= 30) {
                monthly = year * 12;
                System.out.println("months: " + monthly);
                break;
            }
            else
                System.out.println("Please enter a year between 1 and 30.");
        }

        float ratePlusOne = (float) (Math.pow((1 + actualRate), monthly));
//        System.out.println("ratePlusOne is: " + ratePlusOne);

        float mortgage = (principal * ((actualRate * ratePlusOne) / (ratePlusOne - 1)));

        String currency = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + currency);
//        refactored(principal, rate, year);
    }

    private static void refactored(long principal, float rate, int year) {
//        this is the refactored code for mortgage rate
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        float rate2 = rate / PERCENT / MONTHS_IN_YEAR;
        int monthly = year * MONTHS_IN_YEAR;

        double mortgage2 = principal
                            * (rate2 * Math.pow(1 + rate2, monthly)
                            / (Math.pow(1 + rate2, monthly) - 1 ));

        String totalPayment = NumberFormat.getCurrencyInstance().format(mortgage2);

        System.out.println("refactored part: ");
        System.out.println(totalPayment);
    }
    /*
    From all this, the concepts utilized for this basic practice were reference types, casting (implicit and explicit)
    primitive types, reading inputs, variables and CONSTANTS, and strings, numbers, and arrays. We need conditional
    statements to make this flow better without hitting the EXCEPTION ERROR.
    */

}
