package AdventureSpil;

public class Room {
    private String currentRoom;
    private String name;
    private String description;
    private Room east;
    private Room west;
    private Room north;
    private Room south;

    public Room(String name, String description){
        this.name=name;
        this.description=description;
    }

    public Room(){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String getCurrentRoom() {
        return currentRoom;
    }
    public void setEast(Room east){
        this.east = east;
    }
    public void setNorth(Room north) {
        this.north = north;
    }
    public void setSouth(Room south) {
        this.south = south;
    }
    public void setWest(Room west) {
        this.west = west;
    }
    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public String toString(){
        return "You are in " + name + description;
    }
}
