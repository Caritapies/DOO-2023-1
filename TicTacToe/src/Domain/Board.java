package Domain;

import java.util.Objects;

public class Board {
    public static int round;
    public static byte freeBoxes;
    public static char[][] board;
    public Board(){
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        freeBoxes = 9;
    }

    String menu = """
            1) Seleccionar oponente\s
            2) Definir simbolos
            3) Definir quien comienza el juego
            4) Definir nombre de los jugadores
            5) Comenzar juego""";

    public boolean verifyWinner() {
        if(Objects.equals(board[0][0], board[0][1]) && Objects.equals(board[0][1], board[0][2]) && board[0][0] != ' '){
            return true;
        }
        if (Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[1][1], board[2][2])&& board[0][0] != ' '){
            return true;
        }
        if (Objects.equals(board[1][0], board[1][1]) && Objects.equals(board[1][1], board[1][2])&& board[1][0] != ' '){
            return true;
        }
        if (Objects.equals(board[2][0], board[2][1]) && Objects.equals(board[2][1], board[2][2])&& board[2][0] != ' '){
            return true;
        }
        if (Objects.equals(board[2][0], board[1][1]) && Objects.equals(board[1][1], board[0][2])&& board[2][0] != ' '){
            return true;
        }
        if (Objects.equals(board[0][0], board[1][0]) && Objects.equals(board[1][0], board[2][0]) && board[0][0] != ' '){
            return true;
        }
        if (Objects.equals(board[0][1], board[1][1]) && Objects.equals(board[1][1], board[2][1])&& board[0][1] != ' '){
            return true;
        }
        return Objects.equals(board[0][2], board[1][2]) && Objects.equals(board[1][2], board[2][2])&& board[0][2] != ' ';
    }

    public static void reiniciarJuego(){
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        freeBoxes = 9;
    }

    public static void setRound(int round) {
        Board.round = round;
    }

    public static int getRound() {
        return Board.round;
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("  " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("----+---+----");
            }
        }
        System.out.println();
    }

    public String getMenu() {
        return menu;
    }
}
