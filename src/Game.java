package src;

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
            player1.makeAMove(field, field.X);
            field.printField();
            player2.makeAMove(field, field.O);
            field.printField();
        }
    }
}
