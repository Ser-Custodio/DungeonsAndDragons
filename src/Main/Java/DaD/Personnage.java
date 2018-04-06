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
    private String lifeLevel;
    private String attackForce;
    protected static final int NB_ATTACKS = 3;
    private static Scanner sc = new Scanner(in);



    /**
     * Gets type.
     *
     * @return the type
     */
//Getters
    public String getType() {
        return type;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Gets life level.
     *
     * @return the life level
     */
    public String getLifeLevel() {
        return lifeLevel;
    }

    /**
     * Gets attack force.
     *
     * @return the attack force
     */
    public String getAttackForce() {
        return attackForce;
    }

    /**
     * Sets type.
     *
     * @param pType the p type
     */
// Setters
    public void setType(String pType) {
        this.type = pType;
    }


    /**
     * Sets name.
     *
     * @param pname the pname
     */
    public void setName(String pname) {
        this.name = pname;
    }

    /**
     * Sets image.
     *
     * @param pImage the p image
     */
    public void setImage(String pImage) {
        this.image = pImage;
    }

    /**
     * Sets life level.
     *
     * @param pLife the p life
     */
    public void setLifeLevel(String pLife) {
        this.lifeLevel = pLife;
    }

    /**
     * Sets attack force.
     *
     * @param pForce the p force
     */
    public void setAttackForce(String pForce) {
        this.attackForce = pForce;
    }
    public String toString() {
        return "Your character is a " + getType() + "\n1. Name:" + getName() + "\n2. Image: " + getImage() + "\n3. Life Level: " + getLifeLevel() + "\n4. Attack Force: " + getAttackForce();

    }
}