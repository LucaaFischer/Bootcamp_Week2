package com.btcag.bootcamp;

import java.util.Scanner;

public class tuerme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] turmOne = {1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] turmTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] turmThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        while (turmThree[0] != 1 || turmThree[1] != 2 || turmThree[2] != 3 || turmThree[3] != 4) {
            System.out.println("Welche Scheibe möchtest du bewegen?");
            int move = input.nextInt();
            System.out.println("Auf welchen Turm?");
            int moveDest = input.nextInt();

            while (turmOne[3] != 0) {
                if (move == turmOne[3] && moveDest == 2) {
                    turmTwo[0] = turmOne[3];
                    turmOne[3] = 0;
                } else if (move == turmOne[3] && moveDest == 3) {
                    turmThree[0] = turmOne[3];
                    turmOne[3] = 0;
                } else {
                    System.out.println("Zug nicht möglich\nBitte neuen Zug eingeben");
                    System.out.println("Welche Scheibe möchtest du bewegen?");
                    move = input.nextInt();
                    System.out.println("Auf welchen Turm?");
                    moveDest = input.nextInt();
                }
            }
            while (turmOne[2] != 0) {
                if (move == turmOne[2] && moveDest == 3 && (turmThree[0] < turmOne[2] || turmThree[1] < turmOne[2])) {
                    if (turmThree[0] < turmOne[2]) {
                        turmThree[0] = turmOne[2];
                        turmOne[2] = 0;
                    } else {
                        turmThree[1] = turmOne[2];
                        turmOne[2] = 0;
                    }
                } else if (move == turmTwo[0] && moveDest == 3 && (turmThree[0] < turmTwo[0])) {
                    turmTwo[0] = turmThree[0];
                    turmThree[0] = 0;
                } else if (move == turmThree[0] && moveDest == 2 && (turmTwo[0] < turmThree[0])) {
                    turmTwo[0] = turmThree[0];
                    turmThree[0] = 0;
                } else {
                    System.out.println("Zug nicht möglich\nBitte neuen Zug eingeben");
                    System.out.println("Welche Scheibe möchtest du bewegen?");
                    move = input.nextInt();
                    System.out.println("Auf welchen Turm?");
                    moveDest = input.nextInt();
                }
            }
        }
    }
}

