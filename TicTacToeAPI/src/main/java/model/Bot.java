package model;

import java.util.ArrayList;
import java.util.Random;

public class Bot {
    private int randomRow;
    private int randomColumn;
    private char symbol;

    public Bot(char symbol) {
        this.symbol = symbol;
    }

    public int[] makeMove(Board inputboard) {
        Board board = inputboard;
        Random random = new Random();
        boolean correctPostion = false;
        int[] randomPosition = new int[2];
        while (!correctPostion) {
            // Generate random numbers from 0 to 2 to represent row and column indices
            int randomRow = random.nextInt(3);
            int randomColumn = random.nextInt(3);

            if (!(inputboard.getGrid()[randomRow][randomColumn] == symbol)) {
                correctPostion = true;
            }
            randomPosition[0] = randomRow;
            randomPosition[1] = randomColumn;
        }
        return randomPosition;
    }

    // Get symbol
    public char getSymbol() {
        return symbol;
    }

}
