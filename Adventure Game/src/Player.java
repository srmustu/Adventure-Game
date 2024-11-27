import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private int id;
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String playerName;
    private String heroName;
    private Inventory inventory;
    private int protectionLevel;
    private Set<String> materials;


    private String m1 = "Id : ";
    private String m2 = "Hero name : ";
    private String m3 = "Damage : ";
    private String m4 = "Health : ";
    private String m5 = "Money : ";
    private String m6 = "Please enter the Id of the hero you want to choose :  ";
    private String m7 = "You entered the wrong value, please try again.";
    private String m8 = " hero selected.";
    private String m9 = "Damage : ";
    private String m10 = "Health : ";
    private String m11 = "Money : ";
    private String m12 = "Weapon name : ";
    private String m13 = "Armor name : ";
    private String m14 = "Protection level : ";
    private String m15 = "Current inventory status : ";
    private String m16 = "Materials : ";

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
        this.materials = new HashSet<>();
    }

    Scanner input = new Scanner(System.in);

    public void selectHero() {

        Hero[] heroes = new Hero[]{new Samurai(), new Knight(), new Archer()};

        System.out.println("-----------------");
        for (Hero h : heroes) {
            System.out.println(
                    m1 + h.getId() + "\t" +
                            m2 + h.getHeroName() + "\t\t" +
                            m3 + h.getDamage() + "\t" +
                            m4 + h.getHealth() + "\t" +
                            m5 + h.getMoney());
        }
        System.out.println("-------------");
        System.out.print(m6);
        int selectHero = input.nextInt();

        switch (selectHero) {
            case 1:
                initHero(new Samurai());
                break;
            case 2:
                initHero(new Knight());
                break;
            case 3:
                initHero(new Archer());
                break;
            default:
                System.out.println(m7);
                break;
        }

        System.out.println();
        System.out.println(this.getHeroName() + m8 + "\n" + m9 + this.getDamage() + "\t" + m10 + this.getHealth() + "\t" + m11 + this.getMoney());

    }

    public void initHero(Hero hero) {
        this.setId(hero.getId());
        this.setHeroName(hero.getHeroName());
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setMoney(hero.getMoney());
        this.setOriginalHealth(hero.getHealth());

    }

    public void printInventoryInfo() {
        System.out.println(m15
                + m12 + this.inventory.getWeapon().getName() + "\t  "
                + m9 + this.getTotalDamage() + "\t"
                + m10  + this.getHealth() + "\t  "
                + m13 + this.inventory.getArmor().getName() + "\t"
                + m14 + this.getProtectionLevel() +  "\t"
                + m11 + this.getMoney());
    }




    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getHeroName() {
        return this.heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getProtectionLevel() {
        return this.protectionLevel + getInventory().getArmor().getProtectionLevel();
    }

    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public int getOriginalHealth(){
        return this.originalHealth;
    }

    public void setOriginalHealth(int originalHealth){
        this.originalHealth = originalHealth;
    }


    public Set<String> getMaterials() {
        return materials;
    }

    public void addMaterial(String material) {
        materials.add(material);
    }

    public boolean hasAllMaterials(Set<String> requiredMaterials) {
        return materials.containsAll(requiredMaterials);
    }

}
