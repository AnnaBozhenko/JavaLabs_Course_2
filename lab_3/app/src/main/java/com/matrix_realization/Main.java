package com.matrix_realization;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Test diag function
//        --------------------------------------------------
//        ArrayList<Integer> vector = new ArrayList<>();
//        for (int i = 1; i < 6; i++) {
//            vector.add(i);
//        }
//        Matrix.printMatrix(Matrix.diag(vector));
//        --------------------------------------------------
//        test fill manually function;
//        --------------------------------------------------
//        Matrix a = new Matrix(2, 2);
//        a.fillManually();
//        Matrix.printMatrix(a.getMatrix());
//        --------------------------------------------------
//        Test ones function
//        --------------------------------------------------
//        Matrix.printMatrix(Matrix.ones(8, 8));
//        --------------------------------------------------
//        Test random row function
//        --------------------------------------------------
//        Matrix.printMatrix(Matrix.randomRow(7, 12, 3));
//        --------------------------------------------------
//        Test random col function
//        --------------------------------------------------
//        Matrix.printMatrix(Matrix.randomCol(7, 100, 12));
//        --------------------------------------------------
//        Test for generation a square matrix
//        --------------------------------------------------
        ArrayList<ArrayList<Integer>> matrixSource = new ArrayList<>();
        int numb = 0;
        for (int row = 0; row < 5; row++) {
            matrixSource.add(new ArrayList<>());
            for (int col = 0; col < 5; col++) {
                matrixSource.get(row).add(numb++);
            }
        }
//        Matrix a = new Matrix(matrixSource);
//        Matrix.printMatrix(a.getMatrix());
//        --------------------------------------------------
//        Test lower matrix
//        --------------------------------------------------
//        Matrix.printMatrix(a.lowerTriangle(a.getMatrix()));
//        --------------------------------------------------
//        Test upper matrix
//        --------------------------------------------------
//        Matrix.printMatrix(a.upperTriangle(a.getMatrix()));
//        --------------------------------------------------
//        Test for multiplication by scalar
//        --------------------------------------------------
//        Matrix.printMatrix(a.multiplicationOnScalar(a.getMatrix(), 10));
//        --------------------------------------------------
//        Test for addition to scalar
//        --------------------------------------------------
//        Matrix.printMatrix(a.additionOnScalar(a.getMatrix(), 10));
//        --------------------------------------------------
//        Test for multiplication of matrices
//        --------------------------------------------------
//        Matrix m1 = new Matrix(2, 3);
//        m1.fillManually();
//        Matrix m2 = new Matrix(3, 1);
//        m2.fillManually();
//        System.out.println("\nMatrix 1: ");
//        Matrix.printMatrix(m1.getMatrix());
//        System.out.println("\nMatrix 2: ");
//        Matrix.printMatrix(m2.getMatrix());
//        System.out.println("\nMultiplication: ");
//        Matrix.printMatrix(Matrix.multiplicationMatrices(m1.getMatrix(), m2.getMatrix()));
//        --------------------------------------------------
//        Test immutability of MatrixIm
//        --------------------------------------------------
//        MatrixIm a = new MatrixIm(matrixSource);
//        MatrixIm.printMatrix(a.getMatrix());
//        matrixSource.get(0).set(0, -13);
//        MatrixIm.printMatrix(a.getMatrix());
//        --------------------------------------------------
//        Test mutability of Matrix
//        --------------------------------------------------
//        Matrix a = new Matrix(matrixSource);
//        Matrix.printMatrix(a.getMatrix());
//        matrixSource.get(0).set(0, -13);
//        Matrix.printMatrix(a.getMatrix())
//        --------------------------------------------------
//        MatrixEnv b = new MatrixIm(matrixSource);
//        ArrayList<ArrayList<Integer>> c = b.getMatrix();
//        if (c != null) Matrix.printMatrix(c);
    }
}
