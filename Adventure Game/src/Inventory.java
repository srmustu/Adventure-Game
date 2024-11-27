public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory(){
        this.weapon = new Weapon(-1 , "Punch",1, 0);
        this.armor = new Armor(-1, "T-shirt", 0, 0);
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Armor getArmor(){
        return this.armor;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }
}
