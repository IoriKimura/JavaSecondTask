package game;

public class Guns extends Characteristics{
    public Guns(String name, int dmg, int cost){
        super(name,cost,dmg);
    }

    public void showstats(){
        System.out.println("\u001b[38;5;30m" + "Имя орудия: " + "\u001b[38;5;148m" + Name + "\u001b[38;5;30m" +" || Урон: " + "\u001b[38;5;196m"+ DMG + "\u001b[38;5;30m" +" || Цена: " + "\u001b[38;5;148m" + Cost);
    }
}
