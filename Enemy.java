package AdventureSpil;

public class Enemy {
    private String name;
    private String description;
    private double health;
    private double damage;
    private Weapon weapon;


    public Enemy(String name, String description, double health, double damage, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String dropWeapon() {
        if (!isAlive() && weapon != null) {
            Weapon droppedWeapon = weapon;
            weapon = null; // Fjern weapon fra fjenden
            return "The enemy dropped a " + droppedWeapon.getName() + "\n";
        }
        return "";
    }


    public String attackPlayer(Player player) {
    player.takeDamage(damage);
    return name + "brutally attacked you and dealt " + damage + " damage";
    }
}

