package interview1To100;

import java.util.Arrays;

@Deprecated
public class a1713respace {
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len+1];
        Trie trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<len+1;i++){
            dp[i] = dp[i-1]+1;
            Trie cur = trie;
            for(int j=i;j>=1;j--){
                int k = sentence.charAt(j-1)-'a';
                if(cur.next[k] == null){
                    break;
                }else if(cur.next[k].isEnd){
                    dp[i] = Math.min(dp[i],dp[j-1]);
                }
                if(dp[i] == 0){
                    break;
                }
                // 很好奇这样子为什么trie的指针没有被移动
                cur = cur.next[k];
            }
        }
        return dp[len];
    }


    static class Trie{

        public Trie[] next = new Trie[26];
        public boolean isEnd = false;

        public void insert(String s){
            Trie root = this;

            for(int i=s.length()-1;i>=0;i--){
                int k = s.charAt(i)-'a';
                if(root.next[k] == null){
                    root.next[k] = new Trie();
                }
                root = root.next[k];
            }
            root.isEnd = true;
        }

    }
}
