package DaD;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class First {
    private static Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        Integer nb = 0;
        Personnage characters[] = new Personnage[5];
        ArrayList<Attack> objects = new ArrayList<Attack>();
//        Integer count = 0;
//        Integer countWeapon = 0;
//        Integer countSpell = 0;
//        Weapon weapons[] = new Weapon[10];
//        Spell spells[] = new Spell[10];
        String userMenu;
        out.println("Welcome to Dongeons and Dragons!");
        do {
            out.println("\nWhat do you want to do?\n1. Create new character\n2. View characters list\n3. Change a character\n" +
                    "4. Attack \n5. Create weapon or spell\n6. View weapons list\n10. Exit\n");
            userMenu = sc.nextLine();
            switch (userMenu) {
                case "1":
                    createChar(characters, nb, objects);
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
                        modifyChar(characters, objects);
                    } else {
                        out.println("No caracters");
                    }
                    break;
                case "4":
                    attack(characters);
                    break;
                case "5":
                    attackObject(objects);
                    break;
                case "6":
                    showWeaponsList(objects);
                    if (objects.get(0) != null) {
                        weaponDetails(objects);
                    }
                    break;
                case "10":
                    out.println("Exiting ...");
                    break;
                default:
                    out.println("Invalid Choice");
            }
        } while (!userMenu.equals("10"));
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

    public static void showWeaponsList(ArrayList<Attack> objects) {
        boolean noWeapons = true;
        out.println("List of Weapons");
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != null) {
                out.println(i + 1 + ". " + objects.get(i).getName());
                noWeapons = false;
            }
        }
        if (noWeapons) {
            out.println("no weapons\n");
        }
    }

    public static void weaponDetails(ArrayList<Attack> objects) {
        String details;
        try {
            do {
                out.println("Which weapon you want to check? (0 to exit)");
                details = sc.nextLine();
                if (details.equals("0")) {
                    out.println("exiting ...");
                } else {
                    int index = Integer.parseInt(details) - 1;
                    if (objects.get(index) != null) {
                        out.println(objects.get(index));
                    }
                }
            } while (!details.equals("0"));
        } catch (java.lang.NumberFormatException | java.lang.ArrayIndexOutOfBoundsException e) {
            out.println("Wrong type of entry");
        }
    }

    public static void modifyChar(Personnage characters[], ArrayList<Attack> objects) {
        String charTOchange;
        String modif;
        out.println("Which character you want to modify?");
        showCharsList(characters);
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
                if ((p.getType()).equals("Magician")) {
                    giveSpell((Magician) p); // convert my character into a magician - cast notions
                } else {
                    giveWeapon((Warrior) p, objects);
                }
                break;
            default:
                out.println("Invalid Choice");
        }
    }

    // Method to give a spell to the magician
    public static void giveSpell(Magician magician) {
        String spell;
        do {
            out.println("Choose your spell: 1. Explosion or 2. Bone crusher");
            spell = sc.nextLine();
            if (spell.equals("1")) {
                magician.setSpell("Explosion");
            } else if (spell.equals("2")) {
                magician.setSpell("Bone crusher");
            } else {
                out.println("Wrong input! Choose again");
            }
        } while (!spell.equals("1") && !spell.equals("2"));
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
                    objects.add(weapon);
                    out.println(objects.get(0));
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
                    objects.add(weapon);
                    out.println(objects.get(0));
                    out.println("Do you want to create more (Y for yes)? ");
                    more = sc.nextLine().toUpperCase();
                } while (more.equals("Y"));
            }
        } while (!attackObject.equals("1") && !attackObject.equals("2"));

    }

    // Method to give a weapon to the warrior
//    public static int createWeapon(Attack objects[], Integer count) {
//
////        do {
////            if (count < 10) {
////                out.println("Create your Weapon!\nGive it a name:");
////                String weapon2 = sc.nextLine();
////                out.println("Give it an attack power:");
////                String power = sc.nextLine();
////                weapon = new Weapon(weapon2, power);
////                objects[count] = weapon;
////                count++;
////                out.println(objects[0]);
////                out.println("Do you want to create more (Y for yes)? (you can still create " + (objects.length - count) + ")");
////                more = sc.nextLine().toUpperCase();
////            } else {
////                out.println("No space for more weapons");
////            }
////        } while (more.equals("Y") && count < 10);
//        return count;
//    }
//    public static int createSpell(Attack objects, Integer count) {
//        String more = null;
//        Attack spell = null;
//        do {
//            if (count < 10) {
//                out.println("Create your Spell!\nGive it a name:");
//                String weapon2 = sc.nextLine();
//                out.println("Give it an attack power:");
//                String power = sc.nextLine();
//                spell = new Spell(weapon2, power);
//                objects[count] = spell;
//                count++;
//                out.println(objects[0]);
//                out.println("Do you want to create more (Y for yes)? (you can still create " + (objects.length - count) + ")");
//                more = sc.nextLine().toUpperCase();
//            } else {
//                out.println("No space for mor weapons");
//            }
//        } while (more.equals("Y") && count < 10);
//        return count;
//    }

    public static void giveWeapon(Warrior warrior, ArrayList<Attack> objects) {
        String weapon;
        if (objects.size() > 0) {
            out.println("Choose your weapon:");
            showWeaponsList(objects);
            weapon = sc.nextLine();
            warrior.setWeapon((Weapon)(objects.get(Integer.parseInt(weapon) - 1)));
        } else {
            out.println("You need to create a weapon first!\n1. Create now\n2. Create later");
            String question = sc.nextLine();
            if (question.equals("1")) {
                attackObject(objects);
                warrior.setWeapon((Weapon)(objects.get(0)));
            }
        }
    }


    // Creates a character giving it a type and calling all necessary functions
    public static void createChar(Personnage characters[], Integer nb, ArrayList<Attack> objects) {
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
            giveWeapon((Warrior) p, objects);
        } else {
            out.println("fdfdjkgdn");
            //giveSpell((Magician) p, objects);
        }
    }

    // Function to give a name to the character
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

    public static void attack(Personnage characters[]) {
        if (characters[0] != null) {
            out.println("ATTACK");
            Personnage fighter = characters[0];
            out.println("Which attack force you want to use? (Attack force available: " + fighter.getAttackForce() + ")");
            String useForce = sc.nextLine();
            int newAttackForce = Integer.parseInt(fighter.getAttackForce()) - Integer.parseInt(useForce);
            fighter.setAttackForce(String.valueOf(newAttackForce));
            out.println("Your new attack force is: " + fighter.getAttackForce());
        } else {
            out.println("No usable characters");
        }
    }
}