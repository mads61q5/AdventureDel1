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
        this.player = adventure.getPlayer();

    }

    /*public UI(Player player) {
        this.player = adventure.getPlayer();
    }*/


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


            System.out.println("You can go North, West, South, East, 'look', 'take[item]', 'drop[item]', 'inventory', 'help', 'inventory', 'health', 'eat' or 'exit'.");
            System.out.println("You can also 'attack' and 'equip' weapons");
            System.out.println("You start to see an entrance take a 'look' to see where you are" );
            while (running) {
                String nextRoom = null;
                String input = scanner.nextLine();
                if (input.startsWith("take ")) {
                    String itemName = input.substring(5).trim();
                    System.out.println(adventure.take(itemName));
                } else if (input.startsWith("drop ")) {
                    String dropItemName = input.substring(5).trim();
                    System.out.println(adventure.drop(dropItemName));
                } else if (input.equals("health")) {
                    checkHealth();
                }else if (input.startsWith("eat")) {
                    String itemName = input.substring(4).trim();
                    System.out.println(adventure.eat(itemName));
                }else if (input.startsWith("equip")) {
                    String itemName = input.substring(6).trim();
                    System.out.println(adventure.equip(itemName));
                }else if (input.equalsIgnoreCase("attack")){
                    String attackResult = adventure.attack();
                    System.out.println(attackResult);
                } else if (input.equals("go north")) {
                    System.out.println(commands("go north"));
                } else if (input.equals("go south")) {
                    System.out.println(commands("go south"));
                } else if (input.equals("go west")) {
                    System.out.println(commands("go west"));
                } else if (input.equals("go east")) {
                    System.out.println(commands("go east"));
                } else if (input.equals("look")) {
                    System.out.println(commands(input));
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

    public void displayHelp() {
        System.out.println("Help Menu:");
        System.out.println("Type 'go north' to go north.");
        System.out.println("Type 'go south' to go south.");
        System.out.println("Type 'go west' to go west.");
        System.out.println("Type 'go east' to go east.");
        System.out.println("Type 'look' to get a description of the current room.");
        System.out.println("Type 'take' to pick up item.");
        System.out.println("Type 'drop' to drop item.");
        System.out.println("Type 'equip' to equip a weapon");
        System.out.println("Type 'attack' to attack an enemy");
        System.out.println("Type 'help' to display this help menu.");
        System.out.println("Type 'exit' to exit the game.");
    }

    public String commands(String command) {
        switch (command.toLowerCase()) {
            case "go north", "go east", "go west", "go south":
                return player.move(command);
            case "look":
                return player.look();
            default:
                return "Unknown command. Type 'help' ";
        }
    }





    private void checkHealth() {
        double health = player.getHealth();
        System.out.println("Health is: " + health);
            if (health > 75) {
                System.out.println("Your health is high.");
            } else if (health >= 50) {
                System.out.println("Your health is moderate.");
            } else if (health > 25) {
                System.out.println("Your health is low.");
            } else {
                System.out.println("Your health is critical!");
            }
        }
    }






