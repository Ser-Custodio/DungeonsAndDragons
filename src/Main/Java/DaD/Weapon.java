package DaD;

public class Weapon extends AttackItem {


    //protected static Weapon allWeapons[] = {bow, mace, sword};

    public Weapon(String pName, String pPower) {
        super(pName, pPower);
    }

    public static Weapon bow = new Weapon("Bow","50");
    public static Weapon mace = new Weapon("Mace","30");
    public static Weapon sword = new Weapon("Sword","25");

}
