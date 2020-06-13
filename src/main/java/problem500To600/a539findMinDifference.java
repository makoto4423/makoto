package problem500To600;

import java.util.ArrayList;
import java.util.List;

public class a539findMinDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<timePoints.size();i++){
            int h = Integer.parseInt(timePoints.get(i).split(":")[0]);
            int m = Integer.parseInt(timePoints.get(i).split(":")[1]);
            list.add(h*60+m);
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                res = Math.min(res,cal(list.get(i),list.get(j)));
            }
        }
        return res;
    }

    public int cal(int time1,int time2){
        int d = Math.abs(time1-time2);
        return Math.min(1440-d,d);
    }
}
