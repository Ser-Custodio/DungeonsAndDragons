package DaD;

/**
 * The type Magician.
 */
public class Magician extends Personnage {
    private Spell spells[] = new Spell[NB_ITEMS];
    private String potion;

    /**
     * Gets spell.
     *
     * @return the spell
     */
    public Spell getSpell(int slot) {
        return spells[slot];
    }

    /**
     * Delete slot.
     *
     * @param slot the slot
     */
    public void deleteSlot(int slot){
        spells[slot] = null;
    }

    /**
     * Sets spell.
     *
     * @param pSpell the p spell
     * @param slot   the slot
     */
    public void setSpell(Spell pSpell, int slot) {
        this.spells[slot] = pSpell;
    }

    public String toString() {
        String result = super.toString();
        result = result + "\n5. Spells:\n";
        for (int i = 0; i < NB_ITEMS; i++){
            result = result + "Slot "+(i+1)+": ";
            if (spells[i] != null) {
                result = result + spells[i].toString()+"\n";
            }else{
                result = result + "<empty slot>\n";
            }
        }
        return result;
    }
}
