package life;

import java.util.Random;

public class GenAlgorithm {
    private static Random random;
    //long seed;

    public GenAlgorithm() {
        //this.seed = seed;
        random = new Random();
    }

    public static char[][] newGen(char[][] oldGen) {
        char[][] newGen = new char[oldGen.length][oldGen[0].length];
        int oCounter;

        for (int i = 0; i < oldGen.length; i++) {
            for (int j = 0; j < oldGen[i].length; j++) {
                oCounter = 0;
                if (oldGen[((i - 1) + oldGen.length) % oldGen.length][j] == 'O') {
                    oCounter++;
                }
                if (oldGen[((i - 1) + oldGen.length) % oldGen.length]
                        [(j + 1) % oldGen[i].length] == 'O') {
                    oCounter++;
                }
                if (oldGen[(i + 1) % oldGen.length][j] == 'O') {
                    oCounter++;
                }
                if (oldGen[i][(j + 1) % oldGen[i].length] == 'O') {
                    oCounter++;
                }
                if (oldGen[i][((j - 1 + oldGen[i].length) % oldGen[i].length)] == 'O') {
                    oCounter++;
                }
                if (oldGen[((i - 1) + oldGen.length) % oldGen.length]
                        [((j - 1 + oldGen[i].length) % oldGen[i].length)] == 'O') {
                    oCounter++;
                }
                if (oldGen[(i + 1) % oldGen.length]
                        [(j + 1) % oldGen[i].length] == 'O') {
                    oCounter++;
                }
                if (oldGen[(i + 1) % oldGen.length]
                        [((j - 1 + oldGen[i].length) % oldGen[i].length)] == 'O') {
                    oCounter++;
                }

                if (oldGen[i][j] == 'O') {
                    if (oCounter < 2 || oCounter > 3) {
                        newGen[i][j] = ' ';
                    } else {
                        newGen[i][j] = 'O';
                    }
                } else if (oldGen[i][j] == ' ') {
                    if (oCounter == 3) {
                        newGen[i][j] = 'O';
                    } else {
                        newGen[i][j] = ' ';

                    }
                }
            }
        }
        return newGen;
    }

    public char[][] createGen(int size) {
        char[][] newBornGen = new char[size][size];

        for (int i = 0; i < newBornGen.length; i++) {
            for (int j = 0; j < newBornGen[i].length; j++) {
                if (random.nextBoolean()) {
                    newBornGen[i][j] = 'O';
                } else {
                    newBornGen[i][j] = ' ';
                }
            }
        }
        return newBornGen;
    }
}