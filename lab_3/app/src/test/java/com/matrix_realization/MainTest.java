package com.matrix_realization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.ArrayList;

public class MainTest {
    private final ArrayList<ArrayList<Integer>> matrixSource1;
    private final ArrayList<ArrayList<Integer>> matrixSource2;
    private final ArrayList<Integer> row;


    public MainTest() {
//        matrix 3x5
        matrixSource1 = new ArrayList<>();
        int numb = 0;
        for (int row = 0; row < 3; row++) {
            matrixSource1.add(new ArrayList<>());
            for (int col = 0; col < 5; col++) {
                matrixSource1.get(row).add(numb++);
            }
        }
//        matrix 6x7 but empty
        matrixSource2 = new ArrayList<>();
        for (int row = 0; row < 6; row++) {
            matrixSource2.add(new ArrayList<>());
        }
//        matrix row (should contain 5 elements)
        row = new ArrayList<>();
        for (int i = 100; i < 105; i++) {
            row.add(i);
        }
    }

    @Test
    @DisplayName("Testing for empty matrix without dimensions.")
    public void testEmptyWithoutDim() {
        ArrayList<ArrayList<Integer>> emptyMatrix = new ArrayList<>();
        Matrix emptyMatrixTest = new Matrix();
        assertThat(emptyMatrixTest.getMatrix(), equalTo(emptyMatrix));
    }


    @Test
    @DisplayName("Testing for empty matrix with specific dimensions (2x3).")
    public void testEmptyWithDim() {
        ArrayList<ArrayList<Integer>> emptyMatrixWithSize = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            emptyMatrixWithSize.add(new ArrayList<>());
        }
        Matrix emptyMatrixWithSizeTest = new Matrix(2, 3);
        assertThat(emptyMatrixWithSizeTest.getMatrix(), equalTo(emptyMatrixWithSize));
    }


    @Test
    @DisplayName("Testing for generation of non-empty matrix from the given matrix.")
    public void testGeneratedNonEmpty()
    {
        Matrix generatedOnGivenTest = new Matrix(matrixSource1);
        assertThat(generatedOnGivenTest.getMatrix(), equalTo(matrixSource1));
    }


    @Test
    @DisplayName("Testing for generation of empty matrix from the given matrix.")
    public void testGeneratedEmpty()
    {
        Matrix generatedOnGivenTest = new Matrix(matrixSource2);
        assertThat(generatedOnGivenTest.getMatrix(), equalTo(matrixSource2));
    }


    @Test
    @DisplayName("Testing for correct dimensions.")
    public void correctDim() {
        Matrix m = new Matrix(2, 4);
        int[] dimensions = {2, 4};
        assertThat(m.getSize(), equalTo(dimensions));
    }


    @Test
    @DisplayName("Test for getting correct element.")
    public void getElement() {
        Matrix m = new Matrix(matrixSource1);
        assertThat(m.getElement(0, 0), is(0));
    }


    @Test
    @DisplayName("Test for setting value of a particular element.")
    public void setValueTest() {
        Matrix m = new Matrix(matrixSource1);
        m.setElement(0, 1, -45);
        assertThat(m.getElement(0, 1), is(-45));
    }


    @Test
    @DisplayName("Test for objects equality.")
    public void checkIfEquals() {
        Matrix m1 = new Matrix(matrixSource1);
        Matrix m2 = new Matrix(matrixSource1);
        Matrix m3 = new Matrix(matrixSource2);
        assertThat(m1.equals(m2), is(true));
        assertThat(m1.equals(m1), is(true));
        assertThat(m1.equals(m3), is(false));
        assertThat(m1.equals(null), is(false));
    }

    @Test
    @DisplayName("HashCode test.")
    public void hashCodeTest() {
        Matrix m1 = new Matrix(matrixSource1);
        Matrix m2 = new Matrix(matrixSource1);
        Matrix m3 = new Matrix(matrixSource2);
        assertThat(m1.hashCode(), is(m2.hashCode()));
        assertThat(m1.hashCode() == m3.hashCode(), is(false));
    }


    @Test
    @DisplayName("Test for setting cols and getting rows.")
    public void rowsTest() {
        Matrix m = new Matrix((matrixSource1));
        m.setRowFrom(0, row);
        assertThat(m.getRow(0), is(row));
    }
}
