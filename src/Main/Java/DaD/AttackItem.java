package DaD;


public abstract class AttackItem {
    private String name;
    private int power;
    private String type; // weapon or spell

    public AttackItem(String pName, int pPower) {
        name = pName;
        power = pPower;
    }

    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setType(String pType){
        type = pType;
    }

    public void setName(String pName) {
        name = pName;
    }

    public void setPower(int pPower) {
        power = pPower;
    }

    public String toString() {
        return "Name: " + name + " ----> Power: " + power;
    }
}
