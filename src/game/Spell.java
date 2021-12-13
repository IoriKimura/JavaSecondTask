package game;

public class Spell <A extends ElementsPower>{

    public A firstElement;

    public Spell(A firstElement){
        this.firstElement = firstElement;
    }

    void spelling(){
        firstElement.useSlot();
        firstElement.getDMG();
    }
}
