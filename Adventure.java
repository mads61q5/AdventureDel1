package AdventureSpil;

public class Adventure {
    private Map map;
    private Player player;


    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getCurrentRoom());

    }

    public String take(String item) {
        return player.takeItem(item);
    }
    public String drop(String item) {
        return player.dropItem(item);
    }


    public String showItems() {
        return player.showInventory();
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

    public Player getPlayer() {
        return player;
    }

    public String attack() {
        return player.attack();
    }

}

