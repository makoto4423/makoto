package problem900To1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 同余定理, 若 m % K == z && n % K == z, 则 (m-n)%K == 0
 * 所以遍历一遍累加，若有相同余数（C个），则根据同余定理得出，有C个结果满足对K求余为0
 */
@Deprecated
public class a974subarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
//        int len = A.length;
//        if(len == 0)    return 0;
//        int[] arr = new int[len];
//        int res = 0;
//        for(int i=0;i<len;i++){
//            arr[i] = A[i];
//            if(arr[i] % K == 0) res++;
//            for(int j=i+1;j<len;j++){
//                arr[j] = A[j]+arr[j-1];
//                if(arr[j] % K == 0){
//                    res++;
//                }
//            }
//        }
//        return res;
    }
}
