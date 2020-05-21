package problem1To100;

public class a81search {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target || nums[right] == target || nums[mid] == target) return true;
            if (nums[mid] > nums[left]) {
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else if(nums[right]>nums[left]){
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }else{
                // 如果没办法判断哪半段是有序的，移动左坐标，故整个数列都是同一个数时算法退化为O(n)
                left++;
            }
        }
        return false;
    }
}
