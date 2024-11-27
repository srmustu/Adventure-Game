public class EquipmentStore extends SafeLocations {
    private String message1 = "Welcome to the Equipment Store. ";
    private String message2 = "You can increase your chances of survival by shopping here. ";
    private String message3 = "Please enter the number of the transaction you want to perform.";
    private String message4 = "1 - Weaponary";
    private String message5 = "2 - Armors";
    private String message6 = "3 - Log out";
    private String message7 = "Your choice : ";
    private String message8 = "Left the store.";
    private String message9 = "You entered the wrong value, please try again.";
    private String message10 = "Please enter the Id of the weapon you want to choose : ";
    private String message11 = "You do not have enough money to buy this weapon.";
    private String message12 = "You have purchased ";
    private String message13 = " weapon and added it to your inventory.";
    private String message14 = "Your previous weapon : ";
    private String message15 = "Your new weapon : ";
    private String message16 = "Please enter the Id of the armor you want to choose : ";
    private String message17 = "You do not have enough money to buy this armor.";
    private String message18 = " and added it to your inventory.";
    private String message19 = "Your previous armor : ";
    private String message20 = "Your new armor : ";
    private String message21 = "0 - Log out.";


    public EquipmentStore(Player player) {
        super(2, player, "Equipment Store");
    }


    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println(message1 + "\n" + message2 + "\n" + message3);
        System.out.println();

        boolean showMenu = true;
        while (showMenu) {
            System.out.print(message4 + "\n" + message5 + "\n" + message6 + "\n" + message7);
            int transactionSelection = Location.input.nextInt();

            while (transactionSelection < 1 || transactionSelection > 3) {
                System.out.println(message9);
                System.out.print(message7);
                transactionSelection = Location.input.nextInt();
            }

            switch (transactionSelection) {
                case 1:
                    printWeaponary();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println(message8);
                    showMenu = false;
                    break;
            }
        }

        return true;
    }

    public void printWeaponary() {
        System.out.println();
        System.out.println("Weapons : ");

        for (Weapon w : Weapon.weapons()) {
            System.out.println("Id : " + w.getId() + "  " +
                    "Weapon name : " + w.getName() + "  " +
                    "Damage : " + w.getDamage() + "  " +
                    "Price : " + w.getPrice());
        }

        System.out.println(message21);
    }


    public void buyWeapon() {

        System.out.print(message10);
        int weaponChoose = input.nextInt();
        while (weaponChoose < 0 || weaponChoose > Weapon.weapons().length) {
            System.out.println(message9);
            System.out.print(message10);
            weaponChoose = input.nextInt();
        }

        System.out.println(" ");

        if (weaponChoose != 0) {

            Weapon weaponOfChoice = Weapon.getWeaponObjById(weaponChoose);

            if (weaponOfChoice != null) {
                if (weaponOfChoice.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println(message11);
                } else {

                    int balance = this.getPlayer().getMoney() - weaponOfChoice.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println(message12 + weaponOfChoice.getName() + message13);

                    System.out.println(" ");
                    System.out.println(message14 + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(weaponOfChoice);
                    System.out.println(message15 + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }


    }

    public void printArmors() {
        System.out.println();
        System.out.println("Armors : ");

        for (Armor a : Armor.armors()) {
            System.out.println("Id : " + a.getId() + "  " +
                    "Armor name : " + a.getName() + "  " +
                    "Protection level : " + a.getProtectionLevel() + "  " +
                    "Price : " + a.getPrice());
        }

        System.out.println(message21);
    }


    public void buyArmor() {

        System.out.print(message16);
        int armorChoose = input.nextInt();
        while (armorChoose < 0 || armorChoose > Armor.armors().length) {
            System.out.println(message9);
            System.out.print(message16);
            armorChoose = input.nextInt();
        }

        System.out.println(" ");


        if (armorChoose != 0) {
            Armor armorOfChoice = Armor.getArmorObjById(armorChoose);

            if (armorOfChoice != null) {
                if (armorOfChoice.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println(message17);
                } else {

                    int balance = this.getPlayer().getMoney() - armorOfChoice.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println(message12 + armorOfChoice.getName() + message18);

                    System.out.println(" ");
                    System.out.println(message19 + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(armorOfChoice);
                    System.out.println(message20 + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    /*
    Bu methodun abstract olarak tanımlanmamasının sebebi artık onu override ederek ona bir gövde ve ek özellik eklememizdir.
     */
    }
}
