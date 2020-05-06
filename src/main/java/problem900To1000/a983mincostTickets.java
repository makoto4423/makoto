package problem900To1000;

@Deprecated
public class a983mincostTickets {
    int[] days,costs;
    Integer[] meno;
    int[] duration = {1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.meno = new Integer[days.length];
        return dp(0);
    }

    public int dp(int i){
        if(i>days.length){
            return 0;
        }
        if(meno[i] != null){
            return meno[i];
        }
        meno[i] = Integer.MAX_VALUE;
        for(int m=0; m<3; m++){
            int j=i;
            while(j<days.length && days[j] < days[i]+duration[m]){
                j++;
            }
            meno[i] = Math.min(meno[i],dp(j)+costs[m]);
        }
        return meno[i];
    }
}
