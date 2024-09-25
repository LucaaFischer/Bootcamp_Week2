package com.btcag.bootcamp;

import java.util.Scanner;

public class fibonacci_rec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       // System.out.println("Wie viele Fibonacci-Zahlen willst du haben?");
        // int n = input.nextInt();
        System.out.println(fibonacci(20));
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 33; // random zahl zum prüfen atm
        } else {
            fibonacci(n-1);
            return n;
        }
    }
}
