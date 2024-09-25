package com.btcag.bootcamp;

import java.util.Scanner;

public class immer_positiv {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Gib eine negative Zahl ein.");
        int zahl = input.nextInt();

        if(zahl<0) {
            zahl = zahl * -1;
        }
        System.out.println(zahl);
    }
}

