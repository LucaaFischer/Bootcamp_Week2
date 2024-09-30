package com.btcag.bootcamp;

import java.util.Scanner;

//------------------------------------------------------------------Mehrfach benötigte Variablen---------------------------------------------------------------
public class connectFour {
    public static Scanner input = new Scanner(System.in);
    public static String[] players = getPlayers();
    public static String[] coins = getCoins();

    public static int turn = 1;
    public static int maxTurns = 42;

    public static char[][] board = new char[7][6];
    public static int rows = 6;
    public static int columns = 7;

    public static int move = 0;


    //-----------------------------------------------------------------------------Main------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("Willkommen zu Vier-Gewinnt " + players[0] + " und " + players[1] + "!");

        System.out.println(players[0] + "Hat die " + coins[0] + "Münzen.");

        while (turn < maxTurns) {
            turn++;
            board();
        }
        System.out.println("Unentschieden. Das Spielfeld ist voll.");
    }

    //-------------------------------------------------------------------Namenseingabe------------------------------------------------------------------------------
    public static String[] getPlayers() {
        String[] players = new String[2];
        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 1.");
        players[0] = input.nextLine();

        System.out.println("Bitte gib deinen gewünschten Benutzernamen ein, Spieler 2.");
        players[1] = input.nextLine();

        return players;
    }

    //---------------------------------------------------------------------Münzwahl----------------------------------------------------------------------------------------
    public static String[] getCoins() {
        System.out.println("Wähle ein Zeichen als Münze, X oder O " + players[0]);
        coins[0] = input.nextLine();

        while (coins[0] != "X" && coins[0] != "O") {
            System.out.println("Deine Münze muss X oder O sein.");
            System.out.println("Bitte gib erneut deine Wunschmünze ein");
            coins[0] = input.nextLine();
        }

        if (coins[0].equals("X")) {
            coins[1] = "O";
        } else {
            coins[1] = "X";
        }
        return coins;
    }

    //----------------------------------------------------------------------Game--------------------------------------------------------------------------------
    public static void game() {
        if (turn % 2 == 0) {
            System.out.println("In welche Spalte möchtest du deine Münze werfen, " + players[0] + "?");
            move = input.nextInt();
        } else {
            System.out.println("In welche Spalte möchtest du deine Münze werfen, " + players[1] + "?");
            move = input.nextInt();
        }
    }

    //-------------------------------------------------------------Prüfen auf Gültigkeit des Zugs------------------------------------------------------------------
    public static void isValid() {
        printBoard();
        if((rows[i] != "" && move == rows[i]) || (columns[j] != "" && move == columns[j])) {
            System.out.println("Der gewünschte Zug ist ungültig. Bitte nochmal einwerfen.");
            move = input.nextInt();
        }
    }

    //--------------------------------------------------------------------Spielfeld--------------------------------------------------------------------------------
    public static void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}