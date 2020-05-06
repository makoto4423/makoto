package problem700To800;

import java.util.ArrayList;
import java.util.List;
// 是我输了，["a/*comment", "line", "more_comment*/b"]这种输入要输出[ab]，而不是[a,b]，单纯理细节，不写了
@Deprecated
public class a722removeComments {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean block = false;
        for(String s : source){
            int leanIndex = s.indexOf("//");
            int starBeginIndex = s.indexOf("/*");
            int starEndIndex = s.indexOf("*/");
            if(!block){
                if(leanIndex != -1){
                    if(leanIndex < starBeginIndex || starBeginIndex == -1){
                        String a = s.substring(0,leanIndex);
                        if(a.length() != 0){
                            ans.add(a);
                        }
                    }
                }else{
                    if(starBeginIndex != -1){
                        if(starEndIndex == -1){
                            String a = s.substring(0,starBeginIndex);
                            if(a.length() != 0){
                                ans.add(a);
                            }
                            block = true;
                        }else{
                            String a = s.substring(0,starBeginIndex)+s.substring(starEndIndex+2);
                            if(a.length() != 0){
                                ans.add(a);
                            }
                        }
                    }else if(s.length() != 0){
                        ans.add(s);
                    }
                }
            }else{
                if(starEndIndex != -1 && starEndIndex > leanIndex){
                    block = false;
                    String a = s.substring(starEndIndex+2);
                    if(a.length() != 0){
                        ans.add(a);
                    }
                }
            }
        }
        return ans;
    }
}
