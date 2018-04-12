package DaD;

public class Enemies extends Event{
    public int damage = 1;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void show(){
        System.out.println("I'm an enemy");
    }
}
