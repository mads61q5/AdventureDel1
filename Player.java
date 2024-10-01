package AdventureSpil;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;



    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        inventory = new ArrayList<>();
    }

    public String takeItem(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                currentRoom.removeItem(item);
                inventory.add(item);
                return "You took " + item.getName() + ".";
            }
        }
        return "There is no " + itemName + "in this room";
    }

        public String dropItem(String itemName) {
            for (Item item : inventory) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    inventory.remove(item);
                    currentRoom.addItem(item);
                    return "You dropped " + item.getName() + ".";
                }
            }
            return "There is no " + itemName + "in this room";

        }

    public String showInventory() {
        if (inventory.isEmpty()) {
            return "Inventory is empty";
        } else {
            String itemList = "Your inventory is:\n";
            for (Item item : inventory) {
                itemList += item.getDescription();
            }
            return itemList;
        }
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
            return "You are now in " + currentRoom.getName() + ": " + currentRoom.getDescription() + currentRoom.showItems();
        } else {
            return "It is not possible to go that way.";
        }
    }


    public String look () {
        return "You are in " + currentRoom.getName() + currentRoom.getDescription() + currentRoom.showItems();
    }
}

