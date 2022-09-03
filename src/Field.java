package src;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Field {

    protected static final char X = 'X';

    protected static final char O = 'O';

    public static final char EMPTY_CELL = '_';

    public Map<Integer, Cell> grid;

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
        System.out.println("\n---------");
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
        System.out.println("---------\n");
    }

    public Cell findEmptyCell(Cell cell1, Cell cell2, Cell cell3) {
        return Stream.of(cell1, cell2, cell3).filter(v -> v.getMark() == Field.EMPTY_CELL).findFirst().orElse(null);
    }

    public int getCellId(Cell cell) {
        Map.Entry<Integer, Cell> entry = grid.entrySet().stream().filter(v -> v.getValue().equals(cell)).findFirst().orElse(null);
        assert entry != null;
        return entry.getKey();
    }
}
