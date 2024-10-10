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

    public String eat(String item){
        return player.eatItem(item);
    }

    public String equip(String item) {
        return player.equipWeapon(item);
    }

    public String attack() {
        return player.attack();
    }


    public Player getPlayer() {
        return player;
    }



}

