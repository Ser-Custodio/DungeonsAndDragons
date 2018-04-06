package DaD;

public class Sorcerer extends Enemies {
    public Sorcerer (int newDamage){
        damage = newDamage;
    }
    public String showEnemy(){
        return "I'm a sorcerer";
    }
}
