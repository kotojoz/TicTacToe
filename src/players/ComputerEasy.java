package src.players;

import src.Field;

public class ComputerEasy extends Player {

    @Override
    public void makeAMove(Field field, char mark) {
        makeRandomMove(field, mark);
        System.out.println("Making move level \"easy\"");
    }
}
