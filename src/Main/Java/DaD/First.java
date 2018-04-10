package DaD;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * The type First.
 */
public class First {
    private static Scanner sc = new Scanner(in);


    public static void main(String[] args) {
        Integer nb = 0;
        Integer nbAta = 0;
        Personnage characters[] = new Personnage[5];
        ArrayList<AttackItem> objects = new ArrayList<AttackItem>();
        String userMenu;

        out.println("Welcome to Dongeons and Dragons!");
        Factory.generateMap();
        Factory.generateEvents();
        Factory.placeEvents();
        do {

            out.println("\nWhat do you want to do?\n1. Create new character\n2. View characters list\n3. Change a character\n" +
                    "4. AttackItem \n5. Create weapon or spell\n6. View weapons list \n7. Play\n10. Exit\n");
            userMenu = sc.nextLine();
            switch (userMenu) {
                case "1":
                    Factory.createChar(characters, nb, objects, nbAta);
                    nb++;
                    break;
                case "2":
                    showCharsList(characters);
                    if (characters[0] != null) {
                        details(characters);
                    }
                    break;
                case "3":
                    if (characters[0] != null) {
                        Factory.modifyChar(characters, objects, nbAta);
                    } else {
                        out.println("No caracters");
                    }
                    break;
//                case "4":
//                    attack(characters);
//                    break;
//                case "5":
//                    Factory.attackObject(objects);
//                    break;
//                case "6":
//                    showWeaponsList(objects);
//                    if (objects.size() != 0) {
//                        weaponDetails(objects);
//                    }
//                    break;
                case "7":
                    if(characters[0] != null) {
                        playGame(characters[0]);
                    }else{
                        out.println("No characters");
                    }
//                    out.println("You are in position " + Factory.startPos);
//                    int rollValue = Factory.rollDie();
//                    out.println("You rolled: " + rollValue);
//                    int newPosition = Factory.startPos + rollValue;
//                    Factory.startPos = newPosition;
//                    if (newPosition < 64) {
//                        if (!Factory.map.get(newPosition).getClass().equals(Event.class)) {
//                            out.println("You are in square " + newPosition + "\n You found " + Factory.map.get(newPosition).show());
//                            if (Factory.map.get(newPosition).getClass().equals(BoxMalus.class)) {
//                                Factory.startPos = newPosition - 5;
//                            } else if (Factory.map.get(newPosition).getClass().equals(BoxBonus.class)) {
//                                Factory.startPos = newPosition + 5;
//                            }else if(Factory.map.get(newPosition).getClass().equals(BoxJoker.class)) {
//                                out.println("Life added");
//                                //add life points to the life level of the character
//                            }
//                        }else {
//                                out.println("You are in square " + newPosition);
//                        }
//                    } else {
//                            out.println("Game Over --- YOU WIN");
//                            Factory.startPos = 0;
//                    }
                    break;
//                case "8":
//
//                    break;
                case "10":
                    out.println("Exiting ...");
                    break;
                default:
                    out.println("Invalid Choice");
            }
        } while (!userMenu.equals("10"));
    }

