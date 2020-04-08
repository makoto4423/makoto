package interview1To100;


public class a13movingCount {

    public int movingCount(int m, int n, int k) {
        int cnt = 0;
        boolean[][] matrix = new boolean[m][n];
        matrix[0][0] = true;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    cnt++;
                    continue;
                }
                if(k>=help(i)+help(j) && check(i,j,matrix)){
                    matrix[i][j] = true;
                    cnt++;
                    System.out.println("i:"+i+";j:"+j);
                }
            }
        }
        return cnt;
    }

    public int help(int num){
        int i = 0;
        while(num > 0){
            i += num%10;
            num /= 10;
        }
        return i;
    }

    public boolean check(int i,int j, boolean[][] matrix){
        boolean tag = false;
        if(i>0){
            tag = matrix[i - 1][j];
        }
        if(j>0){
            tag = tag || matrix[i][j-1];
        }
        return tag;
    }

}
