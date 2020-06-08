package problem900To1000;
@Deprecated
// 想到是图，但是怎么入手毫无头绪，并查集
public class a990equationsPossible {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i=0;i<26; i++){
            parent[i] = i;
        }
        for(String s : equations){
            if(s.charAt(1) == '='){
                int index1 = s.charAt(0)-'a';
                int index2 = s.charAt(3)-'a';
                union(parent,index1, index2);
            }
        }
        for(String s : equations){
            if(s.charAt(1) == '!'){
                int index1 = s.charAt(0)-'a';
                int index2 = s.charAt(3)-'a';
                if(find(parent,index1) == find(parent,index2)){
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2){
        parent[find(parent,index2)] = find(parent,index1);
    }

    public int find(int[] parent, int index){
        while(parent[index] != index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
