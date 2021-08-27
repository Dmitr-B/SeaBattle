package game;

import dto.*;

public class BattleMap {
    private Ship[][] shipsOnMap;
    private Area area;

    public BattleMap() {
        shipsOnMap = new Ship[10][10];
    }



    public void setOnceShip(int x, int y) {
        shipsOnMap[x][y] = new SingleDeckShip();
        setArea(x, y);
    }

    public void setDoubleShip(int x, int y, int x1, int y1) {
        shipsOnMap[x][y] = new DoubleDeckShip();
        setArea(x,y);
        shipsOnMap[x1][y1] = shipsOnMap[x][y];
        setArea(x1,y1);
        //setOnceShip(x,y);
        //setOnceShip(x1,y1);
    }

    public void setThreeShip(int x, int y, int x1, int y1, int x2, int y2) {
        shipsOnMap[x][y] = new ThreeDeckShip();
        setArea(x,y);
        shipsOnMap[x1][y1] = shipsOnMap[x][y];
        setArea(x1,y1);
        shipsOnMap[x2][y2] = shipsOnMap[x1][y1];
        setArea(x2,y2);
        //setOnceShip(x, y);
        //setOnceShip(x1, y1);
        //setOnceShip(x2, y2);
    }

    public void setFourShip(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3) {
        new FourDeckShip();
        setOnceShip(x, y);
        setOnceShip(x1, y1);
        setOnceShip(x2, y2);
        setOnceShip(x3, y3);
    }

    public void setOneShot(int x, int y) {
        shipsOnMap[x][y] = new ShotOnShip();
    }

    private void setArea(int x, int y) {
//        if ((x - 1 > 0 || y - 1 > 0) && (x + 1 < shipsOnMap.length || y + 1 < shipsOnMap.length)) {
//            if (getOnceShip(x + 1, y) == null)
//                //area = new Area();
//                shipsOnMap[x+1][y] = new Area();
//        }
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0: if (x + 1 < shipsOnMap.length)
                    if (getOnceShip(x + 1, y) == null)
                    shipsOnMap[x+1][y] = createArea();
                break;
                case 1: if (x + 1 < shipsOnMap.length && y + 1 < shipsOnMap.length)
                    if (getOnceShip(x + 1, y + 1) == null)
                    shipsOnMap[x+1][y+1] = createArea();
                break;
                case 2: if (y + 1 < shipsOnMap.length)
                    if (getOnceShip(x, y + 1) == null)
                        shipsOnMap[x][y+1] = createArea();
                break;
                case 3: if (x - 1 >= 0)
                    if (getOnceShip(x - 1, y) == null)
                        shipsOnMap[x-1][y] = createArea();
                break;
                case 4: if (x - 1 >= 0 && y + 1 < shipsOnMap.length)
                    if (getOnceShip(x - 1, y + 1) == null)
                        shipsOnMap[x-1][y+1] = createArea();
                    break;
                case 5: if (x - 1 >= 0 && y - 1 >= 0)
                    if (getOnceShip(x - 1, y - 1) == null)
                        shipsOnMap[x-1][y-1] = createArea();
                    break;
                case 6: if (y - 1 >= 0)
                    if (getOnceShip(x, y -1 ) == null)
                        shipsOnMap[x][y-1] = createArea();
                    break;
                case 7: if (x + 1 < shipsOnMap.length && y - 1 >= 0)
                    if (getOnceShip(x + 1, y - 1) == null)
                        shipsOnMap[x+1][y-1] = createArea();
                    break;
            }

        }
    }

    public Ship getOnceShip(int x, int y) {
        return shipsOnMap[x][y];
    }

    private Area createArea() {
        return new Area();
    }
}
