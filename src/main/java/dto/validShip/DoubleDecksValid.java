package dto.validShip;

public class DoubleDecksValid implements ValidStrategy{

    @Override
    public boolean isValidShip(String input, int countDecks) {
        return false;
    }
}
