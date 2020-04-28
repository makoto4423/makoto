package interview1To100;

// 想到用异或，但是两个数字实在想不出要怎么办，二分时间复杂度又是n*log N
@Deprecated
public class a56I_singleNumbers {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        int div = 1;
        while((div&res) == 0){
            div = div<<1;
        }
        int a = 0, b=0;
        for(int num : nums){
            if((num&div) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
