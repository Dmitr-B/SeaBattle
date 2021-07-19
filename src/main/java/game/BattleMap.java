package game;

import dto.Area;
import dto.Ship;
import dto.SingleDeckShip;

public class BattleMap {
    private Ship[][] shipsOnMap;
    private Area area;

    public BattleMap() {
        shipsOnMap = new Ship[10][10];
    }

//    public void addSingleDeckShip(int x, int y) {
//
//        if (SingleDeckShip.getCounter() < 4) {
//            shipsOnMap[x][y] = new SingleDeckShip();
//        } else {
//            System.out.println("На поле максимальное количество однопалубных кораблей");
//        }
//    }

//    public Ship[][] getShipsOnMap() {
//        return shipsOnMap;
//    }

    public void setOnceShip(int x, int y) {
        shipsOnMap[x][y] = new SingleDeckShip();
        setArea(x, y);
    }

    public void setDoubleShip(int x, int y, int x1, int y1) {
        setOnceShip(x,y);
        setOnceShip(x1,y1);
    }

    public void setThreeShip(int x, int y, int x1, int y1, int x2, int y2) {
        setOnceShip(x, y);
        setOnceShip(x1, y1);
        setOnceShip(x2, y2);
    }

    public void setFourShip(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3) {
        setOnceShip(x, y);
        setOnceShip(x1, y1);
        setOnceShip(x2, y2);
        setOnceShip(x3, y3);
    }

    private void setArea(int x, int y) {
        if (getOnceShip(x + 1, y) == null)
            area = new Area();
            shipsOnMap[x+1][y] = new Area();
    }

    public Ship getOnceShip(int x, int y) {
        return shipsOnMap[x][y];
    }
}
