package game;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //BattleMap battleMap = new BattleMap();
        //comment for commit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sea Battle game. Enter name of first player: ");
        Player player1 = new Player(scanner.nextLine());
        System.out.println("Hello " + player1.getName());
        System.out.println("Enter coordinates of first SingleDesk ship:");
        player1.addSingleDeckShip(scanner.nextLine(), scanner);
        System.out.println("1");
        //player1.addSingleDeckShip(scanner.nextLine(), scanner);
        player1.addDoubleDeckShip(scanner.nextLine(), scanner);
        System.out.println(player1.getOnceShip(0,2));
        player1.addThreeDeckShip(scanner.nextLine(), scanner);
        System.out.println("Shot");
        player1.shot(scanner.nextLine());
        System.out.println(player1.getOnceShip(2,0));
        System.out.println(player1.getOnceShip(2,1));
        System.out.println(player1.getOnceShip(2,2));
        player1.shot(scanner.nextLine());
        System.out.println(player1.getOnceShip(2,1));
        player1.shot(scanner.nextLine());
        System.out.println(player1.getOnceShip(2,2));
        //player1.addThreeDeckShip(scanner.nextLine(), scanner);
        //player1.addFourDeckShip(scanner.nextLine(), scanner);
        //player1.addFourDeckShip(scanner.nextLine(), scanner);
        //player1.addSingleDeckShip(2,2);
       // player1.addSingleDeckShip(3,3);
       // player1.addSingleDeckShip(1,1);
        //player1.addSingleDeckShip(4,4);

        //System.out.println(player1.getOnceShip(0,0));
        //System.out.println(player1.getOnceShip(1,0));
        //System.out.println(player1.getOnceShip(0,1));
        //System.out.println(player1.getOnceShip(1,1));
        System.out.println(player1.getOnceShip(0,0));
        System.out.println(player1.getOnceShip(1,0));
        System.out.println(player1.getOnceShip(0,1));
        System.out.println(player1.getOnceShip(1,1));
        System.out.println(player1.getOnceShip(2,0));
        System.out.println(player1.getOnceShip(2,1));

//        System.out.println(player1.getOnceShip(1,1));
//        System.out.println(player1.getOnceShip(2,2));
//        System.out.println(player1.getOnceShip(3,3));
//        System.out.println(player1.getOnceShip(4,4));
        //System.out.println(Arrays.toString(battleMap.getShipsOnMap()));
    }
}
