package DaD;

public class Succubes extends Enemies {
    private boolean killed = false;
    public Succubes (int newDamage){
        damage = newDamage;
    }

    public void show(){
        System.out.println("---------------> SUCCUBE with an attack force of: "+ damage);
    }

    public void action(Personnage p){
        if(!killed){
            damage = damage - p.getAttackForce();
            if(damage <= 0){
                damage = 0;
                p.setPosition(p.getPosition()+2);
                System.out.println("You killed the dragon. Advance 2 squares");
                killed = true;
            }else {
                p.setLifeLevel(p.getLifeLevel()- damage);
                if(p.getLifeLevel()<=0){
                    System.out.println("You died! GAME OVER");
                }
                p.setPosition(p.getPosition()-2);
            }
        }else{
            System.out.println("This succube is dead");
        }
    }
}
