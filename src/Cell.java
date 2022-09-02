package src;

public class Cell {

    private final int row;

    private final int column;

    private char mark;

    public Cell(int row, int column, char mark) {
        this.row = row;
        this.column = column;
        this.mark = mark;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
}
