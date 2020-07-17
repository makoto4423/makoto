package problem800To900;

public class a826maxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int pro = 0;
        for(int w : worker){
            int temp = 0;
            for(int i=0;i<difficulty.length;i++){
                if(difficulty[i] <= w){
                    temp = Math.max(temp, profit[i]);
                }
            }
            pro+=temp;
        }
        return pro;
    }
}
