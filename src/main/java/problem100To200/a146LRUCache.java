package problem100To200;

import java.util.*;

public class a146LRUCache {

    int[] keys;
    Map<Integer,Integer> values = new HashMap<>();
    int capacity;
    int size=0;

    public a146LRUCache(int capacity) {
        this.capacity = capacity;
        keys  =new  int[capacity];
    }

    public int get(int key) {
        int index = 0;
        for(;index<size;index++){
            if(keys[index] == key)  break;
        }
        if(index != size){
            System.arraycopy(keys,index+1,keys,index,capacity-index-1);
            keys[size-1] = key;
        }
        return values.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(values.containsKey(key)){
            this.get(key);
            values.put(key,value);
            return;
        }
        if(size == capacity){
            values.remove(keys[0]);
            System.arraycopy(keys,1,keys,0,capacity-1);
            keys[capacity-1] = key;
        }else{
            keys[size] = key;
            size++;
        }
        values.put(key,value);
    }
}
