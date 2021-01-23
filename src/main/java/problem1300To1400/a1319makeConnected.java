package problem1300To1400;

// 并查集
public class a1319makeConnected {
    public int makeConnected(int n, int[][] connections) {
        Union union = new Union(n);
        int more = 0;
        for(int[] con : connections){
            int fx = union.find(con[0]);
            int fy = union.find(con[1]);
            if(fx == fy){
                more++;
            }else{
                union.union(fx,fy);
            }
        }
        if(more >= union.link-1){
            return union.link-1;
        }
        return -1;
    }

    static class Union{
        int[] arr;
        int link;

        Union(int n){
            this.arr = new int[n];
            link = n;
            for(int i=0;i<n;i++){
                arr[i] = i;
            }
        }

        public int find(int a){
            if(arr[a] != a){
                arr[a] = find(arr[a]);
            }
            return arr[a];
        }

        public void union(int x,int y){
            arr[x] = y;
            link--;
        }
    }
}
