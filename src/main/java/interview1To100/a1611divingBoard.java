package interview1To100;

public class a1611divingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0)  return new int[0];
        if(shorter == longer)  return new int[]{shorter*k};
        int[] res = new int[k+1];
        for(int i=k;i>=0;i--){
            res[k-i] = i*shorter+(k-i)*longer;
        }
        return res;
    }
}
