public abstract class SafeLocations extends Location{
    private int id;

    public SafeLocations (int id ,Player player , String name){
        super(id , player , name);
    }

    /*
    Bu methodu true olarak override etmemin sebebi alt sınıflarda da default olarak true gelmesini istemem ötürüdür.
     */
    @Override
    public boolean onLocation(){
        return true;

    }
}
