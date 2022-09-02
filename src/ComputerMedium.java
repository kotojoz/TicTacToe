package src;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ComputerMedium extends Player {

    private int bestMove;

    @Override
    public void makeAMove(Field field, char mark) {
        if (isBestMove(field.grid)){
            field.grid.get(bestMove).setMark(mark);
        }else {
            makeRandomMove(field, mark);
        }
        System.out.println("Making move level \"medium\"");
    }

    private boolean isBestMove(Map<Integer, Cell> grid) {
        return checkResult(grid.get(1), grid.get(2), grid.get(3), grid) ||
                checkResult(grid.get(4), grid.get(5), grid.get(6), grid) ||
                checkResult(grid.get(7), grid.get(8), grid.get(9), grid) ||

                checkResult(grid.get(1), grid.get(4), grid.get(7), grid) ||
                checkResult(grid.get(2), grid.get(5), grid.get(8), grid) ||
                checkResult(grid.get(3), grid.get(6), grid.get(9), grid) ||

                checkResult(grid.get(1), grid.get(5), grid.get(9), grid) ||
                checkResult(grid.get(3), grid.get(5), grid.get(7), grid);
    }

    private boolean checkResult(Cell cell1, Cell cell2, Cell cell3, Map<Integer, Cell> grid) {
        int sum = cell1.getMark() + cell2.getMark() + cell3.getMark();

        if (sum == 271 || sum == 253) {
            Optional<Cell> optionalCell = Stream.of(cell1, cell2, cell3).filter(v -> v.getMark() == Field.EMPTY_CELL).findFirst();

            if (optionalCell.isPresent()) {
                Optional<Map.Entry<Integer, Cell>> optionalEntry = grid.entrySet().stream().filter(v -> v.getValue().equals(optionalCell.get())).findFirst();

                if (optionalEntry.isPresent()) {
                    bestMove = optionalEntry.get().getKey();
                    return true;
                }
            }
        }
        return false;
    }
}
