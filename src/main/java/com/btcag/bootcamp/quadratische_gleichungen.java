package com.btcag.bootcamp;

import java.util.Scanner;

public class quadratische_gleichungen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gib a ein");
        double a = input.nextDouble();

        System.out.println("Gib b ein");
        double b = input.nextDouble();

        System.out.println("Gib c ein");
        double c = input.nextDouble();

        double bSquared = b*b;
        double fourAC = 4 * (a*c);

        double diskriminante = bSquared - fourAC;

        int loesungen = 0;
        if(diskriminante > 0) {
            loesungen = 2;
        } else if(diskriminante == 0) {
            loesungen = 1;
        } else {
            loesungen = 0;
        }
        System.out.println("Ergebnis: " + loesungen);
    }
}
