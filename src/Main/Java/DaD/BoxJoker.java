package DaD;

public class BoxJoker extends Boxes {

    private int life = 0;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public BoxJoker(int addLife) {
        life = addLife;
    }

    public String show() {
        return "---------------> JOKER, you win "+life+" of life";
    }
}
