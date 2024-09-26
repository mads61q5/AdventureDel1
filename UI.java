package AdventureSpil;

import java.util.Locale;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    String displayUI;
    boolean running = false;
    Adventure room1 = new Adventure();
    Room room = new Room();
    private Adventure adventure;

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


            System.out.println("You can go North, West, South, East or look around ");

            while (running) {
                String nextRoom = null;
                String input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "go north":
                        System.out.println(adventure.move("go north"));
                        break;
                    case "go south":
                        System.out.println(adventure.move("go south"));
                        break;
                    case "go west":
                        System.out.println(adventure.move("go west"));
                        break;
                    case "go east":
                        System.out.println(adventure.move("go east"));
                        break;
                    case "look":
                        System.out.println("Looking around");
                        System.out.println(adventure.look());
                        break;
                    case "exit":
                        System.out.println("Thank you for playing the game!");
                        running = false;
                        break;
                    case "help":
                        System.out.println("Write, 'Go north' to go north");
                        System.out.println("Write, 'Go south' to go south");
                        System.out.println("Write, 'Go east' to go east");
                        System.out.println("Write, 'Go west' to go west");

                }

            }


        }
    }
}
