package match.a0927;

public class a1598minOperations {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                depth = depth == 0 ? 0 : depth - 1;
            } else if (!log.equals("./")) {
                depth++;
            }
        }
        return depth;
    }
}
