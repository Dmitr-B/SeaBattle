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

    public void addSingleDeckShip(String coordinates, Scanner scanner) {
        String[] data = coordinates.split(",");

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

    }

    public void addDoubleDeckShip(String coordinates, Scanner scanner) {
        String[] data = getDataFromShip(coordinates);

        if (!isValidInput(coordinates)) {
            System.out.println("Invalid input data. Please enter coordinates again:");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidNumberOfDoubleCoordinates(coordinates) && isValidInput(coordinates)) {
            System.out.println("Invalid number of coordinates. You must enter: x,y;x1,y1");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidDoubleDeckShip(coordinates) && isValidNumberOfDoubleCoordinates(coordinates) && isValidInput(coordinates)) {
            System.out.println("Invalid DoubleDeckShip. Enter vertical or horizontal coordinates");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (!isEmptyDoublePlace(coordinates) && isValidDoubleDeckShip(coordinates) && isValidNumberOfDoubleCoordinates(coordinates) &&
                isValidInput(coordinates)) {
            System.out.println("The place is not empty. Enter new coordinates:");
            addDoubleDeckShip(scanner.nextLine(), scanner);
        }

        if (DoubleDeckShip.getCounter() < 3 && isValidInput(coordinates) && isValidNumberOfDoubleCoordinates(coordinates) &&
        isValidDoubleDeckShip(coordinates)) {
            battleMap.setDoubleShip(getIntVal(data[0]), getIntVal(data[1]),
                    getIntVal(data[2]), getIntVal(data[3]));
        }

        if (DoubleDeckShip.getCounter() > 3) {
            System.out.println("На поле максимальное количество двупалубных кораблей");
        }
    }

    public void addThreeDeckShip(String coordinates, Scanner scanner) {
        String[] data = getDataFromShip(coordinates);

        if (!isValidInput(coordinates)) {
            System.out.println("Invalid input data. Please enter coordinates again:");
            addThreeDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidNumberOfThreeCoordinates(coordinates) && isValidInput(coordinates)) {
            System.out.println("Invalid number of coordinates. You must enter: x,y;x1,y1;x2,y2");
            addThreeDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidThreeDeckShip(coordinates) && isValidNumberOfThreeCoordinates(coordinates) && isValidInput(coordinates)) {
            System.out.println("Invalid ThreeDeckShip. Enter vertical or horizontal coordinates");
            addThreeDeckShip(scanner.nextLine(), scanner);
        }

        if (!isEmptyThreePlace(coordinates) && isValidThreeDeckShip(coordinates) && isValidNumberOfThreeCoordinates(coordinates) &&
                isValidInput(coordinates)) {
            System.out.println("The place is not empty. Enter new coordinates:");
            addThreeDeckShip(scanner.nextLine(), scanner);
        }

        if (ThreeDeckShip.getCounter() < 2 && isValidInput(coordinates) && isValidNumberOfThreeCoordinates(coordinates) &&
        isValidThreeDeckShip(coordinates)) {
            battleMap.setThreeShip(getIntVal(data[0]), getIntVal(data[1]), getIntVal(data[2]), getIntVal(data[3]),
                    getIntVal(data[4]), getIntVal(data[5]));
        }

        if (ThreeDeckShip.getCounter() > 2) {
            System.out.println("На поле максимальное количество трехпалубных кораблей");
        }
    }

    public void addFourDeckShip(String coordinates, Scanner scanner) {
        String[] data = getDataFromShip(coordinates);

        if (!isValidInput(coordinates)) {
            System.out.println("Invalid input data. Please enter coordinates again:");
            addFourDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidNumberOfFourCoordinates(coordinates) && isValidInput(coordinates)) {
            System.out.println("Invalid number of coordinates. You must enter: x,y;x1,y1;x2,y2;x3,y3");
            addFourDeckShip(scanner.nextLine(), scanner);
        }

        if (!isValidFourDeckShip(coordinates) && isValidNumberOfFourCoordinates(coordinates) && isValidInput(coordinates)) {
            System.out.println("Invalid FourDeckShip. Enter vertical or horizontal coordinates");
            addFourDeckShip(scanner.nextLine(), scanner);
        }

        if (!isEmptyFourPlace(coordinates) && isValidFourDeckShip(coordinates) && isValidNumberOfFourCoordinates(coordinates) &&
                isValidInput(coordinates)) {
            System.out.println("The place is not empty. Enter new coordinates:");
            addFourDeckShip(scanner.nextLine(), scanner);
        }

        if (FourDeckShip.getCounter() < 1 && isValidInput(coordinates) && isValidNumberOfFourCoordinates(coordinates) &&
        isValidFourDeckShip(coordinates)) {
            battleMap.setFourShip(getIntVal(data[0]), getIntVal(data[1]), getIntVal(data[2]), getIntVal(data[3]),
                    getIntVal(data[4]), getIntVal(data[5]), getIntVal(data[6]), getIntVal(data[7]));
        }

        if (FourDeckShip.getCounter() > 1) {
            System.out.println("На поле максимальное количество четырехпалубных кораблей");
        }
    }

//    private boolean isValidInput(String input) {
//        String patternRegex = "^[0-9],+[0-9]";
//        Pattern pattern = Pattern.compile(patternRegex);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.find();
//    }
//
//    private boolean isValidDoubleInput(String input) {
//        String patternRegex = "^[0-9],[0-9];[0-9],+[0-9]";
//        Pattern pattern = Pattern.compile(patternRegex);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.find();
//    }
//
//    private boolean isValidThreeInput(String input) {
//        String patternRegex = "^[0-9],[0-9];[0-9],[0-9];[0-9],+[0-9]";
//        Pattern pattern = Pattern.compile(patternRegex);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.find();
//    }

    private boolean isValidInput(String input) {
        String patternRegex = "^[0-9],+[0-9]";
        String[] data = input.split(";");

        for (String datum : data) {
            Pattern pattern = Pattern.compile(patternRegex);
            Matcher matcher = pattern.matcher(datum);

            if (!matcher.find()) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidNumberOfCoordinates(String input) {
        String[] data = input.split(";");

        return data.length == 1;
    }

    private boolean isValidNumberOfDoubleCoordinates(String input) {
        String[] data = input.split(";");

        return data.length == 2;
    }

    private boolean isValidNumberOfThreeCoordinates(String input) {
        String[] data = input.split(";");

        return data.length == 3;
    }

    private boolean isValidNumberOfFourCoordinates(String input) {
        String[] data = input.split(";");

        return data.length == 4;
    }


    private boolean isValidDoubleDeckShip(String input) {
        String[] data = getDataFromShip(input);
        int firstX = Integer.parseInt(data[0]);
        int firstY = Integer.parseInt(data[1]);

        if ((getIntVal(data[2]) != getIntVal(data[0]))  &&
                (getIntVal(data[3]) != getIntVal(data[1])))
            return false;

        return Integer.parseInt(data[2]) == firstX + 1 || Integer.parseInt(data[3]) == firstY + 1 ||
                Integer.parseInt(data[2]) == firstX - 1 || Integer.parseInt(data[3]) == firstY - 1;
    }

    private boolean isValidThreeDeckShip(String input) {
        String[] data = getDataFromShip(input);
        int firstX = Integer.parseInt(data[0]);
        int firstY = Integer.parseInt(data[1]);

        if ((getIntVal(data[2]) != getIntVal(data[0]) || getIntVal(data[4]) != getIntVal(data[0]))  &&
                (getIntVal(data[3]) != getIntVal(data[1]) || getIntVal(data[5]) != getIntVal(data[1])))
            return false;

        return (getIntVal(data[2]) == firstX + 1 || getIntVal(data[3]) == firstY + 1 ||
                getIntVal(data[2]) == firstX - 1 || getIntVal(data[3]) == firstY - 1) &&
                (getIntVal(data[4]) == firstX + 2 || getIntVal(data[5]) == firstY + 2 ||
                        getIntVal(data[4]) == firstX - 2 || getIntVal(data[5]) == firstY - 2);
    }

    private boolean isValidFourDeckShip(String input) {
        String[] data = getDataFromShip(input);
        int firstX = Integer.parseInt(data[0]);
        int firstY = Integer.parseInt(data[1]);

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


    private boolean isEmptyPlace(String input) {
        String[] data = getDataFromShip(input);

        return battleMap.getOnceShip(getIntVal(data[0]), getIntVal(data[1])) == null;
    }

    private boolean isEmptyDoublePlace(String input) {
        String[] data = getDataFromShip(input);

        return battleMap.getOnceShip(getIntVal(data[0]), getIntVal(data[1])) == null && battleMap.getOnceShip(getIntVal(data[2]), getIntVal(data[3])) == null;
    }

    private boolean isEmptyThreePlace(String input) {
        String[] data = getDataFromShip(input);

        return battleMap.getOnceShip(getIntVal(data[0]), getIntVal(data[1])) == null && battleMap.getOnceShip(getIntVal(data[2]), getIntVal(data[3])) == null &&
                battleMap.getOnceShip(getIntVal(data[4]), getIntVal(data[5])) == null;
    }

    private boolean isEmptyFourPlace(String input) {
        String[] data = getDataFromShip(input);

        return battleMap.getOnceShip(getIntVal(data[0]), getIntVal(data[1])) == null && battleMap.getOnceShip(getIntVal(data[2]), getIntVal(data[3])) == null &&
                battleMap.getOnceShip(getIntVal(data[4]), getIntVal(data[5])) == null && battleMap.getOnceShip(getIntVal(data[6]), getIntVal(data[7])) == null;
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
