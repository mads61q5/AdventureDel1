package AdventureSpil;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    double health = 100;
    private Weapon equippedWeapon = null;


    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        inventory = new ArrayList<>();
    }


    public double getHealth() {
        return health;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public String attack() {
        Weapon weapon = getEquippedWeapon();

        if (weapon == null) {
            return "You don't have any equipped weapon.";
        } else if (!weapon.isEquipped()) {
            return "Your weapon needs more ammunition!";
        } else {
            return weapon.attack();
        }
    }



    public String equipWeapon(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                if (item instanceof Weapon) {
                    equippedWeapon = (Weapon) item;
                    return "You have equipped the weapon " + item.getName();

                } else {
                    return "The item " + item.getName() + " is not a weapon ";
                }
            }
            }

            return "You don't have " + itemName + " in your inventory";

    }





    public String eatItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {

                if (item instanceof Food) {
                    double healthChange = ((Food) item).getHealthOrDamage(); //typecasting fra item til food
                    this.health += healthChange;

                    if(this.health > 100) {
                        this.health = 100;
                    } else if (this.health < 0) {
                        this.health = 0;
                    }
                    inventory.remove(item);
                    if(healthChange > 0 ) {
                    return "You ate " + item.getName() + " and gained " + healthChange + " health";
                } else {
                       return "You ate " + item.getName() + " and lost " + healthChange + " health";
                    }
                    } else {
                    return "You cannot eat " + item.getName();
                }
            }
        }
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {

                if (item instanceof Food) {
                    double healthChange = ((Food) item).getHealthOrDamage(); //typecasting fra item til food
                    this.health += healthChange;

                    if(this.health > 100) {
                        this.health = 100;
                    } else if (this.health < 0) {
                        this.health = 0;
                    }
                    currentRoom.removeItem(item);
                    if(healthChange > 0 ) {
                        return "You ate " + item.getName() + " and gained " + healthChange + " health";
                    } else {
                        return "You ate " + item.getName() + " and lost " + healthChange + " health";
                    }
                } else {
                    return "You cannot eat " + item.getName();
                }
            }
        }
        return "The item " + itemName + " is not in your inventory and not in the room";
    }


            public String takeItem (String itemName){
                for (Item item : currentRoom.getItems()) {
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        currentRoom.removeItem(item);
                        inventory.add(item);
                        return "You took " + item.getName() + ".";
                    }
                }
                return "There is no " + itemName + " in this room";
            }

            public String dropItem (String itemName){
                for (Item item : inventory) {
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        inventory.remove(item);
                        currentRoom.addItem(item);
                        return "You dropped " + item.getName() + ".";
                    }
                }
                return "There is no " + itemName + "in this room";

            }

            public String showInventory () {
                if (inventory.isEmpty()) {
                    return "Inventory is empty";
                } else {
                    String itemList = "Your inventory is:\n";
                    for (Item item : inventory) {
                        itemList += item.getDescription() + "\n";
                    }
                    if(equippedWeapon != null) {
                        itemList += "Equipped weapon: " + equippedWeapon.getName();
                    } else {
                        itemList += "\n You have no weapon equipped";
                    }
                    return itemList;
                }
            }


            public String move (String direction){
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

