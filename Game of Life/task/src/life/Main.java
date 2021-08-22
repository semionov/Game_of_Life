package life;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        //long seed = (long) (Math.random() * (100 - 10 + 1) + 10);
        int numberOfGenerations = (int) (Math.random() * (20 - 10 + 1) + 10);

        GenAlgorithm genAlgorithm = new GenAlgorithm();
        Universe universe = new Universe(genAlgorithm.createGen(size));
        Universe[] generations = new Universe[numberOfGenerations + 1];

        //if (numberOfGenerations > 0) {
        generations[0] = universe;

        for (int i = 1; i < numberOfGenerations + 1; i++) {
            generations[i] = new Universe(GenAlgorithm.newGen(generations[i - 1].getUniverse()));
        }
        //printOutUniverse(generations[numberOfGenerations]);
        //} else {
        //   printOutUniverse(universe);
        //}

        for (int i = 0; i < generations.length; i++) {
            clearConsole();
            System.out.println("Generation #" + i);
            System.out.println("Alive: " + generations[i].aliveCount());
            printOutUniverse(generations[i]);
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        scanner.close();
        System.exit(0);
    }

    public static void printOutUniverse(Universe universe) {
        for (char[] i: universe.getUniverse()) {
            for (char j: i) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public static void clearConsole() {

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }
}