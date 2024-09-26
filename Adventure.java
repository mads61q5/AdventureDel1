package AdventureSpil;

public class Adventure {

    private Room currentRoom;

    public Adventure() {


        Room room1 = new Room("Entrance gateway", " the start of a dungeon with a dull and normal looking room with 2 doors");
        Room room2 = new Room("Passage room", " a grey room with 2 doors");
        Room room3 = new Room("Armory", " a room with used swords and crossbows with 2 doors ");
        Room room4 = new Room("Torture room", " a room with bodies lying around with 2 doors ");
        Room room5 = new Room("Throne room", " a stinky and foggy room with dead bugs and a smell you can feel in your gut, only one door out ");
        Room room6 = new Room("Muddy chamber", " a muddy environment with 2 doors ");
        Room room7 = new Room("Crypt", " The unholy creatures lives here, run or fight");
        Room room8 = new Room("Enchanted treasure room", " Room with glowing armor and weapons that could be used to kill something big ");
        Room room9 = new Room("Mining cell", " Pickaxes and chains lying around");

        room1.setEast(room2);
        room1.setSouth(room4);

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

    public String move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case ("go north"):
                nextRoom = currentRoom.getNorth();
                break;
            case ("go south"):
                nextRoom = currentRoom.getSouth();
                break;
            case ("go east"):
                nextRoom = currentRoom.getEast();
                break;
            case ("go west"):
                nextRoom = currentRoom.getWest();
                break;
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You are now in " + currentRoom.getName() + ": " + currentRoom.getDescription();
        } else {
            return "It is not possible to go that way.";
        }
    }


        public String look () {
            return "You are in" + currentRoom.getName() + currentRoom.getDescription();
        }
    }


