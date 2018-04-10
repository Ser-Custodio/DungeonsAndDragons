package DaD;

public class Sorcerer extends Enemies {
    public Sorcerer (int newDamage){
        damage = newDamage;
    }
    public String show(){
        return "---------------> SORCERER with an attack force of: "+ damage;
    }
}
