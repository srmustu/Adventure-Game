import java.util.Scanner;

public abstract class Location {

    private int id;
    private Player player;
    private String name;
    public Location (int id, Player player , String name){
        this.player = player;
        this.name = name;
        this.id = id;
    }

    public static Scanner input = new Scanner(System.in);

    public abstract boolean onLocation();
    /* ata sınıfın abstract methoduna gövde eklemememizin sebebi oop (nesne yönelimli porgramlamanın) 'nin asıl faydalarından olan
    kodların esnekliğini koruması ve kodların ileride bakımını kolaylaştıran bir mantığı koruması.

    bu abstract methoda eğer şimdi bir ek özellik eklersek alt sınıflarda bu özellik kullanılmayabilir ve istemeden onları kısıtlamış oluruz ve
    gelecekte ki hareket kabiliyetimizi baltalamış oluruz.

    bu durumu engellemek için bu methodun sadece tek bir görevi vardır oda bu class ı extend eden sınıfların bu method'un komutunu kesin olarak
    (kendilerine uyarlarak) kullanılmalarını zorunlu tutmaktadır . Böylece bu komutu her method kendince uyarlayarak kullanarak ileride yaşanabileck
    darboğazı engellemiş olur

    eğer bir özelliğin ata sınıfta tanımlanarak alt sınıflarda kullanılması amaçlanıyorsa bu concrete (somut & normal) kod olarak yazılarak alt sınıflarda
    da rahatlıkla kullanılabilir

     ayrıca bir sınıfta yeniden tanımlanmış body'siz bir abstract bir method varsa o class'ta muhakkak abstract tanımlanmaktadır

     */

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
}
