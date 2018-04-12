package DaD;

public class BoxShield extends Boxes{
    public int protection=0;
    boolean useWarrior = true;
    boolean useMagician = false;


    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public BoxShield (int newProtection){
        protection = newProtection;
    }

    public void show() {
        System.out.println("---------------> SHIELD that gives "+protection+" of protection");
    }
}
