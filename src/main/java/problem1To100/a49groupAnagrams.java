package problem1To100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a49groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 存索引干啥。。。直接把String存在去不就得了
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            int[] stat = new int[26];
            for(char ch : str.toCharArray()){
                stat[ch-'a']++;
            }
            String s = convert(stat);
            List<Integer> list = map.get(s);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(s,list);
        }
        List<List<String>> res = new ArrayList<>();
        for(String s : map.keySet()){
            List<Integer> index = map.get(s);
            List<String> list = new ArrayList<>();
            for(int i : index){
                list.add(strs[i]);
            }
            res.add(list);
        }
        return res;
    }

    public String convert(int[] stat){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(stat[i] != 0){
                sb.append((char)(i+'a')).append(stat[i]);
            }
        }
        return sb.toString();
    }
}
