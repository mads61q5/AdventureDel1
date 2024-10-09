package AdventureSpil;

public class Food extends Item{

    public Food(String name, String desctription, double health){
        super(name, desctription, health);
        this.health=health;

    }

    public double getHealthOrDamage(){
        return health;
    }
}
