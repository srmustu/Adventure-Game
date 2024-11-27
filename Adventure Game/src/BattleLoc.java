import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {

    private String m1 = "You are logged in to ";
    private String m2 = "Be careful ";
    private String m3 = " lives here.";
    private String m4 = " number of ";
    private String m5 = "Press F to fight and R to escape !";
    private String m6 = "Your choice : ";
    private String m7 = "You defeated all ";
    private String m8 = " type enemies";
    private Monster monster;
    private String award;
    private int maxMonster;

    private String reward;
    private boolean visited;
    public BattleLoc(int id, Player player, String name, Monster monster, String award, int maxMonster ) {
        super(id, player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
        this.visited = false;
    }

    @Override
    public boolean onLocation() {

        int obsNumber = this.randomMaxMonsterNumber();
        System.out.println(" ");
        System.out.println(m1 + getName() + "\n" + m2 + obsNumber + m4 + getMonster().getName() + m3);
        System.out.print(m5 + "\n" + m6);

        input.nextLine();
        String bChoice = input.nextLine().toUpperCase();





            if (bChoice.equals("F") && combat(obsNumber)) {
                System.out.println(m7 + getMonster().getName() + m8);
                return true;
            }

            if (getPlayer().getHealth() <= 0) {
                System.out.println("You died.");
                return false;
            }




        return true;
    }


    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {

            getMonster().setHealth(getMonster().getOriginalHealth());
            getPlayer().printInventoryInfo();
            monsterStats(i);

            while (getPlayer().getHealth() > 0 && getMonster().getHealth() > 0) {
                System.out.print(m5 + "\n" + m6);

                String selectTactic = input.nextLine().toUpperCase();
                if (selectTactic.equals("F")) {
                    System.out.println("---------");
                    System.out.println("You hit the monster.");
                    getMonster().setHealth(getMonster().getHealth() - getPlayer().getTotalDamage());

                    afterHit();
                    if (getMonster().getHealth() > 0) {
                        System.out.println("---------");
                        System.out.println("Monster attacked you.");
                        int monsterDamage = getMonster().getDamage() - getPlayer().getProtectionLevel();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        getPlayer().setHealth(getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }


            if (getMonster().getHealth() == 0) {
                System.out.println("You defeated the " + i + ". enemy of " + getMonster().getName() + " type.");
                System.out.println("You earned " + getMonster().getMoney() + " money.");

                getPlayer().setMoney(getPlayer().getMoney() + getMonster().getMoney());
                System.out.println("Your current balance : " + getPlayer().getMoney());
            } else {
                return false;
            }
        }

        return true;
    }

    public void afterHit() {
        System.out.println("Your life : " + getPlayer().getHealth());
        System.out.println("Life of " + getMonster().getName() + " : " + getMonster().getHealth());
        System.out.println();
    }


    public void monsterStats(int i) {
        System.out.println("--------------");
        System.out.println(i + ". properties of " + getMonster().getName());
        System.out.println("Damage : " + getMonster().getDamage() + "\t" + "Health : " + getMonster().getHealth() + "\t" + "Prize : " + getMonster().getMoney());

    }


    public int randomMaxMonsterNumber() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    public Monster getMonster() {
        return this.monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
