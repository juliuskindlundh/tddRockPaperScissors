package rps;

public enum Move {
    ROCK(0),PAPER(1),SCISSORS(2),NOT_A_REAL_MOVE(3);

    public int value;
    Move(int i) {
        this.value = i;
    }
}
