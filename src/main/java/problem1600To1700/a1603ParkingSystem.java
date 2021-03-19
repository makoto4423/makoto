package problem1600To1700;

import java.util.HashMap;
import java.util.Map;

public class a1603ParkingSystem {

    int big;
    int medium;
    int small;

    public a1603ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
            return false;
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
            return false;
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
            return false;
        }
        return false;
    }
}
