package problem800To900;

public class a844backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder ss = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) != '#'){
                ss.append(S.charAt(i));
            }else{
                if(ss.length() != 0){
                    ss.deleteCharAt(ss.length()-1);
                }
            }
        }
        StringBuilder st = new StringBuilder();
        for(int i=0; i<T.length(); i++){
            if(T.charAt(i) != '#'){
                st.append(T.charAt(i));
            }else{
                if(st.length() != 0){
                    st.deleteCharAt(st.length()-1);
                }
            }
        }
        return ss.toString().equals(st.toString());
    }
}
