package DaD;

public class BoxShield extends Boxes{
    public int protection=0;

    public BoxShield (int newProtection){
        protection = newProtection;
    }

    public String show() {
        return "---------------> I'M A SHIELD";
    }
}
