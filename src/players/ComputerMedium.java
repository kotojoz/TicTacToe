package src.players;

import src.Cell;
import src.Field;

public class ComputerMedium extends Player {

    private int bestMove;

    @Override
    public void makeAMove(Field field, char mark) {
        if (isBestMove(field)) {
            field.grid.get(bestMove).setMark(mark);
        } else {
            makeRandomMove(field, mark);
        }
        System.out.println("Making move level \"medium\"");
    }

    private boolean isBestMove(Field field) {
        return checkResult(field.grid.get(1), field.grid.get(2), field.grid.get(3), field) ||
                checkResult(field.grid.get(4), field.grid.get(5), field.grid.get(6), field) ||
                checkResult(field.grid.get(7), field.grid.get(8), field.grid.get(9), field) ||

                checkResult(field.grid.get(1), field.grid.get(4), field.grid.get(7), field) ||
                checkResult(field.grid.get(2), field.grid.get(5), field.grid.get(8), field) ||
                checkResult(field.grid.get(3), field.grid.get(6), field.grid.get(9), field) ||

                checkResult(field.grid.get(1), field.grid.get(5), field.grid.get(9), field) ||
                checkResult(field.grid.get(3), field.grid.get(5), field.grid.get(7), field);
    }

    private boolean checkResult(Cell cell1, Cell cell2, Cell cell3, Field field) {
        int sum = cell1.getMark() + cell2.getMark() + cell3.getMark();

        if (sum == 271 || sum == 253) {
            Cell cell = field.findEmptyCell(cell1, cell2, cell3);
            bestMove = field.getCellId(cell);
            return true;
        }
        return false;
    }
}