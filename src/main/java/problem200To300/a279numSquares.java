package problem200To300;

public class a279numSquares {
    public int numSquares(int n) {
        int[] ints = new int[n+1];
        for(int i=1; i<n+1; i++){
            ints[i] = i;
            for(int j=1; i-j*j>=0; j++){
                ints[i] = Math.min(ints[i],ints[i-j*j]+1);
            }
        }
        return ints[n];

    }
}
