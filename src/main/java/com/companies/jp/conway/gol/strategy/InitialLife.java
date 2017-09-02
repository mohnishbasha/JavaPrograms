package com.companies.jp.conway.gol.strategy;

public class InitialLife implements ILife {

    // setting this to 6 * 8 as per the assignment doc.
    // int rows = 6, cols = 8;

    // pre-initializing this as per the assignment doc.
    // to be transformed into Community
    private int [][] grid  = {
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 1, 1, 1, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
    };

    public int[][] birth() {
        return grid;
    }
}
