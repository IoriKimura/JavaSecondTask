package game;

import java.util.Random;

public class Air implements ElementsPower{
    protected String elementName = "Воздух";
    protected int elementDMG;
    private boolean used = false;
    public Air(int elementDMG){
        this.elementDMG = elementDMG;
    }
    public void useSlot(){
        System.out.println("Слот занят элементом " + elementName);
        used = true;
    }

    public void getDMG(){
        Random rnd = new Random();
        elementDMG = rnd.nextInt(50);
        System.out.println("Урон элементом " + elementName + ": " + elementDMG + ". \n" +
                "Ветер-ветер ты могуч!.");
    }
}
