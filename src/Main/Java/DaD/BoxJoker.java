package DaD;

public class BoxJoker extends Boxes {

    private int life = 0;

    boolean used = false;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public BoxJoker(int addLife) {
        life = addLife;
    }

    public void show() {
        System.out.println( "---------------> JOKER, you win "+life+" of life");
    }

    public void action(Personnage p){
        System.out.println("current life "+p.getLifeLevel());
        p.setLifeLevel(p.getLifeLevel()+life);
        System.out.println("new life = "+p.getLifeLevel());

    }
}
