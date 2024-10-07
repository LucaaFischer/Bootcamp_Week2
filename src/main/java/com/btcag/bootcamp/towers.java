package com.btcag.bootcamp;

import java.util.Scanner;


//-------------------------------------------------------------------------Mehrfach benötigte Variablen und Arrays-----------------------------------------------------------------
public class towers {
    public static Scanner input = new Scanner(System.in);
    public static int[] towerOne = {4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int temp = 0;

    public static int move = 0;
    public static int moveStart = 0;
    public static int moveDest = 0;

    //---------------------------------------------------------------------------Main---------------------------------------------------------------------------------------
    public static void main(String[] args) {

        Game();

        System.out.println("Gelöst :)");
    }

    //----------------------------------------------------------------------------Game-------------------------------------------------------------------------------------------
    public static void Game() {
        while (!solved()) {
            printTowers();

            System.out.println("Welche Scheibe möchtest du bewegen?");
            move = input.nextInt();

            System.out.println("Von welchem Turm?");
            moveStart = input.nextInt();

            System.out.println("Auf welchen Turm?");
            moveDest = input.nextInt();
        }
    }


    //----------------------------------------------------------------------Gewinnbedingung--------------------------------------------------------------------------------------

    public static boolean solved() {
        return (towerThree[0] == 4 && towerThree[1] == 3 && towerThree[2] == 2 && towerThree[3] == 1);
    }

    //----------------------------------------------------------------------Türme ausgeben--------------------------------------------------------------------------------------
    public static String printTowers() {
        casesTowerOne();
        casesTowerTwo();
        casesTowerThree();

        return ("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
    }

    //----------------------------------------------------------------Größte Scheibe auf Turm 1 ermitteln-----------------------------------------------------------------------------
    public static int maxDiskT1() {
        int maxDiscT1 = 0;
        for (int i = 0; i < towerOne.length - 1; i++) {
            if (towerOne[i] > towerOne[i + 1]) {
                maxDiscT1 = towerOne[i + 1];
            }
        }
        return maxDiscT1;
    }

    //----------------------------------------------------------------Größte Scheibe auf Turm 2 ermitteln-----------------------------------------------------------------------------
    public static int maxDiskT2() {
        int maxDiscT2 = 0;
        for (int i = 0; i < towerTwo.length - 1; i++) {
            if (towerTwo[i] > towerTwo[i + 1]) {
                maxDiscT2 = towerTwo[i + 1];
            }
        }
        return maxDiscT2;
    }

    //----------------------------------------------------------------Größte Scheibe auf Turm 3 ermitteln-----------------------------------------------------------------------------
    public static int maxDiskT3() {
        int maxDiscT3 = 0;
        for (int i = 0; i < towerThree.length - 1; i++) {
            if (towerThree[i] > towerThree[i + 1]) {
                maxDiscT3 = towerThree[i + 1];
            }
        }
        return maxDiscT3;
    }

    //----------------------------------------------------------------Mögliche Ausgänge für towerOne-------------------------------------------------------------------------------

    public static void casesTowerOne() {
        if (moveStart == 1) {
            for (int i = 0; i < towerOne.length; i++) {
                if (moveDest == 2 && maxDiskT1() < maxDiskT2()) {
                    temp = towerOne[i];
                    towerOne[i] = towerTwo[i];
                    towerTwo[i] = temp;

                } else if (moveDest == 3 && maxDiskT1() < maxDiskT3()) {
                    temp = towerOne[i];
                    towerOne[i] = towerThree[i];
                    towerThree[i] = temp;

                } else {
                    System.out.println("Zug nicht möglich.");
                }
            }
        }
    }

    //---------------------------------------------------------------Mögliche Ausgänge für towerTwo--------------------------------------------------------------------------------
    public static void casesTowerTwo() {
        if (moveStart == 2) {
            for (int i = 0; i < towerTwo.length; i++) {
                if (moveDest == 1 && maxDiskT2() < maxDiskT1()) {
                    temp = towerTwo[i];
                    towerTwo[i] = towerOne[i];
                    towerOne[i] = temp;

                } else if (moveDest == 3 && maxDiskT2() < maxDiskT3()) {
                    temp = towerTwo[i];
                    towerTwo[i] = towerThree[i];
                    towerThree[i] = temp;

                } else {
                    System.out.println("Zug nicht möglich.");
                }
            }
        }
    }

    //--------------------------------------------------------------Mögliche Ausgänge für towerThree------------------------------------------------------------------------------
    public static void casesTowerThree() {
        if (moveStart == 3) {
            for (int i = 0; i < towerThree.length; i++) {
                if (moveDest == 1 && maxDiskT3() < maxDiskT1()) {
                    temp = towerThree[i];
                    towerThree[i] = towerOne[i];
                    towerOne[i] = temp;

                } else if (moveDest == 2 && maxDiskT3() < maxDiskT2()) {
                    temp = towerThree[i];
                    towerThree[i] = towerTwo[i];
                    towerTwo[i] = temp;

                } else {
                    System.out.println("Zug nicht möglich.");
                }
            }
        }
    }
}