package problem600To700;

public class a647countSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res++;
            // 回文长度为奇数，即当前点作为中心
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
            // 当前点与左侧节点是否相同，若相同则作为中心；右侧不管，遍历到下一个节点就相当于以右侧为中心
            left = i-1;
            if(left>=0 && s.charAt(left) == s.charAt(i)){
                res++;
                left--;
                right=i+1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }
        }
        return res;
    }
}
