package DaD;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public abstract class Factory {
    static Scanner sc = new Scanner(in);

    public static void createChar(Personnage characters[], Integer nb, ArrayList<Attack> objects, Integer nbAta) {
        String character;
        Personnage p = null;

        do {
            out.println("Choose a character:\n1. Warrior \n2. Magician");
            character = sc.nextLine();
            if (character.equals("1")) {
                p = new Warrior();
                p.setType("Warrior");
            } else if (character.equals("2")) {
                p = new Magician();
                p.setType("Magician");
            } else {
                out.println("Wrong choice! Choose 1 for Warrior or 2 for Magician");
            }
        } while (!character.equals("1") && !character.equals("2"));

        characters[nb] = p;
        out.println("You chose " + p.getType());
        p.setName(giveName());
        p.setImage(giveImage());
        p.setLifeLevel(givelife());
        p.setAttackForce(giveAttack());
        if (p.getType().equals("Warrior")) {
            giveWeapon((Warrior) p, objects, nbAta);
            nbAta++;
            String more;
            do {
                out.println("Add another? (Y/N)");
                more = sc.nextLine();
                if (more.equals("y")) {
                    giveWeapon((Warrior) p, objects, nbAta);
                    nbAta++;
                }
            } while (more.equals("y"));
        } else {
            out.println("vkjsd");
            giveSpell((Magician) p, objects, nbAta);
            nbAta++;
            String more;
            do {
                out.println("Add another? (Y/N)");
                more = sc.nextLine();
                if (more.equals("y")) {
                    giveSpell((Magician) p, objects, nbAta);
                    nbAta++;
                }
            } while (more.equals("y"));
        }
    }

    public static void modifyChar(Personnage characters[], ArrayList<Attack> objects, Integer nbAta) {
        String charTOchange;
        String modif;
        out.println("Which character you want to modify?");
        First.showCharsList(characters);
        charTOchange = sc.nextLine();
        Personnage p = characters[Integer.parseInt(charTOchange) - 1];
        out.println("Which property you want to change?");
        out.println(p);
        modif = sc.nextLine();
        switch (modif) {
            case "1":
                p.setName(giveName());
                break;
            case "2":
                p.setImage(giveImage());
                break;
            case "3":
                p.setLifeLevel(givelife());
                break;
            case "4":
                p.setAttackForce(giveAttack());
                break;
            case "5":
                out.println("You want to:\n 1. Change \n 2. Delete?");
                String chgDel = null;
                chgDel = sc.nextLine();
                if (chgDel.equals("1")) {
                    out.println("Witch slot you want to change?");
                    String nbSlot = null;
                    nbSlot = sc.nextLine();
                    try {
                        if ((p.getType()).equals("Magician")) {
                            giveSpell((Magician) p, objects, Integer.parseInt(nbSlot) - 1); // convert my character into a magician - cast notions
                        } else {
                            giveWeapon((Warrior) p, objects, Integer.parseInt(nbSlot) - 1);
                        }
                    } catch (java.lang.NumberFormatException e) {
                        out.println("Bad entry");
                    }
                } else if (chgDel.equals("2")) {
                    out.println("Witch slot you want to delete?");
                    String nbSlot = null;
                    nbSlot = sc.nextLine();
                    ((Warrior) p).deleteSlot(Integer.parseInt(nbSlot) - 1);
                }
                break;
            default:
                out.println("Invalid Choice");
        }
    }


    public static String giveName() {
        String name;
        do {
            out.println("Give your character a name");
            name = sc.nextLine();
        } while (name.equals(""));
        return name;
    }
    // Function to give an image to the character
    public static String giveImage() {
        String image;
        do {
            out.println("Give your character an Image");
            image = sc.nextLine();
        } while (image.equals(""));
        return image;
    }
    /**
     * Givelife string.
     *
     * @return the string
     */
    // Function to give a life level to the character
    public static String givelife() {
        out.println("Set your life level!(between 0-100)");
        String ll = null;
        boolean correct = false;
        while (!correct) {
            ll = sc.nextLine();
            try {
                if (Integer.parseInt(ll) < 0 || Integer.parseInt(ll) > 100) {
                    ll = "50";
                }
                correct = true;
            } catch (java.lang.NumberFormatException e) {
                out.println("Wrong type of entry");
            }
        }
        return ll;
    }
    // Function to give an attack force to the character
    public static String giveAttack() {
        out.println("Set your attack force!(between 0-100)");
        String af = null;
        boolean correct = false;
        while (!correct) {
            af = sc.nextLine();
            try {
                if (Integer.parseInt(af) < 0 || Integer.parseInt(af) > 100) {
                    af = "50";
                }
                correct = true;
            } catch (java.lang.NumberFormatException e) {
                out.println("Wrong type of entry");
            }
        }
        return af;
    }
    /**
     * Give weapon.
     *
     * @param warrior the warrior
     * @param objects the objects
     */
    public static void giveWeapon(Warrior warrior, ArrayList<Attack> objects, Integer nbAta) {
        String weapon;
        if (objects.size() > 0) {
            out.println("Choose your weapon:");
            First.showWeaponsList(objects);
            weapon = sc.nextLine();
            warrior.setWeapon((Weapon) (objects.get(Integer.parseInt(weapon) - 1)),nbAta);
            nbAta++;
        } else {
            out.println("You need to create a weapon first!\n1. Create now\n2. Create later");
            String question = sc.nextLine();
            if (question.equals("1")) {
                attackObject(objects);
                if(objects.get(0).getType() == "Weapon") {
                    warrior.setWeapon((Weapon) (objects.get(0)),0);
                }else{
                    out.println("Warriors can only use weapons and not spells");
                }
            }
        }
    }
    // Method to give a spell to the magician
    public static void giveSpell(Magician magician, ArrayList<Attack> objects, Integer nbAta) {
        String spell;
        if (objects.size() > 0) {
            out.println("Choose your spell:");
            First.showWeaponsList(objects);
            spell = sc.nextLine();
            magician.setSpell((Spell) (objects.get(Integer.parseInt(spell) - 1)), nbAta);
            nbAta++;
        } else {
            out.println("You need to create a weapon first!\n1. Create now\n2. Create later");
            String question = sc.nextLine();
            if (question.equals("1")) {
                attackObject(objects);
                if(objects.get(0).getType() == "Spell") {
                    magician.setSpell((Spell) (objects.get(0)),0);
                }else{
                    out.println("Magicians can only use spells and not weapons");
                }
            }
        }
    }
    public static void attackObject(ArrayList<Attack> objects) {
        String attackObject;
        String more = null;
        Attack weapon = null;
        do {
            out.println("1. Create weapon\n2. Create spell");
            attackObject = sc.nextLine();
            if (attackObject.equals("1")) {
                do {
                    out.println("Create your Weapon!\nGive it a name:");
                    String weapon2 = sc.nextLine();
                    out.println("Give it an attack power:");
                    String power = sc.nextLine();
                    weapon = new Weapon(weapon2, power);
                    weapon.setType("Weapon");
                    objects.add(weapon);
                    for(int i = 0; i<objects.size();i++) {
                        out.println(objects.get(i));
                    }
                    out.println("Do you want to create more (Y for yes)? ");
                    more = sc.nextLine().toUpperCase();
                } while (more.equals("Y"));
            } else if (attackObject.equals("2")) {
                do {
                    out.println("Create your Spell!\nGive it a name:");
                    String weapon2 = sc.nextLine();
                    out.println("Give it an attack power:");
                    String power = sc.nextLine();
                    weapon = new Spell(weapon2, power);
                    weapon.setType("Spell");
                    objects.add(weapon);
                    for(int i = 0; i<objects.size();i++) {
                        out.println(objects.get(i));
                    }
                    out.println("Do you want to create more (Y for yes)? ");
                    more = sc.nextLine().toUpperCase();
                } while (more.equals("Y"));
            }
        } while (!attackObject.equals("1") && !attackObject.equals("2"));
    }
}
