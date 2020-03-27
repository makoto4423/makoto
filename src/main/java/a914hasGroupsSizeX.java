import java.util.Arrays;

@Deprecated
public class a914hasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        if(2 > deck.length) return false;
        int target = deck[0];int len = 1;
        for(int i=1; i<deck.length; i++){
            if(deck[i] != target)   break;
            len++;
        }
        int pos = len;
        while(pos > 1){
            if(len % pos != 0 || deck.length%pos != 0) {
                pos--;continue;
            }
            int i=0;
            for(; i<deck.length-pos; i=i+pos-1){
                if(deck[i] != deck[i+pos-1]) break;
            }
            if(i == deck.length-pos)    return true;
            pos--;
        }
        return false;
    }

}
