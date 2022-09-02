package src;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Field field;

    private static Map<String, Player> players;

    public Game() {
        players = new HashMap<>();
        loadPlayers();
    }

    private void loadPlayers() {
        players.put("user", new User());
        players.put("easy", new ComputerEasy());
    }

    public static boolean isPlayer(String player) {
        return players.get(player) != null;
    }

    private void startNewGame() {
        field = new Field();
    }

    public void menu() {
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("Input command:");
            String[] command = InputHandler.enterCommand();
            String START = "start";
            if (command[0].equals(START)) {
                playGame(command);
            } else {
                isMenu = false;
            }
        }
    }

    public void playGame(String[] command) {
        startNewGame();
        while (true) {
            players.get(command[1]).makeAMove(field, field.X);
            field.printField();
            players.get(command[2]).makeAMove(field, field.O);
            field.printField();
        }
    }
}
