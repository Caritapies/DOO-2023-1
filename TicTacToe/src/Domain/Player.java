package Domain;
public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public void playRound(Byte row, Byte column) {
        if(isAvaliable(row, column)){
            Board.board[row-1][column-1] = this.symbol;
            Board.freeBoxes -= 1;
            Board.round += 1;
        }

    }
    public boolean isAvaliable(Byte row, Byte column){
        return Board.board[row-1][column-1] == ' ';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
