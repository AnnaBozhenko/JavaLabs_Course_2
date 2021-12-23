package com.matrix_realization;

import java.util.ArrayList;

public interface MatrixEnv {
    ArrayList<Integer> getRow(int row);
    ArrayList<Integer> getCol(int col);
    int getElement(int row, int col);
    ArrayList<ArrayList<Integer>> getMatrix();
    int[] getSize();
    boolean equals(Object obj);
    int hashCode();
}
