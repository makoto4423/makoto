package problem1To100;

@Deprecated
public class a4findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length+nums2.length;
        int midIndex = totalLength/2;
        if(totalLength%2==1){
            return help(nums1,nums2,midIndex+1);
        }else{
            return (help(nums1,nums2,midIndex)+help(nums1,nums2,midIndex+1))/2.0;
        }

    }

    public double help(int[] nums1,int[] nums2,int k){
        int index1 = 0,index2=0;
        while (true){
            if(index1 == nums1.length){
                return nums2[index2+k-1];
            }
            if(index2 == nums2.length){
                return nums1[index1+k-1];
            }
            if(k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int newIndex1 = Math.min(nums1.length,index1+k/2)-1;
            int newIndex2 = Math.min(nums2.length,index2+k/2)-1;
            if(nums1[newIndex1]>nums2[newIndex2]){
                k-=(newIndex2-index2+1);
                index2 = newIndex2+1;
            }else{
                k-=(newIndex1-index1+1);
                index1 = newIndex1+1;
            }
        }
    }

}
