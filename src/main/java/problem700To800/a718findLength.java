package problem700To800;

// 滑动窗口来源答案，手写的暴力也能通过
public class a718findLength {
    public int findLength(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length, res = 0;
        for(int i=0;i<aLen;i++){
            int len = Math.min(aLen-i,bLen);
            int max = find(A,B,i,0,len);
            res = Math.max(res, max);
        }
        for(int i=0;i<bLen;i++){
            int len = Math.min(aLen,bLen-i);
            int max = find(A, B, 0, i, len);
            res = Math.max(res, max);
        }
        return res;
//        int aLen = A.length,bLen = B.length,res = 0;
//        for(int i=0;i<aLen;i++){
//            for(int j=0;j<bLen;j++){
//                int a = i,b = j,len = 0;
//                while(a<aLen && b < bLen && A[a] == B[b]){
//                    a++;
//                    b++;
//                    len++;
//                }
//                res = Math.max(res,len);
//            }
//        }
//        return res;
    }

    public int find(int[] A, int[] B, int a, int b, int len){
        int k=0,res=0;
        for(int i=0;i<len;i++){
            if(A[a+i]==B[b+i]){
                k++;
            }else {
                k = 0;
            }
            res = Math.max(res, k);
        }
        return res;
    }
}
