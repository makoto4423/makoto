package problem100To200;

public class a167twoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 2) return new int[]{1,2};
        int i=0, j=numbers.length-1;
        while(j>i){
            if(numbers[i]+numbers[j]==target)   return new int[]{i+1,j+1};
            if(target > numbers[i]+numbers[j]){
                i++;j=numbers.length-1;
            }else{
                int mid = (i+j)/2;
                if(numbers[i]+numbers[mid]>target)
                    j = mid;
                else
                    j--;
            }
        }
        return new int[]{1,2};
    }
}
