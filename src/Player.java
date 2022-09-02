package src;

import java.util.Random;

abstract class Player {

    private final Random random = new Random();

    public void makeRandomMove(Field field, char mark) {
        Cell cell;
        while (true) {
            int MAX = 9;
            int MIN = 1;
            int number = random.nextInt((MAX - MIN + 1) + MIN);
            cell = field.grid.get(number);

            if (cell != null && cell.getMark() == field.EMPTY_CELL) {
                cell.setMark(mark);
                break;
            }
        }
    }

    public abstract void makeAMove(Field field, char mark);
}
