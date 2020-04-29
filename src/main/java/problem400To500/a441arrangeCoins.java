package problem400To500;

// 等差数组求和公式
public class a441arrangeCoins {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2*(long)n+ 0.25)-0.5);
    }
}
