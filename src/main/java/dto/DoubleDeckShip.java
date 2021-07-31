package dto;

public class DoubleDeckShip extends Ship{
    private static int counter = 0;
    private int counterSingleDeckShip = 0;

    public DoubleDeckShip() {

        if (counter < 3)
            counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getCounterSingleDeckShip() {
        return counterSingleDeckShip;
    }

    @Override
    public String toString() {
        return "DoubleDeckShip";
    }
}
