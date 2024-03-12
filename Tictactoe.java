import java.util.Scanner;

public class Tictactoe {

    private static String makeMove(String board, String position, String playerPiece) {
        if (board.contains(position)) {
            board = board.replace(position, playerPiece);
        }
        return board;
    }

    private static boolean checkWin(String board, String playerPiece) {
        // Rows
        if (board.contains(playerPiece + " | " + playerPiece + " | " + playerPiece)) {
            return true;
        }

        // Columns
        String[] positions = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        for (int i = 1; i <= positions.length; i++) {
            System.out.println(board.indexOf(i));
        }

        return false;
    }

    public static void main(String args[]) {

        System.out.println("----------Tic-Tac-Toe----------");
        String board = "+---+---+---+\n" +
                "| 1 | 2 | 3 |\n" +
                "+---+---+---+\n" +
                "| 4 | 5 | 6 |\n" +
                "+---+---+---+\n" +
                "| 7 | 8 | 9 |\n" +
                "+---+---+---+";
        System.out.println(board);

        System.out.println("Player choose O or X: ");
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine().toUpperCase();

        switch (input) {
            case "O":
                System.out.println("Player 1 has O and player 2 has X");
                break;
            case "X":
                System.out.println("Player 1 has X and player 2 has O");
                break;
            default:
                System.out.println("Not valid piece!");
                System.exit(0);
                break;
        }

        String p1 = input;
        String p2 = (p1 == "X") ? "O" : "X";
        String position;
        int winner = 0;

        System.out.println("Now let's start the game!");
        System.out.println("-------------------------");
        while (winner == 0) {

            System.out.println("Player 1's turn! type the position you want to place " + p1 + ": ");
            Scanner placementScnrP1 = new Scanner(System.in);
            position = placementScnrP1.nextLine();

            board = makeMove(board, position, p1);
            System.out.println(board);
            if (checkWin(board, p1)) {
                System.out.println("Player 1 wins");
            }

            System.out.println("Player 2's turn! type the position you want to place " + p2 + ": ");
            Scanner placementScnrP2 = new Scanner(System.in);
            position = placementScnrP2.nextLine();

            board = makeMove(board, position, p2);
            System.out.println(board);
            if (checkWin(board, p2)) {
                System.out.println("Player 2 wins");
            }

            winner = 1;
        }

    }

}