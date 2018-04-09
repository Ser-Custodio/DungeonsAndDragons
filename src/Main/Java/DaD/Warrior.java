package DaD;

/**
 * The type Warrior.
 */
public class Warrior extends Personnage {
//    private Weapon weapon;
    private Weapon weapons[] = new Weapon[NB_ATTACKS];
    private String shield;


    public void deleteSlot(int slot){
        weapons[slot] = null;
    }
    /**
     * Gets weapon.
     * slot value between 0 and NB_ATTACKS-1
     * @return the weapon
     */
    public Weapon getWeapon(int slot) {
        return weapons[slot];
    }

    /**
     * Gets shield.
     *
     * @return the shield
     */
    public String getShield() {
        return shield;
    }

    /**
     * Sets weapon.
     *
     * @param pWeapon the p weapon
     */
    public void setWeapon(Weapon pWeapon, int slot) {
        this.weapons[slot] = pWeapon;

    }

    /**
     * Sets shield.
     *
     * @param pShield the p shield
     */
    public void setShield(String pShield) {
        this.shield = pShield;
    }

//        public Warrior() {
//        weapon = "Sword";
//        shield = "BoxShield";
//    }
    public String toString() {
        String result = super.toString();
        result = result + "\n5. Weapons:\n";
        for (int i = 0; i < NB_ATTACKS; i++){
            result = result + "Slot "+(i+1)+": ";
            if (weapons[i] != null) {
                result = result + weapons[i].toString()+"\n";
            }else{
                result = result + "<empty slot>\n";
            }
        }
        return result;
    }

}
