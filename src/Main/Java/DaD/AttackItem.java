package DaD;


public abstract class AttackItem {
    private String name;
    private String power;
    private String type;

    public AttackItem(String pName, String pPower) {
        name = pName;
        power = pPower;
    }

    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public void setType(String pType){
        type = pType;
    }

    public void setName(String pName) {
        name = pName;
    }

    public void setPower(String pPower) {
        power = pPower;
    }

    public String toString() {
        return "Name: " + name + " ----> Power: " + power;
    }
}
