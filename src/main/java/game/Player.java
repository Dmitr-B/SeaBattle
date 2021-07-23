package game;

import dto.*;

import java.util.Arrays;
import java.util.Scanner;
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

    public void addSingleDeckShip(String coordinates, Scanner scanner) {
        String[] data = coordinates.split(",");
        System.out.println(isValidInput(coordinates));
        System.out.println(isValidNumberOfCoordinates(coordinates));
        //System.out.println(isValidDoubleDeckShip(coordinates));
        //System.out.println("Empty " + isEmptyPlace(coordinates));

        if (!isValidInput(coordinates)) {
            System.out.println("Invalid input data. Please enter coordinates again:");
            addSingleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidNumberOfCoordinates(coordinates)) {
            System.out.println("Invalid number of coordinates. You must enter: x,y");
            addSingleDeckShip(scanner.nextLine(), scanner);
        }

        if (isValidInput(coordinates) && isValidNumberOfCoordinates(coordinates) && !isEmptyPlace(coordinates)) {
            System.out.println("The place is not empty. Enter new coordinates:");
            addSingleDeckShip(scanner.nextLine(), scanner);
        }


        if (SingleDeckShip.getCounter() < 4 && isValidInput(coordinates) && isValidNumberOfCoordinates(coordinates) && isEmptyPlace(coordinates)) {
            battleMap.setOnceShip(getIntVal(data[0]), getIntVal(data[1]));
        }

        if (SingleDeckShip.getCounter() > 4)
            System.out.println("На поле максимальное количество однопалубных кораблей");

        //System.out.println("Valid " + isValidDoubleDeckShip(coordinates));
    }

    public void addDoubleDeckShip(String coordinates, Scanner scanner) {
        String[] data = getDataFromShip(coordinates);

        if (!isValidDoubleInput(coordinates)) {
            System.out.println("Invalid input data. Please enter coordinates again:");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidNumberOfDoubleCoordinates(coordinates) && isValidDoubleInput(coordinates)) {
            System.out.println("Invalid number of coordinates. You must enter: x,y;x1,y1");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidDoubleDeckShip(coordinates) && isValidNumberOfDoubleCoordinates(coordinates) && isValidDoubleInput(coordinates)) {
            System.out.println("Invalid DoubleDeckShip. Enter vertical or horizontal coordinates");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isEmptyDoublePlace(coordinates) && isValidDoubleDeckShip(coordinates) && isValidNumberOfDoubleCoordinates(coordinates) &&
                isValidDoubleInput(coordinates)) {
            System.out.println("The place is not empty. Enter new coordinates:");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (DoubleDeckShip.getCounter() < 3 && isValidDoubleInput(coordinates) && isValidNumberOfDoubleCoordinates(coordinates) &&
        isValidDoubleDeckShip(coordinates)) {
            battleMap.setDoubleShip(getIntVal(data[0]), getIntVal(data[1]),
                    getIntVal(data[2]), getIntVal(data[3]));
        }



        if (DoubleDeckShip.getCounter() > 3) {
            System.out.println("На поле максимальное количество двупалубных кораблей");
        }
        //System.out.println("Valid " + isValidDoubleDeckShip(coordinates));
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

    public boolean isValidDoubleInput(String input) {
        String patternRegex = "^[0-9],[0-9];[0-9],+[0-9]";
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public boolean isValidNumberOfCoordinates(String input) {
        String[] data = input.split(";");

        return data.length == 1;
    }

    public boolean isValidNumberOfDoubleCoordinates(String input) {
        String[] data = input.split(";");
        System.out.println(data.length);

        return data.length == 2;
    }


    public boolean isValidDoubleDeckShip(String input) {
        String[] data = getDataFromShip(input);
        int firstX = Integer.parseInt(data[0]);
        int firstY = Integer.parseInt(data[1]);

        System.out.println("suck" + Arrays.toString(data));
        System.out.println(getOnceShip(Integer.parseInt(data[0]), Integer.parseInt(data[1])));

        if ((getIntVal(data[2]) != getIntVal(data[0]))  &&
                (getIntVal(data[3]) != getIntVal(data[1])))
            return false;

        return Integer.parseInt(data[2]) == firstX + 1 || Integer.parseInt(data[3]) == firstY + 1 ||
                Integer.parseInt(data[2]) == firstX - 1 || Integer.parseInt(data[3]) == firstY - 1;
    }

    public boolean isValidThreeDeckShip(String input) {
        String[] data = getDataFromShip(input);
        int firstX = Integer.parseInt(data[0]);
        int firstY = Integer.parseInt(data[1]);

        System.out.println("suck" + Arrays.toString(data));
        System.out.println("x+2" + (Integer.parseInt(data[4]) == firstX - 2));
        System.out.println(getOnceShip(Integer.parseInt(data[0]), Integer.parseInt(data[1])));

        if ((getIntVal(data[2]) != getIntVal(data[0]) || getIntVal(data[4]) != getIntVal(data[0]))  &&
                (getIntVal(data[3]) != getIntVal(data[1]) || getIntVal(data[5]) != getIntVal(data[1])))
            return false;

        return (Integer.parseInt(data[2]) == firstX + 1 || Integer.parseInt(data[3]) == firstY + 1 ||
                Integer.parseInt(data[2]) == firstX - 1 || Integer.parseInt(data[3]) == firstY - 1) &&
                (Integer.parseInt(data[4]) == firstX + 2 || Integer.parseInt(data[5]) == firstY + 2 ||
                Integer.parseInt(data[4]) == firstX - 2 || Integer.parseInt(data[5]) == firstY - 2);
    }

    public boolean isValidFourDeckShip(String input) {
        String[] data = getDataFromShip(input);
        int firstX = Integer.parseInt(data[0]);
        int firstY = Integer.parseInt(data[1]);

        System.out.println("suck" + Arrays.toString(data));
        System.out.println(getOnceShip(Integer.parseInt(data[0]), Integer.parseInt(data[1])));

//        if (getIntVal(data[2]) == getIntVal(data[3]) || getIntVal(data[4]) == getIntVal(data[5]) ||
//                getIntVal(data[6]) == getIntVal(data[7]))
//            return false;
        if ((getIntVal(data[2]) != getIntVal(data[0]) || getIntVal(data[4]) != getIntVal(data[0]) || getIntVal(data[6]) != getIntVal(data[0])) &&
                (getIntVal(data[3]) != getIntVal(data[1]) || getIntVal(data[5]) != getIntVal(data[1]) || getIntVal(data[7]) != getIntVal(data[1])))
            return false;

        return (getIntVal(data[2]) == firstX + 1 || getIntVal(data[3]) == firstY + 1 ||
                getIntVal(data[2]) == firstX - 1 || getIntVal(data[3]) == firstY - 1) &&
                (getIntVal(data[4]) == firstX + 2 || getIntVal(data[5]) == firstY + 2 ||
                        getIntVal(data[4]) == firstX - 2 || getIntVal(data[5]) == firstY - 2) &&
                (getIntVal(data[6]) == firstX + 3 || getIntVal(data[7]) == firstY + 3 ||
                        getIntVal(data[6]) == firstX - 3 || getIntVal(data[7]) == firstY - 3);
    }


    public boolean isEmptyPlace(String input) {
        String[] data = getDataFromShip(input);

        return battleMap.getOnceShip(getIntVal(data[0]), getIntVal(data[1])) == null;
    }

    public boolean isEmptyDoublePlace(String input) {
        String[] data = getDataFromShip(input);

        return battleMap.getOnceShip(getIntVal(data[0]), getIntVal(data[1])) == null && battleMap.getOnceShip(getIntVal(data[2]), getIntVal(data[3])) == null;
    }


    public void addThreeDeckShip(String coordinates) {
        String[] data = getDataFromShip(coordinates);

        if (ThreeDeckShip.getCounter() < 2) {
            battleMap.setThreeShip(getIntVal(data[0]), getIntVal(data[1]), getIntVal(data[2]), getIntVal(data[3]),
                    getIntVal(data[4]), getIntVal(data[5]));
        } else {
            System.out.println("На поле максимальное количество трехпалубных кораблей");
        }
        System.out.println("ValidThree " + isValidThreeDeckShip(coordinates));
    }

    public void addFourDeckShip(String coordinates) {
        String[] data = getDataFromShip(coordinates);

        if (FourDeckShip.getCounter() < 1) {
            battleMap.setFourShip(getIntVal(data[0]), getIntVal(data[1]), getIntVal(data[2]), getIntVal(data[3]),
                    getIntVal(data[4]), getIntVal(data[5]), getIntVal(data[6]), getIntVal(data[7]));
        } else {
            System.out.println("На поле максимальное количество четырехпалубных кораблей");
        }
        System.out.println("ValidFour " + isValidFourDeckShip(coordinates));
    }

    private String[] getDataFromShip(String input) {
        return input.split("[,;]");
    }

    private int getIntVal(String element) {
        return Integer.parseInt(element);
    }

    public Ship getOnceShip(int x, int y) {
        return battleMap.getOnceShip(x,y);
    }

    public String getName() {
        return this.name;
    }
}
