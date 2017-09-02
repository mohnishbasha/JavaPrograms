package com.companies.jp.conway.gol.model;

import com.companies.jp.conway.gol.strategy.IEvolution;

import java.util.HashSet;
import java.util.Set;

/*
Community represents the current life form in a 2D space grid

 */
public class Community {

    // Community consists of live cells
    private Set<Cell> aliveCells = new HashSet<Cell>();;
    private IEvolution evolution;
    private int[][] grid = null;

    public void setEvolution(IEvolution evolution) { this.evolution = evolution; }

    public void setCommunityGrid(int[][] grid) {
        this.grid = grid;
    }

    private int getRows() {
        return this.grid.length;
    }

    private int getCols() {
        return this.grid[0].length;
    }


    // Build the Community
    public void buildCommunity() {

        for (int i = 0; i < getRows(); i++)
            for (int j = 0; j < getCols(); j++)
            {
                if (grid[i][j] == 1) {
                    Cell cell = new Cell(i, j, true);
                    aliveCells.add(cell);
                }
            }
        displayCommunity(aliveCells);
    }

    private void displayCommunity(Set<Cell> aliveCells) {

        System.out.println("Displaying Life Community");
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                Cell tmpCell = new Cell(i, j, true);
                if (!aliveCells.contains(tmpCell))
                    System.out.print("*");
                else
                    System.out.print("0");

            }
            System.out.println();
        }
        System.out.println();

    }

    public void runEvolution() {
        displayCommunity(evolution.runEvolution(aliveCells));
    }
}

