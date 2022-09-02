package src;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static int[] enterCoordinates() {
        int[] numbers = new int[2];
        while (true) {
            try {
                System.out.println("Enter the coordinates:");
                String[] command = scanner.nextLine().split(" ");
                int column = Integer.parseInt(command[0]);
                if (column < 1 || column > 3) {
                    throw new RuntimeException("Coordinates should be from 1 to 3!");
                }
                int row = Integer.parseInt(command[1]);
                if (row < 1 || row > 3) {
                    throw new RuntimeException("Coordinates should be from 1 to 3!");
                }
                numbers[0] = column;
                numbers[1] = row;
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String[] enterCommand() {
        while (true) {
            String[] commands = scanner.nextLine().split("\\s+");
            if (commands.length == 1 && commands[0].equals("exit")) {
                return commands;
            } else if (commands[0].equals("start") && commands.length == 3) {
                if (Game.isPlayer(commands[1]) &&
                        Game.isPlayer(commands[2])) {
                    return commands;
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }
}
