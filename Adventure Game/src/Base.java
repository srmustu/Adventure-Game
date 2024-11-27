public class Base extends SafeLocations{
    private String message1 = "Welcome to the safe house. ";
    private String message2 = "Your life is completely renewed. ";

    public Base (Player player){
        super(1 , player , "Safe house");
    }
    @Override
    public boolean onLocation(){
        System.out.println();
        System.out.println(message1 + "\n" + message2);
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
