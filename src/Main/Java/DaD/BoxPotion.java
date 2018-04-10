package DaD;

public class BoxPotion extends Boxes{
    public int protection=0;

    public BoxPotion (int newProtection){
        protection = newProtection;
    }

    public String show() {
        return "---------------> POTION";
    }
}
