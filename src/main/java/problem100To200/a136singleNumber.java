package problem100To200;

public class a136singleNumber {
    public int singleNumber(int[] nums) {
        int foo = nums[0];
        for(int i=1;i<nums.length; i++){
            foo ^= nums[i];
        }
        return foo;
    }
}
