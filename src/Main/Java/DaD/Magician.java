package DaD;

public class Magician extends Personnage {
    private String spell;
    private String potion;

    public String getSpell() {
        return spell;
    }
    public void setSpell(String pSpell) {
        this.spell = pSpell;
    }

    public String toString(){
        return super.toString() +"\n5. Spell: "+getSpell()+"\n";
    }
}
