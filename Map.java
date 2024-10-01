package AdventureSpil;

public class Map {
    private Room currentRoom;

    public Map() {
        rooms();
    }

    private void rooms(){



        Room room1 = new Room("Entrance gateway", " the start of a dungeon with a dull and normal looking room with 2 doors");
        Room room2 = new Room("Passage room", " a grey room with 2 doors");
        Room room3 = new Room("Armory",     " a room with used swords and crossbows with 2 doors ");
        Room room4 = new Room("Torture room", " a room with bodies lying around with 2 doors ");
        Room room5 = new Room("Throne room", " a stinky and foggy room with dead bugs and a smell you can feel in your gut, only one door out ");
        Room room6 = new Room("Muddy chamber", " a muddy environment with 2 doors ");
        Room room7 = new Room("Crypt", " The unholy creatures lives here, run or fight");
        Room room8 = new Room("Enchanted treasure room", " Room with glowing armor and weapons that could be used to kill something big ");
        Room room9 = new Room("Mining cell", " Pickaxes and chains lying around");

        Item sword = new Item("Sword", "A long iron sword");
        Item lamp = new Item("Lamp", "Broken but useful lamp");
        Item bow = new Item("Bow", "A bow made of elderwood");



        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItem(sword);
        room1.addItem(lamp);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room2);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}

