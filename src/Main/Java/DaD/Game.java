package DaD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class Game {
    protected int startPos = 0;
    private int[] protectionValue = {5, 3, 2};

    protected final int MAP_LENGTH = 64; // constant
    private final int NUM_SORCERER = 4; // constant


    private final int NUM_SUCCUBUS = 4; // constant
    private final int NUM_DRAGONS = 6; // constant
    private final int NUM_WEAPONS = 2; // constant
    private final int NUM_SPELLS = 2; // constant
    private final int NUM_SHIELDS = 3; // constant
    private final int NUM_POTIONS = 3; // constant
    private final int NUM_MALUS = 2; // constant
    private final int NUM_BONUS = 1; // constant
    private final int NUM_JOKER = 2; // constant

    protected  List<Event> map = new ArrayList<Event>();
    private  Sorcerer[] mySorcerers = new Sorcerer[NUM_SORCERER];
    private  Succubes[] mySuccubes = new Succubes[NUM_SUCCUBUS];
    private  Dragon[] myDragons = new Dragon[NUM_DRAGONS];
    private  BoxWeapon[] myWeapons = new BoxWeapon[NUM_WEAPONS];
    private  BoxSpell[] mySpells = new BoxSpell[NUM_SPELLS];
    private  BoxShield[] myShields = new BoxShield[NUM_SHIELDS];
    private  BoxPotion[] myPotions = new BoxPotion[NUM_POTIONS];
    private  BoxMalus[] myMalus = new BoxMalus[NUM_MALUS];
    private  BoxBonus[] myBonus = new BoxBonus[NUM_BONUS];
    private  BoxJoker[] myJoker = new BoxJoker[NUM_JOKER];

//    public ArrayList getEvents(){
//        ArrayList list = new ArrayList();
//        list.add(mySorcerers, mySuccubes);
//        return list;
//    }




    public void newGame(Personnage p){
        do {
            // Lancer le dé
            out.println(p.getName() + " You are in position " + p.getPosition());
            int rollValue = Factory.rollDie();
            out.println("You rolled: " + rollValue);
            // personnage.move();
            p.move(rollValue);
            // personnage.interactWithEvent();
            p.interactWithEvent(map.get(p.getPosition()));


        }while(p.getPosition()<=63);
    }

//    public void playGame(Personnage p) {
//        out.println(p.getName() + " You are in position " + startPos);
//        int rollValue = Factory.rollDie();
//        out.println("You rolled: " + rollValue);
//        int newPosition = startPos + rollValue;
//        startPos = newPosition;
//        if (newPosition < 64) {
//            if (!map.get(newPosition).getClass().equals(Event.class)) {
//                out.println("You are in square " + newPosition + "\n You found " + map.get(newPosition).show());
//                if (map.get(newPosition).getClass().equals(BoxMalus.class)) {
//                    startPos = newPosition - 5;
//                } else if (map.get(newPosition).getClass().equals(BoxBonus.class)) {
//                    startPos = newPosition + 5;
//                } else if (map.get(newPosition).getClass().equals(BoxJoker.class)) {
//                    BoxJoker boxJoker = (BoxJoker) map.get(newPosition);
//                    if (boxJoker.getLife() == 50 && boxJoker.isUsed() == false) {
//                        int currentLife = p.getLifeLevel();
//                        int newLife = currentLife + 50;
//                        p.setLifeLevel(newLife);
//                        boxJoker.setUsed(true);
//                    } else if (boxJoker.getLife() == 50 && boxJoker.isUsed() == true) {
//                        out.println("Joker already used");
//                    } else if (boxJoker.getLife() == 25 && boxJoker.isUsed() == false) {
//                        int currentLife = p.getLifeLevel();
//                        int newLife = currentLife + 25;
//                        p.setLifeLevel(newLife);
//                        boxJoker.setUsed(true);
//                    } else if (boxJoker.getLife() == 25 && boxJoker.isUsed() == true) {
//                        out.println("Joker already used");
//                    }
//                } else if (map.get(newPosition).getClass().equals(BoxWeapon.class)) {
//                    BoxWeapon boxWeapon = (BoxWeapon) map.get(newPosition);
//                    if (boxWeapon.getName().equals("Mace")) {
//                        Warrior.setWeapon(Weapon.mace, 1);
//                    } else {
//                        Warrior.setWeapon(Weapon.sword, 2);
//                    }
//                } else if (map.get(newPosition).getClass().equals(BoxShield.class)) {
//                    BoxShield boxShield = (BoxShield) map.get(newPosition);
//                    if (boxShield.getProtection() == 2) {
//                        //Warrior.inventory[3] = "Shield";
//                    }
//                } else if (map.get(newPosition).getClass().equals(Dragon.class)) {
//                    Enemies enemies = (Enemies) map.get(newPosition);
//                    if (!Dragon.isKilled()) {
//                        int enemyAttack = enemies.getDamage();
//                        out.println(enemyAttack);
//                        int heroAttack = p.getAttackForce();
//                        out.println(heroAttack);
//                        int enemyNewLife = enemyAttack - heroAttack;
//                        out.println(enemyNewLife);
//                        int heroNewLife = p.getLifeLevel() - enemyNewLife;
//                        if (enemyNewLife <= 0) {
//                            startPos = startPos + 2;
//                            out.println("You won. You advanced 2 squares. You are now in square " + startPos);
//                            Dragon.setKilled(true);
//                        } else {
//                            p.setLifeLevel(heroNewLife);
//                            if (p.getLifeLevel() <= 0) {
//                                out.println("You died! GAME OVER");
//                            }
//                            startPos = startPos - 2;
//                            out.println("You lost. You go back 2 squares. You are now in square " + startPos);
//                        }
//                    } else {
//                        out.println("Dragon already killed");
//                    }
//                } else if (map.get(newPosition).getClass().equals(Sorcerer.class)) {
//                    Enemies enemies = (Enemies) map.get(newPosition);
//                    if (Sorcerer.isKilled() == false) {
//                        int enemyAttack = enemies.getDamage();
//                        out.println(enemyAttack);
//                        int heroAttack = p.getAttackForce();
//                        out.println(heroAttack);
//                        int enemyNewLife = enemyAttack - heroAttack;
//                        out.println(enemyNewLife);
//                        int heroNewLife = p.getLifeLevel() - enemyNewLife;
//                        if (enemyNewLife <= 0) {
//                            startPos = startPos + 2;
//                            out.println("You won. You advanced 2 squares. You are now in square " + startPos);
//                        } else {
//                            p.setLifeLevel(heroNewLife);
//                            if (p.getLifeLevel() <= 0) {
//                                out.println("You died! GAME OVER");
//                            }
//                            startPos = startPos - 2;
//                            out.println("You lost. You go back 2 squares. You are now in square " + startPos);
//                        }
//                    } else {
//                        out.println("Sorcerer already killed");
//                    }
//                } else {
//                    out.println("You are in square " + newPosition);
//                }
//            } else {
//                out.println("Game Over --- YOU WIN");
//                startPos = 0;
//            }
//        }
//    }

    public void placeEvents() {
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
            out.println("Case " + i + " ");
            map.get(i).show();
        }
    }

    public void placeMalus() {
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
            } while (!malusPlaced);// the same as (malusPlaced != true)
        }
    }

    public  void placeBonus() {
        int placement = 0;
        for (int i = 0; i < NUM_BONUS; i++) {
            boolean bonusPlaced = false;
            do {
                Random place = new Random();
                placement = place.nextInt(MAP_LENGTH - 1) + 1;
                if (map.get(placement).getClass().equals(Event.class)) {
                    map.set(placement, myBonus[i]);
                    bonusPlaced = true;
                }
            } while (!bonusPlaced); // the same as (bonusPlaced != true)
        }
    }

    public  void placeJoker() {
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
            } while (!jokerPlaced); // the same as (jokerPlaced != true)
        }
    }

    public  void placePotions() {
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
            } while (!potionPlaced); // the same as (potionPlaced != true)
        }
    }

    public  void placeShields() {
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
            } while (!shieldPlaced);// the same as (shieldPlaced != true)
        }
    }

    public  void placeWeapons() {
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
            } while (!weaponPlaced); // the same as (weaponPlaced != true)
        }
    }

    public  void placeSpells() {
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
            } while (!spellPlaced);// the same as (spellPlaced != true)
        }
    }

    public  void placeSorcerer() {
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
            } while (!sorcPlaced); // the same as (sorcPlaced != true)
        }
    }

    public  void placeDragons() {
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
            } while (!dragPlaced);// the same as (dragPlaced != true)
        }
    }

    public void placeSuccubes() {
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
            } while (!succuPlaced);// the same as (succuPlaced != true)
        }
    }

    public void generateEvents() {
        mySorcerers = Factory.generateSorcerer(NUM_SORCERER);
        mySuccubes = Factory.generateSuccubes(NUM_SUCCUBUS);
        myDragons = Factory.generateDragons(NUM_DRAGONS);
        myWeapons = Factory.generateWeaponBoxes();
        mySpells = Factory.generateSpellBoxes(NUM_SPELLS);
        myShields = Factory.generateShieldBoxes(NUM_SHIELDS, protectionValue);
        myPotions = Factory.generatePotionBoxes(NUM_POTIONS, protectionValue);
        myMalus = Factory.generateMalusBoxes(NUM_MALUS);
        myBonus = Factory.generateBonusBoxes(NUM_BONUS);
        myJoker = Factory.generateJokerBoxes(NUM_JOKER);
    }
}
