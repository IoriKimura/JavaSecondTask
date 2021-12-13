package game;

import java.util.Random;

public class Characteristics {
    protected int HP;
    protected String Name;
    protected int Lvl;
    protected int Cost;
    protected int Exp;
    protected int DMG;
    protected int Armour;

    public Characteristics(String Name,int HP, int Lvl, int Exp, int DMG, int Armour) {
        this.Name = Name;
        this.HP = HP;
        this.Lvl = Lvl;
        this.DMG = DMG;
        this.Exp = Exp;
        this.Armour = Armour;
    }

    public Characteristics(String Name, int HP, int DMG, int Armour){
        this.Name = Name;
        this.HP = HP;
        this.DMG = DMG;
        this.Armour = Armour;
    }

    public Characteristics(String name, int cost, int dmg){
        this.DMG = dmg;
        this.Cost = cost;
        this.Name = name;
    }

    static public class GameLogic{
        String characterName; //Имя персонажа
        int attackPower; //Сила персонажа без оружия
        int characterArmour; //Броня персонажа
        int characterHP; //Здоровье персонажа
        int characterLVL; //Уровень персонажа
        int cfullDPS; //Полный урон
        int gunDMG; //Сила атаки оружия
        String enemyName; //Имя противника
        int enemyAttackPower; //Сила противника без оружия
        int enemyArmour; //Броня противника
        int enemyHP; //Здоровье противника
        int enFullDPS; //Полный урон противника
        int enGun; //Оружие противника

        public GameLogic(String characterName, int attackPower, int characterArmour, int characterHP, int characterLVL,
                         String enemyName, int enemyAttackPower, int enemyArmour, int enemyHP, int gunDMG, int enGun){
            this.characterName = characterName;
            this.attackPower = attackPower;
            this.gunDMG = gunDMG;
            this.characterArmour = characterArmour;
            this.characterHP = characterHP;
            this.characterLVL = characterLVL;
            this.enemyName = enemyName;
            this.enemyAttackPower = enemyAttackPower;
            this.enemyArmour = enemyArmour;
            this.enemyHP = enemyHP;
            this.enGun = enGun;
        }

        public void setFullDPC() {
            cfullDPS = gunDMG + attackPower;
            enFullDPS = enGun + enemyAttackPower;
        }

        public void initiative(){
            Random rnd = new Random();
            int cInitiative = rnd.nextInt(20);
            int enInitiative = rnd.nextInt(20);

            if(cInitiative > enInitiative){
                System.out.println("\u001b[38;5;28m" + " Ты первым атакуешь своего противника!");
                characterStart();
            }
            else if(cInitiative < enInitiative){
                System.out.println(enemyName + "\u001b[38;5;28m" + " не ждёт и атакует тебя!");
                enemyStart();
            }
            else{
                System.out.println("\u001b[38;5;28m" + "Мирно разошлись!");
                System.exit(0);
            }
        }

        public void characterStart(){
            while (enemyHP > 0 || characterHP > 0){
                System.out.println("\u001b[38;5;28m" + "Ты атакуешь!");
                if(enemyArmour >= cfullDPS){
                    enemyHP = enemyHP - cfullDPS/2;
                    if(enemyHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Ты одолел противника!");
                        break;
                    }
                    System.out.println("\u001b[38;5;28m" + "Броня спасает " + enemyName + ", но тебе удаётся ударить его.");
                }
                else{
                    enemyHP = enemyHP - cfullDPS;
                    if(enemyHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Ты одолел противника!");
                        break;
                    }
                    System.out.println("\u001b[38;5;28m" + "Ты пробиваешь его броню! Страдай, " + enemyName + "!");
                }
                System.out.println("\u001b[38;5;28m" + "Враг атакует!");
                if(characterArmour >= enFullDPS){
                    characterHP = characterHP - enFullDPS/2;
                    if(characterHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Тебя убили...");
                        System.exit(0);
                    }
                    System.out.println("\u001b[38;5;28m" + "Броня  отчасти спасает тебя!");

                }
                else{
                    characterHP = characterHP - enFullDPS;
                    if(characterHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Тебя убили...");
                        System.exit(0);;
                    }
                    System.out.println("\u001b[38;5;28m" + "По тебе попали! Берегись!");
                }
            }
        }

        public void enemyStart(){
            while (enemyHP > 0 || characterHP > 0){
                System.out.println("\u001b[38;5;28m" + "Враг атакует!");
                if(characterArmour >= enFullDPS){
                    characterHP = characterHP - enFullDPS/2;
                    if(characterHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Тебя убили...");
                        System.exit(0);;
                    }
                    System.out.println("\u001b[38;5;28m" + "Броня отчасти спасает тебя!");
                }
                else{
                    characterHP = characterHP - enFullDPS;
                    if(characterHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Тебя убили...");
                        System.exit(0);;
                    }
                    System.out.println("\u001b[38;5;28m" + "По тебе попали! Берегись!");
                }
                System.out.println("\u001b[38;5;28m" + "Ты атакуешь!");
                if(enemyArmour >= cfullDPS){
                    enemyHP = enemyHP - cfullDPS/2;
                    if(enemyHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Ты одолел противника!");
                        break;
                    }
                    System.out.println("\u001b[38;5;28m" + "Броня спасает " + enemyName + ", но тебе удаётся нанести ему урон.");
                }
                else{
                    enemyHP = enemyHP - cfullDPS;
                    if(enemyHP <= 0) {
                        System.out.println("\u001b[38;5;28m" + "Ты одолел противника!");
                        break;
                    }
                    System.out.println("\u001b[38;5;28m" + "Ты пробиваешь его броню! Страдай, " + enemyName + "!");
                }
            }
        }
    }
}

