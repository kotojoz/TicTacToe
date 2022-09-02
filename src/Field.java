package src;

import java.util.HashMap;
import java.util.Map;

public class Field {

    protected static final char X = 'X';

    protected static final char O = 'O';

    protected static final char EMPTY_CELL = '_';

    protected Map<Integer, Cell> grid;

    public Field() {
        createField();
        printField();
    }

    public void createField() {
        grid = new HashMap<>();
        int counter = 1;

        int MAX_ROW_AND_COLUMN_COUNT = 3;
        for (int row = 1; row <= MAX_ROW_AND_COLUMN_COUNT; row++) {
            for (int column = 1; column <= MAX_ROW_AND_COLUMN_COUNT; column++) {
                grid.put(counter++, new Cell(row, column, EMPTY_CELL));
            }
        }
    }

    public void printField() {
        int cell_id = 1;
        System.out.println("---------");
        int MAX_CELL_COUNT = 9;
        while (cell_id < MAX_CELL_COUNT) {
            int counter = 0;
            System.out.print("| ");
            while (counter < 3) {
                System.out.print(grid.get(cell_id).getMark() + " ");
                cell_id++;
                counter++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

}
