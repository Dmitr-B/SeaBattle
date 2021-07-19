package game;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BattleMap battleMap = new BattleMap();
        Player player1 = new Player("Tom");
        System.out.println("Hello " + player1.getName());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates of first SingleDesk ship:");
        player1.addSingleDeckShip(scanner.nextLine());
        //player1.addSingleDeckShip(scanner.nextLine());
       // player1.addDoubleDeckShip(scanner.nextLine());
        //player1.addSingleDeckShip(2,2);
       // player1.addSingleDeckShip(3,3);
       // player1.addSingleDeckShip(1,1);
        //player1.addSingleDeckShip(4,4);

        System.out.println(player1.getOnceShip(0,0));
        System.out.println(player1.getOnceShip(1,0));
//        System.out.println(player1.getOnceShip(1,1));
//        System.out.println(player1.getOnceShip(2,2));
//        System.out.println(player1.getOnceShip(3,3));
//        System.out.println(player1.getOnceShip(4,4));
        //System.out.println(Arrays.toString(battleMap.getShipsOnMap()));
    }
}
