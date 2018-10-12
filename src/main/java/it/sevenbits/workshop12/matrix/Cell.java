package it.sevenbits.workshop12.matrix;

class Cell {
    private int x;
    private int y;
    private int value;

    private Cell() {
    }

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void inverse(){
        value = -value;
    }
}
