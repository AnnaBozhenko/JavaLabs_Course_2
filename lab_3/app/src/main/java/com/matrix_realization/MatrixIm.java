package com.matrix_realization;

import java.util.ArrayList;
import java.util.Scanner;

public final class MatrixIm implements MatrixEnv{

    private final ArrayList<ArrayList<Integer>> matrix;
    private final int rowsN;
    private final int colsN;

    static ArrayList<ArrayList<Integer>> diag (ArrayList<Integer> vector) {
        /* vector - array of numbers to be set on the diagonal of the matrix;
         * returns diagonal matrix.*/
        ArrayList<ArrayList<Integer>> diagMatrix = new ArrayList<>();
        for (int r = 0; r < vector.size(); r++) {
            diagMatrix.add(new ArrayList<>());
            for (int c = 0; c < vector.size(); c++) {
                if (r == c) diagMatrix.get(r).add(vector.get(c));
                else diagMatrix.get(r).add(0);
            }
        }
        return diagMatrix;
    }


    static ArrayList<ArrayList<Integer>> ones (int rows, int cols) {
        /*rows and cols - numbers;
         * returns created matrix with dimensions [rows X cols],
         * where on the diagonal are set ones.*/
        ArrayList<ArrayList<Integer>> onesMatrix = new ArrayList<>();
        if (rows == cols) {
            for (int r = 0; r < rows; r++) {
                onesMatrix.add(new ArrayList<>());
                for (int c = 0; c < cols; c++) {
                    if (r == c) onesMatrix.get(r).add(1);
                    else onesMatrix.get(r).add(0);
                }
            }
        }
        return onesMatrix;
    }


    static ArrayList<ArrayList<Integer>> randomRow (int cols, int maxValue, int minValue) {
        /* cols - number; maxValue and MinValue - upper and lower bounds for random numbers;
         * returns created matrix with [1 X cols] dimensions filled with random numbers.*/
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
        m.add(new ArrayList<>());
        for (int i = 0; i < cols; i++) {
            m.get(0).add((int) ((Math.random() * (maxValue - minValue)) + minValue));
        }
        return m;
    }


