package AdventureSpil;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String name, String description, double damage){
        super(name, description, damage);
    }

    @Override
    public boolean isEquipped() {
        return true;
    }

    @Override
    public String attack(){
        return "You swing your " + getName();
    }
}
