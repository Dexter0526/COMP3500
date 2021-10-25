package academy.pocu.ch08.tictactoe;

public class Move {
    private int index;
    private int score;

    public Move(final int index, final int score){
        this.index = index;
        this.score = score;
    }

    public int getIndex() {
        return index;
    }

    public int getScore() {
        return score;
    }
}
