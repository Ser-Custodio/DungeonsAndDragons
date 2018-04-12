package DaD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static DaD.Weapon.bow;
import static DaD.Weapon.mace;
import static DaD.Weapon.sword;
import static java.lang.System.*;

public abstract class Factory {
    private static Scanner sc = new Scanner(in);

    public static void createChar(Personnage characters[], Integer nb, ArrayList<AttackItem> objects, Integer nbAta) {
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
        sc.nextLine();
        if (p.getType().equals("Warrior")) {
            out.println("Choose your weapon");
            for(int i=0;i <objects.size();i++) {
                out.println((i+1)+". "+objects.get(i).getName());
            }
            giveWeapon((Warrior)p);
            p.setAttackForce(p.getAttackForce() + 25);
        } else {
            out.println("vkjsd");
//            giveSpell((Magician) p, objects, nbAta);
//            nbAta++;
//            String more;
//            do {
//                out.println("Add another? (Y/N)");
//                more = sc.nextLine();
//                if (more.equals("y")) {
//                    giveSpell((Magician) p, objects, nbAta);
//                    nbAta++;
//                }
//            } while (more.equals("y"));
        }
    }

    public static void modifyChar(Personnage characters[], ArrayList<AttackItem> objects, Integer nbAta) {
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
//            case "4":
//                p.setAttackForce(giveAttack());
//                break;
//            case "5":
//                out.println("You want to:\n 1. Change \n 2. Delete?");
//                String chgDel = null;
//                chgDel = sc.nextLine();
//                if (chgDel.equals("1")) {
//                    out.println("Witch slot you want to change?");
//                    String nbSlot = null;
//                    nbSlot = sc.nextLine();
//                    try {
//                        if ((p.getType()).equals("Magician")) {
//                            giveSpell((Magician) p, objects, Integer.parseInt(nbSlot) - 1); // convert my character into a magician - cast notions
//                        } else {
//                            giveWeapon((Warrior) p, objects, Integer.parseInt(nbSlot) - 1);
//                        }
//                    } catch (java.lang.NumberFormatException e) {
//                        out.println("Bad entry");
//                    }
//                } else if (chgDel.equals("2")) {
//                    out.println("Witch slot you want to delete?");
//                    String nbSlot = null;
//                    nbSlot = sc.nextLine();
//                    ((Warrior) p).deleteSlot(Integer.parseInt(nbSlot) - 1);
//                }
//                break;
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

    // Function to give a life level to the character
    public static int givelife() {
        out.println("Set your life level!(between 0-100)");
        int ll = 0;
        boolean correct = false;
        while (!correct) {
            ll = sc.nextInt();
            try {
                if (ll < 0 || ll > 100) {
                    ll = 50;
                }
                correct = true;
            } catch (java.lang.NumberFormatException e) {
                out.println("Wrong type of entry");
            }
        }
        return ll;
    }

    public static void giveWeapon(Warrior warrior) {
        String weapon;
            weapon = sc.nextLine();
            switch (weapon) {
                case "1":
                    warrior.setWeapon(bow,0);
                   // Warrior.inventory[0] = Weapon.allWeapons[0].toString();
                    break;
                case "2":
                    warrior.setWeapon(mace,0);
//                    Warrior.inventory[0] = Weapon.allWeapons[1].toString();
                    break;
                case "3":
                    warrior.setWeapon(sword,0);
//                    Warrior.inventory[0] = Weapon.allWeapons[2].toString();
                    break;
                default:
                    out.println("no weapon");
                    break;
            }
//            warrior.setWeapon((Weapon) (objects.get(Integer.parseInt(weapon) - 1)), nbAta);
//            nbAta++;
    }

    // Method to give a spell to the magician
//    public static void giveSpell(Magician magician, ArrayList<AttackItem> objects, Integer nbAta) {
//        String spell;
//        if (objects.size() > 0) {
//            out.println("Choose your spell:");
//            First.showWeaponsList();
//            spell = sc.nextLine();
//            magician.setSpell((Spell) (objects.get(Integer.parseInt(spell) - 1)), nbAta);
//            nbAta++;
//        } else {
//            out.println("You need to create a weapon first!\n1. Create now\n2. Create later");
//            String question = sc.nextLine();
//            if (question.equals("1")) {
//                attackObject(objects);
//                if (objects.get(0).getType() == "Spell") {
//                    magician.setSpell((Spell) (objects.get(0)), 0);
//                } else {
//                    out.println("Magicians can only use spells and not weapons");
//                }
//            }
//        }
//    }
//******************************************* Function to create weapons ********************************************
//    public static void attackObject(ArrayList<AttackItem> objects) {
//        String attackObject;
//        String more = null;
//        AttackItem weapon = null;
//        do {
//            out.println("1. Create weapon\n2. Create spell");
//            attackObject = sc.nextLine();
//            if (attackObject.equals("1")) {
//                do {
//                    out.println("Create your Weapon!\nGive it a name:");
//                    String weapon2 = sc.nextLine();
//                    out.println("Give it an attack power:");
//                    String power = sc.nextLine();
//                    weapon = new Weapon(weapon2, power);
//                    weapon.setType("Weapon");
//                    objects.add(weapon);
//                    for (int i = 0; i < objects.size(); i++) {
//                        out.println(objects.get(i));
//                    }
//                    out.println("Do you want to create more (Y for yes)? ");
//                    more = sc.nextLine().toUpperCase();
//                } while (more.equals("Y"));
//            } else if (attackObject.equals("2")) {
//                do {
//                    out.println("Create your Spell!\nGive it a name:");
//                    String weapon2 = sc.nextLine();
//                    out.println("Give it an attack power:");
//                    String power = sc.nextLine();
//                    weapon = new Spell(weapon2, power);
//                    weapon.setType("Spell");
//                    objects.add(weapon);
//                    for (int i = 0; i < objects.size(); i++) {
//                        out.println(objects.get(i));
//                    }
//                    out.println("Do you want to create more (Y for yes)? ");
//                    more = sc.nextLine().toUpperCase();
//                } while (more.equals("Y"));
//            }
//        } while (!attackObject.equals("1") && !attackObject.equals("2"));
//    }

    public static void generateMap(int MAP_LENGTH, List map) {
        for (int i = 0; i <= MAP_LENGTH; i++) {
            Event newMap = new Event();
            map.add(newMap);
        }
    }



    public static Sorcerer[] generateSorcerer(int NUM_SORCERER) {
        int[] listDamage = {75, 50, 25, 15};
        Sorcerer[] myTempSorcerers = new Sorcerer[NUM_SORCERER];
        for (int i = 0; i < NUM_SORCERER; i++) {
            myTempSorcerers[i] = new Sorcerer(listDamage[i]);
        }
        return myTempSorcerers;
    }

    public static Succubes[] generateSuccubes(int NUM_SUCCUBUS) {
        int[] listDamage = {75, 50, 25, 15};
        Succubes[] myTempSuccubus = new Succubes[NUM_SUCCUBUS];
        for (int i = 0; i < NUM_SUCCUBUS; i++) {
            myTempSuccubus[i] = new Succubes(listDamage[i]);
        }
        return myTempSuccubus;
    }

    public static Dragon[] generateDragons(int NUM_DRAGONS) {
        int[] listDamage = {80, 60, 40, 30, 20, 15};
        Dragon[] myTempDragons = new Dragon[NUM_DRAGONS];
        for (int i = 0; i < NUM_DRAGONS; i++) {
            myTempDragons[i] = new Dragon(listDamage[i]);
        }
        return myTempDragons;
    }

    public static BoxWeapon[] generateWeaponBoxes() {
        String weapon1 = "Mace";
        String weapon2 = "Sword";
        BoxWeapon[] myTempWeapons = new BoxWeapon[2];
//        for (int i = 0; i < NUM_WEAPONS; i++) {
            myTempWeapons[0] = new BoxWeapon(weapon1);
            myTempWeapons[1] = new BoxWeapon(weapon2);
//        }
        return myTempWeapons;
    }

    public static BoxSpell[] generateSpellBoxes(int NUM_SPELLS) {
        BoxSpell[] myTempSpells = new BoxSpell[NUM_SPELLS];
        for (int i = 0; i < NUM_SPELLS; i++) {
            myTempSpells[i] = new BoxSpell();
        }
        return myTempSpells;
    }

    public static BoxJoker[] generateJokerBoxes(int NUM_JOKER) {
        int[] jokerValues = {50, 25};
        BoxJoker[] myTempJoker = new BoxJoker[NUM_JOKER];
        for (int i = 0; i < NUM_JOKER; i++) {
            myTempJoker[i] = new BoxJoker(jokerValues[i]);
        }
        return myTempJoker;
    }

    public static BoxShield[] generateShieldBoxes(int NUM_SHIELDS, int[] protectionValue) {
        BoxShield[] myTempShields = new BoxShield[NUM_SHIELDS];
        for (int i = 0; i < NUM_SHIELDS; i++) {
            myTempShields[i] = new BoxShield(protectionValue[i]);
        }
        return myTempShields;
    }

    public static BoxPotion[] generatePotionBoxes(int NUM_POTIONS, int[] protectionValue) {
        BoxPotion[] myTempPotions = new BoxPotion[NUM_POTIONS];
        for (int i = 0; i < NUM_POTIONS; i++) {
            myTempPotions[i] = new BoxPotion(protectionValue[i]);
        }
        return myTempPotions;
    }

    public static BoxMalus[] generateMalusBoxes(int NUM_MALUS) {
        BoxMalus[] myTempMalus = new BoxMalus[NUM_MALUS];
        for (int i = 0; i < NUM_MALUS; i++) {
            myTempMalus[i] = new BoxMalus();
        }
        return myTempMalus;
    }

    public static BoxBonus[] generateBonusBoxes(int NUM_BONUS) {
        BoxBonus[] myTempBonus = new BoxBonus[NUM_BONUS];
        for (int i = 0; i < NUM_BONUS; i++) {
            myTempBonus[i] = new BoxBonus();
        }
        return myTempBonus;
    }



    public static int rollDie() {
        Random roll = new Random();
        int die = roll.nextInt(6) + 1;
        return die;
    }

}