    static ArrayList<ArrayList<Integer>> randomCol (int rows, int maxValue, int minValue) {
        /* cols - number; maxValue and MinValue - upper and lower bounds for random numbers;
         * returns created matrix with [rows X 1] dimensions filled with random numbers.*/
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            matrix.get(i).add((int) ((Math.random() * (maxValue - minValue)) + minValue));
        }
        return matrix;
    }


    public ArrayList<ArrayList<Integer>> lowerTriangle (ArrayList<ArrayList<Integer>> m) {
        /*creates and returns a lowerTriangle matrix based on the given matrix;
         * if the given matrix is not square, then return empty matrix.  */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (Matrix.isMatrix(m) && m.size() == m.get(0).size()) {
            for (int r = 0; r < m.size(); r++) {
                res.add(new ArrayList<>());
                for (int c = 0; c < m.get(r).size(); c++) {
                    if (c > r) res.get(r).add(0);
                    else res.get(r).add(m.get(r).get(c));
                }
            }
        }
        return res;
    }


    public ArrayList<ArrayList<Integer>> upperTriangle (ArrayList<ArrayList<Integer>> m) {
        /*creates and returns a upperTriangle matrix based on the given matrix;
         * if the given matrix is not square, then return empty matrix.  */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (isMatrix(m) && m.size() == m.get(0).size()) {
            for (int r = 0; r < m.size(); r++) {
                res.add(new ArrayList<>());
                for (int c = 0; c < m.get(r).size(); c++) {
                    if (c < r) res.get(r).add(0);
                    else res.get(r).add(m.get(r).get(c));
                }
            }
        }
        return res;
    }


    public ArrayList<ArrayList<Integer>> multiplicationOnScalar(ArrayList<ArrayList<Integer>> m, int scalar) {
        /*m - array; scalar - number;
         * returns matrix with elements multiplied on the given scalar value,
         * if m is not a matrix then return empty matrix.*/
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (isMatrix(m)) {
            int rowsNumber = m.size();
            int colsNumber = m.get(0).size();
            if (colsNumber == 0) return res;
            int temp;
            for (int r = 0; r < rowsNumber; r++) {
                res.add(new ArrayList<>());
                for (int c = 0; c < colsNumber; c++) {
                    temp = m.get(r).get(c) * scalar;
                    res.get(r).add(temp);
                }
            }
        }
        return res;
    }


    public ArrayList<ArrayList<Integer>> additionOnScalar(ArrayList<ArrayList<Integer>> m, int scalar) {
        /*m - array; scalar - number;
         * returns matrix with elements added with the given scalar value,
         * if m is not a matrix then return empty matrix.*/
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (isMatrix(m)) {
            int rowsNumber = m.size();
            int colsNumber = m.get(0).size();
            if (colsNumber == 0) return res;
            int temp;
            for (int r = 0; r < rowsNumber; r++) {
                res.add(new ArrayList<>());
                for( int c =0; c < colsNumber; c++) {
                    temp = m.get(r).get(c) + scalar;
                    res.get(r).add(temp);
                }
            }
        }
        return res;
    }


    MatrixIm() {
        rowsN = 0;
        colsN = 0;
        matrix = new ArrayList<>();
    }


    MatrixIm (int rowsNumber, int colsNumber) {
        rowsN = rowsNumber;
        colsN = colsNumber;
        matrix = new ArrayList<>(rowsN);
        Scanner sc = new Scanner(System.in);
        for (int r = 0; r < rowsN; r++) {
            matrix.add(new ArrayList<>(colsN));
            for (int c = 0; c < colsN; c++) {
                System.out.printf("Enter element[%d][%d]: ", r, c);
                matrix.get(r).add(sc.nextInt());
            }
        }
    }


    MatrixIm (ArrayList<ArrayList<Integer>> sourceMatrix) {
        rowsN = sourceMatrix.size();
        colsN = sourceMatrix.get(0).size();
        matrix = new ArrayList<>(rowsN);
        for (int r = 0; r < rowsN; r++) {
            matrix.add(new ArrayList<>(colsN));
            for (int c = 0; c < colsN; c++) {
                matrix.get(r).add(sourceMatrix.get(r).get(c));
            }
        }
    }


    boolean isFull() {
        for (ArrayList<Integer> row: matrix) {
            if (row.size() == 0) return false;
        }
        return true;
    }


    static boolean isMatrix(ArrayList<ArrayList<Integer>> m) {
        /*returns true if given array is a matrix, else otherwise. */
        if (m.size() > 0) {
            int cols = m.get(0).size();
            for (ArrayList<Integer> row: m) {
                if (row.size() != cols) return false;
            }
        }
        return true;
    }


    static void printMatrix(ArrayList<ArrayList<Integer>> m) {
        /*prints to the console m (if m is matrix)*/
        if (isMatrix(m)) {
            int rowsNumber = m.size();
            int colsNumber = m.get(0).size();
            System.out.print("\n[");
            for (int r = 0; r < rowsNumber; r++) {
                if (r == 0) System.out.print("[");
                else System.out.print(" [");
                for (int c = 0; c < colsNumber; c++) {
                    System.out.printf("%d", m.get(r).get(c));
                    if (c + 1 == colsNumber) {
                        if (r + 1 == rowsNumber) System.out.print("]]");
                        else System.out.printf("],\n");
                    } else System.out.print(",");
                }
            }
        }
    }


    public ArrayList<Integer> getRow(int row) {
        ArrayList<Integer> rowList = new ArrayList<>(colsN);
        if (row < rowsN && isFull()) {
            for (int col = 0; col < colsN; col++) {
                rowList.add(matrix.get(row).get(col));
            }
        }
        return rowList;
    }


    public ArrayList<Integer> getCol(int col) {
        ArrayList<Integer> colsList = new ArrayList<>(rowsN);
        if (col < colsN && isFull()) {
            for (int row = 0; row < rowsN; row++) {
                colsList.add(matrix.get(row).get(col));
            }
        }
        return colsList;
    }


    public int getElement(int row, int col) {
        if (row < rowsN && col < colsN && isFull()) {
            return matrix.get(row).get(col);
        }
        else return 0;
    }


    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }


    public int[] getSize() {
        int[] arr = {rowsN, colsN};
        return arr;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null || obj.getClass() != this.getClass()) return false;
        MatrixIm otherObj = (MatrixIm)obj;
        if (otherObj.colsN != this.colsN || otherObj.rowsN != this.rowsN) return false;
        else {
//            check the content of objects matrix data
            boolean objIsFull = ((MatrixIm) obj).isFull();
            if (objIsFull != isFull()) return false;
            if (objIsFull) {
                for (int row = 0; row < rowsN; row++) {
                    for (int col = 0; col < colsN; col++) {
                        if (!((MatrixIm) obj).matrix.get(row).get(col).equals(this.matrix.get(row).get(col))) return false;
                    }
                }
            }
            return true;
        }
    }


    @Override
    public int hashCode() {
        int result = 1;
        int SEED = 31;
        int sumOfInternalElements = 0;
        if (isFull()) {
            for (int r = 0; r < rowsN; r++) {
                for (int c = 0; c < colsN; c++) {
                    sumOfInternalElements += matrix.get(r).get(c);
                }
            }
        }
        result = SEED * result + this.rowsN;
        result = SEED * result + this.colsN;
        result = SEED * result + Math.abs(sumOfInternalElements);
        return result;
    }
}

