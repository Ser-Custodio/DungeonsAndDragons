package DaD;

public class Warrior extends Personnage {

    protected static Weapon inventory[] = new Weapon[NB_ITEMS];
    private String shield;

    public void deleteSlot(int slot){
        inventory[slot] = null;
    }

    public Weapon getWeapon(int slot) {
        return inventory[slot];
    }

    public String getShield() {
        return shield;
    }

    public static void setWeapon(Weapon pWeapon, int slot) {
        inventory[slot] = pWeapon;
    }

    public void setShield(String pShield) {
        this.shield = pShield;
    }

    public String toString() {
        String result = super.toString();
        result = result + "\n5. Inventory:\n";
        for (int i = 0; i < NB_ITEMS; i++){
            result = result + "Slot "+(i+1)+": ";
            if (inventory[i] != null) {
                result = result + inventory[i].toString()+"\n";
            }else{
                result = result + "<empty slot>\n";
            }
        }
        return result;
    }
}
