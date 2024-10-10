package AdventureSpil;

public abstract class Weapon extends Item {
    private boolean isEquipped;
    private int ammo;
    private double damage;

    public Weapon(String name, String description, double damage) {
        super(name, description);
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    public abstract String attack();


    public abstract boolean isEquipped();


    @Override
    public String toString(){
        return getName();
    }

        }




