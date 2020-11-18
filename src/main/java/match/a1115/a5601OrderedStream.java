package match.a1115;

import java.util.ArrayList;
import java.util.List;

public class a5601OrderedStream {

    int ptr;
    String[] arr;
    public a5601OrderedStream(int n) {
        ptr = 1;
        arr = new String[n+1];
    }

    public List<String> insert(int id, String value) {
        arr[id] = value;
        List<String> res = new ArrayList<>();
        if(id == ptr){
            int i=id;
            for(;i<arr.length;i++){
                if(arr[i] == null)    break;
                res.add(arr[i]);
            }
            ptr = i;
        }
        return res;
    }
}
