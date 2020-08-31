package problem800To900;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a841canVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() < 2)    return true;
        boolean[] arr = new boolean[rooms.size()];
        arr[0] = true;
        Queue<Integer> queue = new LinkedList<>(rooms.get(0));
        while (!queue.isEmpty()){
            int i = queue.poll();
            if(arr[i])  continue;
            arr[i] = true;
            for(int m : rooms.get(i)){
                if(!arr[m]){
                    queue.add(m);
                }
            }
        }
        for(boolean b : arr){
            if(!b) return false;
        }
        return true;
    }
}
