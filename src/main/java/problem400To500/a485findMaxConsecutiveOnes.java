package problem400To500;

public class a485findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,temp = 0;
        for(int i : nums){
            if(i == 0){
                max = Math.max(max,temp);
                temp = 0;
            }else{
                temp++;
            }
        }
        return Math.max(max,temp);
    }
}
