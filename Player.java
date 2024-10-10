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

    public void takeDamage(double damage) {
        this.health -= damage;
        if(this.health < 0) {
            this.health = 0;
        }
        System.out.println("You took " + damage + " damage. Your current health is: " + this.health);
    }

    public String attack() {
        if (equippedWeapon == null) {
            return "You have no weapon equipped!";
        }

        Enemy enemy = currentRoom.getEnemy();  // Vi antager her, at der kun er én fjende i rummet
        if (enemy == null) {
            return "There are no enemies in this room";
        }

        // Spilleren angriber fjenden
        double damageDealt = equippedWeapon.getDamage();
        enemy.takeDamage(damageDealt);
        String result = "You attacked " + enemy.getName() + " with your weapon " + equippedWeapon.getName() + " dealing " + damageDealt + " damage.\n";
        result += enemy.getName() + "'s health after your attack is: " + enemy.getHealth() + "\n";
        if (!enemy.isAlive()) {
            // Fjenden dør og dropper våbenet
            result += enemy.getName() + " is dead.\n";
            Weapon droppedWeapon = enemy.getWeapon();
            result += enemy.dropWeapon();

            if(droppedWeapon != null) {
                currentRoom.addItem(droppedWeapon);
            }

            currentRoom.removeEnemy();
        } else {
            // Fjenden slår tilbage
            double enemyDamage = enemy.getWeapon().getDamage();
            this.health -= enemyDamage;
            result += enemy.getName() + " attacked you with " + enemy.getWeapon().getName() + " for " + enemyDamage + " damage.\n";
        }
        result += "Your health after the enemy attack is: " + this.getHealth() + "\n";

        return result;
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
                    return "You are now in " + currentRoom.getName() + ": " + currentRoom.getDescription() + currentRoom.showItems() + currentRoom.showEnemies();
                } else {
                    return "It is not possible to go that way.";
                }
            }


            public String look () {
                return "You are in " + currentRoom.getName() + currentRoom.getDescription() + currentRoom.showItems() + currentRoom.showEnemies();
            }
        }

