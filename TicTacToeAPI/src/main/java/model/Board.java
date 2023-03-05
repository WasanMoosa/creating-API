package model;

import java.util.Scanner;

/**
 * This is a board class, its responsibilities are:
 * 1)Show the grid board of the game.
 * 2)know if someone win
 * 3)put the symbol in the board
 * 4)notify if the board is full
 */
public class Board {
    private char[][] grid = new char[3][3];
    private char symbol;

    // Check if grid is empty or has a symbol
    public boolean isEmpty() {
        boolean full = true;
        //Game is finish and draw
        for (int i = 0; i < 3; i++) {
            for (int r = 0; r < 3; r++) {
                if (Character.isDigit(grid[i][r])) {
                    full = false;

                }

            }

        }
        return full;
    }

    // Get grid
    public char[][] getGrid() {
        return grid;
    }

    // Set Symbol

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void changePosition(int row, int colunm) {
        grid[row][colunm]=symbol;

    }
    public void setGrid(char[][] grid){
        this.grid=grid;
    }

    public boolean win() {
        boolean win = false;
        // Win conditions
        if (grid[0][0] == symbol && grid[0][1] == symbol && grid[0][2] == symbol
                || grid[1][0] == symbol && grid[1][1] == symbol && grid[1][2] == symbol
                || grid[2][0] == symbol && grid[2][1] == symbol && grid[2][2] == symbol
                || grid[0][0] == symbol && grid[1][0] == symbol && grid[2][0] == symbol
                || grid[0][1] == symbol && grid[1][1] == symbol && grid[2][1] == symbol
                || grid[0][2] == symbol && grid[1][2] == symbol && grid[2][2] == symbol
                || grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol
                || grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            win = true;

        }
        return win;
    }
    public boolean isGridFull() {
        boolean full = true;
        //Game is finish and draw
        for (int i = 0; i < 3; i++) {
            for (int r = 0; r < 3; r++) {
                if (Character.isDigit(grid[i][r])) {
                    full = false;
                }

            }

        }
        return full;
    }
}