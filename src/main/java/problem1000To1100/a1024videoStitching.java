package problem1000To1100;

public class a1024videoStitching {
    public int videoStitching(int[][] clips, int T) {
        int left = T;
        for(int[] clip : clips){
            if(clip[1] >= T){
                left = Math.min(clip[0],left);
            }
        }
        if(left == T){
            return -1;
        }
        if(left == 0){
            return 1;
        }
        int cnt=1,old=left;boolean n = true;
        while(n){
            for(int[] clip : clips){
                if(clip[1] >= old){
                    left = Math.min(clip[0],left);
                }
            }
            if(left <= 0) return ++cnt;
            if(old == left){
                n = false;cnt=-1;
            }else{
                old=left;cnt++;
            }
        }
        return cnt;
    }
}
