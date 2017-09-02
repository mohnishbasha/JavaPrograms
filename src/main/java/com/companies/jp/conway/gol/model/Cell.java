package com.companies.jp.conway.gol.model;


import com.companies.jp.conway.gol.util.CellNeighbor;

import java.util.Set;

/*
Model Cell class, consists of x, y location in a community.
 */
public class Cell {

    protected int y;
    protected int x;
    protected boolean alive;

    public Cell() { }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isAlive() {return  alive;}

    public Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public boolean equals(Object o) {

        if(o == null) return false;

        Cell cell = (Cell) o;

        if (cell == null
                || getClass() != cell.getClass()
                || alive != cell.alive
                || x != cell.x
                || y != cell.y)
            return false;

        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    public Set<Cell> getNeighbors() {
        CellNeighbor cellNeighbor = new CellNeighbor(this);
        return cellNeighbor.getNeighbours();
    }


}
