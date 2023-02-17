import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static int turn = 0;

    public static void main(String[] args) {
        while (true) {
            printBoard();
            if (checkWin('X')) {
                System.out.println("Ganador: X");
                break;
            } else if (checkWin('O')) {
                System.out.println("Ganador: O");
                break;
            } else if (turn == 9) {
                System.out.println("Empate");
                break;
            }
            getMove();
            turn++;
        }
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    static void getMove() {
        char symbol = turn % 2 == 0 ? 'X' : 'O';
        System.out.print("Jugador " + symbol + ", ingrese su movimiento (fila columna): ");
        int row = sc.nextInt() - 1;
        int col = sc.nextInt() - 1;
        if (board[row][col] == ' ') {
            board[row][col] = symbol;
        } else {
            System.out.println("Movimiento no válido, intente de nuevo");
            turn--;
        }
    }

    static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }
}