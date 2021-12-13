package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
    static ArrayList<Guns> Gun = new ArrayList<Guns>();

    public static void main(String[] args) {
        //Игровой процесс начинается с введение имени игроком
        Scanner scanner = new Scanner(System.in);
        System.out.println("Скажи своё имя");
        String name = scanner.nextLine();

        Random rnd = new Random();

        Character character = new Character(name, rnd.nextInt(100), rnd.nextInt(100), 1, rnd.nextInt(10), rnd.nextInt(50));
        gunCreation();
        enemyCreation();
        Enemy oneEnemy = Enemies.get(rnd.nextInt(Enemies.size())); //Из списка врагов берём случайного и делаем его первым противником
        Guns firstWeapon = Gun.get(rnd.nextInt(Gun.size())); //Из списка оружия берём случайное

        System.out.println("\t\t\t\t\t\u001b[38;5;50m" + "Твои статы:");
        character.showstats(); //Показываем статистику игрока

        System.out.println("\t\t\t\t\t\u001b[38;5;50m" + "Твоё оружие:");
        firstWeapon.showstats(); //Показываем статистику оружия игрока

        for (int i = 0; i <= Enemies.size(); i++){ //Пока враги есть - дерёмся
            System.out.println("\u001b[38;5;28m" + "Берегись," + character.Name +"! На тебя нападает " + oneEnemy.Name +"!");
            Guns enemyWeapon = Gun.get(rnd.nextInt(Gun.size())); //Случайное оружие противника
            System.out.println("\t\t\t\t\t\u001b[38;5;50m" + "Статы противника:");
            oneEnemy.showstats();
            System.out.println("\t\t\t\t\t\u001b[38;5;50m" + "Оружие противника:");
            enemyWeapon.showstats();
            if(i >= 1)
                oneEnemy = Enemies.get(rnd.nextInt(Gun.size()));
            Characteristics.GameLogic gameLogic = new Characteristics.GameLogic(character.Name, character.DMG, character.Armour, character.HP, character.Lvl,
                    oneEnemy.Name, oneEnemy.DMG, oneEnemy.Armour, oneEnemy.HP, firstWeapon.DMG, enemyWeapon.DMG);
            gameLogic.setFullDPC();
            gameLogic.initiative();
            System.out.println("\u001b[38;5;28m" + "___________________________________________________________________________________________________________");
        }
        for (Enemy object : Enemies){
            System.out.println(object);
        }
    }

    public static void gunCreation() {
        String[] gunNames = new String[]{"Вылизанный меч смертельного испуга", "Кистень наставления на путь истины", "Меч леденящего душу взгляда",
                "Кортик", "Усиленный пернач", "Церемониальная булава", "Дубина переговоров", "Лук Амоса", "Средний охотничий нож", "Алая сабля смерти"};
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            Guns _Guntemp = new Guns(gunNames[rnd.nextInt(gunNames.length)], rnd.nextInt(100), rnd.nextInt(100));
            Gun.add(_Guntemp);
        }
    }
    public static void enemyCreation(){
        String[] enemyNames = new String[]{"Розария", "Акакий", "Белфаст", "Эксия", "Рут", "Элизабет", "Айморлаг", "Андрей", "Суета", "Лёня"};
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            Enemy _Enmtemp = new Enemy(enemyNames[rnd.nextInt(enemyNames.length)], rnd.nextInt(100), rnd.nextInt(20), rnd.nextInt(50));
            Enemies.add(_Enmtemp);
        }
    }
}
