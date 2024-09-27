package com.btcag.bootcamp;

import java.util.Scanner;

public class towers {
    public static Scanner input = new Scanner(System.in);
    public static int[] towerOne = {4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int temp = 0;
    public static String result = "";

    public static int move = 0;
    public static int moveStart = 0;
    public static int moveDest = 0;

    public static boolean solved() {
        return (towerThree[0] == 4 && towerThree[1] == 3 && towerThree[2] == 2 && towerThree[3] == 1);
    }

    public static void printTowers() {
        if (moveStart == 1) {
            casesTowerOne();
        } else if (moveStart == 2) {
            casesTowerTwo();
        } else if (moveStart == 3) {
            casesTowerThree();
        }
        System.out.println(result);
    }

    public static String casesTowerOne() {
        for (int i = 0; i < towerOne.length; i++) {
            if (moveStart == 1 && moveDest == 2) {
                if (towerOne[i] < towerTwo[i]) {
                    temp = towerOne[i];
                    towerOne[i] = towerTwo[i];
                    towerTwo[i] = temp;
                }
            } else if (moveStart == 1 && moveDest == 3) {
                if (towerOne[i] < towerThree[i]) {
                    temp = towerOne[i];
                    towerOne[i] = towerThree[i];
                    towerThree[i] = temp;
                }
            }
        }
        result = ("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
        return result;
    }

    public static String casesTowerTwo() {
        for (int i = 0; i < towerTwo.length; i++) {
            if (moveStart == 2 && moveDest == 1) {
                if (towerTwo[i] < towerOne[i]) {
                    temp = towerTwo[i];
                    towerTwo[i] = towerOne[i];
                    towerOne[i] = temp;
                }
            } else if (moveStart == 2 && moveDest == 3) {
                if (towerTwo[i] < towerThree[i]) {
                    temp = towerTwo[i];
                    towerTwo[i] = towerThree[i];
                    towerThree[i] = temp;
                }
            }
        }
        result = ("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
        return result;
    }

    public static String casesTowerThree() {
        for (int i = 0; i < towerThree.length; i++) {
            if (moveStart == 3 && moveDest == 1) {
                if (towerThree[i] < towerOne[i]) {
                    temp = towerThree[i];
                    towerThree[i] = towerOne[i];
                    towerOne[i] = temp;
                }
            } else if (moveStart == 3 && moveDest == 2) {
                if (towerThree[i] < towerTwo[i]) {
                    temp = towerThree[i];
                    towerThree[i] = towerTwo[i];
                    towerTwo[i] = temp;
                }
            }
        }
        result = ("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
        return result;
    }
    public static void main(String[] args) {
        while (!solved()) {
            printTowers();
            System.out.println("Welche Scheibe möchtest du bewegen?");
            move = input.nextInt();

            System.out.println("Von welchem Turm?");
            moveStart = input.nextInt();

            System.out.println("Auf welchen Turm?");
            moveDest = input.nextInt();
        }
        System.out.println("Gelöst :)");
    }
}