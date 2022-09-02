package src;

import java.util.Optional;

public class User extends Player {
    @Override
    public void makeAMove(Field field, char mark) {
        while (true) {

            int[] numbers = InputHandler.enterCoordinates();
            Optional<Cell> cellOptional = field.grid.values().stream()
                    .filter(v -> v.getRow() == numbers[0] && v.getColumn() == numbers[1]).findFirst();

            if (cellOptional.isPresent()) {
                Cell cell = cellOptional.get();
                if (cell.getMark() == field.EMPTY_CELL) {
                    cell.setMark(mark);
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
        }
    }
}
