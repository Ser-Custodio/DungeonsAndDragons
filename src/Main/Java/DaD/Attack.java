package DaD;

public abstract class Attack {
    private String name;
    private String power;
    private String type;

    public Attack(String pName, String pPower) {
        name = pName;
        power = pPower;
    }

    public String getType(){
        return type;
    }
    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }


    public String getPower() {
        return power;
    }

    public void setType(String pType){
        type = pType;
    }
    public void setPower(String pPower) {
        power = pPower;
    }

    public String toString() {
        return "Name: " + name + " ----> Power: " + power;
    }
}
