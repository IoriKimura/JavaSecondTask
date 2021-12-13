package game;

import java.util.Random;

public class Water implements ElementsPower{
    protected String elementName = "Водичка";
    protected int elementDMG;
    private boolean used = false;
    public Water(int elementDMG){
        this.elementDMG = elementDMG;
    }
    public void useSlot(){
         System.out.println("Слот занят элементом " + elementName);
         used = true;
    }

    public void getDMG(){
        System.out.println("Урон элементом " + elementName + ": " + elementDMG + ". \n" +
                "Накладывает статус Гидро на противника.");
    }

}
