package problem1200To1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 用数组位移啊，傻不拉几手写。。。
public class a1222queensAttacktheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] grid = new int[8][8];
        for(int[] queen : queens){
            grid[queen[0]][queen[1]] = 1;
        }
        List<List<Integer>> list = new ArrayList<>();
        int m = king[0],n = king[1];
        for(;n>=0;n--){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;n<8;n++){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;m<8;m++){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;m>=0;m--){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;m>=0&&n>=0;m--,n--){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;m<8&&n>=0;m++,n--){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;m<8&&n<8;m++,n++){
            if(check(grid,m,n,list)) break;
        }
        m = king[0];n=king[1];
        for(;m>=0&&n<8;m--,n++){
            if(check(grid,m,n,list)) break;
        }
        return list;
    }

    public boolean check(int[][] grid,int m,int n,List<List<Integer>> list){
        if(grid[m][n] == 1){
            list.add(Arrays.asList(m,n));
            return true;
        }
        return false;
    }

}
