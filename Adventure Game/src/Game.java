import java.util.Scanner;

public class Game {
    private String message1 = "Welcome to adventure island. Generally, visitors do not come here very often. What is your name adventurer ? ";
    private String message2 = "Nice to meet you ";
    private String message3 = "We will spend a lot of time together on this island. If you can survive, I will grant you the right to know my name ahahahah. ";
    private String message4 = "Please select a hero. ";
    private String message5 = "Id : ";
    private String message6 = "Location : ";
    private String message7 = "Please enter the id number of the location you want to select : ";
    private String message8 = "You're entered the wrong value, please try again.";
    private String message9 = "Regions : ";
    private String message10 = "0 : Log out.";
    private String message11 = "Game over.";
    private String message12 = "Coward where are you running to ?";

    String playerName;
    private Scanner inp = new Scanner(System.in);

    public void start(){
        System.out.print(message1);
        playerName = inp.nextLine();
        Player player1 = new Player(playerName);
        System.out.println(message2 + player1.getPlayerName() + ". " + message3);

        System.out.println(message4);
        player1.selectHero();

        Location location = null;
        while (true){
            System.out.println();
            player1.printInventoryInfo();
            System.out.println();
            System.out.println(message9);
            SafeLocations[] safeLocations = new SafeLocations[] {new Base(player1) , new EquipmentStore( player1)};
            for (SafeLocations s : safeLocations){
                System.out.println(message5 + s.getId() + "\t" + message6 + s.getName());
            }
            BattleLoc[] battleLocs = new BattleLoc[] {new Cave(player1) , new Forest(player1) , new River(player1)};
            for (BattleLoc b : battleLocs){
                System.out.println((message5) + b.getId() + "\t" + message6 + b.getName());
            }


            System.out.println(message10);
            System.out.print(message7);
            int chooseLocation = Location.input.nextInt();

            while(chooseLocation < 0 || chooseLocation > safeLocations.length + battleLocs.length){
                System.out.println(message8);
                System.out.print(message7);
                chooseLocation = Location.input.nextInt();
            }
            switch (chooseLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new Base(player1);
                    break;
                case 2:
                    location = new EquipmentStore(player1);
                    break;
                case 3:
                    location = new Cave(player1);
                    break;
                case 4:
                    location = new Forest(player1);
                    break;
                case 5:
                    location = new River(player1);
                    break;
                default:
                    System.out.println(message8);
                    break;
            }

            if (location == null){
                System.out.println();
                System.out.println(message12 + "\n" + message11);
                break;
            }
            if (!location.onLocation()){
                System.out.println();
                System.out.println(message11);
                break;
            }
            /* bu kod nesne yönelimli programlamanın özelliklerinin faydalarını adeta açıkça vurgularcasına burada duruyor
            ve bizim kolaylıkla üst sınıftan alt sınıflara hükmemize imkan tanıyor
             */


        }
    };
}
 