package problem1To100;

// 吐血，end=mid不通过，非要end=mid-1
public class a33search {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        int start=0, end=nums.length-1,mid=(nums.length-1)/2;
        while(start<end){
            if(nums[start] == target)   return start;
            if(nums[end] == target) return end;
            if(nums[mid] == target) return mid;
            if(nums[mid]>nums[start]){
                if(target>nums[mid] || target<nums[start]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }else{
                if(target>nums[end] || target<nums[mid]){
                    end=mid-1;
                }else{
                    start = mid+1;
                }
            }
            mid = start+(end-start)/2;
        }
        if(nums[start] == target)   return start;
        return -1;
    }
}
