package DaD;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The type Personnage.
 */
public abstract class Personnage {
    private String name;
    private String image;
    private String type;
    protected static String lifeLevel;
    private String attackForce = "15";
    protected static final int NB_ITEMS = 3;
    private static Scanner sc = new Scanner(in);


//Getters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public static String getLifeLevel() {
        return lifeLevel;
    }

    public String getAttackForce() {
        return attackForce;
    }


// Setters
    public void setType(String pType) {
        this.type = pType;
    }

    public void setName(String pname) {
        this.name = pname;
    }

    public void setImage(String pImage) {
        this.image = pImage;
    }

    public static void setLifeLevel(String pLife) {
        lifeLevel = pLife;
    }

    public void setAttackForce(String pForce) {
        this.attackForce = pForce;
    }


    public String toString() {
        return "Your character is a " + getType() + "\n1. Name:" + getName() + "\n2. Image: " + getImage() + "\n3. Life Level: " + getLifeLevel() + "\n4. AttackItem Force: " + getAttackForce();

    }
}