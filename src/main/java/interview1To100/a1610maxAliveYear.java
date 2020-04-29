package interview1To100;

public class a1610maxAliveYear {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] stat = new int[101];
        for(int i=0; i<birth.length; i++){
            for(int j=birth[i];j<=death[i];j++){
                stat[j-1900]++;
            }
        }
        int max = stat[0],pos=0;
        for(int i=0; i<101; i++){
            if(max < stat[i]){
                max = stat[i];
                pos = i;
            }
        }
        return pos+1900;
    }
}
