package it.sevenbits.workshop12;

import it.sevenbits.workshop12.matrix.Matrix;

public class Main {
    public static void main(String[] args) throws Exception {
        DoubleEndedQueue queue = new DoubleEndedQueue();
        if(args.length < 2){
            throw new Exception();
        }
        int rows = Integer.valueOf(args[0]);
        int columns = Integer.valueOf(args[1]);
        for(int i=0;i<2;i++){
            Matrix m = new Matrix(rows,columns);
            queue.addFirst(m);
            Matrix m_invert = new Matrix(m);
            m_invert.inverseMatrix();
            queue.addLast(m_invert);
        }

        System.out.println(queue.toString());
    }

}
