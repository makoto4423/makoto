package problem300To400;

import java.util.*;

@Deprecated
public class a381RandomizedCollection {

    Map<Integer,Set<Integer>> map;
    List<Integer> list;

    public a381RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set = map.getOrDefault(val,new HashSet<>());
        set.add(list.size()-1);
        map.put(val,set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        Iterator<Integer> it = map.get(val).iterator();
        int i = it.next();
        int last = list.get(list.size()-1);
        list.set(i,last);
        map.get(val).remove(i);
        map.get(last).remove(list.size()-1);
        if(i < list.size()-1){
            map.get(last).add(i);
        }
        if(map.get(val).size() == 0){
            map.remove(val);
        }
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random()*(list.size())));
    }



}