    public static void playGame(Personnage p){
        out.println(p.getName() + " You are in position " + Factory.startPos);
        int rollValue = Factory.rollDie();
        out.println("You rolled: " + rollValue);
        int newPosition = Factory.startPos + rollValue;
        Factory.startPos = newPosition;
        if (newPosition < 64) {
            if (!Factory.map.get(newPosition).getClass().equals(Event.class)) {
                out.println("You are in square " + newPosition + "\n You found " + Factory.map.get(newPosition).show());
                if (Factory.map.get(newPosition).getClass().equals(BoxMalus.class)) {
                    Factory.startPos = newPosition - 5;
                } else if (Factory.map.get(newPosition).getClass().equals(BoxBonus.class)) {
                    Factory.startPos = newPosition + 5;
                }else if(Factory.map.get(newPosition).getClass().equals(BoxJoker.class)) {
                    BoxJoker boxJoker = (BoxJoker) Factory.map.get(newPosition);
                    if(boxJoker.getLife() == 50) {
                        int currentLife = Integer.parseInt(p.getLifeLevel());
                        int newLife = currentLife + 50;
                        p.setLifeLevel(String.valueOf(newLife));
                    }else{
                        int currentLife = Integer.parseInt(p.getLifeLevel());
                        int newLife = currentLife + 25;
                        p.setLifeLevel(String.valueOf(newLife));
                    }
                }else if(Factory.map.get(newPosition).getClass().equals(BoxWeapon.class)){
                    BoxWeapon boxWeapon = (BoxWeapon)Factory.map.get(newPosition);
                    if(boxWeapon.getName().equals("Mace")) {
                        Warrior.setWeapon(Weapon.mace, 1);
                    }else{
                        Warrior.setWeapon(Weapon.sword, 2);
                    }
                }
            }else {
                out.println("You are in square " + newPosition);
            }
        } else {
            out.println("Game Over --- YOU WIN");
            Factory.startPos = 0;
        }
    }

    // Shows list of characters
    public static void showCharsList(Personnage characters[]) {
        boolean noCharacters = true;
        out.println("Character List:");
        try {
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] != null) {
                    out.println(i + 1 + ". " + characters[i].getName());
                    noCharacters = false;
                }
            }
            if (noCharacters) {
                out.println("no characters\n");
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            out.println("Try again, not a good entry");
        }
    }

//    public static void showWeaponsList() {
//        out.println("List of Weapons");
//        for (int i = 0; i < Weapon.allWeapons.length; i++) {
//                out.println(i + 1 + ". " + Weapon.allWeapons[i]);
//            }
//    }

    // Shows details of specified character
    public static void details(Personnage characters[]) {
        String details;
        try {
            do {
                out.println("Which character you want to check? (0 to exit)");
                details = sc.nextLine();
                if (details.equals("0")) {
                    out.println("Exiting ...");
                } else {
                    if (characters[Integer.parseInt(details) - 1] != null) {
                        out.println(characters[Integer.parseInt(details) - 1]);
                    }
                }
            } while (characters[Integer.parseInt(details)] == null);
        } catch (java.lang.NumberFormatException | java.lang.ArrayIndexOutOfBoundsException e) {
            out.println("Wrong type of entry");
        }
    }

    public static void warriorWeapList() {
        out.println("List of Weapons");
        if (Warrior.inventory.length == 0) {
            out.println("no weapons\n");
        } else {
            for (int i = 0; i < Warrior.inventory.length; i++) {
                out.println(i + 1 + ". " + Warrior.inventory[i].getName());
            }
        }
    }

//    public static void weaponDetails(ArrayList<AttackItem> objects) {
//        String details;
//        try {
//            do {
//                out.println("Which weapon you want to check? (0 to exit)");
//                details = sc.nextLine();
//                if (details.equals("0")) {
//                    out.println("exiting ...");
//                } else {
//                    int index = Integer.parseInt(details) - 1;
//                    if (objects.get(index) != null) {
//                        out.println(objects.get(index));
//                    }
//                }
//            } while (!details.equals("0"));
//        } catch (java.lang.NumberFormatException | java.lang.IndexOutOfBoundsException e) {
//            out.println("Wrong type of entry");
//        }
//    }
}


//    public void attack(Personnage characters[]) {
//        if (characters[0] != null) {
//            out.println("ATTACK");
//            Personnage fighter = characters[0];
//            out.println("Which attack force you want to use? (AttackItem force available: " + fighter.getAttackForce() + ")");
//            String useForce = sc.nextLine();
//            int newAttackForce = Integer.parseInt(fighter.getAttackForce()) - Integer.parseInt(useForce);
//            fighter.setAttackForce(String.valueOf(newAttackForce));
//            out.println("Your new attack force is: " + fighter.getAttackForce());
//        } else {
//            out.println("No usable characters");
//        }
//    }
//    public int rollDie(){
//        Random roll = new Random();
//        int die = roll.nextInt(6)+1;
//        return die;
//    }
//}