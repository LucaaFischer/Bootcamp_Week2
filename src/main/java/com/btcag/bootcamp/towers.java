package com.btcag.bootcamp;

import java.util.Scanner;

//----------------------------------------------------------------------------Mehrfach gebrauchte Variablen-----------------------------------------------------------------------
public class towers {
    public static Scanner input = new Scanner(System.in);
    public static int[] towerOne = {4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerTwo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] towerThree = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static int moveStart = 0;
    public static int moveDest = 0;
    public static int move = 0;

    public static void main(String[] args) {
        Game();
    }

    //--------------------------------------------------------------------------------Game-------------------------------------------------------------------------------------------
    public static void Game() {
        while (!isSolved()) {
            printTowers();
            isValid();
            checkDisc();
            moveDisc();
        }
        System.out.println("Gelöst :)");
    }

    public static boolean isSolved() {
        return towerThree[0] == 4 && towerThree[1] == 3 && towerThree[2] == 2 && towerThree[3] == 1;
    }

    //-----------------------------------------------------------------------Ausgabe der Türme-------------------------------------------------------------------------------------
    public static void printTowers() {
        checkDisc();
        System.out.println("Turm 1: " + java.util.Arrays.toString(towerOne) + "\n" +
                "Turm 2: " + java.util.Arrays.toString(towerTwo) + "\n" +
                "Turm 3: " + java.util.Arrays.toString(towerThree));
    }

    //--------------------------------------------------------------------------Zugabfrage---------------------------------------------------------------------------------------
    public static void getMove() {
        System.out.println("Von welchem Turm willst du die Scheibe nehmen?");
        moveStart = input.nextInt();

        System.out.println("Auf welchen Turm willst du sie legen?");
        moveDest = input.nextInt();
    }

    //---------------------------------------------------------------------Validierung des Zuges-----------------------------------------------------------------------------------
    public static void isValid() {
        getMove();
        if (moveStart < 1 || moveStart > 3 || moveDest < 0 || moveDest > 3 || moveStart == moveDest) {
            getMove();
            isValid();
        }
    }

    //-----------------------------------------------------------------------Check oberste Disc auf Turm-----------------------------------------------------------------------------

    public static void checkDisc() {
        if (moveStart == 1 && moveDest == 2) {
            for (int i = towerOne.length - 1; i >= 0; i--) {
                for (int j = towerTwo.length - 1; j >= 0; j--) {
                    if (towerOne[i] != 0 && towerOne[i] < towerTwo[j]) {
                        towerOne[i] = move;
                        if (towerTwo[j] != 0) {
                            towerTwo[j] = 0;
                        }
                        break;
                    }
                }
            }

        } else if (moveStart == 1 && moveDest == 3) {
            for (int i = towerOne.length - 1; i >= 0; i--) {
                for (int j = towerThree.length - 1; j >= 0; j--) {
                    if (towerOne[i] != 0 && towerOne[i] < towerThree[j]) {
                        towerOne[i] = move;
                        if (towerThree[j] != 0) {
                            towerThree[j] = 0;
                        }
                        break;
                    }
                }
            }
        } else if (moveStart == 2 && moveDest == 1) {
            for (int i = towerTwo.length - 1; i >= 0; i--) {
                for (int j = towerOne.length -1; j >= 0; j--) {
                    if (towerTwo[i] != 0 && towerTwo[i] < towerOne[j]) {
                        towerOne[i] = move;
                        if(towerTwo[j] != 0) {
                            towerTwo[j] = 0;
                        }
                        break;
                    }
                }
            }

        } else if (moveStart == 3) {
            for (int i = towerThree.length - 1; i > 0; i--) {
                if (towerThree[i] != 0) {
                    towerThree[i] = move;
                    break;
                }
            }
        }
    }

    //--------------------------------------------------------------------------Disc auf Turm legen------------------------------------------------------------------------------
    public static void moveDisc() {
        if (moveDest == 1) {
            for (int i = towerOne.length - 1; i > 0; i--) {
                if (towerOne[i] != 0 && move < towerOne[i]) {
                    towerOne[i] = move;
                    break;
                }
            }

        } else if (moveDest == 2) {
            for (int i = towerTwo.length - 1; i > 0; i--) {
                if (towerTwo[i] != 0 && move < towerTwo[i]) {
                    towerTwo[i] = move;
                    break;
                }
            }

        } else if (moveDest == 3) {
            for (int i = towerThree.length - 1; i > 0; i--) {
                if (towerThree[i] != 0 && move < towerThree[i]) {
                    towerThree[i] = move;
                    break;
                }
            }
        }
    }
}
