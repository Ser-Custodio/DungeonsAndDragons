package DaD;

public class Dragon extends Enemies{
    public Dragon (int newDamage){
        damage = newDamage;
    }

    public String show(){
        return "---------------> I'M A DRAGON";
    }
}
