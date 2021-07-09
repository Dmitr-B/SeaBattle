package game;

import dto.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    private static int counterPlayer;
    private final String name;
    private final BattleMap battleMap;

    public Player(String name) {
        this.name = name;
        this.battleMap = new BattleMap();

        if (counterPlayer < 2)
            counterPlayer++;
    }

//    public void addSingleDeckShip(int x, int y) {
//
//        if (SingleDeckShip.getCounter() < 4) {
//            battleMap.setOnceShip(x, y);
//        } else {
//            System.out.println("На поле максимальное количество однопалубных кораблей");
//        }
//    }

    public void addSingleDeckShip(String coordinates) {
        String[] data = coordinates.split(",");
        System.out.println(isValidInput(coordinates));
        System.out.println(isValidNumberOfCoordinates(coordinates));
        System.out.println(isValidShip(coordinates));
        System.out.println("Empty " + isEmptyPlace(coordinates));

        if (SingleDeckShip.getCounter() < 4) {
            battleMap.setOnceShip(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        } else {
            System.out.println("На поле максимальное количество однопалубных кораблей");
        }
    }

//    public void addDoubleDeckShip(int x, int y, int x1, int y1) {
//
//        if (DoubleDeckShip.getCounter() < 3) {
//            battleMap.setDoubleShip(x, y, x1, y1);
//        } else {
//            System.out.println("На поле максимальное количество двупалубных кораблей");
//        }
//    }

    public boolean isValidInput(String input) {
        String patternRegex = "^[0-9],+[0-9]";
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public boolean isValidNumberOfCoordinates(String input) {
        String[] data = input.split(";");

        return data.length == 1;
    }

    public boolean isValidShip(String input) {
        String[] data = input.split("[,;]");

        //if (Integer.parseInt(data[0]) == 0 && Integer.parseInt(data[1]) == 0)
        //    return Integer.parseInt(data[2]) == 1 && Integer.parseInt(data[3]) == 0 || Integer.parseInt(data[2]) == 0 && Integer.parseInt(data[3]) == 1;

        //if (Integer.parseInt(data[0]) == 0 && Integer.parseInt(data[1]) == 9)
        //    return Integer.parseInt(data[2]) == 0 && Integer.parseInt(data[3]) == 8 || Integer.parseInt(data[2]) == 1 && Integer.parseInt(data[3]) == 9;

        //if (Integer.parseInt(data[0]) == 9 && Integer.parseInt(data[1]) == 0)
        //    return Integer.parseInt(data[2]) == 8 && Integer.parseInt(data[3]) == 0 || Integer.parseInt(data[2]) == 9 && Integer.parseInt(data[3]) == 1;

        //if (Integer.parseInt(data[9]) == 9 && Integer.parseInt(data[1]) == 9)
        //    return Integer.parseInt(data[2]) == 8 && Integer.parseInt(data[3]) == 9 || Integer.parseInt(data[2]) == 9 && Integer.parseInt(data[3]) == 8;


        return false;
    }

    public boolean isEmptyPlace(String input) {
        String[] data = input.split("[,;]");

        return battleMap.getOnceShip(Integer.parseInt(data[0]), Integer.parseInt(data[1])) == null;
    }

    public void addDoubleDeckShip(String coordinates) {
        String[] data = coordinates.split("[,;]");

        if (DoubleDeckShip.getCounter() < 3) {
            battleMap.setDoubleShip(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        } else {
            System.out.println("На поле максимальное количество двупалубных кораблей");
        }
    }

    public void addThreeDeckShip(int x, int y, int x1, int y1, int x2, int y2) {

        if (ThreeDeckShip.getCounter() < 2) {
            battleMap.setThreeShip(x, y, x1, y1, x2, y2);
        } else {
            System.out.println("На поле максимальное количество трехпалубных кораблей");
        }
    }

    public void addFourDeckShip(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3) {

        if (FourDeckShip.getCounter() < 1) {
            battleMap.setFourShip(x, y, x1, y1, x2, y2, x3, y3);
        } else {
            System.out.println("На поле максимальное количество четырехпалубных кораблей");
        }
    }

    public Ship getOnceShip(int x, int y) {
        return battleMap.getOnceShip(x,y);
    }

    public String getName() {
        return this.name;
    }
}
