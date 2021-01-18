package problem600To700;

public class a605canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 1) {
            return n != 1 || flowerbed[0] != 1;
        }
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == len - 1) {
                if (flowerbed[i - 1] == 0) {
                    n--;
                }
            } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
