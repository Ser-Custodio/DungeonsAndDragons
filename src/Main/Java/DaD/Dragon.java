package DaD;

public class Dragon extends Enemies{
    public Dragon (int newDamage){
        damage = newDamage;
    }

    public String show(){
        return "---------------> DRAGON with an attack force of: "+ damage;
    }
}
