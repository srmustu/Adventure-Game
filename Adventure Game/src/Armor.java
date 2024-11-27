public class Armor {
    private int id;
    private String name;
    private int protectionLevel;
    private int price;

    public Armor(int id, String name, int protectionLevel, int price ){
        this.id = id;
        this.name = name;
        this.protectionLevel = protectionLevel;
        this.price = price;
    }

        public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Leather armor",1, 15 );
        armorList[1] = new Armor(2, "Metal armor", 3, 25);
        armorList[2] = new Armor(3, "Carbon fiber armor", 5, 40);
            return armorList;
    }

    public static Armor getArmorObjById (int id){

        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public int getProtectionLevel(){return this.protectionLevel;}
    public void setProtectionLevel(int protectionLevel){this.protectionLevel = protectionLevel;}
    public int getPrice(){return this.price;}
    public void setPrice(int price){this.price = price;}
}
