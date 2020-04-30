package interview1To100;

public class a1704missingNumber {
    public int missingNumber(int[] nums) {
        int[] stat = new int[nums.length+1];
        for(int num : nums){
            stat[num] = 1;
        }
        for(int i=0; i<stat.length; i++){
            if(stat[i] == 0)    return i;
        }
        return -1;
    }
}
