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


        Item lamp = new Item("Lamp", "Broken but useful lamp");
        Item bodyArmor = new Item("Body armor", "A full set of steel body armor");
        Item pouch = new Item("Pouch", "A pouch with some gold");
        Item pickaxe = new Item("Pickaxe", "A pickaxe made of steel");
        Item chain = new Item("Chain", "a silver chain");
        Item glowingSword = new Item("Glowing sword", "A sword glowing with a shade of blue");
        Item glowingChestPlate = new Item("Glowing Chest plate", "A chest plate glowing with a shade of blue");

        Food bread = new Food("Bread", "Big and fresh bread", 50);
        Food poison = new Food("Poison", "Potion of poison", -50);
        Food apple = new Food("Apple", "Green apple", 25);
        Food oldMeat = new Food("Old meat", "A piece of old meat", -25);

        MeleeWeapon sword = new MeleeWeapon("Sword", "Long iron Sword");
        RangedWeapon bow = new RangedWeapon("Bow", "A bow made of elderwood", 2);
        MeleeWeapon mace = new MeleeWeapon("Mace", "A big mace");
        RangedWeapon crossbow = new RangedWeapon("Crossbow", "A crossbow made of wood", 3);


        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItem(sword);
        room1.addItem(lamp);
        room1.addItem(bread);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItem(bow);
        room2.addItem(apple);

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItem(pouch);
        room3.addItem(crossbow);
        room3.addItem(bodyArmor);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItem(poison);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addItem(oldMeat);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.addItem(glowingSword);
        room8.addItem(glowingChestPlate);

        room9.setNorth(room6);
        room9.setWest(room8);
        room9.addItem(pickaxe);
        room9.addItem(chain);

        currentRoom = room1;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}

