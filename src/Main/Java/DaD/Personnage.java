package DaD;

public abstract class Personnage {
    private String name;
    private String image;
    private String type;
    private String lifeLevel;
    private String attackForce;

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
    public String getLifeLevel() {
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
    public void setLifeLevel(String pLife) {
        this.lifeLevel = pLife;
    }
    public void setAttackForce(String pForce) {
        this.attackForce = pForce;
    }
    public String toString() {
        return "Your character is a " + getType() + "\n1. Name:" + getName() + "\n2. Image: " + getImage() + "\n3. Life Level: " + getLifeLevel() + "\n4. Attack Force: " + getAttackForce();

    }
}