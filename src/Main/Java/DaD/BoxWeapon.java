package DaD;

public class BoxWeapon extends Boxes {
    private  String name = "";
    boolean useWarrior = true;
    boolean useMagician = false;
    boolean used = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoxWeapon(String pname){
        name = pname;
    }
    public void show(){
        System.out.println("---------------> WEAPON = "+name);
    }
}
