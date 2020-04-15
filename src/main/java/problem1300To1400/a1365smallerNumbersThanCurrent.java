package problem1300To1400;

public class a1365smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int cnt=0;
            for (int num : nums) {
                if (nums[i] > num) cnt++;
            }
            res[i] = cnt;
        }
        return res;
    }
}
