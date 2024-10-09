package AdventureSpil;

public class RangedWeapon extends Weapon {
    private int ammo;

    public RangedWeapon(String name, String description, int ammo) {
        super(name, description);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public boolean isEquipped() {
        return ammo > 0;
    }

    @Override
    public String attack() {
        if (ammo > 0) {
            ammo--;
            return "You shoot your " + getName() + " ammo left: " + ammo;
        } else {

            return "You are out of ammo";
        }
    }
}


