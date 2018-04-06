package DaD;

/**
 * The type Attack.
 */
public abstract class Attack {
    private String name;
    private String power;
    private String type;

    /**
     * Instantiates a new Attack.
     *
     * @param pName  the p name
     * @param pPower the p power
     */
    public Attack(String pName, String pPower) {
        name = pName;
        power = pPower;
    }

    /**
     * Get type string.
     *
     * @return the string
     */
    public String getType(){
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
     * Sets name.
     *
     * @param pName the p name
     */
    public void setName(String pName) {
        name = pName;
    }


    /**
     * Gets power.
     *
     * @return the power
     */
    public String getPower() {
        return power;
    }

    /**
     * Set type.
     *
     * @param pType the p type
     */
    public void setType(String pType){
        type = pType;
    }

    /**
     * Sets power.
     *
     * @param pPower the p power
     */
    public void setPower(String pPower) {
        power = pPower;
    }

    public String toString() {
        //for (int i = 0; )
        return "Name: " + name + " ----> Power: " + power;
    }
}
