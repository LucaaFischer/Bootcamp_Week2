package com.btcag.bootcamp;

import java.util.Scanner;

public class towers {
    public static Scanner input = new Scanner(System.in);
    public static int[] towerOne = {4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int[] newTowerOne = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] newTowerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] newTowerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int move = 0;
    public static int moveStart = 0;
    public static int moveDest = 0;

    public static void main(String[] args) {
        while (!solved()) {
            System.out.println("Welche Scheibe möchtest du bewegen?");
            move = input.nextInt();

            System.out.println("Von welchem Turm?");
            moveStart = input.nextInt();

            System.out.println("Auf welchen Turm?");
            moveDest = input.nextInt();

            if (moveStart == 1) {
                System.out.println(casesTowerOne());
            } else if (moveStart == 2) {
                System.out.println(casesTowerTwo());
            } else if (moveStart == 3) {
                System.out.println(casesTowerThree());
            } else {
                printTowers();
                System.out.println("Ungültiger Zug.");
                System.out.println("Welche Scheibe möchtest du bewegen?");
                move = input.nextInt();

                System.out.println("Von welchem Turm?");
                moveStart = input.nextInt();

                System.out.println("Auf welchen Turm?");
                moveDest = input.nextInt();
            }

        }

        System.out.println("Gelöst :)");
    }

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
        System.out.println("Turm 1: " + java.util.Arrays.toString(towerOne));
        System.out.println("Turm 2: " + java.util.Arrays.toString(towerTwo));
        System.out.println("Turm 3: " + java.util.Arrays.toString(towerThree));
    }

    public static String casesTowerOne() {
        for (int i = 0; i < towerOne.length; i++) {
            if (moveStart == 1 && moveDest == 2) {
                if (towerOne[i] < towerTwo[i]) {
                    newTowerOne[i] = towerTwo[i];
                    newTowerTwo[i] = towerOne[i];
                }
            } else if (moveStart == 1 && moveDest == 3) {
                if (towerOne[i] < towerThree[i]) {
                    newTowerOne[i] = towerThree[i];
                    newTowerThree[i] = towerOne[i];
                }
            }
        }
        String result = ("Turm 1: " + java.util.Arrays.toString(newTowerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
        return result;
    }

    public static String casesTowerTwo() {
        for (int i = 0; i < towerTwo.length; i++) {
            if (moveStart == 2 && moveDest == 1) {
                if (towerTwo[i] < towerOne[i]) {
                    newTowerTwo[i] = towerOne[i];
                    newTowerOne[i] = towerTwo[i];
                }
            } else if (moveStart == 2 && moveDest == 3) {
                if (towerTwo[i] < towerThree[i]) {
                    newTowerTwo[i] = towerThree[i];
                    newTowerThree[i] = towerTwo[i];
                }
            }
        }
        String result = ("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(newTowerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
        return result;
    }

    public static String casesTowerThree() {
        for (int i = 0; i < towerThree.length; i++) {
            if (moveStart == 3 && moveDest == 1) {
                if (towerThree[i] < towerOne[i]) {
                    newTowerThree[i] = towerOne[i];
                    newTowerOne[i] = towerThree[i];
                }
            } else if (moveStart == 3 && moveDest == 2) {
                if (towerThree[i] < towerTwo[i]) {
                    newTowerTwo[i] = towerThree[i];
                    newTowerThree[i] = towerTwo[i];
                }
            }
        }
        String result = ("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(newTowerThree));
        return result;
    }
}