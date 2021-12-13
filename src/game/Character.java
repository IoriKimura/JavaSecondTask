package game;

import java.util.ArrayList;
import java.util.Random;

public class Character extends Characteristics{

    public Character(String name, int hp, int exp, int lvl, int dmg, int arm) {
        super(name, hp, lvl, exp, dmg, arm);
    }

    public void showstats(){
        System.out.println("\u001b[38;5;28m" + "Имя героя: " + "\u001b[38;5;148m" +  Name + "\u001b[38;5;28m" + "\nУровень: " + "\u001b[38;5;148m"
                + Lvl + "\u001b[38;5;28m" + "\nЗдоровье: "  + "\u001b[38;5;148m" + HP + "\u001b[38;5;28m"+ "\nБроня: " + "\u001b[38;5;196m"+ Armour
                + "\u001b[38;5;28m"+" \nУрон: " + "\u001b[38;5;196m"+ DMG + "\u001b[38;5;28m"+ "\nКоличество опыта: " + "\u001b[38;5;148m"+ Exp);

        Random rnd = new Random();
        SpellInventory spl = new SpellInventory();

        Spell<?> spell = new Spell<>(new Water(rnd.nextInt(50)));
        spl.addSpell(spell);

        spell = new Spell<>(new Fire(rnd.nextInt(50)));
        spl.addSpell(spell);

        spell = new Spell<>(new Air(rnd.nextInt(50)));
        spl.addSpell(spell);

        ArrayList<Spell<?>> list = spl.getSpells();
        for (Spell<?> k: list) {
            k.spelling();
        }
    }
}
