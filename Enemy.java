package AdventureSpil;

public class Enemy {
    private String name;
    private String description;
    private double health;
    private double damage;


    public Enemy(String name, String description, double health, double damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.health = health;
    }

    public String getName() {
        return name;
    }
}

