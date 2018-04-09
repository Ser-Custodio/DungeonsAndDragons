package DaD;

public class BoxJoker extends Boxes {
    public int life = 0;

    public BoxJoker(int addLife) {
        life = addLife;
    }

    public String show() {
        return "---------------> I'M A JOKER, +"+life+" of life";
    }
}
