package AdventureSpil;

public abstract class Weapon extends Item {
    private boolean isEquipped;
    private int ammo;

    public Weapon(String name, String description) {
        super(name, description);
    }

    public abstract String attack();


    public abstract boolean isEquipped();


    @Override
    public String toString(){
        return getName();
    }

        }




