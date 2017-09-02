package com.companies.jp.conway.gol.util;

import com.companies.jp.conway.gol.model.Cell;

import java.util.HashSet;
import java.util.Set;

/*
Util Funtion to figure out neighbours for a given Cell.
 */
public class CellNeighbor implements INeighbor {

    private Cell cell;

    private final int CENTER = 0;
    private final int BOTTOM = -1;
    private final int TOP = 1;
    private final int LEFT = -1;
    private final int RIGHT = 1;

    public CellNeighbor(Cell c) {
        this.cell = c;
    }

    private Cell getTopLeft() {
        return neighbor(LEFT, TOP);
    }

    private Cell getTop() {
        return neighbor(CENTER, TOP);
    }

    private Cell getTopRight() {
        return neighbor(RIGHT, TOP);
    }

    private Cell getRight() {
        return neighbor(RIGHT, CENTER);
    }

    private Cell getLeft() {
        return neighbor(LEFT, CENTER);
    }

    private Cell getBottomLeft() {
        return neighbor(LEFT, BOTTOM);
    }

    private Cell getBottom() {
        return neighbor(CENTER, BOTTOM);
    }

    private Cell getBottonRight() {
        return neighbor(RIGHT, BOTTOM);
    }

    private Cell neighbor(int xDiff, int yDiff) {
        return new Cell(cell.getX() + xDiff, cell.getY() + yDiff, cell.isAlive());
    }

    public Set<Cell> getNeighbours() {
        HashSet<Cell> neighbors = new HashSet<Cell>();
        neighbors.add(getTop());
        neighbors.add(getTopLeft());
        neighbors.add(getTopRight());
        neighbors.add(getRight());
        neighbors.add(getLeft());
        neighbors.add(getBottom());
        neighbors.add(getBottomLeft());
        neighbors.add(getBottonRight());
        return neighbors;
    }
}

