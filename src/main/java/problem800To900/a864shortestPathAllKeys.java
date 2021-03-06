package problem800To900;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 从起点开始，找到一个最近的key，（如果有多个，随机一个？），然后放进key集合里，但有两个问题
 * <p>1.当距离相同时如何取舍，随机一个不会影响结果</p>
 * <p>2.会出现有个距离稍远的钥匙节点，取到以后就改变最短路径的情况吗</p>
 * 难点：如何计算距离
 *
 * 没看懂bfs怎么求出最短距离的,放弃。。。
 */
@Deprecated
public class a864shortestPathAllKeys {
    int INF = Integer.MAX_VALUE;
    String[] grid;
    int R, C;
    Map<Character, Point> location;
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int shortestPathAllKeys(String[] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length();

        //location['a'] = the coordinates of 'a' on the grid, etc.
        location = new HashMap<>();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                char v = grid[r].charAt(c);
                if (v != '.' && v != '#')
                    location.put(v, new Point(r, c));
            }

        int ans = INF;
        int num_keys = location.size() / 2;
        String[] alphabet = new String[num_keys];
        for (int i = 0; i < num_keys; ++i)
            alphabet[i] = Character.toString((char)('a' + i));
        //alphabet = ["a", "b", "c"], if there were 3 keys
        List<String> list = permutations(alphabet, 0, num_keys);
        search: for (String cand: permutations(alphabet, 0, num_keys)) {
            //bns : the built candidate answer, consisting of the sum
            //of distances of the segments from '@' to cand[0] to cand[1] etc.
            int bns = 0;
            for (int i = 0; i < num_keys; ++i) {
                char source = i > 0 ? cand.charAt(i-1) : '@';
                char target = cand.charAt(i);

                //keymask : an integer with the 0-th bit set if we picked up
                // key 'a', the 1-th bit set if we picked up key 'b', etc.
                int keymask = 0;
                for (int j = 0; j < i; ++j)
                    keymask |= 1 << (cand.charAt(j) - 'a');
                int d = bfs(source, target, keymask);
                if (d == INF) continue search;
                bns += d;
                if (bns >= ans) continue search;
            }
            ans = bns;
        }

        return ans < INF ? ans : -1;
    }

    public int bfs(char source, char target, int keymask) {
        int sr = location.get(source).x;
        int sc = location.get(source).y;
        int tr = location.get(target).x;
        int tc = location.get(target).y;
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        int curDepth = 0;
        Queue<Point> queue = new LinkedList<>();
        // offer是把元素插入到head上
        queue.offer(new Point(sr, sc));
        queue.offer(null);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p == null) {
                curDepth++;
                if (!queue.isEmpty())
                    queue.offer(null);
                continue;
            }
            int r = p.x, c = p.y;
            if (r == tr && c == tc) return curDepth;
            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i];
                int cc = c + dc[i];
                if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                    char cur = grid[cr].charAt(cc);
                    if (cur != '#') {
                        if (Character.isUpperCase(cur) && (((1 << (cur - 'A')) & keymask) <= 0))
                            continue; // at lock and don't have key

                        queue.offer(new Point(cr, cc));
                        seen[cr][cc] = true;
                    }
                }
            }
        }

        return INF;
    }

    // 算出取得钥匙的所有可能
    public List<String> permutations(String[] alphabet, int used, int size) {
        List<String> ans = new ArrayList<>();
        if (size == 0) {
            ans.add("");
            return ans;
        }

        for (int b = 0; b < alphabet.length; ++b)
            if (((used >> b) & 1) == 0)
                for (String rest: permutations(alphabet, used | (1 << b), size - 1))
                    ans.add(alphabet[b] + rest);
        return ans;
    }
}
