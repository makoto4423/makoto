package problem1200To1300;

import java.util.ArrayList;
import java.util.List;

// 把奇数坐标记录下来，然后用滑动窗口处理数组
public class a1248numberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            if(nums[i]%2==1){
                list.add(i);
            }
        }
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        int pre = -1,aft=-1,cnt=0;
        for(int i=0; i+k <=arr.length; i++){
            if(i+k>arr.length){
                return cnt;
            }
            if(i+k<arr.length){
                aft = arr[i+k];
            }else{
                aft = nums.length;
            }
            cnt += (arr[i]-pre)*(aft-arr[i+k-1]);
            pre = arr[i];
        }
        return cnt;
    }

}
