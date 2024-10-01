package AdventureSpil;

import java.util.Locale;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    boolean running = false;
    private Adventure adventure;
    private Player player;

    public UI(Adventure adventure) {
        this.adventure = adventure;

    }


    public void setDisplayUI() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("Welcome to the adventure game");
            System.out.println("Press 1 to start the game");
            System.out.println("Press 2 to exit the game");
            System.out.println("Press 3 to get the help menu");

            int valg1 = scanner.nextInt();
            scanner.nextLine();
            switch (valg1) {
                case 1 -> {
                    running = true;
                    inMenu = false;
                }


                case 2 -> {
                    System.out.println("Game over");
                    inMenu = false;
                }
                case 3 -> {
                    System.out.println("Write, 'Go north' to go north");
                    System.out.println("Write, 'Go south' to go south");
                    System.out.println("Write, 'Go east' to go east");
                    System.out.println("Write, 'Go west' to go west");

                }
            }


            System.out.println("You can go North, West, South, East, 'look', 'take[item]', 'drop[item]', 'inventory', 'help', or 'exit'.");

            while (running) {
                String nextRoom = null;
                String input = scanner.nextLine();
                if (input.startsWith("take ")) {
                    String itemName = input.substring(5).trim();
                    System.out.println(adventure.take(itemName));
                } else if (input.startsWith("drop ")) {
                    String dropItemName = input.substring(5).trim();
                    System.out.println(adventure.drop(dropItemName));
                } else if (input.equals("go north")) {
                    System.out.println(adventure.commands("go north"));
                } else if (input.equals("go south")) {
                    System.out.println(adventure.commands("go south"));
                } else if (input.equals("go west")) {
                    System.out.println(adventure.commands("go west"));
                } else if (input.equals("go east")) {
                    System.out.println(adventure.commands("go east"));
                } else if (input.equals("look")) {
                    System.out.println(adventure.commands(input));
                } else if (input.equals("inventory")) {
                    System.out.println(adventure.showItems());
                } else if (input.equals("help")) {
                    displayHelp();
                } else if (input.equals("exit")) {
                    running = false;
                    System.out.println("Exiting the game");
                } else {
                    System.out.println("Not allowed. Type a new command.");
                }


            }
        }
    }
        public void displayHelp () {
            System.out.println("Help Menu:");
            System.out.println("Type 'go north' to go north.");
            System.out.println("Type 'go south' to go south.");
            System.out.println("Type 'go west' to go west.");
            System.out.println("Type 'go east' to go east.");
            System.out.println("Type 'look' to get a description of the current room.");
            System.out.println("Type 'take' to pick up item.");
            System.out.println("Type 'drop' to drop item.");
            System.out.println("Type 'help' to display this help menu.");
            System.out.println("Type 'exit' to exit the game.");
        }


    }


