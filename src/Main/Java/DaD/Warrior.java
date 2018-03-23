package DaD;

public class Warrior extends Personnage {
    private Weapon weapon;
    private String shield;

    public Weapon getWeapon() {
        return weapon;
    }

    public String getShield() {
        return shield;
    }

    public void setWeapon(Weapon pWeapon) {
        this.weapon = pWeapon;
    }

    public void setShield(String pShield) {
        this.shield = pShield;
    }

//        public Warrior() {
//        weapon = "Sword";
//        shield = "Shield";
//    }
    public String toString() {
        return super.toString() + "\n4. Attack Force: " + getAttackForce() + "\n5. Weapon: " + getWeapon() + "\n";
    }

}
