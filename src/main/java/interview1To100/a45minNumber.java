package interview1To100;

@Deprecated
public class a45minNumber {
    public String minNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(compare(nums[i],nums[j])){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: nums){
            sb.append(i);
        }
        return sb.toString();
    }

    public boolean compare(int i,int j){
        String si = i+"";
        String sj = j+"";
        String sho,lon;
        int m=0;
        for(;m<si.length() && m<sj.length();m++){
            if(si.charAt(m) != sj.charAt(m)){
                return si.charAt(m) > sj.charAt(m);
            }
        }
        if(m == si.length()){
            int pre = sj.charAt(m);
            for(int n = 0; n < sj.length(); n++){
                if(pre != sj.charAt(n)){
                    return sj.charAt(n) > pre;
                }
            }
        }else{
            int pre = si.charAt(m);
            for(int n = 0; n < si.length(); n++){
                if(pre != si.charAt(n)){
                    return pre > si.charAt(n);
                }
            }
        }
        return false;
    }

}
