package DaD;

public class BoxWeapon extends Boxes {
    private  String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoxWeapon(String pname){
        name = pname;
    }
    public String show(){
        return "---------------> WEAPON = "+name;
    }
}
