package com.companies.jp.conway.gol.strategy;

public class RandomLife implements ILife {

    private int rows, cols;
    private int [][] grid;;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public RandomLife() {
        rows = 6;
        cols = 8;
        grid  = new int[rows][cols];
    }

    public RandomLife(int rows, int cols) {
        this.grid = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public int[][] birth() {

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                grid[i][j] = 0 + (int)(Math.random() * ((1 - 0) + 1));
            }

        return grid;
    }
}
