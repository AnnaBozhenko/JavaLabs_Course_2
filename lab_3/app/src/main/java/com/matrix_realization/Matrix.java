package com.matrix_realization;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix implements MatrixEnv{

    private ArrayList<ArrayList<Integer>> matrix;
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


    static ArrayList<ArrayList<Integer>> multiplicationMatrices(ArrayList<ArrayList<Integer>> m1, ArrayList<ArrayList<Integer>> m2) {
        /*m1 and m2 - matrices;
         * if m1 number of cols is equal to m2 number of rows then return matrix, which is
         * a multiplication of m1 and m2; else return empty matrix.*/
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (isMatrix(m1) && isMatrix(m2) && m1.get(0).size() == m2.size()) {
            int tempNumb;
            for (int rowNew = 0; rowNew < m1.size(); rowNew++){
                result.add(new ArrayList<>());
                for (int colNew = 0; colNew < m2.get(0).size(); colNew++) {
                    tempNumb = 0;
                    for (int ind = 0; ind < m2.size(); ind++) {
                        tempNumb += m1.get(rowNew).get(ind) * m2.get(ind).get(colNew);
                    }
                    result.get(rowNew).add(tempNumb);
                }
            }
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> transformedMatrix (ArrayList<ArrayList<Integer>> m) {
        /*m is an array;
         * e transformed matrix m if m is non-empty and is matrix, otherwise returns empty matrix. */
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (isMatrix(m) && 0 < m.size()){
            for (int r = 0; r < m.get(0).size(); r++) {
                res.add(new ArrayList<>());
                for (int c = 0; c < m.size(); c++) {
                    res.get(r).add(m.get(c).get(r));
                }
            }
        }
        return res;
    }


    Matrix () {
        rowsN = 0;
        colsN = 0;
        matrix = new ArrayList<>();
    }


    Matrix (int rowsNumber, int colsNumber) {
        rowsN = rowsNumber;
        colsN = colsNumber;
        matrix = new ArrayList<>(rowsN);
        for (int r = 0; r < rowsN; r++) {
            matrix.add(new ArrayList<>(colsN));
        }
    }


    Matrix (ArrayList<ArrayList<Integer>> sourceMatrix) {
        rowsN = sourceMatrix.size();
        colsN = sourceMatrix.get(0).size();
        matrix = (ArrayList<ArrayList<Integer>>) sourceMatrix.clone();
    }


    boolean isFull() {
        /*returns boolean value, if matrix is full*/
        for (ArrayList<Integer> row: matrix) {
            if (row.size() == 0) return false;
        }
        return true;
    }


    public void setElement(int row, int col, int newValue) {
        /*row and col are desired cell to set an newValue-element;
         * if given cell is out of bounds then nothing happens to matrix's element. */
        if (row < rowsN && col < colsN && isFull()) {
            matrix.get(row).set(col, newValue);
        }
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


    public void fillManually() {
        /*fills the whole matrix with received numbers from the keyboard*/
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < rowsN; row++) {
            for (int col = 0; col < colsN; col++) {
                System.out.printf("\nEnter [%d][%d]: %n", row, col);
                if (col == matrix.get(row).size()) {
                    matrix.get(row).add(sc.nextInt());
                }
                else matrix.get(row).set(col, sc.nextInt());
            }
        }
    }


    public void fillFrom(ArrayList<ArrayList<Integer>> source) {
        /* fills the matrix from the given source if dimensions of the given
        source-matrix are equal to the matrix's ones, else does nothing.*/
        if (isMatrix(source) && source.size() == rowsN && source.get(0).size() == colsN) {
            matrix = (ArrayList<ArrayList<Integer>>) source.clone();
        }
    }


    public void setRow(int row) {
        /*row is an-index number to be set, if there is such a number,
        so set a row with given values from the console.*/
        if (row < rowsN && isFull()) {
            Scanner sc = new Scanner(System.in);
            for (int col = 0; col < colsN; col++) {
                System.out.printf("Enter [%d][%d]: %n", row, col);
                matrix.get(row).set(col, sc.nextInt());
            }
        }
    }


    public void setCol(int col) {
        if (col < colsN && isFull()) {
            Scanner sc = new Scanner(System.in);
            for (int row = 0; row < rowsN; row++) {
                System.out.printf("Enter [%d][%d]: %n", row, col);
                matrix.get(row).set(col, sc.nextInt());
            }
        }
    }


    public void setRowFrom(int rowNumb, ArrayList<Integer> row) {
        if (isFull() && rowNumb < rowsN && row.size() == colsN) {
            for (int c = 0; c < colsN; c++) {
                matrix.get(rowNumb).set(c, row.get(c));
            }
        }
    }


    public void setColFrom(int colNumb, ArrayList<Integer> col) {
        if (isFull() && colNumb < colsN && col.size() == rowsN) {
            for (int r = 0; r < rowsN; r++) {
                matrix.get(r).set(colNumb, col.get(r));
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
        Matrix otherObj = (Matrix)obj;
        if (otherObj.colsN != this.colsN || otherObj.rowsN != this.rowsN) return false;
        else {
//            check the content of objects matrix data
            boolean objIsFull = ((Matrix) obj).isFull();
            if (objIsFull != isFull()) return false;
            if (objIsFull) {
                for (int row = 0; row < rowsN; row++) {
                    for (int col = 0; col < colsN; col++) {
                        if (!((Matrix) obj).matrix.get(row).get(col).equals(this.matrix.get(row).get(col))) return false;
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