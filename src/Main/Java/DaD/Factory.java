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
    protected static int startPos = 0;
    private static int[] protectionValue = {5, 3, 2};

    private final static int MAP_LENGTH = 64; // constant
    private final static int NUM_SORCERER = 4; // constant
    private final static int NUM_SUCCUBUS = 4; // constant
    private final static int NUM_DRAGONS = 6; // constant
    private final static int NUM_WEAPONS = 2; // constant
    private final static int NUM_SPELLS = 2; // constant
    private final static int NUM_SHIELDS = 3; // constant
    private final static int NUM_POTIONS = 3; // constant
    private final static int NUM_MALUS = 2; // constant
    private final static int NUM_BONUS = 1; // constant
    private final static int NUM_JOKER = 2; // constant

    protected static List<Event> map = new ArrayList<Event>();
    private static Sorcerer[] mySorcerers = new Sorcerer[NUM_SORCERER];
    private static Succubes[] mySuccubes = new Succubes[NUM_SUCCUBUS];
    private static Dragon[] myDragons = new Dragon[NUM_DRAGONS];
    private static BoxWeapon[] myWeapons = new BoxWeapon[NUM_WEAPONS];
    private static BoxSpell[] mySpells = new BoxSpell[NUM_SPELLS];
    private static BoxShield[] myShields = new BoxShield[NUM_SHIELDS];
    private static BoxPotion[] myPotions = new BoxPotion[NUM_POTIONS];
    private static BoxMalus[] myMalus = new BoxMalus[NUM_MALUS];
    private static BoxBonus[] myBonus = new BoxBonus[NUM_BONUS];
    private static BoxJoker[] myJoker = new BoxJoker[NUM_JOKER];


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
//        p.setAttackForce(p.getAttackForce());

        if (p.getType().equals("Warrior")) {
            out.println("Choose your weapon");
            for(int i=0;i <objects.size();i++) {
                out.println((i+1)+". "+objects.get(i).getName());
            }
            giveWeapon((Warrior)p);
//            String choice = sc.nextLine();
//            switch (choice) {
//                case "1":
//                    Warrior.inventory[0] = bow;
//                    break;
//                case "2":
//                    Warrior.inventory[0] = Weapon.mace;
//                    break;
//                case "3":
//                    Warrior.inventory[0] = Weapon.sword;
//                    break;
//                default:
//                    out.println("jhb");
//            }
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

    public static void generateMap() {
        startPos = 0;
        for (int i = 0; i <= MAP_LENGTH; i++) {
            Event newMap = new Event();
            map.add(newMap);
        }
    }

    public static void generateEvents() {
        generateSorcerer();
        generateSuccubes();
        generateDragons();
        generateWeaponBoxes();
        generateSpellBoxes();
        generateShieldBoxes();
        generatePotionBoxes();
        generateMalusBoxes();
        generateBonusBoxes();
        generateJokerBoxes();

    }


    public static Sorcerer[] generateSorcerer() {
        int[] listDamage = {75, 50, 25, 15};
        for (int i = 0; i < NUM_SORCERER; i++) {
            mySorcerers[i] = new Sorcerer(listDamage[i]);
        }
        return mySorcerers;
    }

    public static Succubes[] generateSuccubes() {
        int[] listDamage = {75, 50, 25, 15};
        for (int i = 0; i < NUM_SUCCUBUS; i++) {
            mySuccubes[i] = new Succubes(listDamage[i]);
        }
        return mySuccubes;
    }

    public static Dragon[] generateDragons() {
        int[] listDamage = {80, 60, 40, 30, 20, 15};
        for (int i = 0; i < NUM_DRAGONS; i++) {
            myDragons[i] = new Dragon(listDamage[i]);
        }
        return myDragons;
    }

    public static BoxWeapon[] generateWeaponBoxes() {
        String weapon1 = "Mace";
        String weapon2 = "Sword";


//        for (int i = 0; i < NUM_WEAPONS; i++) {
            myWeapons[0] = new BoxWeapon(weapon1);
            myWeapons[1] = new BoxWeapon(weapon2);

//        }
        return myWeapons;
    }

    public static BoxSpell[] generateSpellBoxes() {
        for (int i = 0; i < NUM_SPELLS; i++) {
            mySpells[i] = new BoxSpell();
        }
        return mySpells;
    }

    public static BoxJoker[] generateJokerBoxes() {
        int[] jokerValues = {50, 25};
        for (int i = 0; i < NUM_JOKER; i++) {
            myJoker[i] = new BoxJoker(jokerValues[i]);
        }
        return myJoker;
    }

    public static BoxShield[] generateShieldBoxes() {
        for (int i = 0; i < NUM_SHIELDS; i++) {
            myShields[i] = new BoxShield(protectionValue[i]);
        }
        return myShields;
    }

    public static BoxPotion[] generatePotionBoxes() {
        for (int i = 0; i < NUM_POTIONS; i++) {
            myPotions[i] = new BoxPotion(protectionValue[i]);
        }
        return myPotions;
    }

    public static BoxMalus[] generateMalusBoxes() {
        for (int i = 0; i < NUM_MALUS; i++) {
            myMalus[i] = new BoxMalus();
        }
        return myMalus;
    }

    private static BoxBonus[] generateBonusBoxes() {
        for (int i = 0; i < NUM_BONUS; i++) {
            myBonus[i] = new BoxBonus();
        }
        return myBonus;
    }

    public static void placeEvents() {
        placeWeapons();
        placeSpells();
        placeShields();
        placePotions();
        placeMalus();
        placeBonus();
        placeJoker();
        placeSorcerer();
        placeDragons();
        placeSuccubes();
        for (int i = 0; i <= MAP_LENGTH; i++) {
            out.println("Case " + i + " " + map.get(i).show());
        }
    }

    private static void placeMalus() {
        int placement = 0;
        for (int i = 0; i < NUM_MALUS; i++) {
            boolean malusPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myMalus[i]);
                    malusPlaced = true;
                }
            } while (malusPlaced != true);
        }
    }

    private static void placeBonus() {
        int placement = 0;
        for (int i = 0; i < NUM_BONUS; i++) {
            boolean bonusPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myMalus[i]);
                    bonusPlaced = true;
                }
            } while (bonusPlaced != true);
        }
    }

    private static void placeJoker() {
        int placement = 0;
        for (int i = 0; i < NUM_JOKER; i++) {
            boolean jokerPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myJoker[i]);
                    jokerPlaced = true;
                }
            } while (jokerPlaced != true);
        }
    }

    private static void placePotions() {
        int placement = 0;
        for (int i = 0; i < NUM_POTIONS; i++) {
            boolean potionPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myPotions[i]);
                    potionPlaced = true;
                }
            } while (potionPlaced != true);
        }
    }

    public static void placeShields() {
        int placement = 0;
        for (int i = 0; i < NUM_SHIELDS; i++) {
            boolean shieldPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myShields[i]);
                    shieldPlaced = true;
                }
            } while (shieldPlaced != true);
        }
    }

    public static void placeWeapons() {
        int placement = 0;
        for (int i = 0; i < NUM_WEAPONS; i++) {
            boolean weaponPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myWeapons[i]);
                    weaponPlaced = true;
                }
            } while (weaponPlaced != true);
        }
    }

    public static void placeSpells() {
        int placement = 0;
        for (int i = 0; i < NUM_SPELLS; i++) {
            boolean spellPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, mySpells[i]);
                    spellPlaced = true;
                }
            } while (spellPlaced != true);
        }
    }

    public static void placeSorcerer() {
        int placement = 0;
        for (int i = 0; i < NUM_SORCERER; i++) {
            boolean sorcPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, mySorcerers[i]);
                    sorcPlaced = true;
                }
            } while (sorcPlaced != true);
        }
    }

    public static void placeDragons() {
        int placement = 0;
        for (int i = 0; i < NUM_DRAGONS; i++) {
            boolean dragPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myDragons[i]);
                    dragPlaced = true;
                }
            } while (dragPlaced != true);
        }
    }

    public static void placeSuccubes() {
        int placement = 0;
        for (int i = 0; i < NUM_SUCCUBUS; i++) {
            boolean succuPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, mySuccubes[i]);
                    succuPlaced = true;
                }
            } while (succuPlaced != true);
        }
    }

    public static int rollDie() {
        Random roll = new Random();
        int die = roll.nextInt(6) + 1;
        return die;
    }
}
