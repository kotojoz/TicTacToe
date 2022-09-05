package src;

import src.players.*;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Field field;

    private Player player1;

    private Player player2;

    private static Map<String, Player> players;

    public Game() {
        loadPlayers();
    }

    private void loadPlayers() {
        players = new HashMap<>();
        players.put("user", new User());
        players.put("easy", new ComputerEasy());
        players.put("medium", new ComputerMedium());
        players.put("hard", new ComputerHard());
    }

    public static boolean isPlayer(String player) {
        return players.get(player) != null;
    }

    private void startNewGame() {
        field = new Field();
    }

    public static boolean winning(Map<Integer, Cell> board, char player) {
        return board.get(1).getMark() == player && board.get(2).getMark() == player && board.get(3).getMark() == player ||
                board.get(4).getMark() == player && board.get(5).getMark() == player && board.get(6).getMark() == player ||
                board.get(7).getMark() == player && board.get(8).getMark() == player && board.get(9).getMark() == player ||

                board.get(1).getMark() == player && board.get(4).getMark() == player && board.get(7).getMark() == player ||
                board.get(2).getMark() == player && board.get(5).getMark() == player && board.get(8).getMark() == player ||
                board.get(3).getMark() == player && board.get(6).getMark() == player && board.get(9).getMark() == player ||

                board.get(1).getMark() == player && board.get(5).getMark() == player && board.get(9).getMark() == player ||
                board.get(3).getMark() == player && board.get(5).getMark() == player && board.get(7).getMark() == player;
    }


    protected boolean noEmptyCells() {
        return field.board.values().stream().noneMatch(v -> v.getMark() == Field.EMPTY_CELL);
    }

    public void menu() {
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("Input command:");
            String[] command = InputHandler.enterCommand();
            String START = "start";
            if (command[0].equals(START)) {
                player1 = players.get(command[1]);
                player2 = players.get(command[2]);
                playGame();
            } else {
                isMenu = false;
            }
        }
    }

    public void playGame() {
        startNewGame();

        while (true) {
            player1.makeAMove(field, Field.X);
            field.printField();
            if (winning(field.board, Field.X)) {
                System.out.println("Win X");
                break;
            }

            if (noEmptyCells()) {
                System.out.println("Draw");
                break;
            }

            player2.makeAMove(field, Field.O);
            field.printField();
            if (winning(field.board, Field.O)) {
                System.out.println("Win O");
                break;
            }
        }
    }
}
