package DaD;

public class Succubes extends Enemies {
    public Succubes (int newDamage){
        damage = newDamage;
    }

    public String show(){
        return "---------------> SUCCUBE with an attack force of: "+ damage;
    }
}
