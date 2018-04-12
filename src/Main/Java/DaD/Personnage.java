package DaD;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The type Personnage.
 */
public abstract class Personnage {
    private String name;
    private int position = 0;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    private String image;
    private String type;
    protected int lifeLevel;
    private int attackForce = 15;
    protected static final int NB_ITEMS = 5;
    private static Scanner sc = new Scanner(in);


    public void move(int rollDice) {
        this.position = this.position + rollDice;
    }

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

    public int getLifeLevel() {
        return lifeLevel;
    }

    public int getAttackForce() {
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

    public void setLifeLevel(int pLife) {
        lifeLevel = pLife;
    }

    public void setAttackForce(int pForce) {
        this.attackForce = pForce;
    }

    public void interactWithEvent(Event event) {
        event.show();
        event.action(this);
    }

    public String toString() {
        return "Your character is a " + getType() + "\n1. Name:" + getName() + "\n2. Image: " + getImage() + "\n3. Life Level: " + getLifeLevel() + "\n4. AttackItem Force: " + getAttackForce();

    }
}