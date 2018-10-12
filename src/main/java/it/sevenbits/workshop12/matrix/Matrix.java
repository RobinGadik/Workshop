package it.sevenbits.workshop12.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private final int CELL_MAX_VALUE = 100;
    private Cell[][] matrix;

    public Matrix(int rowsCount, int columnsCount) {
        this.matrix = new Cell[rowsCount][columnsCount];
        fillMatrixByRandomValues();
    }

    private void fillMatrixByRandomValues(){
        Random r = new Random();

        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++){
                int cellValue = r.nextInt(CELL_MAX_VALUE);
                Cell newCell = new Cell(x,y,cellValue);
                matrix[x][y] = newCell;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++){
                sb.append(matrix[x][y].getValue()).append(" ");
            }
            sb.append("\n");
        }


        return sb.toString();
    }

    public void inverseMatrix(){
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++){
                matrix[x][y].inverse();
            }
        }
    }
}
