package src.players;

import src.Cell;
import src.Field;
import src.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerHard extends Player {

    private char computer;

    private char opposite;

    private int bestMove;


    @Override
    public void makeAMove(Field field, char player) {
        computer = player;

        opposite = computer == Field.X ? Field.O : Field.X;

        minimax(field.board, player);

        field.board.get(bestMove).setMark(player);
        System.out.println("Making move level \"hard\"");
    }


    public int minimax(Map<Integer, Cell> board, char player) {

        //available spots
        List<Integer> availSpots = getIndexesOfEmptyCells(board);


        // checks for the terminal states such as win, lose, and tie
        //and returning a value accordingly
        if (Game.winning(board, opposite)) {
            return -10;
        } else if (Game.winning(board, computer)) {
            return 10;
        } else if (availSpots.size() == 0) {
            return 0;
        }

        // an array to collect all the objects
        Map<Integer, Integer> moves = new HashMap<>();

        // loop through available spots
        for (Integer spot : availSpots) {
            board.get(spot).setMark(player); // set the empty spot to the current player

            /*collect the score resulted from calling minimax
            on the opponent of the current player*/
            int result;
            if (player == computer) {
                result = minimax(board, opposite);
            } else {
                result = minimax(board, computer);
            }
            moves.put(spot, result);

            board.get(spot).setMark(Field.EMPTY_CELL); // reset the spot to empty
        }

        // if it is the computer's turn loop over the moves and choose the move with the highest score and set bestMove
        if (player == computer) {
            int bestScore = -10000;
            for (Map.Entry<Integer, Integer> move : moves.entrySet()) {
                if (move.getValue() > bestScore) {
                    bestScore = move.getValue();
                    bestMove = move.getKey();
                }
            }
        } else {
            // else loop over the moves and choose the move with the lowest score and set bestMove
            int bestScore = 10000;
            for (Map.Entry<Integer, Integer> move : moves.entrySet()) {
                if (move.getValue() < bestScore) {
                    bestScore = move.getValue();
                    bestMove = move.getKey();
                }
            }
        }
        // return the best score from the moves array
        return moves.get(bestMove);
    }

    // returns list of the indexes of empty spots on the board
    public List<Integer> getIndexesOfEmptyCells(Map<Integer, Cell> board) {
        return board.entrySet().stream()
                .filter(entry -> entry.getValue().getMark() == Field.EMPTY_CELL).map(Map.Entry::getKey).toList();
    }
}
