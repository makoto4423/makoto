package interview1To100;

import java.util.*;

public class a1619pondSizes {
    int[] xGrid = {0, 1, 0, -1, -1, 1, 1, -1};
    int[] yGrid = {1, 0, -1, 0, -1, -1, 1, 1};

    public int[] pondSizes(int[][] land) {
        int xLen = land.length;
        int yLen = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[xLen][yLen];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (land[i][j] == 0 && !visited[i][j]){
                    int size = 0;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        int[] p = queue.poll();
                        int x = p[0],y=p[1];
                        size++;
                        for(int k=0;k<8;k++){
                            int m = x+xGrid[k],n=y+yGrid[k];
                            if(m>=0 && m < xLen && n>=0 && n<yLen && land[m][n] == 0 && !visited[m][n]){
                                visited[m][n] = true;
                                queue.add(new int[]{m,n});
                            }
                        }
                    }
                    list.add(size);
                }
            }
        }
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
