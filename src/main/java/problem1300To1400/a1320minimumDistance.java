package problem1300To1400;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class a1320minimumDistance {
    public int minimumDistance(String word) {
        List<String> pos = new ArrayList<>();
        for (Character ch : word.toCharArray()) {
            pos.add(location(ch));
        }
        int res = Integer.MAX_VALUE;
        for(int i=1;i<word.length();i++){
            String left = pos.get(0);
            String right = pos.get(i);
            int dis = 0;
            for(int j = 1;j<word.length();j++){
                if(i == j)  continue;
                int leftDis = cal(left, pos.get(j));
                int rightDis = cal(right, pos.get(j));
                if(leftDis > rightDis){
                    dis += rightDis;
                    right = pos.get(j);
                }else if(rightDis > leftDis){
                    dis += leftDis;
                    left = pos.get(j);
                }else{
                    int m = j+1;
                    for(;m<word.length();m++){
                        int le = cal(left, pos.get(m));
                        int ri = cal(right, pos.get(m));
                        if(le > ri){
                            dis += leftDis;
                            left = pos.get(j);
                            break;
                        }else if(ri > le){
                            dis += rightDis;
                            right = pos.get(j);
                            break;
                        }
                    }
                    if(m == word.length()){
                        dis += leftDis;
                        left = pos.get(j);
                    }
                }
            }
            res = Math.min(res, dis);
        }
        return res;
    }

    public String location(Character ch) {
        return (ch - 'A') / 6 + "," + (ch - 'A') % 6;
    }

    public int cal(String a, String b) {
        int xA = Integer.parseInt(a.split(",")[0]);
        int yA = Integer.parseInt(a.split(",")[1]);
        int xB = Integer.parseInt(b.split(",")[0]);
        int yB = Integer.parseInt(b.split(",")[1]);
        return Math.abs(xA - xB) + Math.abs(yA - yB);

    }
}
