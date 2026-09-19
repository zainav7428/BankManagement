package game;

import java.util.*;

public class TicTacToe {

    static String[] board = new String[9];
    static String turn = "X";

    // Display Board
    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    // Check Winner
    static boolean checkWinner() {

        // Rows
        if (checkLine(0, 1, 2)) return true;
        if (checkLine(3, 4, 5)) return true;
        if (checkLine(6, 7, 8)) return true;

        // Columns
        if (checkLine(0, 3, 6)) return true;
        if (checkLine(1, 4, 7)) return true;
        if (checkLine(2, 5, 8)) return true;

        // Diagonals
        if (checkLine(0, 4, 8)) return true;
        if (checkLine(2, 4, 6)) return true;

        return false;
    }

    // Check if three positions contain the same player's symbol
    static boolean checkLine(int a, int b, int c) {

        return board[a].equals(board[b]) &&
                board[b].equals(board[c]) &&
                (board[a].equals("X") || board[a].equals("O"));
    }

    // Switch Player
    static void switchTurn() {

        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize Board
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        int moves = 0;

        // Game Loop
        while (moves < 9) {

            printBoard();

            System.out.println("Player " + turn + ", enter slot (1-9):");
            int position = sc.nextInt();

            // Validate position
            if (position < 1 || position > 9) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            // Check if position is occupied
            if (board[position - 1].equals("X") ||
                    board[position - 1].equals("O")) {

                System.out.println("Position already occupied! Try again.");
                continue;
            }

            // Place player's symbol
            board[position - 1] = turn;
            moves++;

            // Check Winner
            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + turn + " wins!");
                break;
            }

            // Check Draw
            if (moves == 9) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            // Switch Turn
            switchTurn();
        }

        sc.close();
    }
}