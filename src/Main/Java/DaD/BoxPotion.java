package DaD;

public class BoxPotion extends Boxes{
    public int protection=0;
    boolean useWarrior = false;
    boolean useMagician = true;

    public BoxPotion (int newProtection){
        protection = newProtection;
    }

    public void show() {
        System.out.println("---------------> POTION");
    }
}
