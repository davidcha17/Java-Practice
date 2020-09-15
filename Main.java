package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Let's calculate your mortgage payments");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        long principal = scanner.nextLong();

        System.out.print("Annual Interest Rate: ");
        float rate = scanner.nextFloat();
        float actualRate = (rate / 100) / 12;
        System.out.println("Annual Rate: " + actualRate);

        System.out.print("Period (years): ");
        int year = scanner.nextInt();
        int monthly = year * 12;
        System.out.println("months: " + monthly);

        float ratePlusOne = (float) (Math.pow((1 + actualRate), monthly));
//        System.out.println("ratePlusOne is: " + ratePlusOne);

        float mortgage = (principal * ((actualRate * ratePlusOne) / (ratePlusOne - 1)));

        String currency = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + currency);
        refactored(principal, rate, year);
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

}
