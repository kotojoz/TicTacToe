package src.players;

import src.Cell;
import src.Field;

public class ComputerMedium extends Player {

    private int bestMove;

    @Override
    public void makeAMove(Field field, char mark) {
        if (isBestMove(field)) {
            field.board.get(bestMove).setMark(mark);
        } else {
            makeRandomMove(field, mark);
        }
        System.out.println("Making move level \"medium\"");
    }

    private boolean isBestMove(Field field) {
        return checkResult(field.board.get(1), field.board.get(2), field.board.get(3), field) ||
                checkResult(field.board.get(4), field.board.get(5), field.board.get(6), field) ||
                checkResult(field.board.get(7), field.board.get(8), field.board.get(9), field) ||

                checkResult(field.board.get(1), field.board.get(4), field.board.get(7), field) ||
                checkResult(field.board.get(2), field.board.get(5), field.board.get(8), field) ||
                checkResult(field.board.get(3), field.board.get(6), field.board.get(9), field) ||

                checkResult(field.board.get(1), field.board.get(5), field.board.get(9), field) ||
                checkResult(field.board.get(3), field.board.get(5), field.board.get(7), field);
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