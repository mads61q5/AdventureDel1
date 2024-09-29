package AdventureSpil;

import java.util.Locale;

public class Adventure {
    private Map map;
    private Player player;


    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom());

    }

    public String commands(String command) {
        switch (command.toLowerCase()) {
            case "go north", "go east", "go west", "go south":
                return player.move(command);
            case "look":
                return player.look();
            case "help":
                return getHelp();
            default:
                return "Unknown command. Type 'help' ";
        }
    }

    public String getHelp(){
        return "Commands:\n"
         + "'go north', 'go south', 'go east', 'go west' to move your character.\n"
         + "'look' to look around\n"
        + "'help' to get help";


    }
}

