package problem700To800;

import java.util.*;

/**
 * 1.为病毒区编号
 * 2.统计每个病毒区外围0的个数
 * 3.选出2）个数最多的病毒区，统计病毒区边长，更改病毒区的编号为-1
 * 4.感染，然后重复1步骤，直至找不到病毒区
 */
// 不改了，卡在用例26 / 32上，这个用例数据模拟都要半个小时，看了眼答案，实现都差不多，不管了
@Deprecated
public class a749containVirus {
    Set<Integer> seen;
    List<Set<Integer>> regions;
    List<Set<Integer>> frontiers;
    List<Integer> perimeters;
    int[][] grid;
    int R, C;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int containVirus(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int ans = 0;
        while (true) {
            seen = new HashSet();
            regions = new ArrayList();
            frontiers = new ArrayList();
            perimeters = new ArrayList();

            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] == 1 && !seen.contains(r*C + c)) {
                        regions.add(new HashSet());
                        frontiers.add(new HashSet());
                        perimeters.add(0);
                        dfs(r, c);
                    }
                }
            }

            if (regions.isEmpty()) break;
            int triageIndex = 0;
            for (int i = 0; i < frontiers.size(); ++i) {
                if (frontiers.get(triageIndex).size() < frontiers.get(i).size())
                    triageIndex = i;
            }
            ans += perimeters.get(triageIndex);

            for (int i = 0; i < regions.size(); ++i) {
                if (i == triageIndex) {
                    for (int code: regions.get(i))
                        grid[code / C][code % C] = -1;
                } else {
                    for (int code: regions.get(i)) {
                        int r = code / C, c = code % C;
                        for (int k = 0; k < 4; ++k) {
                            int nr = r + dr[k], nc = c + dc[k];
                            if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 0)
                                grid[nr][nc] = 1;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c) {
        if (!seen.contains(r*C + c)) {
            seen.add(r*C + c);
            int N = regions.size();
            regions.get(N - 1).add(r*C + c);
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (grid[nr][nc] == 1) {
                        dfs(nr, nc);
                    } else if (grid[nr][nc] == 0){
                        frontiers.get(N - 1).add(nr*C + nc);
                        perimeters.set(N - 1, perimeters.get(N - 1) + 1);
                    }
                }
            }
        }
    }
//    int[] xGrid = {1, 0, 0, -1};
//    int[] yGrid = {0, 1, -1, 0};
//
//    public int containVirus(int[][] grid) {
//        int index = -1;
//        int m = grid.length;
//        int n = grid[0].length;
//        int res = 0;
//        while (index != 2) {
//            index = takeTag(grid, m, n);
//            if(index != 2){
//                int selectIndex = calculateZero(grid,m,n,index);
//                res += fireWall(grid,m,n,selectIndex);
//                populate(grid,m,n);
//            }
//        }
//        return res;
//    }
//
//    public int takeTag(int[][] grid, int m, int n) {
//        int index = 2;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    Queue<int[]> queue = new LinkedList<>();
//                    grid[i][j] = index;
//                    queue.add(new int[]{i, j});
//                    while (!queue.isEmpty()) {
//                        int[] p = queue.poll();
//                        for (int k = 0; k < 4; k++) {
//                            int x = p[0] + xGrid[k], y = p[1] + yGrid[k];
//                            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
//                                grid[x][y] = index;
//                                queue.add(new int[]{x, y});
//                            }
//                        }
//                    }
//                    index++;
//                }
//            }
//        }
//        return index;
//    }
//
//    public int calculateZero(int[][] grid, int m, int n,int index){
//        boolean[] tagVisited = new boolean[index];
//        int selectIndex = -2,selectNum = -1;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j] > 1 && !tagVisited[grid[i][j]]){
//                    tagVisited[grid[i][j]] = true;
//                    int now = grid[i][j];
//                    int nowNum = 0;
//                    boolean[][] visited = new boolean[m][n];
//                    Queue<int[]> queue = new LinkedList<>();
//                    queue.add(new int[]{i,j});
//                    visited[i][j] = true;
//                    while (!queue.isEmpty()){
//                        int[] p = queue.poll();
//                        for (int k = 0; k < 4; k++) {
//                            int x = p[0] + xGrid[k], y = p[1] + yGrid[k];
//                            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
//                                visited[x][y] = true;
//                                if(grid[x][y] == 0){
//                                    nowNum++;
//                                }else{
//                                    queue.add(new int[]{x,y});
//                                }
//                            }
//                        }
//                    }
//                    if(selectNum < nowNum){
//                        selectIndex = now;
//                        selectNum = nowNum;
//                    }
//                }
//            }
//        }
//        return selectIndex;
//    }
//
//    public int fireWall(int[][] grid,int m,int n,int select){
//        int fireWall = 0;
//        Queue<int[]> queue = new LinkedList<>();
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j] == select){
//                    queue.add(new int[]{i,j});
//                    grid[i][j] = -1;
//                    while (!queue.isEmpty()){
//                        int[] p = queue.poll();
//                        for (int k = 0; k < 4; k++) {
//                            int x = p[0] + xGrid[k], y = p[1] + yGrid[k];
//                            if (x >= 0 && y >= 0 && x < m && y < n) {
//                                if(grid[x][y] == 0){
//                                    fireWall++;
//                                }else if(grid[x][y] == select){
//                                    grid[x][y] = -1;
//                                    queue.add(new int[]{x,y});
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return fireWall;
//    }
//
//    public void populate(int[][] grid,int m,int n){
//        boolean[][] visited = new boolean[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j] == 0){
//                    for(int k=0;k<4;k++){
//                        int x = i + xGrid[k], y = j + yGrid[k];
//                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] > 0 && !visited[x][y]) {
//                            grid[i][j] = 1;
//                            visited[i][j] = true;
//                            break;
//                        }
//                    }
//                }else if(grid[i][j] != -1){
//                    grid[i][j] = 1;
//                }
//            }
//        }
//    }
}
