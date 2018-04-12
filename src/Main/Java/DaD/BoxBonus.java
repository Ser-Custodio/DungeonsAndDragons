package DaD;

public class BoxBonus extends Boxes {

    public void show(){
        System.out.println("---------------> BONUS");
    }

    public void action(Personnage p){
        p.setPosition(p.getPosition()+5);
    }
}
