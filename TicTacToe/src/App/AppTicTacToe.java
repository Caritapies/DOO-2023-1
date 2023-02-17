package App;

import Domain.Board;
import Domain.Player;

import java.util.Scanner;

public class AppTicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();

        Player player1 = new Player("Jugador 1", 'X');
        Player machine = new Player("Maquina", 'O');
        Player player2 = new Player("Jugador 2", 'O');

        byte row;
        byte column;
        boolean playing = true;

        System.out.println("=========MENU TIC-TAC-TOE=========");
        while (playing) {
            System.out.println(board.getMenu());
            Board.setRound((byte) (Math.random() * 2 + 1));
            byte option = in.nextByte();
            switch (option) {
                case 1 -> {
                    System.out.println("Escoja a su oponente\n1) Maquina\n2) Otro jugador");
                    option = in.nextByte();
                    if (option == 1) {
                        player2 = machine;
                    }
                }
                case 2 -> {
                    System.out.println("¿A quien deseas cambiarle su simbolo?\n1) " + player1.getName() + "\n2) " + player2.getName() + "\n3) Mostrar simbolos actuales");
                    option = in.nextByte();
                    if (option != 3) {
                        System.out.println("Ingrese el nuevo simbolo");
                    }
                    switch (option) {
                        case 1 -> player1.setSymbol(in.next().charAt(0));
                        case 2 -> player2.setSymbol(in.next().charAt(0));
                        case 3 -> {
                            System.out.println(player1.getSymbol());
                            System.out.println(player2.getSymbol());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("¿Quien deseas que comience?\n1) " + player1.getName() + "\n2) " + player2.getName());
                    option = in.nextByte();
                    switch (option) {
                        case 1:
                            Board.setRound((byte) 1);
                        case 2:
                            Board.setRound((byte) 2);
                    }
                }
                case 4 -> {
                    if (player2.getName().equals("Maquina")) {
                        System.out.println("Ingresa el nombre de " + player1.getName());
                        player1.setName(in.next());
                    } else {
                        System.out.println("A quien le deseas cambiar el nombre?\n1) " + player1.getName() + "\n2) " + player2.getName());
                        option = in.nextByte();
                        System.out.println("Ingrese el nuevo nombre");
                        switch (option) {
                            case 1 -> player1.setName(in.next());
                            case 2 -> player2.setName(in.next());
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Iniciando juego");
                    System.out.println("(Para reiniciar el juego, ingresa un numero mayor a 3)");

                    while (playing) {
                        Board.printBoard();
                        if (Board.round % 2 == 0) {
                            System.out.println("Turno de " + player1.getName());
                            System.out.println("Ingresa la fila(1-3)");
                            playing = play(player1, in, board);

                        } else if (player2.getName().equals("Maquina")) {
                            do {
                                row = (byte) (Math.random() * 3 + 1);
                                column = (byte) (Math.random() * 3 + 1);

                            }while (Board.board[row-1][column-1] != ' ');

                            player2.playRound(row, column);
                        } else {
                            System.out.println("Turno de " + player2.getName());
                            System.out.println("Ingresa la fila(1-3)");
                            playing = play(player2, in, board);
                        }
                    }
                }
            }
        }
    }
    public static boolean play(Player player, Scanner in, Board board) {
        byte row;
        byte column;
        row = in.nextByte();
        if (row < 1 || row > 3) {
            Board.reiniciarJuego();
            Board.setRound(Board.getRound() + 1);
        } else {
            System.out.println("Ingresa la columna(1-3)");
            column = in.nextByte();
            if (column < 1 || column > 3) {
                Board.reiniciarJuego();
                Board.setRound(Board.getRound() + 1);
            }
            player.playRound(row, column);
        }
        if (board.verifyWinner()) {
            System.out.println("ganaste");
            return false;
        } else if (Board.freeBoxes == 0) {
            System.out.println("Empate");
            return false;
        }
        return true;
    }
}
