package it.sevenbits.workshop12;

import it.sevenbits.workshop12.matrix.Matrix;

public class Main {
    public static void main(String[] args){
        Matrix m = new Matrix(4 ,3);
        System.out.println(m.toString());

        m.inverseMatrix();
        System.out.println(m.toString());


    }
}
