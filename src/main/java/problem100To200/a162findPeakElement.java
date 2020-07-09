package problem100To200;

// 为什么二分查找大的那一半一定会有峰值呢？（即nums[mid]<nums[mid+1]时，
// mid+1~N一定存在峰值） 我的理解是，首先已知 nums[mid+1]>nums[mid]，
// 那么mid+2只有两种可能，一个是大于mid+1，一个是小于mid+1，
// 小于mid+1的情况，那么mid+1就是峰值，大于mid+1的情况，继续向右推，
// 如果一直到数组的末尾都是大于的，那么可以肯定最后一个元素是峰值，
// 因为nums[nums.length]=负无穷
// 想什么呢，n/2不还是O(n)
@Deprecated
public class a162findPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
