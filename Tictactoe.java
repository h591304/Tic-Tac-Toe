import java.util.Scanner;

public class Tictactoe {

    private static String makeMove(String board, String[] positions, String position, String playerPiece) {
        if (board.contains(position)) {
            board = board.replace(position, playerPiece);
            positions[Integer.valueOf(position) - 1] = playerPiece;
        }
        return board;
    }

    private static boolean checkDraw(String[] positions) {

        for (String pos : positions) {
            if (!pos.equals("X") && !pos.equals("O")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWin(String board, String[] positions, String playerPiece) {
        // Rows
        if (board.contains(playerPiece + " | " + playerPiece + " | " + playerPiece)) {
            return true;
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (positions[i].equals(playerPiece) && positions[i + 3].equals(playerPiece)
                    && positions[i + 6].equals(playerPiece)) {
                return true;
            }
        }

        // Diagonal
        if (positions[0].equals(playerPiece) && positions[4].equals(playerPiece) && positions[8].equals(playerPiece)) {
            return true;
        } else if (positions[2].equals(playerPiece) && positions[4].equals(playerPiece)
                && positions[6].equals(playerPiece)) {
            return true;
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

        // Defining player 1 and player 2 pieces
        String p1 = input;
        String p2 = (p1.equals("X")) ? "O" : "X";

        String position = "0";
        int winner = 0;
        String[] positions = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

        System.out.println("Now let's start the game!");
        System.out.println("-------------------------");
        while (winner == 0) {

            System.out.println("Player 1's turn! type the position you want to place " + p1 + ": ");
            do {
                Scanner placementScnrP1 = new Scanner(System.in);
                position = placementScnrP1.nextLine();
                if (!board.contains(position)) {
                    System.out.println("This position is already taken or doesn't exist, try again!");
                }
            } while (!board.contains(position));

            board = makeMove(board, positions, position, p1);
            System.out.println(board);
            if (checkWin(board, positions, p1)) {
                winner = 1;
                System.out.println("Gratzz, player " + winner + " wins!");
                break;
            }

            if (checkDraw(positions)) {
                System.out.println("It's a draw, nobody wins!");
                break;
            }

            System.out.println("Player 2's turn! type the position you want to place " + p2 + ": ");
            do {
                Scanner placementScnrP2 = new Scanner(System.in);
                position = placementScnrP2.nextLine();
                if (!board.contains(position)) {
                    System.out.println("This position is already taken or doesn't exist, try again!");
                }
            } while (!board.contains(position));

            board = makeMove(board, positions, position, p2);
            System.out.println(board);
            if (checkWin(board, positions, p2)) {
                winner = 2;
                System.out.println("Gratzz, player " + winner + " wins!");
                break;
            }

            if (checkDraw(positions)) {
                System.out.println("It's a draw, nobody wins!");
                break;
            }

        }

    }

}