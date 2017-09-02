package com.companies.jp.conway.gol.strategy;

import com.companies.jp.conway.gol.model.Cell;

import java.util.HashSet;
import java.util.Set;

public class ConwaysEvolution implements IEvolution {

    private Set<Cell> liveCells;

    /*

        Evolution Rules:
        1. Any live cell with fewer than two live neighbors	dies, as if	caused by underpopulation.
        2. Any live	cell with more than	three live neighbors dies, as if by	overcrowding.
        3. Any live	cell with two or three live	neighbors lives	on to the next generation.
        4. Any dead	cell with exactly three	live neighbors becomes a live cell.
        5. A cell’s	neighbors are those	cells which	are	horizontally, vertically or diagonally adjacent. Most cells
        	will have eight neighbors. Cells placed on the edge	of the	grid will have fewer.
     */

    public synchronized Set<Cell> runEvolution(Set<Cell> aliveCells) {
        liveCells = aliveCells;

        Set<Cell> nextCells = new HashSet<Cell>();
        for (Cell cell : aliveCells) {
            int countLiveNeighbor = countAliveNeighbors(cell.getNeighbors());

            // 1. Any live cell with fewer than two live neighbors dies, as	if caused by underpopulation.
            // 2. Any live cell with more than three live neighbors dies, as if by overcrowding.
            if (countLiveNeighbor == 2 || countLiveNeighbor == 3) {
                // 3. Any	live	cell	with	two	or	three	live	neighbors	lives	on	to	the	next	generation.
                nextCells.add(cell);
            }

            applyEvolution(cell, nextCells);
        }
        aliveCells = nextCells;

        return aliveCells;
    }

    private void applyEvolution(Cell cell, Set<Cell> nextCells) {
        for (Cell deadCell : deadNeighbors(cell)) {
            int countAliveNeighbors = countAliveNeighbors(deadCell.getNeighbors());

            // 4. Any	dead	cell	with	exactly	three	live neighbors	becomes	a	live	cell.
            if (countAliveNeighbors == 3) {
                nextCells.add(deadCell);
            }
        }
    }
    private Set<Cell> deadNeighbors(Cell cell) {

        Set<Cell> deadNeighbors = new HashSet<Cell>();
        for (Cell neighbor : cell.getNeighbors()) {
            if (!liveCells.contains(neighbor)) {
                deadNeighbors.add(neighbor);
            }
        }
        return deadNeighbors;
    }

    protected int countAliveNeighbors(Set<Cell> countLiveNeighbor) {
        int count = 0;
        for (Cell neighbor : countLiveNeighbor) {
            if (liveCells.contains(neighbor)) {
                count++;
            }
        }
        return count;
    }

}
