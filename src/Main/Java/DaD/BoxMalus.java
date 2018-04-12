package DaD;

public class BoxMalus extends Boxes{

    public void show(){
        System.out.println("---------------> MALUS");
    }

    public void action(Personnage p){
        p.setPosition(p.getPosition()-5);
    }
}
