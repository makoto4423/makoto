package problem1400To1500;

public class a1423maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        if(len-k<=0){
            int sum=0;
            for(int ca : cardPoints){
                sum+=ca;
            }
            return sum;
        }else{
            int min = 0;
            for(int i=0;i<len-k;i++){
                min+=cardPoints[i];
            }
            int sum=min;
            int all=min;
            for(int i=0,j=len-k;j<len;j++,i++){
                sum = sum-cardPoints[i]+cardPoints[j];
                min = Math.min(sum,min);
                all+=cardPoints[j];
            }
            return all-min;
        }
    }
}
