package game;

public class Enemy extends Characteristics{
    public Enemy(String name, int hp, int dmg, int armour){
        super(name,hp,dmg,armour);
    }

    public void showstats(){
        System.out.println("\u001b[38;5;28m" + "Имя противника: " + "\u001b[38;5;32m" + Name + "\u001b[38;5;28m" +
                "\u001b[38;5;28m" +  "\u001b[38;5;28m" + " Здоровье: "+ "\u001b[38;5;32m" +  HP +"\u001b[38;5;28m" + " Урон с руки: " +
                "\u001b[38;5;32m" + DMG + "\u001b[38;5;28m" +" Броня: " + "\u001b[38;5;32m" + Armour);
    }
}
