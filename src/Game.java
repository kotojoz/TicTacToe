package src;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Field field;

    private Player player1;

    private Player player2;

    protected boolean isWin_X;

    protected boolean isWin_O;

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
        isWin_X = false;
        isWin_O = false;
    }

    private boolean isGameOver() {
        if (isWin_X) {
            System.out.println("X wins\n");
            return true;
        } else if (isWin_O) {
            System.out.println("O wins\n");
            return true;
        } else if (noEmptyCells()) {
            System.out.println("Draw\n");
            return true;
        } else {
            return false;
        }
    }

    private void analyzeGame() {
        checkResult(field.grid.get(1).getMark() + field.grid.get(2).getMark() + field.grid.get(3).getMark());
        checkResult(field.grid.get(4).getMark() + field.grid.get(5).getMark() + field.grid.get(6).getMark());
        checkResult(field.grid.get(7).getMark() + field.grid.get(8).getMark() + field.grid.get(9).getMark());

        checkResult(field.grid.get(1).getMark() + field.grid.get(4).getMark() + field.grid.get(7).getMark());
        checkResult(field.grid.get(2).getMark() + field.grid.get(5).getMark() + field.grid.get(8).getMark());
        checkResult(field.grid.get(3).getMark() + field.grid.get(6).getMark() + field.grid.get(9).getMark());

        checkResult(field.grid.get(1).getMark() + field.grid.get(5).getMark() + field.grid.get(9).getMark());
        checkResult(field.grid.get(3).getMark() + field.grid.get(5).getMark() + field.grid.get(7).getMark());

    }

    protected void checkResult(int result) {
        if (result == 264) {
            isWin_X = true;
        } else if (result == 237) {
            isWin_O = true;
        }
    }

    private boolean noEmptyCells() {
        return field.grid.values().stream().noneMatch(v -> v.getMark() == Field.EMPTY_CELL);
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
            analyzeGame();
            if (isGameOver()) {
                break;
            }

            player2.makeAMove(field, Field.O);
            field.printField();
            analyzeGame();
            if (isGameOver()) {
                break;
            }
        }
    }
}
