import java.time.MonthDay;

public class Monster {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int originalHealth;
    private int money;

    public Monster(int id, String name, int damage, int health, int money){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.originalHealth = health;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public int getDamage(){return this.damage;}
    public void setDamage(int damage){this.damage = damage;}
    public int getHealth(){return this.health;}
    public void setHealth(int health){
        if (health < 0){
            health = 0;
        }
        this.health = health;}
    public int getMoney(){return this.money;}
    public void setMoney(int money){this.money = money;}

    public int getOriginalHealth(){
        return this.originalHealth;
    }

    public void setOrginalHealth(int orginalHealth){
        this.originalHealth = orginalHealth;
    }
}
