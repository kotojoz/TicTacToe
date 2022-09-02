package src;

import java.util.HashMap;
import java.util.Map;

public class Field {

    private final int MAX_ROW_AND_COLUMN_COUNT = 3;

    protected final char X = 'X';

    protected final char O = 'O';

    protected final char EMPTY_CELL = '_';

    protected Map<Integer, Cell> grid;

    public Field() {
        createField();
        printField();
    }

    public void createField() {
        grid = new HashMap<>();
        int counter = 1;

        for (int row = 1; row <= MAX_ROW_AND_COLUMN_COUNT; row++) {
            for (int column = 1; column <= MAX_ROW_AND_COLUMN_COUNT; column++) {
                grid.put(counter++, new Cell(row, column, EMPTY_CELL));
            }
        }
    }

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < MAX_ROW_AND_COLUMN_COUNT; i++) {
            System.out.print("| ");
            for (int j = 1; j <= MAX_ROW_AND_COLUMN_COUNT; j++) {
                System.out.print(grid.get(j + i).getMark() + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
