package AdventureSpil;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private ArrayList<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }


    public List<Item> getItems() {
        return items;
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public String showItems() {
        if (items.isEmpty()) {
            return "\nNo items in this room";

        } else {
            String myitems = "\nItems in this room: \n";
            for (Item item : items) {
                myitems += item.getDescription() + " \n";
            }
            return myitems;
        }
    }

        public void addItem (Item item){
            items.add(item);
        }

        public void setEast (Room east){
            this.east = east;
        }
        public void setNorth (Room north){
            this.north = north;
        }
        public void setSouth (Room south){
            this.south = south;
        }
        public void setWest (Room west){
            this.west = west;
        }
        public Room getNorth () {
            return north;
        }

        public Room getEast () {
            return east;
        }

        public Room getSouth () {
            return south;
        }

        public Room getWest () {
            return west;
        }

        public String toString () {
            return "You are in " + name + description;
        }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
