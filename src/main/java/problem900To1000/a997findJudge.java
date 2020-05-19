package problem900To1000;

public class a997findJudge {
    public int findJudge(int N, int[][] trust) {
        int[] stat = new int[N];
        for(int[] ints : trust){
            stat[ints[1]]++;
            stat[ints[0]]--;
        }
        for(int i=1;i<N+1;i++){
            if(stat[i] == N-1)    return i;
        }
        return -1;
    }
}
