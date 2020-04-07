package problem1To100;

public class a11maxArea {
    public int maxArea(int[] height) {
//        不动脑子的蛮力，下面用leetcode提供的思路实现O(n)
//        int max = 0;
//        for(int i=0; i<height.length;i++){
//            for(int j=i+1; j<height.length;j++){
//                max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
//            }
//        }
//        return max;
        int max = 0, l = 0, r = height.length-1;
        while(l<r){
            max = Math.max(max,(r-l)*Math.min(height[r],height[l]));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
