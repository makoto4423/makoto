package match.a1025;

// 不想写的时候，连简单难度都写不出来，然后直接跳过第二题，做第三题，然后卡住，然后啥都不干，真有你的啊
public class a5546slowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char ch = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            if (max < releaseTimes[i] - releaseTimes[i - 1]) {
                max = releaseTimes[i] - releaseTimes[i - 1];
                ch = keysPressed.charAt(i);
            } else if (max == releaseTimes[i] - releaseTimes[i - 1]) {
                ch = ch > keysPressed.charAt(i) ? ch : keysPressed.charAt(i);
            }
        }
        return ch;
    }
}
