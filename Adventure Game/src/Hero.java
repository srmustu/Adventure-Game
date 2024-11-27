public abstract class Hero {
    private int id;
    private String heroName;
    private int damage;
    private int health;
    private int money;


    public Hero(int id, String heroName, int damage, int health, int money){
        this.id = id;
        this.heroName = heroName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getHeroName(){
        return this.heroName;
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;
    }

    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money = money;
    }
}
