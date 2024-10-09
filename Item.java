package AdventureSpil;

public class Item {
    private String name;
    private String description;
    protected double health;

    public Item(String name, String description) {
        this.name=name;
        this.description=description;

    }

    public Item (String name, String description, double health){
        this.name=name;
        this.description=description;
        this.health=health;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    }
