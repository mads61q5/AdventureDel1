package AdventureSpil;

public class Player {
    private Room currentRoom;


    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
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
        return "You are in " + currentRoom.getName() + currentRoom.getDescription();
    }
}

