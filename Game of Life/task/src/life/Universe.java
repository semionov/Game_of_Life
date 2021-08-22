package life;

public class Universe {
    private char[][] universe;

    public Universe(char[][] universe) {
        this.universe = universe;
    }

    public char[][] getUniverse() {
        return universe;
    }

    public void setUniverse(char[][] universe) {
        this.universe = universe;
    }

    public int aliveCount() {
        int counter = 0;
        for (char[] i: universe) {
            for (char j: i) {
                if (j == 'O') {
                    counter++;
                }
            }
        }
        return counter;
    }
}