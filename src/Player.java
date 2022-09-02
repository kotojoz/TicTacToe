package src;

import java.util.Random;

abstract class Player {
    private final int MAX = 9;

    private final int MIN = 1;

    private final Random random = new Random();

    public void makeRandomMove(Field field, char mark) {
        while (true) {
            int number = random.nextInt((MAX - MIN - 1) + MAX);
            Cell cell = field.grid.get(number);

            if (cell.getMark() == field.EMPTY_CELL) {
                cell.setMark(mark);
                break;
            }
        }
    }

    public abstract void makeAMove(Field field, char mark);
}
